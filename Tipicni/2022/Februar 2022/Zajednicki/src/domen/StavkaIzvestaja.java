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
    
    private String proizvodjac;
    private Date datum;
    private String opis;
    private double proizvedenoElEng;

    public StavkaIzvestaja(String proizvodjac, Date datum, String opis, double proizvedenoElEng) {
        this.proizvodjac = proizvodjac;
        this.datum = datum;
        this.opis = opis;
        this.proizvedenoElEng = proizvedenoElEng;
    }

    public StavkaIzvestaja() {
    }

    public String getProizvodjac() {
        return proizvodjac;
    }

    public void setProizvodjac(String proizvodjac) {
        this.proizvodjac = proizvodjac;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public double getProizvedenoElEng() {
        return proizvedenoElEng;
    }

    public void setProizvedenoElEng(double proizvedenoElEng) {
        this.proizvedenoElEng = proizvedenoElEng;
    }
    
}
