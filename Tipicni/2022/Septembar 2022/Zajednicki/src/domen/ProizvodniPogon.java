/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;

/**
 *
 * @author Korisnik
 */
public class ProizvodniPogon implements Serializable {
    
    private long proizvodniPogonID;
    private String naziv;
    private String adresa;

    @Override
    public String toString() {
        return naziv;
    }

    public ProizvodniPogon(long proizvodniPogonID, String naziv, String adresa) {
        this.proizvodniPogonID = proizvodniPogonID;
        this.naziv = naziv;
        this.adresa = adresa;
    }

    public ProizvodniPogon() {
    }

    public long getProizvodniPogonID() {
        return proizvodniPogonID;
    }

    public void setProizvodniPogonID(long proizvodniPogonID) {
        this.proizvodniPogonID = proizvodniPogonID;
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
    
}
