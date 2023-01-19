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
public class Komponenta implements Serializable {
    
    private long komponentaID;
    private String naziv;
    private String opis;

    @Override
    public String toString() {
        return naziv;
    }

    public Komponenta(long komponentaID, String naziv, String opis) {
        this.komponentaID = komponentaID;
        this.naziv = naziv;
        this.opis = opis;
    }

    public Komponenta() {
    }

    public long getKomponentaID() {
        return komponentaID;
    }

    public void setKomponentaID(long komponentaID) {
        this.komponentaID = komponentaID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
    
}
