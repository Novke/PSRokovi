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
public class Let implements Serializable {
    
    private long letID;
    private Date datumVremePocetka;
    private Date datumVremeKraja;
    private String opis;
    private String tipAviona;
    private boolean redovanLet;
    private Aerodrom pocetniAerodrom;
    private Aerodrom krajnjiAerodrom;
    private ArrayList<Interkonekcija> interkonekcije;

    public Let() {
    }

    public Let(long letID, Date datumVremePocetka, Date datumVremeKraja, String opis, String tipAviona, boolean redovanLet, Aerodrom pocetniAerodrom, Aerodrom krajnjiAerodrom, ArrayList<Interkonekcija> interkonekcije) {
        this.letID = letID;
        this.datumVremePocetka = datumVremePocetka;
        this.datumVremeKraja = datumVremeKraja;
        this.opis = opis;
        this.tipAviona = tipAviona;
        this.redovanLet = redovanLet;
        this.pocetniAerodrom = pocetniAerodrom;
        this.krajnjiAerodrom = krajnjiAerodrom;
        this.interkonekcije = interkonekcije;
    }

    public Aerodrom getKrajnjiAerodrom() {
        return krajnjiAerodrom;
    }

    public void setKrajnjiAerodrom(Aerodrom krajnjiAerodrom) {
        this.krajnjiAerodrom = krajnjiAerodrom;
    }

    public long getLetID() {
        return letID;
    }

    public void setLetID(long letID) {
        this.letID = letID;
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

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getTipAviona() {
        return tipAviona;
    }

    public void setTipAviona(String tipAviona) {
        this.tipAviona = tipAviona;
    }

    public boolean isRedovanLet() {
        return redovanLet;
    }

    public void setRedovanLet(boolean redovanLet) {
        this.redovanLet = redovanLet;
    }

    public Aerodrom getPocetniAerodrom() {
        return pocetniAerodrom;
    }

    public void setPocetniAerodrom(Aerodrom pocetniAerodrom) {
        this.pocetniAerodrom = pocetniAerodrom;
    }

    public ArrayList<Interkonekcija> getInterkonekcije() {
        return interkonekcije;
    }

    public void setInterkonekcije(ArrayList<Interkonekcija> interkonekcije) {
        this.interkonekcije = interkonekcije;
    }
    
    
    
}
