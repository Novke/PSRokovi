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
public class Radnik implements Serializable {
    
    private int radnikID;
    private String ime;
    private String prezime;
    private int brojLicence;
    private String strucnaSprema;
    private String status;

    public Radnik(int radnikID, String ime, String prezime, int brojLicence, String strucnaSprema, String status) {
        this.radnikID = radnikID;
        this.ime = ime;
        this.prezime = prezime;
        this.brojLicence = brojLicence;
        this.strucnaSprema = strucnaSprema;
        this.status = status;
    }

    public Radnik() {
    }

    public int getRadnikID() {
        return radnikID;
    }

    public void setRadnikID(int radnikID) {
        this.radnikID = radnikID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public int getBrojLicence() {
        return brojLicence;
    }

    public void setBrojLicence(int brojLicence) {
        this.brojLicence = brojLicence;
    }

    public String getStrucnaSprema() {
        return strucnaSprema;
    }

    public void setStrucnaSprema(String strucnaSprema) {
        this.strucnaSprema = strucnaSprema;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }
    
}
