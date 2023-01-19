/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import baza.DBBroker;
import domen.Aerodrom;
import domen.Interkonekcija;
import domen.Let;
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

    public ArrayList<Aerodrom> vratiAerodrome() {
        return dbb.vratiAerodrome();
    }

    public boolean sacuvajLet(Let let) {
        try {
            return dbb.sacuvajLet(let);
        } catch (SQLException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<Let> vratiIzvestaj() {
        return dbb.vratiIzvestaj();
    }

    public ArrayList<Interkonekcija> vratiInterkonekcijeZaLet(Let let) {
        return dbb.vratiInterkonekcijeZaLet(let);
    }

}
