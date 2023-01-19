/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import baza.DBBroker;
import domen.DnevnaProizvodnjaIzvestaj;
import domen.Proizvodjac;
import domen.StavkaIzvestaja;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


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

    public Proizvodjac login(String username, String password) {
        return dbb.login(username, password);
    }

    public boolean sacuvajDnevniIzvestaj(DnevnaProizvodnjaIzvestaj dpi) {
        try {
            return dbb.sacuvajDnevniIzvestaj(dpi);
        } catch (SQLException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<StavkaIzvestaja> vratiIzvestaj() {
        return dbb.vratiIzvestaj();
    }
    
}
