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
public class Dogadjaj implements Serializable {
    
    private long dogadjajID;
    private String naziv;
    private String opis;
    private Date datumOd;
    private Date datumDo;
    private String tipDogadjaja;
    private Korisnik korisnikOrganizator;
    private ArrayList<Ucesce> listaUcesca;

    public Dogadjaj() {
    }

    public Dogadjaj(long dogadjajID, String naziv, String opis, Date datumOd, Date datumDo, String tipDogadjaja, Korisnik korisnikOrganizator, ArrayList<Ucesce> listaUcesca) {
        this.dogadjajID = dogadjajID;
        this.naziv = naziv;
        this.opis = opis;
        this.datumOd = datumOd;
        this.datumDo = datumDo;
        this.tipDogadjaja = tipDogadjaja;
        this.korisnikOrganizator = korisnikOrganizator;
        this.listaUcesca = listaUcesca;
    }

    public Korisnik getKorisnikOrganizator() {
        return korisnikOrganizator;
    }

    public void setKorisnikOrganizator(Korisnik korisnikOrganizator) {
        this.korisnikOrganizator = korisnikOrganizator;
    }

    public long getDogadjajID() {
        return dogadjajID;
    }

    public void setDogadjajID(long dogadjajID) {
        this.dogadjajID = dogadjajID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Date getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(Date datumOd) {
        this.datumOd = datumOd;
    }

    public Date getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(Date datumDo) {
        this.datumDo = datumDo;
    }

    public ArrayList<Ucesce> getListaUcesca() {
        return listaUcesca;
    }

    public void setListaUcesca(ArrayList<Ucesce> listaUcesca) {
        this.listaUcesca = listaUcesca;
    }

    public String getTipDogadjaja() {
        return tipDogadjaja;
    }

    public void setTipDogadjaja(String tipDogadjaja) {
        this.tipDogadjaja = tipDogadjaja;
    }
    
    
    
}
