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
public class DnevnaProizvodnjaIzvestaj implements Serializable {
    
    private long dnevnaProizvodnjaIzvestajID;
    private Date datum;
    private String opis;
    private Proizvodjac proizvodjac;
    private ArrayList<DnevnaProizvodnjaStavkaIzvestaja> listaStavki;

    public DnevnaProizvodnjaIzvestaj(long dnevnaProizvodnjaIzvestajID, Date datum, String opis, Proizvodjac proizvodjac, ArrayList<DnevnaProizvodnjaStavkaIzvestaja> listaStavki) {
        this.dnevnaProizvodnjaIzvestajID = dnevnaProizvodnjaIzvestajID;
        this.datum = datum;
        this.opis = opis;
        this.proizvodjac = proizvodjac;
        this.listaStavki = listaStavki;
    }


    public DnevnaProizvodnjaIzvestaj() {
    }

    public long getDnevnaProizvodnjaIzvestajID() {
        return dnevnaProizvodnjaIzvestajID;
    }

    public void setDnevnaProizvodnjaIzvestajID(long dnevnaProizvodnjaIzvestajID) {
        this.dnevnaProizvodnjaIzvestajID = dnevnaProizvodnjaIzvestajID;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Proizvodjac getProizvodjac() {
        return proizvodjac;
    }

    public void setProizvodjac(Proizvodjac proizvodjac) {
        this.proizvodjac = proizvodjac;
    }

    public ArrayList<DnevnaProizvodnjaStavkaIzvestaja> getListaStavki() {
        return listaStavki;
    }

    public void setListaStavki(ArrayList<DnevnaProizvodnjaStavkaIzvestaja> listaStavki) {
        this.listaStavki = listaStavki;
    }
    
}
