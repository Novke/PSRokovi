/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import baza.DBBroker;
import domen.Kategorija;
import domen.Moderator;
import domen.Rad;
import domen.Sekcija;
import domen.StavkaIzvestaja;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Kontroler {

    private static Kontroler instance;
    private DBBroker dbb;
    private ArrayList<Moderator> moderatori = new ArrayList<>();

    private Kontroler() {
        dbb = new DBBroker();
        moderatori.add(new Moderator(1, "Arijan", "Memedi", "ari", "ari"));
        moderatori.add(new Moderator(2, "Ana", "Anic", "ana", "ana"));
        moderatori.add(new Moderator(3, "Petar", "Peric", "pera", "pera"));
    }

    public static Kontroler getInstance() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }

    public Moderator login(String username, String password) {
        for (Moderator moderator : moderatori) {
            if (moderator.getUsername().equals(username) && moderator.getPassword().equals(password)) {
                return moderator;
            }
        }
        return null;
    }

    public ArrayList<Kategorija> vratiNadredjeneKategorije() {
        return dbb.vratiNadredjeneKategorije();
    }

    public ArrayList<Kategorija> vratiPotkategorije(Kategorija nadKategorija) {
        return dbb.vratiPotkategorije(nadKategorija);
    }

    public ArrayList<Rad> vratiRadove() {
        return dbb.vratiRadove();
    }

    public boolean sacuvajSekciju(Sekcija s) {
        try {
            return dbb.sacuvajSekciju(s);
        } catch (SQLException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<StavkaIzvestaja> vratiIzvestaj(String dodatniUpit) {
        return dbb.vratiIzvestaj(dodatniUpit);
    }

}
