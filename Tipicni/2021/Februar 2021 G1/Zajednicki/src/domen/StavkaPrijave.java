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
public class StavkaPrijave implements Serializable {
    
    private Prijava prijava;
    private int redniBroj;
    private String tipVakcine;

    public StavkaPrijave() {
    }

    public StavkaPrijave(Prijava prijava, int redniBroj, String tipVakcine) {
        this.prijava = prijava;
        this.redniBroj = redniBroj;
        this.tipVakcine = tipVakcine;
    }

    public String getTipVakcine() {
        return tipVakcine;
    }

    public void setTipVakcine(String tipVakcine) {
        this.tipVakcine = tipVakcine;
    }

    public Prijava getPrijava() {
        return prijava;
    }

    public void setPrijava(Prijava prijava) {
        this.prijava = prijava;
    }

    public int getRedniBroj() {
        return redniBroj;
    }

    public void setRedniBroj(int redniBroj) {
        this.redniBroj = redniBroj;
    }
    
    
    
}
