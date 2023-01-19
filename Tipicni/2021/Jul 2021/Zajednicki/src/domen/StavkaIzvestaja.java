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
public class StavkaIzvestaja implements Serializable {
    
    private int takmicarID;
    private String imePrezime;
    private String takmicenje;
    private Date datumVremePocetka;
    private Date datumVremeZavrsetka;
    private String vremeTakmicara;

    public StavkaIzvestaja(int takmicarID, String imePrezime, String takmicenje, Date datumVremePocetka, Date datumVremeZavrsetka, String vremeTakmicara) {
        this.takmicarID = takmicarID;
        this.imePrezime = imePrezime;
        this.takmicenje = takmicenje;
        this.datumVremePocetka = datumVremePocetka;
        this.datumVremeZavrsetka = datumVremeZavrsetka;
        this.vremeTakmicara = vremeTakmicara;
    }

    public StavkaIzvestaja() {
    }

    public int getTakmicarID() {
        return takmicarID;
    }

    public void setTakmicarID(int takmicarID) {
        this.takmicarID = takmicarID;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public String getTakmicenje() {
        return takmicenje;
    }

    public void setTakmicenje(String takmicenje) {
        this.takmicenje = takmicenje;
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

    public String getVremeTakmicara() {
        return vremeTakmicara;
    }

    public void setVremeTakmicara(String vremeTakmicara) {
        this.vremeTakmicara = vremeTakmicara;
    }
    
}
