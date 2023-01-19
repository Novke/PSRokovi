/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import baza.DBBroker;
import domen.Emisija;
import domen.Producent;
import domen.Radnik;
import domen.StavkaIzvestaja;
import domen.Studio;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Kontroler {

    private static Kontroler instance;
    private DBBroker dbb;
    private ArrayList<Producent> producenti = new ArrayList<>();

    private Kontroler() {
        dbb = new DBBroker();
        producenti.add(new Producent(1, "Arijan", "Memedi", "ari", "ari"));
        producenti.add(new Producent(2, "Ana", "Anic", "ana", "ana"));
        producenti.add(new Producent(3, "Petar", "Peric", "pera", "pera"));
    }

    public static Kontroler getInstance() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }

    public Producent login(String username, String password) {
        for (Producent producent : producenti) {
            if (producent.getUsername().equals(username) && producent.getPassword().equals(password)) {
                return producent;
            }
        }
        return null;
    }

    public ArrayList<Radnik> vratiAktivneRadnike() {
        return dbb.vratiAktivneRadnike();
    }

    public ArrayList<Studio> vratiAktivnaStudija() {
        return dbb.vratiAktivnaStudija();
    }

    public boolean sacuvajEmisiju(Emisija e) {
        try {
            return dbb.sacuvajEmisiju(e);
        } catch (SQLException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<Studio> vratiStudija() {
        return dbb.vratiStudija();
    }

    public ArrayList<StavkaIzvestaja> vratiIzvestaj(String dodatniUpit) {
        return dbb.vratiIzvestaj(dodatniUpit);
    }

}
