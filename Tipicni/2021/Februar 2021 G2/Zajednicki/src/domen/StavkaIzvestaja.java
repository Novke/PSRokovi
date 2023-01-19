/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

/**
 *
 * @author PC
 */
public class StavkaIzvestaja {
    
    private int prijavaID;
    private String imePrezime;
    private String JMBG;
    private String strucnaSprema;
    private String lokacija;
    private String elektronskaPosta;
    private String telefon;
    private boolean zdravstvenoOsiguran;

    public StavkaIzvestaja() {
    }

    public StavkaIzvestaja(int prijavaID, String imePrezime, String JMBG, String strucnaSprema, String lokacija, String elektronskaPosta, String telefon, boolean zdravstvenoOsiguran) {
        this.prijavaID = prijavaID;
        this.imePrezime = imePrezime;
        this.JMBG = JMBG;
        this.strucnaSprema = strucnaSprema;
        this.lokacija = lokacija;
        this.elektronskaPosta = elektronskaPosta;
        this.telefon = telefon;
        this.zdravstvenoOsiguran = zdravstvenoOsiguran;
    }

    

    public boolean isZdravstvenoOsiguran() {
        return zdravstvenoOsiguran;
    }

    public void setZdravstvenoOsiguran(boolean zdravstvenoOsiguran) {
        this.zdravstvenoOsiguran = zdravstvenoOsiguran;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public String getJMBG() {
        return JMBG;
    }

    public void setJMBG(String JMBG) {
        this.JMBG = JMBG;
    }

    public String getStrucnaSprema() {
        return strucnaSprema;
    }

    public void setStrucnaSprema(String strucnaSprema) {
        this.strucnaSprema = strucnaSprema;
    }

    public String getLokacija() {
        return lokacija;
    }

    public void setLokacija(String lokacija) {
        this.lokacija = lokacija;
    }

    public String getElektronskaPosta() {
        return elektronskaPosta;
    }

    public void setElektronskaPosta(String elektronskaPosta) {
        this.elektronskaPosta = elektronskaPosta;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public int getPrijavaID() {
        return prijavaID;
    }

    public void setPrijavaID(int prijavaID) {
        this.prijavaID = prijavaID;
    }
    
    
    
}
