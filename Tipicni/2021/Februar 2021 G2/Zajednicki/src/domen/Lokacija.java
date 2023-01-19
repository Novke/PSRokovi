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
public class Lokacija implements Serializable {
    
    private long lokacijaID;
    private int pttBroj;
    private String naziv;

    public Lokacija() {
    }

    public Lokacija(long lokacijaID, int pttBroj, String naziv) {
        this.lokacijaID = lokacijaID;
        this.pttBroj = pttBroj;
        this.naziv = naziv;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public long getLokacijaID() {
        return lokacijaID;
    }

    public void setLokacijaID(long lokacijaID) {
        this.lokacijaID = lokacijaID;
    }

    public int getPttBroj() {
        return pttBroj;
    }

    public void setPttBroj(int pttBroj) {
        this.pttBroj = pttBroj;
    }

    @Override
    public String toString() {
        return naziv;
    }
    
    
    
}
