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
public class Delo implements Serializable {
    
    private long deloID;
    private String naziv;

    public Delo(long deloID, String naziv) {
        this.deloID = deloID;
        this.naziv = naziv;
    }

    public Delo() {
    }

    public long getDeloID() {
        return deloID;
    }

    public void setDeloID(long deloID) {
        this.deloID = deloID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
    
}
