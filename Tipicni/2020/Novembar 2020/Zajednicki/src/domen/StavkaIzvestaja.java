/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.util.Date;

/**
 *
 * @author PC
 */
public class StavkaIzvestaja {
    
    private int dogadjajID;
    private String imePrezimeOrganizatora;
    private String naziv;
    private Date datumVremeOd;
    private Date datumVremeDo;

    public StavkaIzvestaja() {
    }

    public StavkaIzvestaja(int dogadjajID, String imePrezimeOrganizatora, String naziv, Date datumVremeOd, Date datumVremeDo) {
        this.dogadjajID = dogadjajID;
        this.imePrezimeOrganizatora = imePrezimeOrganizatora;
        this.naziv = naziv;
        this.datumVremeOd = datumVremeOd;
        this.datumVremeDo = datumVremeDo;
    }

    public Date getDatumVremeDo() {
        return datumVremeDo;
    }

    public void setDatumVremeDo(Date datumVremeDo) {
        this.datumVremeDo = datumVremeDo;
    }

    public int getDogadjajID() {
        return dogadjajID;
    }

    public void setDogadjajID(int dogadjajID) {
        this.dogadjajID = dogadjajID;
    }

    public String getImePrezimeOrganizatora() {
        return imePrezimeOrganizatora;
    }

    public void setImePrezimeOrganizatora(String imePrezimeOrganizatora) {
        this.imePrezimeOrganizatora = imePrezimeOrganizatora;
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
    
    
    
}
