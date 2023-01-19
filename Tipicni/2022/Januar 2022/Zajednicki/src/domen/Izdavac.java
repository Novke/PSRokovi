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
public class Izdavac implements Serializable {
    
    private int izdavacID;
    private String naziv;
    private String adresa;
    private String URL;

    @Override
    public String toString() {
        return naziv;
    }

    public Izdavac(int izdavacID, String naziv, String adresa, String URL) {
        this.izdavacID = izdavacID;
        this.naziv = naziv;
        this.adresa = adresa;
        this.URL = URL;
    }

    public Izdavac() {
    }

    public int getIzdavacID() {
        return izdavacID;
    }

    public void setIzdavacID(int izdavacID) {
        this.izdavacID = izdavacID;
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

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
    
}
