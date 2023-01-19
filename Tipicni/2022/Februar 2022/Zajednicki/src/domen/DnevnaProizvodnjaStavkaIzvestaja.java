/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;

/**
 *
 * @author Korisnik
 */
public class DnevnaProizvodnjaStavkaIzvestaja implements Serializable {
    
    private DnevnaProizvodnjaIzvestaj dnevnaProizvodnjaIzvestaj;
    private int rb;
    private String vrstaKapaciteta;
    private double kolicina;
    private String jedinicaMere;
    private String napomena;

    public DnevnaProizvodnjaStavkaIzvestaja(DnevnaProizvodnjaIzvestaj dnevnaProizvodnjaIzvestaj, int rb, String vrstaKapaciteta, double kolicina, String jedinicaMere, String napomena) {
        this.dnevnaProizvodnjaIzvestaj = dnevnaProizvodnjaIzvestaj;
        this.rb = rb;
        this.vrstaKapaciteta = vrstaKapaciteta;
        this.kolicina = kolicina;
        this.jedinicaMere = jedinicaMere;
        this.napomena = napomena;
    }

    public DnevnaProizvodnjaStavkaIzvestaja() {
    }

    public DnevnaProizvodnjaIzvestaj getDnevnaProizvodnjaIzvestaj() {
        return dnevnaProizvodnjaIzvestaj;
    }

    public void setDnevnaProizvodnjaIzvestaj(DnevnaProizvodnjaIzvestaj dnevnaProizvodnjaIzvestaj) {
        this.dnevnaProizvodnjaIzvestaj = dnevnaProizvodnjaIzvestaj;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public String getVrstaKapaciteta() {
        return vrstaKapaciteta;
    }

    public void setVrstaKapaciteta(String vrstaKapaciteta) {
        this.vrstaKapaciteta = vrstaKapaciteta;
    }

    public double getKolicina() {
        return kolicina;
    }

    public void setKolicina(double kolicina) {
        this.kolicina = kolicina;
    }

    public String getJedinicaMere() {
        return jedinicaMere;
    }

    public void setJedinicaMere(String jedinicaMere) {
        this.jedinicaMere = jedinicaMere;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }
    
}
