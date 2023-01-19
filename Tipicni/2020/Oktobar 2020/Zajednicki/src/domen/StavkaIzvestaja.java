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
    
    private String imePrezimeNastavnika;
    private int brojPredmeta;

    public StavkaIzvestaja() {
    }

    public StavkaIzvestaja(String imePrezimeNastavnika, int brojPredmeta) {
        this.imePrezimeNastavnika = imePrezimeNastavnika;
        this.brojPredmeta = brojPredmeta;
    }

    public int getBrojPredmeta() {
        return brojPredmeta;
    }

    public void setBrojPredmeta(int brojPredmeta) {
        this.brojPredmeta = brojPredmeta;
    }

    public String getImePrezimeNastavnika() {
        return imePrezimeNastavnika;
    }

    public void setImePrezimeNastavnika(String imePrezimeNastavnika) {
        this.imePrezimeNastavnika = imePrezimeNastavnika;
    }
    
    
}
