/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

/**
 *
 * @author PC
 */
public class StavkaIzvestaja {
    
    private String kompanija;
    private String tip;
    private String imePrezime;
    private String ziroRacun;
    private double iznos;
    private String banka;

    public StavkaIzvestaja() {
    }

    public StavkaIzvestaja(String kompanija, String tip, String imePrezime, String ziroRacun, double iznos, String banka) {
        this.kompanija = kompanija;
        this.tip = tip;
        this.imePrezime = imePrezime;
        this.ziroRacun = ziroRacun;
        this.iznos = iznos;
        this.banka = banka;
    }

    

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
    }

    public String getKompanija() {
        return kompanija;
    }

    public void setKompanija(String kompanija) {
        this.kompanija = kompanija;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public String getZiroRacun() {
        return ziroRacun;
    }

    public void setZiroRacun(String ziroRacun) {
        this.ziroRacun = ziroRacun;
    }

    public String getBanka() {
        return banka;
    }

    public void setBanka(String banka) {
        this.banka = banka;
    }
    
    
    
}
