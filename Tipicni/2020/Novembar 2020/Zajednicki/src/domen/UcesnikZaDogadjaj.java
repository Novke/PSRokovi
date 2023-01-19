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
public class UcesnikZaDogadjaj implements Serializable {
    
    private int dogadjajID;
    private int rb;
    private String opisUcesca;
    private boolean obaveznoPrisustvo;
    private String imePrezimeKorisnika;

    public UcesnikZaDogadjaj() {
    }

    public UcesnikZaDogadjaj(int dogadjajID, int rb, String opisUcesca, boolean obaveznoPrisustvo, String imePrezimeKorisnika) {
        this.dogadjajID = dogadjajID;
        this.rb = rb;
        this.opisUcesca = opisUcesca;
        this.obaveznoPrisustvo = obaveznoPrisustvo;
        this.imePrezimeKorisnika = imePrezimeKorisnika;
    }

    public int getDogadjajID() {
        return dogadjajID;
    }

    public void setDogadjajID(int dogadjajID) {
        this.dogadjajID = dogadjajID;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public String getOpisUcesca() {
        return opisUcesca;
    }

    public void setOpisUcesca(String opisUcesca) {
        this.opisUcesca = opisUcesca;
    }

    public boolean isObaveznoPrisustvo() {
        return obaveznoPrisustvo;
    }

    public void setObaveznoPrisustvo(boolean obaveznoPrisustvo) {
        this.obaveznoPrisustvo = obaveznoPrisustvo;
    }

    public String getImePrezimeKorisnika() {
        return imePrezimeKorisnika;
    }

    public void setImePrezimeKorisnika(String imePrezimeKorisnika) {
        this.imePrezimeKorisnika = imePrezimeKorisnika;
    }
    
    
    
}
