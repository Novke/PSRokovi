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
    private String JMBG;
    private String ime;
    private String prezime;
    private String elektronskaPosta;
    private String telefon;
    private boolean zdravstvenoOsiguran;
    private Date datumPrijave;
    private String strucnaSprema;
    private Lokacija lokacija;
    private ArrayList<PrijavaVolontiranje> listaVolontiranja;

    public Prijava() {
    }

    public Prijava(long prijavaID, String JMBG, String ime, String prezime, String elektronskaPosta, String telefon, boolean zdravstvenoOsiguran, Date datumPrijave, String strucnaSprema, Lokacija lokacija, ArrayList<PrijavaVolontiranje> listaVolontiranja) {
        this.prijavaID = prijavaID;
        this.JMBG = JMBG;
        this.ime = ime;
        this.prezime = prezime;
        this.elektronskaPosta = elektronskaPosta;
        this.telefon = telefon;
        this.zdravstvenoOsiguran = zdravstvenoOsiguran;
        this.datumPrijave = datumPrijave;
        this.strucnaSprema = strucnaSprema;
        this.lokacija = lokacija;
        this.listaVolontiranja = listaVolontiranja;
    }

    

    public Lokacija getLokacija() {
        return lokacija;
    }

    public void setLokacija(Lokacija lokacija) {
        this.lokacija = lokacija;
    }

    public long getPrijavaID() {
        return prijavaID;
    }

    public void setPrijavaID(long prijavaID) {
        this.prijavaID = prijavaID;
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

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public boolean isZdravstvenoOsiguran() {
        return zdravstvenoOsiguran;
    }

    public void setZdravstvenoOsiguran(boolean zdravstvenoOsiguran) {
        this.zdravstvenoOsiguran = zdravstvenoOsiguran;
    }

    public Date getDatumPrijave() {
        return datumPrijave;
    }

    public void setDatumPrijave(Date datumPrijave) {
        this.datumPrijave = datumPrijave;
    }

    public String getStrucnaSprema() {
        return strucnaSprema;
    }

    public void setStrucnaSprema(String strucnaSprema) {
        this.strucnaSprema = strucnaSprema;
    }

    public ArrayList<PrijavaVolontiranje> getListaVolontiranja() {
        return listaVolontiranja;
    }

    public void setListaVolontiranja(ArrayList<PrijavaVolontiranje> listaVolontiranja) {
        this.listaVolontiranja = listaVolontiranja;
    }
    
    
    
}
