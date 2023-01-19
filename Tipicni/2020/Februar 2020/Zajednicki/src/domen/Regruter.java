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
public class Regruter implements Serializable {
    
    private int regruterID;
    private String imePrezime;
    private String korisnickoIme;
    private String lozinka;

    public Regruter() {
    }

    public Regruter(int regruterID, String imePrezime, String korisnickoIme, String lozinka) {
        this.regruterID = regruterID;
        this.imePrezime = imePrezime;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
    }

    

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public int getRegruterID() {
        return regruterID;
    }

    public void setRegruterID(int regruterID) {
        this.regruterID = regruterID;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }
    
    
    
}
