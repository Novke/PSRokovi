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
public class Ugovor implements Serializable {
    
    private long ugovorID;
    private Date datumEvidentiranja;
    private String vrstaUgovora;
    private boolean dodatneUsluge;
    private double cena;
    private Paket paket;
    private Pretplatnik pretplatnik;

    public Ugovor() {
    }

    public Ugovor(long ugovorID, Date datumEvidentiranja, String vrstaUgovora, boolean dodatneUsluge, double cena, Paket paket, Pretplatnik pretplatnik) {
        this.ugovorID = ugovorID;
        this.datumEvidentiranja = datumEvidentiranja;
        this.vrstaUgovora = vrstaUgovora;
        this.dodatneUsluge = dodatneUsluge;
        this.cena = cena;
        this.paket = paket;
        this.pretplatnik = pretplatnik;
    }

    public Pretplatnik getPretplatnik() {
        return pretplatnik;
    }

    public void setPretplatnik(Pretplatnik pretplatnik) {
        this.pretplatnik = pretplatnik;
    }

    public long getUgovorID() {
        return ugovorID;
    }

    public void setUgovorID(long ugovorID) {
        this.ugovorID = ugovorID;
    }

    public Date getDatumEvidentiranja() {
        return datumEvidentiranja;
    }

    public void setDatumEvidentiranja(Date datumEvidentiranja) {
        this.datumEvidentiranja = datumEvidentiranja;
    }

    public String getVrstaUgovora() {
        return vrstaUgovora;
    }

    public void setVrstaUgovora(String vrstaUgovora) {
        this.vrstaUgovora = vrstaUgovora;
    }

    public boolean isDodatneUsluge() {
        return dodatneUsluge;
    }

    public void setDodatneUsluge(boolean dodatneUsluge) {
        this.dodatneUsluge = dodatneUsluge;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public Paket getPaket() {
        return paket;
    }

    public void setPaket(Paket paket) {
        this.paket = paket;
    }
    
    
    
}
