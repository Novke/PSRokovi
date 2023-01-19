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
public class StavkaIzvestaja implements Serializable {
    
    private String tipTesta;
    private int ukupnoPozitivnih;
    private int ukupnoNegativnih;

    public StavkaIzvestaja() {
    }

    public StavkaIzvestaja(String tipTesta, int ukupnoPozitivnih, int ukupnoNegativnih) {
        this.tipTesta = tipTesta;
        this.ukupnoPozitivnih = ukupnoPozitivnih;
        this.ukupnoNegativnih = ukupnoNegativnih;
    }

    public int getUkupnoNegativnih() {
        return ukupnoNegativnih;
    }

    public void setUkupnoNegativnih(int ukupnoNegativnih) {
        this.ukupnoNegativnih = ukupnoNegativnih;
    }

    public String getTipTesta() {
        return tipTesta;
    }

    public void setTipTesta(String tipTesta) {
        this.tipTesta = tipTesta;
    }

    public int getUkupnoPozitivnih() {
        return ukupnoPozitivnih;
    }

    public void setUkupnoPozitivnih(int ukupnoPozitivnih) {
        this.ukupnoPozitivnih = ukupnoPozitivnih;
    }
    
    
    
}
