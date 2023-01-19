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
 * @author Korisnik
 */
public class StavkaProgramskogVodica implements Serializable {
    
    private ProgramskiVodic programskiVodic;
    private int rb;
    private String nazivEmisije;
    private Date datumVremeOd;
    private Date datumVremeDo;
    private Stanica stanica;
    private TipEmisije tipEmisije;

    public StavkaProgramskogVodica(ProgramskiVodic programskiVodic, int rb, String nazivEmisije, Date datumVremeOd, Date datumVremeDo, Stanica stanica, TipEmisije tipEmisije) {
        this.programskiVodic = programskiVodic;
        this.rb = rb;
        this.nazivEmisije = nazivEmisije;
        this.datumVremeOd = datumVremeOd;
        this.datumVremeDo = datumVremeDo;
        this.stanica = stanica;
        this.tipEmisije = tipEmisije;
    }

    public StavkaProgramskogVodica() {
    }

    public ProgramskiVodic getProgramskiVodic() {
        return programskiVodic;
    }

    public void setProgramskiVodic(ProgramskiVodic programskiVodic) {
        this.programskiVodic = programskiVodic;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public String getNazivEmisije() {
        return nazivEmisije;
    }

    public void setNazivEmisije(String nazivEmisije) {
        this.nazivEmisije = nazivEmisije;
    }

    public Date getDatumVremeOd() {
        return datumVremeOd;
    }

    public void setDatumVremeOd(Date datumVremeOd) {
        this.datumVremeOd = datumVremeOd;
    }

    public Date getDatumVremeDo() {
        return datumVremeDo;
    }

    public void setDatumVremeDo(Date datumVremeDo) {
        this.datumVremeDo = datumVremeDo;
    }

    public Stanica getStanica() {
        return stanica;
    }

    public void setStanica(Stanica stanica) {
        this.stanica = stanica;
    }

    public TipEmisije getTipEmisije() {
        return tipEmisije;
    }

    public void setTipEmisije(TipEmisije tipEmisije) {
        this.tipEmisije = tipEmisije;
    }

}
