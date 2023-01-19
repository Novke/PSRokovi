/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Korisnik
 */
public class StavkaIzvestaja implements Serializable {
    
    private String kategorija;
    private String potkategorija;
    private String nazivSekcije;
    private Date datum;
    private int ukupnoRadova;
    private int prezentovanoRadova;

    public StavkaIzvestaja(String kategorija, String potkategorija, String nazivSekcije, Date datum, int ukupnoRadova, int prezentovanoRadova) {
        this.kategorija = kategorija;
        this.potkategorija = potkategorija;
        this.nazivSekcije = nazivSekcije;
        this.datum = datum;
        this.ukupnoRadova = ukupnoRadova;
        this.prezentovanoRadova = prezentovanoRadova;
    }

    public StavkaIzvestaja() {
    }

    public String getKategorija() {
        return kategorija;
    }

    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
    }

    public String getPotkategorija() {
        return potkategorija;
    }

    public void setPotkategorija(String potkategorija) {
        this.potkategorija = potkategorija;
    }

    public String getNazivSekcije() {
        return nazivSekcije;
    }

    public void setNazivSekcije(String nazivSekcije) {
        this.nazivSekcije = nazivSekcije;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public int getUkupnoRadova() {
        return ukupnoRadova;
    }

    public void setUkupnoRadova(int ukupnoRadova) {
        this.ukupnoRadova = ukupnoRadova;
    }

    public int getPrezentovanoRadova() {
        return prezentovanoRadova;
    }

    public void setPrezentovanoRadova(int prezentovanoRadova) {
        this.prezentovanoRadova = prezentovanoRadova;
    }
    
}
