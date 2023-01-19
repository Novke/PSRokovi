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
public class Prognoza implements Serializable {
    
    private int prognozaId;
    private Date dan;
    private String opis;
    private Meteorolog meteorolog;
    private ArrayList<PrognozaRegion> prognozeZaRegion;

    public Prognoza() {
    }

    public Prognoza(int prognozaId, Date dan, String opis, Meteorolog meteorolog, ArrayList<PrognozaRegion> prognozeZaRegion) {
        this.prognozaId = prognozaId;
        this.dan = dan;
        this.opis = opis;
        this.meteorolog = meteorolog;
        this.prognozeZaRegion = prognozeZaRegion;
    }

    

    public Meteorolog getMeteorolog() {
        return meteorolog;
    }

    public void setMeteorolog(Meteorolog meteorolog) {
        this.meteorolog = meteorolog;
    }

    public int getPrognozaId() {
        return prognozaId;
    }

    public void setPrognozaId(int prognozaId) {
        this.prognozaId = prognozaId;
    }

    public Date getDan() {
        return dan;
    }

    public void setDan(Date dan) {
        this.dan = dan;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public ArrayList<PrognozaRegion> getPrognozeZaRegion() {
        return prognozeZaRegion;
    }

    public void setPrognozeZaRegion(ArrayList<PrognozaRegion> prognozeZaRegion) {
        this.prognozeZaRegion = prognozeZaRegion;
    }
    
    
    
}
