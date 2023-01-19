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
public class Ucesce implements Serializable {
    
    private int ucesceID;
    private String vrstaTrke;
    private Date datumVremePocetka;
    private Date datumVremeZavrsetka;
    private Takmicenje takmicenje;
    private Takmicar takmicar;
    private Organizator organizator;

    public Ucesce(int ucesceID, String vrstaTrke, Date datumVremePocetka, Date datumVremeZavrsetka, Takmicenje takmicenje, Takmicar takmicar, Organizator organizator) {
        this.ucesceID = ucesceID;
        this.vrstaTrke = vrstaTrke;
        this.datumVremePocetka = datumVremePocetka;
        this.datumVremeZavrsetka = datumVremeZavrsetka;
        this.takmicenje = takmicenje;
        this.takmicar = takmicar;
        this.organizator = organizator;
    }

    public Ucesce() {
    }

    public int getUcesceID() {
        return ucesceID;
    }

    public void setUcesceID(int ucesceID) {
        this.ucesceID = ucesceID;
    }

    public String getVrstaTrke() {
        return vrstaTrke;
    }

    public void setVrstaTrke(String vrstaTrke) {
        this.vrstaTrke = vrstaTrke;
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

    public Takmicenje getTakmicenje() {
        return takmicenje;
    }

    public void setTakmicenje(Takmicenje takmicenje) {
        this.takmicenje = takmicenje;
    }

    public Takmicar getTakmicar() {
        return takmicar;
    }

    public void setTakmicar(Takmicar takmicar) {
        this.takmicar = takmicar;
    }

    public Organizator getOrganizator() {
        return organizator;
    }

    public void setOrganizator(Organizator organizator) {
        this.organizator = organizator;
    }
    
}
