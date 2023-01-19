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
 * @author PC
 */
public class StavkaIzvestaja implements Serializable {
    
    private String imePrezimeMeteorologa;
    private Date dan;
    private String prognozaZaRegione;

    public StavkaIzvestaja() {
    }

    public StavkaIzvestaja(String imePrezimeMeteorologa, Date dan, String prognozaZaRegione) {
        this.imePrezimeMeteorologa = imePrezimeMeteorologa;
        this.dan = dan;
        this.prognozaZaRegione = prognozaZaRegione;
    }

    public String getPrognozaZaRegione() {
        return prognozaZaRegione;
    }

    public void setPrognozaZaRegione(String prognozaZaRegione) {
        this.prognozaZaRegione = prognozaZaRegione;
    }

    public String getImePrezimeMeteorologa() {
        return imePrezimeMeteorologa;
    }

    public void setImePrezimeMeteorologa(String imePrezimeMeteorologa) {
        this.imePrezimeMeteorologa = imePrezimeMeteorologa;
    }

    public Date getDan() {
        return dan;
    }

    public void setDan(Date dan) {
        this.dan = dan;
    }
    
    
    
}
