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
public class PoreskiObveznik implements Serializable{
    
    private int poreskiObveznikID;
    private String ime;
    private String prezime;
    private String JMBG;
    private String korisnickoIme;
    private String lozinka;
    private String telefon;

    public PoreskiObveznik() {
    }

    public PoreskiObveznik(int poreskiObveznikID, String ime, String prezime, String JMBG, String korisnickoIme, String lozinka, String telefon) {
        this.poreskiObveznikID = poreskiObveznikID;
        this.ime = ime;
        this.prezime = prezime;
        this.JMBG = JMBG;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.telefon = telefon;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public int getPoreskiObveznikID() {
        return poreskiObveznikID;
    }

    public void setPoreskiObveznikID(int poreskiObveznikID) {
        this.poreskiObveznikID = poreskiObveznikID;
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

    public String getJMBG() {
        return JMBG;
    }

    public void setJMBG(String JMBG) {
        this.JMBG = JMBG;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }
    
    
}
