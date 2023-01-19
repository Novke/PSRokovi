/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;

/**
 *
 * @author Korisnik
 */
public class Stanica implements Serializable {
    
    private long stanicaID;
    private String naziv;
    private String tip;
    private String kontakt;
    
    @Override
    public String toString() {
        return naziv;
    }

    public Stanica(long stanicaID, String naziv, String tip, String kontakt) {
        this.stanicaID = stanicaID;
        this.naziv = naziv;
        this.tip = tip;
        this.kontakt = kontakt;
    }

    public Stanica() {
    }

    public long getStanicaID() {
        return stanicaID;
    }

    public void setStanicaID(long stanicaID) {
        this.stanicaID = stanicaID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getKontakt() {
        return kontakt;
    }

    public void setKontakt(String kontakt) {
        this.kontakt = kontakt;
    }
    
}
