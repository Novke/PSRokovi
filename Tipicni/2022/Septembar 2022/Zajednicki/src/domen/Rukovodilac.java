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
public class Rukovodilac implements Serializable {
    
    private int rukovodilacID;
    private String ime;
    private String prezime;
    private String username;
    private String password;

    public Rukovodilac(int rukovodilacID, String ime, String prezime, String username, String password) {
        this.rukovodilacID = rukovodilacID;
        this.ime = ime;
        this.prezime = prezime;
        this.username = username;
        this.password = password;
    }

    public Rukovodilac() {
    }

    public int getRukovodilacID() {
        return rukovodilacID;
    }

    public void setRukovodilacID(int rukovodilacID) {
        this.rukovodilacID = rukovodilacID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
