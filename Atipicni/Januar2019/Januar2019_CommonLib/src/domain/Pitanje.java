/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;

/**
 *
 * @author Rastko
 */
public class Pitanje implements Serializable{
    private int pitanjeId;
    private String pitanje;
    private String tacanOdgovor;
    private int brojPoena;

    public Pitanje() {
    }

    public Pitanje(int pitanjeId, String pitanje, String tacanOdgovor, int brojPoena) {
        this.pitanjeId = pitanjeId;
        this.pitanje = pitanje;
        this.tacanOdgovor = tacanOdgovor;
        this.brojPoena = brojPoena;
    }

    public int getBrojPoena() {
        return brojPoena;
    }

    public String getPitanje() {
        return pitanje;
    }

    public int getPitanjeId() {
        return pitanjeId;
    }

    public String getTacanOdgovor() {
        return tacanOdgovor;
    }

    public void setBrojPoena(int brojPoena) {
        this.brojPoena = brojPoena;
    }

    public void setPitanje(String pitanje) {
        this.pitanje = pitanje;
    }

    public void setPitanjeId(int pitanjeId) {
        this.pitanjeId = pitanjeId;
    }

    public void setTacanOdgovor(String tacanOdgovor) {
        this.tacanOdgovor = tacanOdgovor;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Pitanje)
            return ((Pitanje)o).getPitanjeId()==this.pitanjeId;
        return false;
    }

    @Override
    public String toString() {
        return pitanje;
    }
    
    
    
    
}
