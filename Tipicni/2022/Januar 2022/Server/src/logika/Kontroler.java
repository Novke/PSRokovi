/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import baza.DBBroker;
import domen.Igra;
import domen.Izdavac;
import domen.Korisnik;
import domen.StavkaIzvestaja;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Kontroler {

    private static Kontroler instance;
    private DBBroker dbb;
    ArrayList<Korisnik> korisnici = new ArrayList<>();

    private Kontroler() {
        dbb = new DBBroker();
        korisnici.add(new Korisnik(1, "Arijan", "Memedi", "ari", "ari"));
        korisnici.add(new Korisnik(2, "Ana", "Anic", "ana", "ana"));
        korisnici.add(new Korisnik(3, "Petar", "Peric", "pera", "pera"));
    }

    public static Kontroler getInstance() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }

    public Korisnik login(String username, String password) {
        for (Korisnik korisnik : korisnici) {
            if(korisnik.getUsername().equals(username) && korisnik.getPassword().equals(password))
                return korisnik;
        }
        return null;
    }

    public ArrayList<Izdavac> vratiIzdavace() {
        return dbb.vratiIzdavace();
    }

    public int vratiIgruID() {
        return dbb.vratiIgruID();
    }

    public boolean sacuvajIgru(Igra i) {
        try {
            return dbb.sacuvajIgru(i);
        } catch (SQLException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<StavkaIzvestaja> vratiIzvestaj(String dodatniUpit) {
        return dbb.vratiIzvestaj(dodatniUpit);
    }

}
