/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import baza.DBBroker;
import domen.StavkaIzvestaja;
import domen.Laborant;
import domen.Laboratorija;
import domen.Zahtev;
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

    public Laborant login(String user, String pass) {
        return dbb.login(user, pass);
    }

    public ArrayList<Zahtev> vratiNeobradjeneZahteve(int labID) {
        return dbb.vratiNeobradjeneZahteve(labID);
    }

    public boolean sacuvajObradjene(ArrayList<Zahtev> listaObradjenih) {
        try {
            return dbb.sacuvajObradjene(listaObradjenih);
        } catch (SQLException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<Laboratorija> vratiLaboratorije() {
        return dbb.vratiLaboratorije();
    }

    public ArrayList<StavkaIzvestaja> vratiIzvestaj(String upit) {
        return dbb.vratiIzvestaj(upit);
    }

}
