/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import baza.DBBroker;
import domen.Komponenta;
import domen.PrevoznoSredstvo;
import domen.ProizvodniPogon;
import domen.Rukovodilac;
import domen.StavkaIzvestaja;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Kontroler {

    private static Kontroler instance;
    private DBBroker dbb;
    private ArrayList<Rukovodilac> rukovodioci = new ArrayList<>();

    private Kontroler() {
        dbb = new DBBroker();
        rukovodioci.add(new Rukovodilac(1, "Arijan", "Memedi", "ari", "ari"));
        rukovodioci.add(new Rukovodilac(2, "Ana", "Anic", "ana", "ana"));
        rukovodioci.add(new Rukovodilac(3, "Petar", "Peric", "pera", "pera"));
    }

    public static Kontroler getInstance() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }

    public Rukovodilac login(String username, String password) {
        for (Rukovodilac rukovodilac : rukovodioci) {
            if(rukovodilac.getUsername().equals(username) && rukovodilac.getPassword().equals(password))
                return rukovodilac;
        }
        return null;
    }

    public ArrayList<StavkaIzvestaja> vratiIzvestaj(String dodatniUpit) {
        return dbb.vratiIzvestaj(dodatniUpit);
    }

    public ArrayList<ProizvodniPogon> vratiPogone() {
        return dbb.vratiPogone();
    }

    public ArrayList<Komponenta> vratiKomponente() {
        return dbb.vratiKomponente();
    }

    public boolean sacuvajPrevoznoSredstvo(PrevoznoSredstvo ps) {
        try {
            return dbb.sacuvajPrevoznoSredstvo(ps);
        } catch (SQLException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
