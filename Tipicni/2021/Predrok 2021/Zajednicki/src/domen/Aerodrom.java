/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;

/**
 *
 * @author PC
 */
public class Aerodrom implements Serializable {
    
    private long aerodromID;
    private String naziv;
    private String kod;
    private String adresa;
    private String drzava;

    public Aerodrom() {
    }

    public Aerodrom(long aerodromID, String naziv, String kod, String adresa, String drzava) {
        this.aerodromID = aerodromID;
        this.naziv = naziv;
        this.kod = kod;
        this.adresa = adresa;
        this.drzava = drzava;
    }

    public String getDrzava() {
        return drzava;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }

    public long getAerodromID() {
        return aerodromID;
    }

    public void setAerodromID(long aerodromID) {
        this.aerodromID = aerodromID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @Override
    public String toString() {
        return naziv;
    }
    
    
    
}
