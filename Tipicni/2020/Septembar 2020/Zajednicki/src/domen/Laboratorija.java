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
public class Laboratorija implements Serializable {
    
    private int laboratorijaId;
    private String naziv;
    private int dnevniKapacitetTestova;
    private String grad;

    public Laboratorija() {
    }

    public Laboratorija(int laboratorijaId, String naziv, int dnevniKapacitetTestova, String grad) {
        this.laboratorijaId = laboratorijaId;
        this.naziv = naziv;
        this.dnevniKapacitetTestova = dnevniKapacitetTestova;
        this.grad = grad;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public int getLaboratorijaId() {
        return laboratorijaId;
    }

    public void setLaboratorijaId(int laboratorijaId) {
        this.laboratorijaId = laboratorijaId;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getDnevniKapacitetTestova() {
        return dnevniKapacitetTestova;
    }

    public void setDnevniKapacitetTestova(int dnevniKapacitetTestova) {
        this.dnevniKapacitetTestova = dnevniKapacitetTestova;
    }

    @Override
    public String toString() {
        return naziv;
    }
    
    
    
}
