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
public class VrstaNepokretnosti implements Serializable{
    
    private int vrstaNepokretnostiID;
    private String nazivVrsteNepokretnosti;
    private String poreskaGrupa;

    public VrstaNepokretnosti() {
    }

    public VrstaNepokretnosti(int vrstaNepokretnostiID, String nazivVrsteNepokretnosti, String poreskaGrupa) {
        this.vrstaNepokretnostiID = vrstaNepokretnostiID;
        this.nazivVrsteNepokretnosti = nazivVrsteNepokretnosti;
        this.poreskaGrupa = poreskaGrupa;
    }

    public String getPoreskaGrupa() {
        return poreskaGrupa;
    }

    public void setPoreskaGrupa(String poreskaGrupa) {
        this.poreskaGrupa = poreskaGrupa;
    }

    public int getVrstaNepokretnostiID() {
        return vrstaNepokretnostiID;
    }

    public void setVrstaNepokretnostiID(int vrstaNepokretnostiID) {
        this.vrstaNepokretnostiID = vrstaNepokretnostiID;
    }

    public String getNazivVrsteNepokretnosti() {
        return nazivVrsteNepokretnosti;
    }

    public void setNazivVrsteNepokretnosti(String nazivVrsteNepokretnosti) {
        this.nazivVrsteNepokretnosti = nazivVrsteNepokretnosti;
    }

    @Override
    public String toString() {
        return nazivVrsteNepokretnosti;
    }
    
    
}
