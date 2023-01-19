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
public class Pomocna implements Serializable {
    private Publikacija publikacija;
    private int rb;
    private String naslov;
    private String tekst;

    public Pomocna() {
    }

    public Pomocna(Publikacija publikacija, int rb, String naslov, String tekst) {
        this.publikacija = publikacija;
        this.rb = rb;
        this.naslov = naslov;
        this.tekst = tekst;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public Publikacija getPublikacija() {
        return publikacija;
    }

    public void setPublikacija(Publikacija publikacija) {
        this.publikacija = publikacija;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }
    
}
