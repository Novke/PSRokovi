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
public class TipEmisije implements Serializable {
    
    private long tipEmisijeID;
    private String naziv;
    private TipEmisije nadtipEmisije;

    @Override
    public String toString() {
        return naziv;
    }

    public TipEmisije(long tipEmisijeID, String naziv, TipEmisije nadtipEmisije) {
        this.tipEmisijeID = tipEmisijeID;
        this.naziv = naziv;
        this.nadtipEmisije = nadtipEmisije;
    }

    public TipEmisije() {
    }

    public long getTipEmisijeID() {
        return tipEmisijeID;
    }

    public void setTipEmisijeID(long tipEmisijeID) {
        this.tipEmisijeID = tipEmisijeID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public TipEmisije getNadtipEmisije() {
        return nadtipEmisije;
    }

    public void setNadtipEmisije(TipEmisije nadtipEmisije) {
        this.nadtipEmisije = nadtipEmisije;
    }
    
}
