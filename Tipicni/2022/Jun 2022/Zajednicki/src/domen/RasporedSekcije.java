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
public class RasporedSekcije implements Serializable {
    
    private Sekcija sekcija;
    private int rb;
    private String status;
    private Rad rad;

    public RasporedSekcije(Sekcija sekcija, int rb, String status, Rad rad) {
        this.sekcija = sekcija;
        this.rb = rb;
        this.status = status;
        this.rad = rad;
    }

    public RasporedSekcije() {
    }

    public Sekcija getSekcija() {
        return sekcija;
    }

    public void setSekcija(Sekcija sekcija) {
        this.sekcija = sekcija;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Rad getRad() {
        return rad;
    }

    public void setRad(Rad rad) {
        this.rad = rad;
    }
    
}
