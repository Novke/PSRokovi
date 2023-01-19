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
 * @author Korisnik
 */
public class Sekcija implements Serializable {

    private long sekcijaID;
    private String naziv;
    private Date datumVremeOd;
    private Date datumVremeDo;
    private String sala;
    private String moderator;
    private Kategorija kategorija;
    private ArrayList<RasporedSekcije> radoviSekcije;

    public Sekcija(long sekcijaID, String naziv, Date datumVremeOd, Date datumVremeDo, String sala, String moderator, Kategorija kategorija, ArrayList<RasporedSekcije> radoviSekcije) {
        this.sekcijaID = sekcijaID;
        this.naziv = naziv;
        this.datumVremeOd = datumVremeOd;
        this.datumVremeDo = datumVremeDo;
        this.sala = sala;
        this.moderator = moderator;
        this.kategorija = kategorija;
        this.radoviSekcije = radoviSekcije;
    }

    public Sekcija() {
    }

    public long getSekcijaID() {
        return sekcijaID;
    }

    public void setSekcijaID(long sekcijaID) {
        this.sekcijaID = sekcijaID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Date getDatumVremeOd() {
        return datumVremeOd;
    }

    public void setDatumVremeOd(Date datumVremeOd) {
        this.datumVremeOd = datumVremeOd;
    }

    public Date getDatumVremeDo() {
        return datumVremeDo;
    }

    public void setDatumVremeDo(Date datumVremeDo) {
        this.datumVremeDo = datumVremeDo;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getModerator() {
        return moderator;
    }

    public void setModerator(String moderator) {
        this.moderator = moderator;
    }

    public Kategorija getKategorija() {
        return kategorija;
    }

    public void setKategorija(Kategorija kategorija) {
        this.kategorija = kategorija;
    }

    public ArrayList<RasporedSekcije> getRadoviSekcije() {
        return radoviSekcije;
    }

    public void setRadoviSekcije(ArrayList<RasporedSekcije> radoviSekcije) {
        this.radoviSekcije = radoviSekcije;
    }

}
