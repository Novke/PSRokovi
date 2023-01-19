/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import baza.DBBroker;
import domen.Dogadjaj;
import domen.StavkaIzvestaja;
import domen.Korisnik;
import domen.Ucesce;
import domen.UcesnikZaDogadjaj;
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
        return dbb.login(user, pass);
    }

    public ArrayList<Korisnik> vratiKorisnike() {
        return dbb.vratiKorisnike();
    }

    public boolean sacuvajDogadjaj(Dogadjaj dog) {
        try {
            return dbb.sacuvajDogadjaj(dog);
        } catch (SQLException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<StavkaIzvestaja> vratiIzvestaj(String dodatniUpit) {
        return dbb.vratiIzvestaj(dodatniUpit);
    }

    public ArrayList<UcesnikZaDogadjaj> vratiUcescaZaDogadjaj(int dogadjajID) {
        return dbb.vratiUcescaZaDogadjaj(dogadjajID);
    }
    
}
