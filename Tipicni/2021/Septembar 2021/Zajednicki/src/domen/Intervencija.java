/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author PC
 */
public class Intervencija implements Serializable{
    
    private int intervencijaID;
    private Date datumVremePocetka;
    private Date datumVremeZavrsetka;
    private String opis;
    private boolean angazovanjeIzvodjacaRadova;
    private double cena;
    private String status;
    private VrstaIntervencije vrstaIntervencije;
    private StambenaZajednica stambenaZajednica;
    private Upravnik upravnik;

    public Intervencija() {
    }

    public Intervencija(int intervencijaID, Date datumVremePocetka, Date datumVremeZavrsetka, String opis, boolean angazovanjeIzvodjacaRadova, double cena, String status, VrstaIntervencije vrstaIntervencije, StambenaZajednica stambenaZajednica, Upravnik upravnik) {
        this.intervencijaID = intervencijaID;
        this.datumVremePocetka = datumVremePocetka;
        this.datumVremeZavrsetka = datumVremeZavrsetka;
        this.opis = opis;
        this.angazovanjeIzvodjacaRadova = angazovanjeIzvodjacaRadova;
        this.cena = cena;
        this.status = status;
        this.vrstaIntervencije = vrstaIntervencije;
        this.stambenaZajednica = stambenaZajednica;
        this.upravnik = upravnik;
    }

    public Upravnik getUpravnik() {
        return upravnik;
    }

    public void setUpravnik(Upravnik upravnik) {
        this.upravnik = upravnik;
    }

    public int getIntervencijaID() {
        return intervencijaID;
    }

    public void setIntervencijaID(int intervencijaID) {
        this.intervencijaID = intervencijaID;
    }

    public Date getDatumVremePocetka() {
        return datumVremePocetka;
    }

    public void setDatumVremePocetka(Date datumVremePocetka) {
        this.datumVremePocetka = datumVremePocetka;
    }

    public Date getDatumVremeZavrsetka() {
        return datumVremeZavrsetka;
    }

    public void setDatumVremeZavrsetka(Date datumVremeZavrsetka) {
        this.datumVremeZavrsetka = datumVremeZavrsetka;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public boolean isAngazovanjeIzvodjacaRadova() {
        return angazovanjeIzvodjacaRadova;
    }

    public void setAngazovanjeIzvodjacaRadova(boolean angazovanjeIzvodjacaRadova) {
        this.angazovanjeIzvodjacaRadova = angazovanjeIzvodjacaRadova;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public VrstaIntervencije getVrstaIntervencije() {
        return vrstaIntervencije;
    }

    public void setVrstaIntervencije(VrstaIntervencije vrstaIntervencije) {
        this.vrstaIntervencije = vrstaIntervencije;
    }

    public StambenaZajednica getStambenaZajednica() {
        return stambenaZajednica;
    }

    public void setStambenaZajednica(StambenaZajednica stambenaZajednica) {
        this.stambenaZajednica = stambenaZajednica;
    }
    
    
}
