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
public class PrijavaVolontiranje implements Serializable {
    
    private Prijava prijava;
    private int rb;
    private String vrstaVolontiranja;

    public PrijavaVolontiranje() {
    }

    public PrijavaVolontiranje(Prijava prijava, int rb, String vrstaVolontiranja) {
        this.prijava = prijava;
        this.rb = rb;
        this.vrstaVolontiranja = vrstaVolontiranja;
    }

    public String getVrstaVolontiranja() {
        return vrstaVolontiranja;
    }

    public void setVrstaVolontiranja(String vrstaVolontiranja) {
        this.vrstaVolontiranja = vrstaVolontiranja;
    }

    public Prijava getPrijava() {
        return prijava;
    }

    public void setPrijava(Prijava prijava) {
        this.prijava = prijava;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }
    
    
    
}
