/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import baza.DBBroker;
import domen.Banka;
import domen.Kompanija;
import domen.Korisnik;
import domen.StavkaIzvestaja;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class Kontroler {

    private static Kontroler instance;
    private DBBroker dbb;

    private Kontroler() {
        dbb = new DBBroker();
    }

    public static Kontroler getInstance() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }

    public Korisnik login(String user, String pass) {
        Korisnik k = dbb.login(user, pass);
        return k;
    }

    public ArrayList<Banka> vratiBanke() {
        ArrayList<Banka> lista = dbb.vratiBanke();
        return lista;
    }

    public boolean sacuvajKompaniju(Kompanija kompanija) {
        boolean uspesnoKompanija;
        try {
            uspesnoKompanija = dbb.sacuvajKompaniju(kompanija);
            return uspesnoKompanija;
            
        } catch (SQLException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<StavkaIzvestaja> vratiIzvestaj(String upit) {
        ArrayList<StavkaIzvestaja> lista = dbb.vratiIzvestaj(upit);
        return lista;
    }

}
