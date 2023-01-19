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
public class StavkaIzvestaja implements Serializable {
    
    private String studio;
    private int ukupnoEmisija;
    private int ukupnoAngazovanihSati;

    public StavkaIzvestaja() {
    }

    public StavkaIzvestaja(String studio, int ukupnoEmisija, int ukupnoAngazovanihSati) {
        this.studio = studio;
        this.ukupnoEmisija = ukupnoEmisija;
        this.ukupnoAngazovanihSati = ukupnoAngazovanihSati;
    }

    public int getUkupnoAngazovanihSati() {
        return ukupnoAngazovanihSati;
    }

    public void setUkupnoAngazovanihSati(int ukupnoAngazovanihSati) {
        this.ukupnoAngazovanihSati = ukupnoAngazovanihSati;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public int getUkupnoEmisija() {
        return ukupnoEmisija;
    }

    public void setUkupnoEmisija(int ukupnoEmisija) {
        this.ukupnoEmisija = ukupnoEmisija;
    }
    
}
