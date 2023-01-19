/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Korisnik
 */
public class StavkaIzvestaja implements Serializable {

    private String stanica;
    private String tipEmisije;
    private Date dan;
    private int brojEmisija;
    private int ukupnoTrajanje;

    public StavkaIzvestaja(String stanica, String tipEmisije, Date dan, int brojEmisija, int ukupnoTrajanje) {
        this.stanica = stanica;
        this.tipEmisije = tipEmisije;
        this.dan = dan;
        this.brojEmisija = brojEmisija;
        this.ukupnoTrajanje = ukupnoTrajanje;
    }

    public StavkaIzvestaja() {
    }

    public String getStanica() {
        return stanica;
    }

    public void setStanica(String stanica) {
        this.stanica = stanica;
    }

    public String getTipEmisije() {
        return tipEmisije;
    }

    public void setTipEmisije(String tipEmisije) {
        this.tipEmisije = tipEmisije;
    }

    public int getBrojEmisija() {
        return brojEmisija;
    }

    public void setBrojEmisija(int brojEmisija) {
        this.brojEmisija = brojEmisija;
    }

    public int getUkupnoTrajanje() {
        return ukupnoTrajanje;
    }

    public void setUkupnoTrajanje(int ukupnoTrajanje) {
        this.ukupnoTrajanje = ukupnoTrajanje;
    }

    public Date getDan() {
        return dan;
    }

    public void setDan(Date dan) {
        this.dan = dan;
    }

}
