/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import baza.DBBroker;
import domen.Festival;
import domen.Izvodjenje;
import domen.Koncert;
import domen.Korisnik;
import domen.Predstava;
import domen.StavkaIzvestaja;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Kontroler {

    private static Kontroler instance;
    private DBBroker dbb;
    private ArrayList<Korisnik> korisnici = new ArrayList<>();

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

    public ArrayList<Festival> vratiFestivale() {
        return dbb.vratiFestivale();
    }

    public ArrayList<Predstava> vratiPredstave() {
        return dbb.vratiPredstave();
    }

    public ArrayList<Koncert> vratiKoncerte() {
        return dbb.vratiKoncerte();
    }

    public boolean izmeniFestival(Festival f) {
        try {
            return dbb.izmeniFestival(f);
        } catch (SQLException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<Izvodjenje> vratiIzvodjenjaFestivala(Festival f) {
        return dbb.vratiIzvodjenjaFestivala(f);
    }

    public ArrayList<StavkaIzvestaja> vratiIzvestaj(String dodatniUpit) {
        return dbb.vratiIzvestaj(dodatniUpit);
    }

}
