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
public class Publikacija implements Serializable {
    
    private int publikacijaID;
    private String naziv;

    public Publikacija() {
    }

    public Publikacija(int publikacijaID, String naziv) {
        this.publikacijaID = publikacijaID;
        this.naziv = naziv;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getPublikacijaID() {
        return publikacijaID;
    }

    public void setPublikacijaID(int publikacijaID) {
        this.publikacijaID = publikacijaID;
    }

    @Override
    public String toString() {
        return naziv;
    }
    
    
}
