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
public class Zahtev implements Serializable {
    
    private int zahtevId;
    private Date datumVremeTestiranja;
    private boolean hitno;
    private String tip;
    private String rezultat;
    private Date datumVremeRezultata;
    private String napomena;
    private String status;
    private OsiguranoLice osiguranoLice;
    private Laboratorija laboratorija;
    private Laborant laborant;

    public Zahtev() {
    }

    public Zahtev(int zahtevId, Date datumVremeTestiranja, boolean hitno, String tip, String rezultat, Date datumVremeRezultata, String napomena, String status, OsiguranoLice osiguranoLice, Laboratorija laboratorija, Laborant laborant) {
        this.zahtevId = zahtevId;
        this.datumVremeTestiranja = datumVremeTestiranja;
        this.hitno = hitno;
        this.tip = tip;
        this.rezultat = rezultat;
        this.datumVremeRezultata = datumVremeRezultata;
        this.napomena = napomena;
        this.status = status;
        this.osiguranoLice = osiguranoLice;
        this.laboratorija = laboratorija;
        this.laborant = laborant;
    }

    public Laborant getLaborant() {
        return laborant;
    }

    public void setLaborant(Laborant laborant) {
        this.laborant = laborant;
    }

    public int getZahtevId() {
        return zahtevId;
    }

    public void setZahtevId(int zahtevId) {
        this.zahtevId = zahtevId;
    }

    public Date getDatumVremeTestiranja() {
        return datumVremeTestiranja;
    }

    public void setDatumVremeTestiranja(Date datumVremeTestiranja) {
        this.datumVremeTestiranja = datumVremeTestiranja;
    }

    public boolean isHitno() {
        return hitno;
    }

    public void setHitno(boolean hitno) {
        this.hitno = hitno;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getRezultat() {
        return rezultat;
    }

    public void setRezultat(String rezultat) {
        this.rezultat = rezultat;
    }

    public Date getDatumVremeRezultata() {
        return datumVremeRezultata;
    }

    public void setDatumVremeRezultata(Date datumVremeRezultata) {
        this.datumVremeRezultata = datumVremeRezultata;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public OsiguranoLice getOsiguranoLice() {
        return osiguranoLice;
    }

    public void setOsiguranoLice(OsiguranoLice osiguranoLice) {
        this.osiguranoLice = osiguranoLice;
    }

    public Laboratorija getLaboratorija() {
        return laboratorija;
    }

    public void setLaboratorija(Laboratorija laboratorija) {
        this.laboratorija = laboratorija;
    }
    
    
    
}
