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
public class Rad implements Serializable {
    
    private long radID;
    private String naziv;
    private String autor1;
    private String autor2;
    private String autor3;

    @Override
    public String toString() {
        return naziv;
    }

    public Rad(long radID, String naziv, String autor1, String autor2, String autor3) {
        this.radID = radID;
        this.naziv = naziv;
        this.autor1 = autor1;
        this.autor2 = autor2;
        this.autor3 = autor3;
    }

    public Rad() {
    }

    public long getRadID() {
        return radID;
    }

    public void setRadID(long radID) {
        this.radID = radID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAutor1() {
        return autor1;
    }

    public void setAutor1(String autor1) {
        this.autor1 = autor1;
    }

    public String getAutor2() {
        return autor2;
    }

    public void setAutor2(String autor2) {
        this.autor2 = autor2;
    }

    public String getAutor3() {
        return autor3;
    }

    public void setAutor3(String autor3) {
        this.autor3 = autor3;
    }
    
}
