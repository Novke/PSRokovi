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
public class Takmicenje implements Serializable {
    
    private int takmicenjeID;
    private String nazivTakmicenja;
    private String vrstaTrke;
    private String opis;
    private Date datum;

    @Override
    public String toString() {
        return nazivTakmicenja;
    }

    public Takmicenje(int takmicenjeID, String nazivTakmicenja, String vrstaTrke, String opis, Date datum) {
        this.takmicenjeID = takmicenjeID;
        this.nazivTakmicenja = nazivTakmicenja;
        this.vrstaTrke = vrstaTrke;
        this.opis = opis;
        this.datum = datum;
    }

    public Takmicenje() {
    }

    public int getTakmicenjeID() {
        return takmicenjeID;
    }

    public void setTakmicenjeID(int takmicenjeID) {
        this.takmicenjeID = takmicenjeID;
    }

    public String getNazivTakmicenja() {
        return nazivTakmicenja;
    }

    public void setNazivTakmicenja(String nazivTakmicenja) {
        this.nazivTakmicenja = nazivTakmicenja;
    }

    public String getVrstaTrke() {
        return vrstaTrke;
    }

    public void setVrstaTrke(String vrstaTrke) {
        this.vrstaTrke = vrstaTrke;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }
    
}
