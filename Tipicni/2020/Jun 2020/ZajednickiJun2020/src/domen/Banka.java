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
public class Banka implements Serializable{
    
    private long bankaID;
    private String naziv;
    private String adresa;
    private int jedinstveniBrojPlatnogPrometa;

    public Banka() {
    }

    public Banka(long bankaID, String naziv, String adresa, int jedinstveniBrojPlatnogPrometa) {
        this.bankaID = bankaID;
        this.naziv = naziv;
        this.adresa = adresa;
        this.jedinstveniBrojPlatnogPrometa = jedinstveniBrojPlatnogPrometa;
    }

    public int getJedinstveniBrojPlatnogPrometa() {
        return jedinstveniBrojPlatnogPrometa;
    }

    public void setJedinstveniBrojPlatnogPrometa(int jedinstveniBrojPlatnogPrometa) {
        this.jedinstveniBrojPlatnogPrometa = jedinstveniBrojPlatnogPrometa;
    }

    public long getBankaID() {
        return bankaID;
    }

    public void setBankaID(long bankaID) {
        this.bankaID = bankaID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Banka other = (Banka) obj;
        if (this.bankaID != other.bankaID) {
            return false;
        }
        return true;
    }
    
    
    
}
