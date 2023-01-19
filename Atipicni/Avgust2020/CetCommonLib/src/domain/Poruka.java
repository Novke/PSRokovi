/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Rastko
 */
public class Poruka implements Serializable{
    private long porukaId;
    private String posiljalac;
    private String prijemnik;
    private String poruka;
    private Date datum;

    public Poruka() {
    }

    public Poruka(long porukaId, String posiljalac, String prijemnik, String poruka, Date datum) {
        this.porukaId = porukaId;
        this.posiljalac = posiljalac;
        this.prijemnik = prijemnik;
        this.poruka = poruka;
        this.datum = datum;
    }

    public long getPorukaId() {
        return porukaId;
    }

    public void setPorukaId(long porukaId) {
        this.porukaId = porukaId;
    }

    public String getPosiljalac() {
        return posiljalac;
    }

    public void setPosiljalac(String posiljalac) {
        this.posiljalac = posiljalac;
    }

    public String getPrijemnik() {
        return prijemnik;
    }

    public void setPrijemnik(String prijemnik) {
        this.prijemnik = prijemnik;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }
    
    
}
