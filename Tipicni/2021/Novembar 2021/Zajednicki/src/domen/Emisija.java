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
public class Emisija implements Serializable {
    
    private int emisijaID;
    private String nazivEmisije;
    private Date datumVremePocetka;
    private Date datumVremeKraja;
    private String nacinEmitovanja;
    private String producent;
    private Radnik voditeljRadnik;
    private Studio studio;
    private ArrayList<Angazovanje> angazovanja;

    public Emisija(int emisijaID, String nazivEmisije, Date datumVremePocetka, Date datumVremeKraja, String nacinEmitovanja, String producent, Radnik voditeljRadnik, Studio studio, ArrayList<Angazovanje> angazovanja) {
        this.emisijaID = emisijaID;
        this.nazivEmisije = nazivEmisije;
        this.datumVremePocetka = datumVremePocetka;
        this.datumVremeKraja = datumVremeKraja;
        this.nacinEmitovanja = nacinEmitovanja;
        this.producent = producent;
        this.voditeljRadnik = voditeljRadnik;
        this.studio = studio;
        this.angazovanja = angazovanja;
    }

    public Emisija() {
    }

    public int getEmisijaID() {
        return emisijaID;
    }

    public void setEmisijaID(int emisijaID) {
        this.emisijaID = emisijaID;
    }

    public String getNazivEmisije() {
        return nazivEmisije;
    }

    public void setNazivEmisije(String nazivEmisije) {
        this.nazivEmisije = nazivEmisije;
    }

    public Date getDatumVremePocetka() {
        return datumVremePocetka;
    }

    public void setDatumVremePocetka(Date datumVremePocetka) {
        this.datumVremePocetka = datumVremePocetka;
    }

    public Date getDatumVremeKraja() {
        return datumVremeKraja;
    }

    public void setDatumVremeKraja(Date datumVremeKraja) {
        this.datumVremeKraja = datumVremeKraja;
    }

    public String getNacinEmitovanja() {
        return nacinEmitovanja;
    }

    public void setNacinEmitovanja(String nacinEmitovanja) {
        this.nacinEmitovanja = nacinEmitovanja;
    }

    public String getProducent() {
        return producent;
    }

    public void setProducent(String producent) {
        this.producent = producent;
    }

    public Radnik getVoditeljRadnik() {
        return voditeljRadnik;
    }

    public void setVoditeljRadnik(Radnik voditeljRadnik) {
        this.voditeljRadnik = voditeljRadnik;
    }

    public Studio getStudio() {
        return studio;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }

    public ArrayList<Angazovanje> getAngazovanja() {
        return angazovanja;
    }

    public void setAngazovanja(ArrayList<Angazovanje> angazovanja) {
        this.angazovanja = angazovanja;
    }
    
}
