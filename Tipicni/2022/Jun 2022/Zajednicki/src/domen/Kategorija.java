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
public class Kategorija implements Serializable {

    private long kategorijaID;
    private String naziv;
    private Kategorija nadredjenaKategorija;

    @Override
    public String toString() {
        return naziv;
    }

    public Kategorija(long kategorijaID, String naziv, Kategorija nadredjenaKategorija) {
        this.kategorijaID = kategorijaID;
        this.naziv = naziv;
        this.nadredjenaKategorija = nadredjenaKategorija;
    }

    public Kategorija() {
    }

    public long getKategorijaID() {
        return kategorijaID;
    }

    public void setKategorijaID(long kategorijaID) {
        this.kategorijaID = kategorijaID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Kategorija getNadredjenaKategorija() {
        return nadredjenaKategorija;
    }

    public void setNadredjenaKategorija(Kategorija nadredjenaKategorija) {
        this.nadredjenaKategorija = nadredjenaKategorija;
    }

}
