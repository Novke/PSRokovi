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
public class Izvestaj implements Serializable {
    private String publikacija;
    private int rb;
    private String naslov;
    private String tekst;

    public Izvestaj() {
    }

    public Izvestaj(String publikacija, int rb, String naslov, String tekst) {
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

    public String getPublikacija() {
        return publikacija;
    }

    public void setPublikacija(String publikacija) {
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
