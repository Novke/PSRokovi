/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import baza.DBBroker;
import domen.ProgramskiVodic;
import domen.Stanica;
import domen.StavkaIzvestaja;
import domen.TipEmisije;
import domen.Urednik;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Kontroler {

    private static Kontroler instance;
    private DBBroker dbb;
    private ArrayList<Urednik> urednici = new ArrayList<>();

    private Kontroler() {
        dbb = new DBBroker();
        urednici.add(new Urednik(1, "Arijan", "Memedi", "ari", "ari"));
        urednici.add(new Urednik(2, "Ana", "Anic", "ana", "ana"));
        urednici.add(new Urednik(3, "Petar", "Peric", "pera", "pera"));
    }

    public static Kontroler getInstance() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }

    public Urednik login(String username, String password) {
        for (Urednik urednik : urednici) {
            if (urednik.getUsername().equals(username) && urednik.getPassword().equals(password)) {
                return urednik;
            }
        }
        return null;
    }

    public ArrayList<Stanica> vratiStanice() {
        return dbb.vratiStanice();
    }

    public ArrayList<TipEmisije> vratiTipoveEmisije() {
        return dbb.vratiTipoveEmisije();
    }

    public ArrayList<TipEmisije> vratiPodtipoveEmisije(TipEmisije tipEmisije) {
        return dbb.vratiPodtipoveEmisije(tipEmisije);
    }

    public boolean sacuvajProgramskiVodic(ProgramskiVodic pv) {
        try {
            return dbb.sacuvajProgramskiVodic(pv);
        } catch (SQLException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<StavkaIzvestaja> vratiIzvestaj(String dodatniUpit) {
        return dbb.vratiIzvestaj(dodatniUpit);
    }

}
