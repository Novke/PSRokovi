/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author PC
 */
public class Prijava implements Serializable {
    
    private long prijavaID;
    private String drzavljanstvo;
    private String JMBG;
    private String ime;
    private String prezime;
    private String elektronskaPosta;
    private String mobilniTelefon;
    private boolean specificnaOboljenja;
    private Date datumPrijave;
    private Opstina opstina;
    private ArrayList<StavkaPrijave> stavkePrijave;

    public Prijava() {
    }

    public Prijava(long prijavaID, String drzavljanstvo, String JMBG, String ime, String prezime, String elektronskaPosta, String mobilniTelefon, boolean specificnaOboljenja, Date datumPrijave, Opstina opstina, ArrayList<StavkaPrijave> stavkePrijave) {
        this.prijavaID = prijavaID;
        this.drzavljanstvo = drzavljanstvo;
        this.JMBG = JMBG;
        this.ime = ime;
        this.prezime = prezime;
        this.elektronskaPosta = elektronskaPosta;
        this.mobilniTelefon = mobilniTelefon;
        this.specificnaOboljenja = specificnaOboljenja;
        this.datumPrijave = datumPrijave;
        this.opstina = opstina;
        this.stavkePrijave = stavkePrijave;
    }

    

    public Opstina getOpstina() {
        return opstina;
    }

    public void setOpstina(Opstina opstina) {
        this.opstina = opstina;
    }

    public long getPrijavaID() {
        return prijavaID;
    }

    public void setPrijavaID(long prijavaID) {
        this.prijavaID = prijavaID;
    }

    public String getDrzavljanstvo() {
        return drzavljanstvo;
    }

    public void setDrzavljanstvo(String drzavljanstvo) {
        this.drzavljanstvo = drzavljanstvo;
    }

    public String getJMBG() {
        return JMBG;
    }

    public void setJMBG(String JMBG) {
        this.JMBG = JMBG;
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

    public String getElektronskaPosta() {
        return elektronskaPosta;
    }

    public void setElektronskaPosta(String elektronskaPosta) {
        this.elektronskaPosta = elektronskaPosta;
    }

    public String getMobilniTelefon() {
        return mobilniTelefon;
    }

    public void setMobilniTelefon(String mobilniTelefon) {
        this.mobilniTelefon = mobilniTelefon;
    }

    public boolean isSpecificnaOboljenja() {
        return specificnaOboljenja;
    }

    public void setSpecificnaOboljenja(boolean specificnaOboljenja) {
        this.specificnaOboljenja = specificnaOboljenja;
    }

    public Date getDatumPrijave() {
        return datumPrijave;
    }

    public void setDatumPrijave(Date datumPrijave) {
        this.datumPrijave = datumPrijave;
    }

    public ArrayList<StavkaPrijave> getStavkePrijave() {
        return stavkePrijave;
    }

    public void setStavkePrijave(ArrayList<StavkaPrijave> stavkePrijave) {
        this.stavkePrijave = stavkePrijave;
    }
    
    
    
}
