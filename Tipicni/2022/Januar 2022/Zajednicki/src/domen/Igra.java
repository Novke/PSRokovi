/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class Igra implements Serializable {
    
    private int igraID;
    private String naziv;
    private String zanr;
    private String opis;
    private String korisnik;
    private Izdavac izdavac;
    private ArrayList<Dostupnost> listaDostupnosti;

    public Igra() {
    }

    public Igra(int igraID, String naziv, String zanr, String opis, String korisnik, Izdavac izdavac, ArrayList<Dostupnost> listaDostupnosti) {
        this.igraID = igraID;
        this.naziv = naziv;
        this.zanr = zanr;
        this.opis = opis;
        this.korisnik = korisnik;
        this.izdavac = izdavac;
        this.listaDostupnosti = listaDostupnosti;
    }

    public Izdavac getIzdavac() {
        return izdavac;
    }

    public void setIzdavac(Izdavac izdavac) {
        this.izdavac = izdavac;
    }

    public int getIgraID() {
        return igraID;
    }

    public void setIgraID(int igraID) {
        this.igraID = igraID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getZanr() {
        return zanr;
    }

    public void setZanr(String zanr) {
        this.zanr = zanr;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(String korisnik) {
        this.korisnik = korisnik;
    }

    public ArrayList<Dostupnost> getListaDostupnosti() {
        return listaDostupnosti;
    }

    public void setListaDostupnosti(ArrayList<Dostupnost> listaDostupnosti) {
        this.listaDostupnosti = listaDostupnosti;
    }
    
}
