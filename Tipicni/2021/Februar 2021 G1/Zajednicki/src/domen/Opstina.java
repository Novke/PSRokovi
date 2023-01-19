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
public class Opstina implements Serializable {
    
    private long opstinaID;
    private int pttBroj;
    private String naziv;

    public Opstina() {
    }

    public Opstina(long opstinaID, int pttBroj, String naziv) {
        this.opstinaID = opstinaID;
        this.pttBroj = pttBroj;
        this.naziv = naziv;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public long getOpstinaID() {
        return opstinaID;
    }

    public void setOpstinaID(long opstinaID) {
        this.opstinaID = opstinaID;
    }

    public int getPttBroj() {
        return pttBroj;
    }

    public void setPttBroj(int pttBroj) {
        this.pttBroj = pttBroj;
    }

    @Override
    public String toString() {
        return naziv;
    }
    
    
    
}
