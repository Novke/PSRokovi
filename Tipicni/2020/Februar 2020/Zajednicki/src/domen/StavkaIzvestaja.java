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
    
    private String imePrezimeRegrutera;
    private int ukupanBrojKandidata;
    private String imenaKandidata;

    public StavkaIzvestaja() {
    }

    public StavkaIzvestaja(String imePrezimeRegrutera, int ukupanBrojKandidata, String imenaKandidata) {
        this.imePrezimeRegrutera = imePrezimeRegrutera;
        this.ukupanBrojKandidata = ukupanBrojKandidata;
        this.imenaKandidata = imenaKandidata;
    }

    public String getImenaKandidata() {
        return imenaKandidata;
    }

    public void setImenaKandidata(String imenaKandidata) {
        this.imenaKandidata = imenaKandidata;
    }

    public String getImePrezimeRegrutera() {
        return imePrezimeRegrutera;
    }

    public void setImePrezimeRegrutera(String imePrezimeRegrutera) {
        this.imePrezimeRegrutera = imePrezimeRegrutera;
    }

    public int getUkupanBrojKandidata() {
        return ukupanBrojKandidata;
    }

    public void setUkupanBrojKandidata(int ukupanBrojKandidata) {
        this.ukupanBrojKandidata = ukupanBrojKandidata;
    }
    
    
    
}
