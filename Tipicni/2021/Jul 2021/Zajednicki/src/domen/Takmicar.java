/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;

/**
 *
 * @author Korisnik
 */
public class Takmicar implements Serializable {
    
    private int takmicarID;
    private String ime;
    private String prezime;
    // za char isto stavljamo String jer ResultSet nema getChar() metodu!
    private String pol; 
    private String kontakt;
    
    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    public Takmicar(int takmicarID, String ime, String prezime, String pol, String kontakt) {
        this.takmicarID = takmicarID;
        this.ime = ime;
        this.prezime = prezime;
        this.pol = pol;
        this.kontakt = kontakt;
    }

    public Takmicar() {
    }

    public int getTakmicarID() {
        return takmicarID;
    }

    public void setTakmicarID(int takmicarID) {
        this.takmicarID = takmicarID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getPol() {
        return pol;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }

    public String getKontakt() {
        return kontakt;
    }

    public void setKontakt(String kontakt) {
        this.kontakt = kontakt;
    }
    
}
