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
 * @author Korisnik
 */
public class Izvodjenje implements Serializable {
    
    private Festival festival;
    private Delo delo;
    private Date datumVremePocetka;
    private Date datumVremeKraja;
    private String sala;

    public Izvodjenje(Festival festival, Delo delo, Date datumVremePocetka, Date datumVremeKraja, String sala) {
        this.festival = festival;
        this.delo = delo;
        this.datumVremePocetka = datumVremePocetka;
        this.datumVremeKraja = datumVremeKraja;
        this.sala = sala;
    }

    public Izvodjenje() {
    }

    public Festival getFestival() {
        return festival;
    }

    public void setFestival(Festival festival) {
        this.festival = festival;
    }

    public Delo getDelo() {
        return delo;
    }

    public void setDelo(Delo delo) {
        this.delo = delo;
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

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }
    
}
