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
public class Vest implements Serializable {
    
    private Izdanje izdanje;
    private int rb;
    private String naslov;
    private String vest;

    public Vest() {
    }

    public Vest(Izdanje izdanje, int rb, String naslov, String vest) {
        this.izdanje = izdanje;
        this.rb = rb;
        this.naslov = naslov;
        this.vest = vest;
    }

    public String getVest() {
        return vest;
    }

    @Override
    public String toString() {
        return "Vest{" + "izdanje=" + izdanje + ", rb=" + rb + ", naslov=" + naslov + ", vest=" + vest + '}';
    }

    public void setVest(String vest) {
        this.vest = vest;
    }

    public Izdanje getIzdanje() {
        return izdanje;
    }

    public void setIzdanje(Izdanje izdanje) {
        this.izdanje = izdanje;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }
    
    
}
