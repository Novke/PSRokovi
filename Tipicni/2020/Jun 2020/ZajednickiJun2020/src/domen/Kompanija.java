/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author PC
 */
public class Kompanija implements Serializable{
    
    private long kompanijaId;
    private String naziv;
    private String tipKompanija;
    private boolean pdvobveznik;
    private String maticniBroj;
    private Date datumVremeEvidentiranja;
    private int brojZaposlenih;
    private Korisnik korisnik;
    private ArrayList<Zaposleni> listaZaposlenih;
    
    public Kompanija() {
    }

    public Kompanija(long kompanijaId, String naziv, String tipKompanija, boolean pdvobveznik, String maticniBroj, Date datumVremeEvidentiranja, int brojZaposlenih, Korisnik korisnik, ArrayList<Zaposleni> listaZaposlenih) {
        this.kompanijaId = kompanijaId;
        this.naziv = naziv;
        this.tipKompanija = tipKompanija;
        this.pdvobveznik = pdvobveznik;
        this.maticniBroj = maticniBroj;
        this.datumVremeEvidentiranja = datumVremeEvidentiranja;
        this.brojZaposlenih = brojZaposlenih;
        this.korisnik = korisnik;
        this.listaZaposlenih = listaZaposlenih;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public long getKompanijaId() {
        return kompanijaId;
    }

    public void setKompanijaId(long kompanijaId) {
        this.kompanijaId = kompanijaId;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getTipKompanija() {
        return tipKompanija;
    }

    public void setTipKompanija(String tipKompanija) {
        this.tipKompanija = tipKompanija;
    }

    

    public String getMaticniBroj() {
        return maticniBroj;
    }

    public void setMaticniBroj(String maticniBroj) {
        this.maticniBroj = maticniBroj;
    }

    public Date getDatumVremeEvidentiranja() {
        return datumVremeEvidentiranja;
    }

    public void setDatumVremeEvidentiranja(Date datumVremeEvidentiranja) {
        this.datumVremeEvidentiranja = datumVremeEvidentiranja;
    }

    public int getBrojZaposlenih() {
        return brojZaposlenih;
    }

    public void setBrojZaposlenih(int brojZaposlenih) {
        this.brojZaposlenih = brojZaposlenih;
    }

    @Override
    public String toString() {
        return naziv;
    }

    public boolean isPdvobveznik() {
        return pdvobveznik;
    }

    public void setPdvobveznik(boolean pdvobveznik) {
        this.pdvobveznik = pdvobveznik;
    }

    public ArrayList<Zaposleni> getListaZaposlenih() {
        return listaZaposlenih;
    }

    public void setListaZaposlenih(ArrayList<Zaposleni> listaZaposlenih) {
        this.listaZaposlenih = listaZaposlenih;
    }

    
    
}
