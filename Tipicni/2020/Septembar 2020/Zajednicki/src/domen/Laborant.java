/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import com.sun.corba.se.impl.oa.toa.TOA;
import java.io.Serializable;

/**
 *
 * @author PC
 */
public class Laborant implements Serializable {
    
    private int laborantId;
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String lozinka;
    private Laboratorija laboratorija;

    public Laborant() {
    }

    public Laborant(int laborantId, String ime, String prezime, String korisnickoIme, String lozinka, Laboratorija laboratorija) {
        this.laborantId = laborantId;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.laboratorija = laboratorija;
    }

    public Laboratorija getLaboratorija() {
        return laboratorija;
    }

    public void setLaboratorija(Laboratorija laboratorija) {
        this.laboratorija = laboratorija;
    }

    public int getLaborantId() {
        return laborantId;
    }

    public void setLaborantId(int laborantId) {
        this.laborantId = laborantId;
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

    @Override
    public String toString() {
        return ime + " " + prezime;
    }
    
    
    
}
