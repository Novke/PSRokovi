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
public class PoreskaPrijava implements Serializable{
    
    private int poreskaPrijavaID;
    private String adresa;
    private String mestoNepokretnosti;
    private boolean mestoPrebivalista;
    private int brojListaNepokretnosti;
    private int godinaIzgradnje;
    private Date datumPocetkaKoriscenja;
    private double povrsina;
    private Date datumPodnosenjaPrijave;
    private PoreskiObveznik poreskiObveznik;
    private VrstaNepokretnosti vrstaNepokretnosti;

    public PoreskaPrijava() {
    }

    public PoreskaPrijava(int poreskaPrijavaID, String adresa, String mestoNepokretnosti, boolean mestoPrebivalista, int brojListaNepokretnosti, int godinaIzgradnje, Date datumPocetkaKoriscenja, double povrsina, Date datumPodnosenjaPrijave, PoreskiObveznik poreskiObveznik, VrstaNepokretnosti vrstaNepokretnosti) {
        this.poreskaPrijavaID = poreskaPrijavaID;
        this.adresa = adresa;
        this.mestoNepokretnosti = mestoNepokretnosti;
        this.mestoPrebivalista = mestoPrebivalista;
        this.brojListaNepokretnosti = brojListaNepokretnosti;
        this.godinaIzgradnje = godinaIzgradnje;
        this.datumPocetkaKoriscenja = datumPocetkaKoriscenja;
        this.povrsina = povrsina;
        this.datumPodnosenjaPrijave = datumPodnosenjaPrijave;
        this.poreskiObveznik = poreskiObveznik;
        this.vrstaNepokretnosti = vrstaNepokretnosti;
    }

    public VrstaNepokretnosti getVrstaNepokretnosti() {
        return vrstaNepokretnosti;
    }

    public void setVrstaNepokretnosti(VrstaNepokretnosti vrstaNepokretnosti) {
        this.vrstaNepokretnosti = vrstaNepokretnosti;
    }

    public int getPoreskaPrijavaID() {
        return poreskaPrijavaID;
    }

    public void setPoreskaPrijavaID(int poreskaPrijavaID) {
        this.poreskaPrijavaID = poreskaPrijavaID;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getMestoNepokretnosti() {
        return mestoNepokretnosti;
    }

    public void setMestoNepokretnosti(String mestoNepokretnosti) {
        this.mestoNepokretnosti = mestoNepokretnosti;
    }

    public boolean isMestoPrebivalista() {
        return mestoPrebivalista;
    }

    public void setMestoPrebivalista(boolean mestoPrebivalista) {
        this.mestoPrebivalista = mestoPrebivalista;
    }

    public int getBrojListaNepokretnosti() {
        return brojListaNepokretnosti;
    }

    public void setBrojListaNepokretnosti(int brojListaNepokretnosti) {
        this.brojListaNepokretnosti = brojListaNepokretnosti;
    }

    public int getGodinaIzgradnje() {
        return godinaIzgradnje;
    }

    public void setGodinaIzgradnje(int godinaIzgradnje) {
        this.godinaIzgradnje = godinaIzgradnje;
    }

    public Date getDatumPocetkaKoriscenja() {
        return datumPocetkaKoriscenja;
    }

    public void setDatumPocetkaKoriscenja(Date datumPocetkaKoriscenja) {
        this.datumPocetkaKoriscenja = datumPocetkaKoriscenja;
    }

    public double getPovrsina() {
        return povrsina;
    }

    public void setPovrsina(double povrsina) {
        this.povrsina = povrsina;
    }

    public Date getDatumPodnosenjaPrijave() {
        return datumPodnosenjaPrijave;
    }

    public void setDatumPodnosenjaPrijave(Date datumPodnosenjaPrijave) {
        this.datumPodnosenjaPrijave = datumPodnosenjaPrijave;
    }

    public PoreskiObveznik getPoreskiObveznik() {
        return poreskiObveznik;
    }

    public void setPoreskiObveznik(PoreskiObveznik poreskiObveznik) {
        this.poreskiObveznik = poreskiObveznik;
    }
    
    
}
