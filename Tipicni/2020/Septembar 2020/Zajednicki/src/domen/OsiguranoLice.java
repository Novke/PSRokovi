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
public class OsiguranoLice implements Serializable {
    
    private int osiguranoLiceId;
    private String ime;
    private String prezime;
    private String LBO;
    private String krvnaGrupa;

    public OsiguranoLice() {
    }

    public OsiguranoLice(int osiguranoLiceId, String ime, String prezime, String LBO, String krvnaGrupa) {
        this.osiguranoLiceId = osiguranoLiceId;
        this.ime = ime;
        this.prezime = prezime;
        this.LBO = LBO;
        this.krvnaGrupa = krvnaGrupa;
    }

    public String getKrvnaGrupa() {
        return krvnaGrupa;
    }

    public void setKrvnaGrupa(String krvnaGrupa) {
        this.krvnaGrupa = krvnaGrupa;
    }

    public int getOsiguranoLiceId() {
        return osiguranoLiceId;
    }

    public void setOsiguranoLiceId(int osiguranoLiceId) {
        this.osiguranoLiceId = osiguranoLiceId;
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

    public String getLBO() {
        return LBO;
    }

    public void setLBO(String LBO) {
        this.LBO = LBO;
    }
    
    @Override
    public String toString() {
        return ime + " " + prezime;
    }
    
}
