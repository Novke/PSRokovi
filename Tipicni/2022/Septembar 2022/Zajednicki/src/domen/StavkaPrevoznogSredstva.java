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
public class StavkaPrevoznogSredstva implements Serializable {
    
    private PrevoznoSredstvo prevoznoSredstvo;
    private int rb;
    private int kolicina;
    private boolean kontrolisano;
    private Komponenta komponenta;

    public StavkaPrevoznogSredstva(PrevoznoSredstvo prevoznoSredstvo, int rb, int kolicina, boolean kontrolisano, Komponenta komponenta) {
        this.prevoznoSredstvo = prevoznoSredstvo;
        this.rb = rb;
        this.kolicina = kolicina;
        this.kontrolisano = kontrolisano;
        this.komponenta = komponenta;
    }

    public StavkaPrevoznogSredstva() {
    }

    public PrevoznoSredstvo getPrevoznoSredstvo() {
        return prevoznoSredstvo;
    }

    public void setPrevoznoSredstvo(PrevoznoSredstvo prevoznoSredstvo) {
        this.prevoznoSredstvo = prevoznoSredstvo;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public boolean isKontrolisano() {
        return kontrolisano;
    }

    public void setKontrolisano(boolean kontrolisano) {
        this.kontrolisano = kontrolisano;
    }

    public Komponenta getKomponenta() {
        return komponenta;
    }

    public void setKomponenta(Komponenta komponenta) {
        this.komponenta = komponenta;
    }
    
}
