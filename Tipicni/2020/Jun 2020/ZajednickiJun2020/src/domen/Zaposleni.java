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
public class Zaposleni implements Serializable{
    
    private long zaposleniId;
    private String ime;
    private String prezime;
    private String jmbg;
    private String ziroRacun;
    private double iznos;
    private Kompanija kompanija;
    private Banka banka;

    public Zaposleni() {
    }

    public Zaposleni(long zaposleniId, String ime, String prezime, String jmbg, String ziroRacun, double iznos, Kompanija kompanija, Banka banka) {
        this.zaposleniId = zaposleniId;
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.ziroRacun = ziroRacun;
        this.iznos = iznos;
        this.kompanija = kompanija;
        this.banka = banka;
    }

    public Banka getBanka() {
        return banka;
    }

    public void setBanka(Banka banka) {
        this.banka = banka;
    }

    public long getZaposleniId() {
        return zaposleniId;
    }

    public void setZaposleniId(long zaposleniId) {
        this.zaposleniId = zaposleniId;
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

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getZiroRacun() {
        return ziroRacun;
    }

    public void setZiroRacun(String ziroRacun) {
        this.ziroRacun = ziroRacun;
    }

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
    }

    public Kompanija getKompanija() {
        return kompanija;
    }

    public void setKompanija(Kompanija kompanija) {
        this.kompanija = kompanija;
    }
    
}
