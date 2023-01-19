/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class IntervencijeSacuvaj implements Serializable {
    
    private ArrayList<Intervencija> intervencijeZaCuvanje;
    private ArrayList<Intervencija> intervencijeZaIzmenu;
    private ArrayList<Intervencija> intervencijeZaBrisanje;

    public IntervencijeSacuvaj() {
    }

    public IntervencijeSacuvaj(ArrayList<Intervencija> intervencijeZaCuvanje, ArrayList<Intervencija> intervencijeZaIzmenu, ArrayList<Intervencija> intervencijeZaBrisanje) {
        this.intervencijeZaCuvanje = intervencijeZaCuvanje;
        this.intervencijeZaIzmenu = intervencijeZaIzmenu;
        this.intervencijeZaBrisanje = intervencijeZaBrisanje;
    }

    public ArrayList<Intervencija> getIntervencijeZaBrisanje() {
        return intervencijeZaBrisanje;
    }

    public void setIntervencijeZaBrisanje(ArrayList<Intervencija> intervencijeZaBrisanje) {
        this.intervencijeZaBrisanje = intervencijeZaBrisanje;
    }

    public ArrayList<Intervencija> getIntervencijeZaCuvanje() {
        return intervencijeZaCuvanje;
    }

    public void setIntervencijeZaCuvanje(ArrayList<Intervencija> intervencijeZaCuvanje) {
        this.intervencijeZaCuvanje = intervencijeZaCuvanje;
    }

    public ArrayList<Intervencija> getIntervencijeZaIzmenu() {
        return intervencijeZaIzmenu;
    }

    public void setIntervencijeZaIzmenu(ArrayList<Intervencija> intervencijeZaIzmenu) {
        this.intervencijeZaIzmenu = intervencijeZaIzmenu;
    }
    
    
    
}
