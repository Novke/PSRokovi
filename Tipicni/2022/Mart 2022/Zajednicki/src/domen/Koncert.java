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
public class Koncert extends Delo implements Serializable {
    
    private Delo delo;
    private String izvodjac;
    private String program;

    @Override
    public String toString() {
        return program + " (" + delo.getNaziv() + ")";
    }

    public Koncert(Delo delo, String izvodjac, String program) {
        this.delo = delo;
        this.izvodjac = izvodjac;
        this.program = program;
    }

    public Koncert() {
    }

    public Delo getDelo() {
        return delo;
    }

    public void setDelo(Delo delo) {
        this.delo = delo;
    }

    public String getIzvodjac() {
        return izvodjac;
    }

    public void setIzvodjac(String izvodjac) {
        this.izvodjac = izvodjac;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }
    
}
