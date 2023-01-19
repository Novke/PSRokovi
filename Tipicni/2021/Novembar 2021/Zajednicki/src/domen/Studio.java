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
public class Studio implements Serializable {
    
    private int studioID;
    private String naziv;
    private String lokacija;
    private String status; 

    public Studio(int studioID, String naziv, String lokacija, String status) {
        this.studioID = studioID;
        this.naziv = naziv;
        this.lokacija = lokacija;
        this.status = status;
    }

    public Studio() {
    }

    public int getStudioID() {
        return studioID;
    }

    public void setStudioID(int studioID) {
        this.studioID = studioID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getLokacija() {
        return lokacija;
    }

    public void setLokacija(String lokacija) {
        this.lokacija = lokacija;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return naziv;
    }
    
}
