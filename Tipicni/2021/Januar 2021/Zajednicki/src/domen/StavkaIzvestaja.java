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
    
    private long ugovorID;
    private String pretplatnik;
    private String paket;
    private String vrstaUgovora;
    private boolean dodatnaUsluga;
    private Date datumEvidentiranja;
    private double cena;

    public StavkaIzvestaja() {
    }

    public StavkaIzvestaja(long ugovorID, String pretplatnik, String paket, String vrstaUgovora, boolean dodatnaUsluga, Date datumEvidentiranja, double cena) {
        this.ugovorID = ugovorID;
        this.pretplatnik = pretplatnik;
        this.paket = paket;
        this.vrstaUgovora = vrstaUgovora;
        this.dodatnaUsluga = dodatnaUsluga;
        this.datumEvidentiranja = datumEvidentiranja;
        this.cena = cena;
    }

    

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getPretplatnik() {
        return pretplatnik;
    }

    public void setPretplatnik(String pretplatnik) {
        this.pretplatnik = pretplatnik;
    }

    public String getPaket() {
        return paket;
    }

    public void setPaket(String paket) {
        this.paket = paket;
    }

    public String getVrstaUgovora() {
        return vrstaUgovora;
    }

    public void setVrstaUgovora(String vrstaUgovora) {
        this.vrstaUgovora = vrstaUgovora;
    }

    public boolean isDodatnaUsluga() {
        return dodatnaUsluga;
    }

    public void setDodatnaUsluga(boolean dodatnaUsluga) {
        this.dodatnaUsluga = dodatnaUsluga;
    }

    public Date getDatumEvidentiranja() {
        return datumEvidentiranja;
    }

    public void setDatumEvidentiranja(Date datumEvidentiranja) {
        this.datumEvidentiranja = datumEvidentiranja;
    }

    public long getUgovorID() {
        return ugovorID;
    }

    public void setUgovorID(long ugovorID) {
        this.ugovorID = ugovorID;
    }
    
    
    
}
