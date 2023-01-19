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
public class Angazovanje implements Serializable {
    
    private int angazovanjeID;
    private String vrstaAngazovanja;
    private String opisPosla;
    private int brojSati;
    private Emisija emisija;
    private Radnik radnik;

    public Angazovanje(int angazovanjeID, String vrstaAngazovanja, String opisPosla, int brojSati, Emisija emisija, Radnik radnik) {
        this.angazovanjeID = angazovanjeID;
        this.vrstaAngazovanja = vrstaAngazovanja;
        this.opisPosla = opisPosla;
        this.brojSati = brojSati;
        this.emisija = emisija;
        this.radnik = radnik;
    }

    public Angazovanje() {
    }

    public int getAngazovanjeID() {
        return angazovanjeID;
    }

    public void setAngazovanjeID(int angazovanjeID) {
        this.angazovanjeID = angazovanjeID;
    }

    public String getVrstaAngazovanja() {
        return vrstaAngazovanja;
    }

    public void setVrstaAngazovanja(String vrstaAngazovanja) {
        this.vrstaAngazovanja = vrstaAngazovanja;
    }

    public String getOpisPosla() {
        return opisPosla;
    }

    public void setOpisPosla(String opisPosla) {
        this.opisPosla = opisPosla;
    }

    public int getBrojSati() {
        return brojSati;
    }

    public void setBrojSati(int brojSati) {
        this.brojSati = brojSati;
    }

    public Emisija getEmisija() {
        return emisija;
    }

    public void setEmisija(Emisija emisija) {
        this.emisija = emisija;
    }

    public Radnik getRadnik() {
        return radnik;
    }

    public void setRadnik(Radnik radnik) {
        this.radnik = radnik;
    }
    
}
