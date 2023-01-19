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
public class Paket implements Serializable {
    
    private long paketID;
    private String naziv;
    private String opis;
    private double cena;
    private boolean aktivan;

    public Paket() {
    }

    public Paket(long paketID, String naziv, String opis, double cena, boolean aktivan) {
        this.paketID = paketID;
        this.naziv = naziv;
        this.opis = opis;
        this.cena = cena;
        this.aktivan = aktivan;
    }

    public boolean isAktivan() {
        return aktivan;
    }

    public void setAktivan(boolean aktivan) {
        this.aktivan = aktivan;
    }

    public long getPaketID() {
        return paketID;
    }

    public void setPaketID(long paketID) {
        this.paketID = paketID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    @Override
    public String toString() {
        return naziv;
    }
    
    
    
}
