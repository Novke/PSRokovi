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
public class Intervju implements Serializable {
    
    private int intervjuID;
    private Date datum;
    private String opis;
    private double brojPoenaTest;
    private String vozackaDozvola;
    private boolean prethodnoIskustvo;
    private Kandidat kandidat;
    private Regruter regruter;

    public Intervju() {
    }

    public Intervju(int intervjuID, Date datum, String opis, double brojPoenaTest, String vozackaDozvola, boolean prethodnoIskustvo, Kandidat kandidat, Regruter regruter) {
        this.intervjuID = intervjuID;
        this.datum = datum;
        this.opis = opis;
        this.brojPoenaTest = brojPoenaTest;
        this.vozackaDozvola = vozackaDozvola;
        this.prethodnoIskustvo = prethodnoIskustvo;
        this.kandidat = kandidat;
        this.regruter = regruter;
    }

    public Regruter getRegruter() {
        return regruter;
    }

    public void setRegruter(Regruter regruter) {
        this.regruter = regruter;
    }

    public int getIntervjuID() {
        return intervjuID;
    }

    public void setIntervjuID(int intervjuID) {
        this.intervjuID = intervjuID;
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

    public double getBrojPoenaTest() {
        return brojPoenaTest;
    }

    public void setBrojPoenaTest(double brojPoenaTest) {
        this.brojPoenaTest = brojPoenaTest;
    }

    public String getVozackaDozvola() {
        return vozackaDozvola;
    }

    public void setVozackaDozvola(String vozackaDozvola) {
        this.vozackaDozvola = vozackaDozvola;
    }

    public boolean isPrethodnoIskustvo() {
        return prethodnoIskustvo;
    }

    public void setPrethodnoIskustvo(boolean prethodnoIskustvo) {
        this.prethodnoIskustvo = prethodnoIskustvo;
    }

    public Kandidat getKandidat() {
        return kandidat;
    }

    public void setKandidat(Kandidat kandidat) {
        this.kandidat = kandidat;
    }
    
    
    
}
