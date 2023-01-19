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
public class StambenaZajednica implements Serializable{
    
    private int stambenaZajednicaID;
    private String naziv;
    private String adresa;
    private String mesto;
    private Upravnik upravnik;

    public StambenaZajednica() {
    }

    public StambenaZajednica(int stambenaZajednicaID, String naziv, String adresa, String mesto, Upravnik upravnik) {
        this.stambenaZajednicaID = stambenaZajednicaID;
        this.naziv = naziv;
        this.adresa = adresa;
        this.mesto = mesto;
        this.upravnik = upravnik;
    }

    public Upravnik getUpravnik() {
        return upravnik;
    }

    public void setUpravnik(Upravnik upravnik) {
        this.upravnik = upravnik;
    }

    public int getStambenaZajednicaID() {
        return stambenaZajednicaID;
    }

    public void setStambenaZajednicaID(int stambenaZajednicaID) {
        this.stambenaZajednicaID = stambenaZajednicaID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    @Override
    public String toString() {
        return adresa;
    }
    
    
}
