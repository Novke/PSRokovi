/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import baza.DBBroker;
import domen.Paket;
import domen.Pretplatnik;
import domen.StavkaIzvestaja;
import domen.Ugovor;
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

    public ArrayList<Pretplatnik> vratiPretplatnike() {
        return dbb.vratiPretplatnike();
    }

    public ArrayList<Paket> vratiPakete() {
        return dbb.vratiPakete();
    }

    public ArrayList<StavkaIzvestaja> vratiIzvestaj() {
        return dbb.vratiIzvestaj();
    }

    public boolean sacuvajUgovore(ArrayList<Ugovor> listaUgovora) {
        try {
            return dbb.sacuvajUgovore(listaUgovora);
        } catch (SQLException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean ponistiUgovor(long idUgovora) {
        try {
            return dbb.ponistiUgovor(idUgovora);
        } catch (SQLException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
