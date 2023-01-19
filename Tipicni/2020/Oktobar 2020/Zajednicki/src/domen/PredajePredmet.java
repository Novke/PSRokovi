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
 * @author PC
 */
public class PredajePredmet implements Serializable {
    
    private Nastavnik nastavnik;
    private Predmet predmet;
    private int semestar;
    private String studijskiProgram;
    private Date datumAngazovanja;
    private Korisnik korisnik;

    public PredajePredmet() {
    }

    public PredajePredmet(Nastavnik nastavnik, Predmet predmet, int semestar, String studijskiProgram, Date datumAngazovanja, Korisnik korisnik) {
        this.nastavnik = nastavnik;
        this.predmet = predmet;
        this.semestar = semestar;
        this.studijskiProgram = studijskiProgram;
        this.datumAngazovanja = datumAngazovanja;
        this.korisnik = korisnik;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Nastavnik getNastavnik() {
        return nastavnik;
    }

    public void setNastavnik(Nastavnik nastavnik) {
        this.nastavnik = nastavnik;
    }

    public Predmet getPredmet() {
        return predmet;
    }

    public void setPredmet(Predmet predmet) {
        this.predmet = predmet;
    }

    public int getSemestar() {
        return semestar;
    }

    public void setSemestar(int semestar) {
        this.semestar = semestar;
    }

    public String getStudijskiProgram() {
        return studijskiProgram;
    }

    public void setStudijskiProgram(String studijskiProgram) {
        this.studijskiProgram = studijskiProgram;
    }

    public Date getDatumAngazovanja() {
        return datumAngazovanja;
    }

    public void setDatumAngazovanja(Date datumAngazovanja) {
        this.datumAngazovanja = datumAngazovanja;
    }
    
    
}
