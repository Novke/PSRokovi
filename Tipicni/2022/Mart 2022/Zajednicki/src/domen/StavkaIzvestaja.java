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
    
    private String nazivFestivala;
    private Date datumOd;
    private Date datumDo;
    private String izvodjenja;

    public StavkaIzvestaja(String nazivFestivala, Date datumOd, Date datumDo, String izvodjenja) {
        this.nazivFestivala = nazivFestivala;
        this.datumOd = datumOd;
        this.datumDo = datumDo;
        this.izvodjenja = izvodjenja;
    }

    public StavkaIzvestaja() {
    }

    public String getNazivFestivala() {
        return nazivFestivala;
    }

    public void setNazivFestivala(String nazivFestivala) {
        this.nazivFestivala = nazivFestivala;
    }

    public Date getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(Date datumOd) {
        this.datumOd = datumOd;
    }

    public Date getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(Date datumDo) {
        this.datumDo = datumDo;
    }

    public String getIzvodjenja() {
        return izvodjenja;
    }

    public void setIzvodjenja(String izvodjenja) {
        this.izvodjenja = izvodjenja;
    }
    
}
