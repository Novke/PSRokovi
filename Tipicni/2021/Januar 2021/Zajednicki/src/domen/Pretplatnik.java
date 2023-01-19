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
public class Pretplatnik implements Serializable {
    
    private long pretplatnikID;
    private String ime;
    private String prezime;

    public Pretplatnik() {
    }

    public Pretplatnik(long pretplatnikID, String ime, String prezime) {
        this.pretplatnikID = pretplatnikID;
        this.ime = ime;
        this.prezime = prezime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public long getPretplatnikID() {
        return pretplatnikID;
    }

    public void setPretplatnikID(long pretplatnikID) {
        this.pretplatnikID = pretplatnikID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }
    
    
    
}
