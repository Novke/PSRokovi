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
    
    private String igra;
    private String PC;
    private String playstation;
    private String XBOX;
    private String steam;

    public StavkaIzvestaja() {
    }

    public StavkaIzvestaja(String igra, String PC, String playstation, String XBOX, String steam) {
        this.igra = igra;
        this.PC = PC;
        this.playstation = playstation;
        this.XBOX = XBOX;
        this.steam = steam;
    }

    public String getIgra() {
        return igra;
    }

    public void setIgra(String igra) {
        this.igra = igra;
    }

    public String getPC() {
        return PC;
    }

    public void setPC(String PC) {
        this.PC = PC;
    }

    public String getPlaystation() {
        return playstation;
    }

    public void setPlaystation(String playstation) {
        this.playstation = playstation;
    }

    public String getXBOX() {
        return XBOX;
    }

    public void setXBOX(String XBOX) {
        this.XBOX = XBOX;
    }

    public String getSteam() {
        return steam;
    }

    public void setSteam(String steam) {
        this.steam = steam;
    }

    
    
}
