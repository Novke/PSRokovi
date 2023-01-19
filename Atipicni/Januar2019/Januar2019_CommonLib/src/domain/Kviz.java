/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Rastko
 */
public class Kviz implements Serializable{
    private int kvizId;
    private String naziv;
    private Date datumVremePocetka;
    private Date datumVremeKraja;
    private String pobednik;
    private List<Pitanje> pitanja;

    public Kviz() {
    }

    public Kviz(int kvizId, String naziv, Date datumVremePocetka, Date datumVremeKraja, String pobednik, List<Pitanje> pitanja) {
        this.kvizId = kvizId;
        this.naziv = naziv;
        this.datumVremePocetka = datumVremePocetka;
        this.datumVremeKraja = datumVremeKraja;
        this.pobednik = pobednik;
        this.pitanja = pitanja;
    }

    public String getPobednik() {
        return pobednik;
    }

    public void setPobednik(String pobednik) {
        this.pobednik = pobednik;
    }

    

    public Date getDatumVremeKraja() {
        return datumVremeKraja;
    }

    public Date getDatumVremePocetka() {
        return datumVremePocetka;
    }

    public int getKvizId() {
        return kvizId;
    }

    public String getNaziv() {
        return naziv;
    }

    public List<Pitanje> getPitanja() {
        return pitanja;
    }

    public void setDatumVremeKraja(Date datumVremeKraja) {
        this.datumVremeKraja = datumVremeKraja;
    }

    public void setDatumVremePocetka(Date datumVremePocetka) {
        this.datumVremePocetka = datumVremePocetka;
    }

    public void setKvizId(int kvizId) {
        this.kvizId = kvizId;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setPitanja(List<Pitanje> pitanja) {
        this.pitanja = pitanja;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Kviz)
            return ((Kviz)o).getKvizId()==this.kvizId;
        return false;
    }

    @Override
    public String toString() {
        return naziv;
    }
    
    
    
}
