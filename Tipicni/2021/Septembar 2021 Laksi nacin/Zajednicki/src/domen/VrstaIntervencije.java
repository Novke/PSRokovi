/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;

/**
 *
 * @author PC
 */
public class VrstaIntervencije implements Serializable{
    
    private int vrstaIntervencijeID;
    private String nazivVrste;

    public VrstaIntervencije() {
    }

    public VrstaIntervencije(int vrstaIntervencijeID, String nazivVrste) {
        this.vrstaIntervencijeID = vrstaIntervencijeID;
        this.nazivVrste = nazivVrste;
    }

    public String getNazivVrste() {
        return nazivVrste;
    }

    public void setNazivVrste(String nazivVrste) {
        this.nazivVrste = nazivVrste;
    }

    public int getVrstaIntervencijeID() {
        return vrstaIntervencijeID;
    }

    public void setVrstaIntervencijeID(int vrstaIntervencijeID) {
        this.vrstaIntervencijeID = vrstaIntervencijeID;
    }

    @Override
    public String toString() {
        return nazivVrste;
    }
     
    
}
