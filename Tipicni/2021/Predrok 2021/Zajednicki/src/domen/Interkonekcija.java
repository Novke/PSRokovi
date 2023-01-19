/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author PC
 */
public class Interkonekcija implements Serializable {
    
    private Let let;
    private long rb;
    private Aerodrom aerodrom;
    private Date datumVremeLeta;

    public Interkonekcija() {
    }

    public Interkonekcija(Let let, long rb, Aerodrom aerodrom, Date datumVremeLeta) {
        this.let = let;
        this.rb = rb;
        this.aerodrom = aerodrom;
        this.datumVremeLeta = datumVremeLeta;
    }

    public Date getDatumVremeLeta() {
        return datumVremeLeta;
    }

    public void setDatumVremeLeta(Date datumVremeLeta) {
        this.datumVremeLeta = datumVremeLeta;
    }

    public Let getLet() {
        return let;
    }

    public void setLet(Let let) {
        this.let = let;
    }

    public long getRb() {
        return rb;
    }

    public void setRb(long rb) {
        this.rb = rb;
    }

    public Aerodrom getAerodrom() {
        return aerodrom;
    }

    public void setAerodrom(Aerodrom aerodrom) {
        this.aerodrom = aerodrom;
    }
    
    
    
}
