/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import baza.DBBroker;
import domen.Izdanje;
import domen.Pomocna;
import domen.Izvestaj;
import domen.Publikacija;
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

    public ArrayList<Publikacija> vratiPublikacije() {
        ArrayList<Publikacija> lista = dbb.vratiPublikacije();
        return lista;
    }

    public boolean sacuvajIzdanje(Izdanje i) {
        boolean uspesno = false;
        try {
            uspesno = dbb.sacuvajIzdanja(i);
        } catch (SQLException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return uspesno;
    }

    public ArrayList<Izvestaj> vratiIzvestaj(String upit) {
        ArrayList<Izvestaj> lista = dbb.vratiIzvestaj(upit);
        return lista;
    }

    public boolean daLiPostoji(Izdanje i) {
        System.out.println(dbb.daLiPostoji(i));
        return dbb.daLiPostoji(i);
    }

}
