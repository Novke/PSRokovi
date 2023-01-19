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
public class Proizvodjac implements Serializable {
    
    private long proizvodjacID;
    private String naziv;
    private String adresa;
    private String korisnickoIme;
    private String lozinka;

    public Proizvodjac(long proizvodjacID, String naziv, String adresa, String korisnickoIme, String lozinka) {
        this.proizvodjacID = proizvodjacID;
        this.naziv = naziv;
        this.adresa = adresa;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
    }

    public Proizvodjac() {
    }

    public long getProizvodjacID() {
        return proizvodjacID;
    }

    public void setProizvodjacID(long proizvodjacID) {
        this.proizvodjacID = proizvodjacID;
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
