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
public class Ucesce implements Serializable {
    
    private Dogadjaj dogadjaj;
    private int rb;
    private String opisUcesca;
    private boolean obaveznoPrisustvo;
    private Korisnik korisnik;

    public Ucesce() {
    }

    public Ucesce(Dogadjaj dogadjaj, int rb, String opisUcesca, boolean obaveznoPrisustvo, Korisnik korisnik) {
        this.dogadjaj = dogadjaj;
        this.rb = rb;
        this.opisUcesca = opisUcesca;
        this.obaveznoPrisustvo = obaveznoPrisustvo;
        this.korisnik = korisnik;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Dogadjaj getDogadjaj() {
        return dogadjaj;
    }

    public void setDogadjaj(Dogadjaj dogadjaj) {
        this.dogadjaj = dogadjaj;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public String getOpisUcesca() {
        return opisUcesca;
    }

    public void setOpisUcesca(String opisUcesca) {
        this.opisUcesca = opisUcesca;
    }

    public boolean isObaveznoPrisustvo() {
        return obaveznoPrisustvo;
    }

    public void setObaveznoPrisustvo(boolean obaveznoPrisustvo) {
        this.obaveznoPrisustvo = obaveznoPrisustvo;
    }
    
    
    
}
