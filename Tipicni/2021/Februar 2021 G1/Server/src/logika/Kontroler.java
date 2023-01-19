/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import baza.DBBroker;
import domen.Opstina;
import domen.Prijava;
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

    public ArrayList<Opstina> vratiOpstine() {
        return dbb.vratiOpstine();
    }

    public boolean sacuvajPrijavu(Prijava p) {
        try {
            return dbb.sacuvajPrijavu(p);
        } catch (SQLException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<Prijava> vratiIzvestaj() {
        return dbb.vratiIzvestaj();
    }

    public boolean ponistiPrijavu(Prijava p) {
        try {
            return dbb.ponistiStavkePrijave(p);
        } catch (SQLException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
