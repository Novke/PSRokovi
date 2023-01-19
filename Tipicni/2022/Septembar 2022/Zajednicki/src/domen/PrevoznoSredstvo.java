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
 * @author Korisnik
 */
public class PrevoznoSredstvo implements Serializable {
    
    private long prevoznoSredstvoID;
    private String model;
    private Date datumVremePocetka;
    private Date datumVremeZavrsetka;
    private int ocekivaniRadniVek;
    private String rukovodilac;
    private String tipPrevoznogSredstva;
    private ProizvodniPogon proizvodniPogon;
    private ArrayList<StavkaPrevoznogSredstva> listaStavki;

    public PrevoznoSredstvo(long prevoznoSredstvoID, String model, Date datumVremePocetka, Date datumVremeZavrsetka, int ocekivaniRadniVek, String rukovodilac, String tipPrevoznogSredstva, ProizvodniPogon proizvodniPogon, ArrayList<StavkaPrevoznogSredstva> listaStavki) {
        this.prevoznoSredstvoID = prevoznoSredstvoID;
        this.model = model;
        this.datumVremePocetka = datumVremePocetka;
        this.datumVremeZavrsetka = datumVremeZavrsetka;
        this.ocekivaniRadniVek = ocekivaniRadniVek;
        this.rukovodilac = rukovodilac;
        this.tipPrevoznogSredstva = tipPrevoznogSredstva;
        this.proizvodniPogon = proizvodniPogon;
        this.listaStavki = listaStavki;
    }
    
    public PrevoznoSredstvo() {
    }

    public long getPrevoznoSredstvoID() {
        return prevoznoSredstvoID;
    }

    public void setPrevoznoSredstvoID(long prevoznoSredstvoID) {
        this.prevoznoSredstvoID = prevoznoSredstvoID;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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

    public int getOcekivaniRadniVek() {
        return ocekivaniRadniVek;
    }

    public void setOcekivaniRadniVek(int ocekivaniRadniVek) {
        this.ocekivaniRadniVek = ocekivaniRadniVek;
    }

    public String getRukovodilac() {
        return rukovodilac;
    }

    public void setRukovodilac(String rukovodilac) {
        this.rukovodilac = rukovodilac;
    }

    public ProizvodniPogon getProizvodniPogon() {
        return proizvodniPogon;
    }

    public void setProizvodniPogon(ProizvodniPogon proizvodniPogon) {
        this.proizvodniPogon = proizvodniPogon;
    }

    public String getTipPrevoznogSredstva() {
        return tipPrevoznogSredstva;
    }

    public void setTipPrevoznogSredstva(String tipPrevoznogSredstva) {
        this.tipPrevoznogSredstva = tipPrevoznogSredstva;
    }

    public ArrayList<StavkaPrevoznogSredstva> getListaStavki() {
        return listaStavki;
    }

    public void setListaStavki(ArrayList<StavkaPrevoznogSredstva> listaStavki) {
        this.listaStavki = listaStavki;
    }
    
}
