/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.DBBroker;
import domain.Kviz;
import domain.Pitanje;
import form.TableModel;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rastko
 */
public class ServerController {

    private static ServerController instance;
    private List<String> ucesnici;
    private Kviz kviz;
    private List<Pitanje> listaPitanja;

    private int brojTrenutnoPitanje;
    private Pitanje trenutnoPitanje;
    private boolean mozeDaPocne;
    private boolean kraj;
    private double brojBodovaTim;
    private double brojBodovaServer;

    private int brojPorta;
    private int brojIgraca;
    private TableModel tableModel;

    public ServerController() {
        try {
            InputStream input = new FileInputStream("settings.properties");
            Properties prop = new Properties();
            prop.load(input);

            brojPorta = Integer.parseInt(prop.getProperty("port"));
            brojIgraca = Integer.parseInt(prop.getProperty("broj_igraca"));
            tableModel = new TableModel();
            ucesnici = new LinkedList<>();
            brojTrenutnoPitanje = 0;
            mozeDaPocne = false;
            kraj = false;
            brojBodovaServer = 0;
            brojBodovaTim = 0;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static ServerController getInstance() {
        if (instance == null) {
            instance = new ServerController();
        }
        return instance;
    }

    public List<Kviz> getAllKvizovi() {
        return DBBroker.getInstance().getAllKvizovi();
    }

    private void setDatumPocetkaKviza() {
        kviz.setDatumVremePocetka(new Date());
        DBBroker.getInstance().updateKvizDatumPocetka(kviz);
    }

    private void setDatumKrajaIPobednik(String pobednik) {
        kviz.setDatumVremeKraja(new Date());
        kviz.setPobednik(pobednik);
        DBBroker.getInstance().updateKvizDatumKrajaIPobednik(kviz);
    }

    public boolean addUcesnik(String name) throws Exception {
        if (ucesnici.size() < brojIgraca) {
            if (ucesnici.contains(name)) {
                throw new Exception("Vec postoji ucesnik sa tim imenom");
            } else {
                ucesnici.add(name);
                if(kviz!=null && ucesnici.size()==brojIgraca){
                    mozeDaPocne=true;
                    trenutnoPitanje=listaPitanja.get(0);
                }
                return true;
            }
            
        } else {
            if (kviz != null) {
                mozeDaPocne = true;
                trenutnoPitanje=listaPitanja.get(0);
            }
            return false;
        }
    }

    public boolean daLiJeKraj() {
        return kraj;
    }

    public List<String> getUcesnici() {
        return ucesnici;
    }

    public void setKviz(Kviz kviz) {
        this.kviz = kviz;
        listaPitanja = kviz.getPitanja();
        setDatumPocetkaKviza();
        if (ucesnici.size() == brojIgraca) {
            mozeDaPocne = true;
            trenutnoPitanje=listaPitanja.get(0);
        }
    }

    public Kviz getKviz() {
        return kviz;
    }

    public int getBrojIgraca() {
        return brojIgraca;
    }

    public int getBrojPorta() {
        return brojPorta;
    }

    public double getBrojBodovaTim() {
        return brojBodovaTim;
    }

    public double getBrojBodovaServer() {
        return brojBodovaServer;
    }
    
    

    public TableModel getTableModel() {
        return tableModel;
    }

    public boolean isMozeDaPocne() {
        return mozeDaPocne;
    }

    public Pitanje getTrenutnoPitanje() {
        return trenutnoPitanje;
    }
    

    public String koJePobednik() {
        if (brojBodovaServer == brojBodovaTim) {
            setDatumKrajaIPobednik("Nereseno");
            return "Nereseno - Nema pobednika";
        }
        if (brojBodovaServer > brojBodovaTim) {
            setDatumKrajaIPobednik("Server");
            return "Server je pobednik";
        } else {
            setDatumKrajaIPobednik("Tim");
            return "Tim je pobednik";
        }
    }

    public synchronized String posaljiOdgovor(Pitanje odgovor, String igrac) {
        String poruka="";
        boolean tacnoOdogovoreno=false;
        if (odgovor.equals(trenutnoPitanje) && odgovor.getTacanOdgovor().toLowerCase().equals(trenutnoPitanje.getTacanOdgovor().toLowerCase())) {
            tacnoOdogovoreno=true;
            if (trenutnoPitanje.equals(listaPitanja.get(listaPitanja.size() - 1))) {
                kraj = true;
            } else {
                brojTrenutnoPitanje++;
                trenutnoPitanje = listaPitanja.get(brojTrenutnoPitanje);
            }
            poruka= "Tacan odgovor (" + trenutnoPitanje.getBrojPoena() + ")";
        } else {
            if (odgovor.equals(trenutnoPitanje)) {
                brojBodovaServer -= trenutnoPitanje.getBrojPoena() * 0.2;
                if (trenutnoPitanje.equals(listaPitanja.get(listaPitanja.size() - 1))) {
                    kraj = true;
                } else {
                    brojTrenutnoPitanje++;
                    trenutnoPitanje = listaPitanja.get(brojTrenutnoPitanje);
                }
                poruka= "Netacan odgovor (-" + (trenutnoPitanje.getBrojPoena() * 0.2) + ")";
            }
        }
        
        if(igrac.equals("server")){
            if(tacnoOdogovoreno){
                brojBodovaServer+=odgovor.getBrojPoena();
                tableModel.addTacanOdgovorServer(odgovor);
            }
            else{
                brojBodovaServer-=odgovor.getBrojPoena()*0.2;
                tableModel.addNetacanOdgovorServer(odgovor);
            }
        }else{
            if(tacnoOdogovoreno){
                brojBodovaTim+=odgovor.getBrojPoena();
                tableModel.addTacanOdgovorTim(odgovor);
            }
            else{
                brojBodovaTim-=odgovor.getBrojPoena()*0.2;
                tableModel.addNetacanOdgovorTim(odgovor);
            }
        }
        return poruka;
    }

}
