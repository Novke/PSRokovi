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
public class StavkaIzvestaja implements Serializable {

    private String pogon;
    private String vrsta;
    private int brojProizvedenihJedinica;
    private String ukupnoTrajanjeProizvodnje;

    public StavkaIzvestaja(String pogon, String vrsta, int brojProizvedenihJedinica, String ukupnoTrajanjeProizvodnje) {
        this.pogon = pogon;
        this.vrsta = vrsta;
        this.brojProizvedenihJedinica = brojProizvedenihJedinica;
        this.ukupnoTrajanjeProizvodnje = ukupnoTrajanjeProizvodnje;
    }

    public StavkaIzvestaja() {
    }

    public String getPogon() {
        return pogon;
    }

    public void setPogon(String pogon) {
        this.pogon = pogon;
    }

    public String getVrsta() {
        return vrsta;
    }

    public void setVrsta(String vrsta) {
        this.vrsta = vrsta;
    }

    public int getBrojProizvedenihJedinica() {
        return brojProizvedenihJedinica;
    }

    public void setBrojProizvedenihJedinica(int brojProizvedenihJedinica) {
        this.brojProizvedenihJedinica = brojProizvedenihJedinica;
    }

    public String getUkupnoTrajanjeProizvodnje() {
        return ukupnoTrajanjeProizvodnje;
    }

    public void setUkupnoTrajanjeProizvodnje(String ukupnoTrajanjeProizvodnje) {
        this.ukupnoTrajanjeProizvodnje = ukupnoTrajanjeProizvodnje;
    }

}
