/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author PC
 */
public class Izdanje implements Serializable {
    
    private int izdanjeID;
    private Date datum;
    private int broj;
    private Publikacija publikacija;
    private ArrayList<Pomocna> pomocne;
    
    public Izdanje() {
    }

    public Izdanje(int izdanjeID, Date datum, int broj, Publikacija publikacija, ArrayList<Pomocna> pomocne) {
        this.izdanjeID = izdanjeID;
        this.datum = datum;
        this.broj = broj;
        this.publikacija = publikacija;
        this.pomocne = pomocne;
    }

    

    public Publikacija getPublikacija() {
        return publikacija;
    }

    public void setPublikacija(Publikacija publikacija) {
        this.publikacija = publikacija;
    }

    public int getIzdanjeID() {
        return izdanjeID;
    }

    public void setIzdanjeID(int izdanjeID) {
        this.izdanjeID = izdanjeID;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public int getBroj() {
        return broj;
    }

    public void setBroj(int broj) {
        this.broj = broj;
    }

    @Override
    public String toString() {
        return "Izdanje{" + "izdanjeID=" + izdanjeID + ", datum=" + datum + ", broj=" + broj + ", publikacija=" + publikacija + '}';
    }

    public ArrayList<Pomocna> getPomocne() {
        return pomocne;
    }

    public void setPomocne(ArrayList<Pomocna> pomocne) {
        this.pomocne = pomocne;
    }
    
}
