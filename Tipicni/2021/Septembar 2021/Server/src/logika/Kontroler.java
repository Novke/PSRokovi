/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import baza.DBBroker;
import domen.Intervencija;
import domen.IntervencijeSacuvaj;
import domen.StambenaZajednica;
import domen.Upravnik;
import domen.VrstaIntervencije;
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

    public Upravnik login(String username, String password) {
        return dbb.login(username, password);
    }

    public ArrayList<Intervencija> vratiIntervencije(Upravnik u) {
        return dbb.vratiIntervencije(u);
    }

    public ArrayList<StambenaZajednica> vratiStambeneZajednice() {
        return dbb.vratiStambeneZajednice();
    }

    public ArrayList<Intervencija> vratiIzvestaj(String dodatniUpit) {
        return dbb.vratiIzvestaj(dodatniUpit);
    }

    public ArrayList<VrstaIntervencije> vratiVrsteIntervencija() {
        return dbb.vratiVrsteIntervencija();
    }

    public boolean sacuvajIzmene(IntervencijeSacuvaj intervencije) {
        try {
            return dbb.sacuvajIzmene(intervencije);
        } catch (SQLException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
