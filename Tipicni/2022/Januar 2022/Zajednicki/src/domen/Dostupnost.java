/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author PC
 */
public class Dostupnost implements Serializable {
    
    private Igra igra;
    private int rb;
    private String platforma;
    private Date datumObjave;
    private String status;

    public Dostupnost(Igra igra, int rb, String platforma, Date datumObjave, String status) {
        this.igra = igra;
        this.rb = rb;
        this.platforma = platforma;
        this.datumObjave = datumObjave;
        this.status = status;
    }

    public Dostupnost() {
    }

    public Igra getIgra() {
        return igra;
    }

    public void setIgra(Igra igra) {
        this.igra = igra;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public String getPlatforma() {
        return platforma;
    }

    public void setPlatforma(String platforma) {
        this.platforma = platforma;
    }

    public Date getDatumObjave() {
        return datumObjave;
    }

    public void setDatumObjave(Date datumObjave) {
        this.datumObjave = datumObjave;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
