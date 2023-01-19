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
public class Predstava extends Delo implements Serializable {
    
    private Delo delo;
    private String reditelj;
    private String podela;
    private String size;
    
    @Override
    public String toString() {
        return podela.split(" ")[0] + " (" + delo.getNaziv() + ")";
    }

    public Predstava(Delo delo, String reditelj, String podela, String size) {
        this.delo = delo;
        this.reditelj = reditelj;
        this.podela = podela;
        this.size = size;
    }

    public Predstava() {
    }

    public Delo getDelo() {
        return delo;
    }

    public void setDelo(Delo delo) {
        this.delo = delo;
    }

    public String getReditelj() {
        return reditelj;
    }

    public void setReditelj(String reditelj) {
        this.reditelj = reditelj;
    }

    public String getPodela() {
        return podela;
    }

    public void setPodela(String podela) {
        this.podela = podela;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
    
}
