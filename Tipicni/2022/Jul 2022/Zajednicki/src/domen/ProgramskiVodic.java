/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Korisnik
 */
public class ProgramskiVodic implements Serializable {
    
    private long programskiVodicID;
    private Date dan;
    private String opis;
    private String urednik;
    private ArrayList<StavkaProgramskogVodica> stavkeProgramskogVodica;

    public ProgramskiVodic(long programskiVodicID, Date dan, String opis, String urednik, ArrayList<StavkaProgramskogVodica> stavkeProgramskogVodica) {
        this.programskiVodicID = programskiVodicID;
        this.dan = dan;
        this.opis = opis;
        this.urednik = urednik;
        this.stavkeProgramskogVodica = stavkeProgramskogVodica;
    }

    public ProgramskiVodic() {
    }

    public long getProgramskiVodicID() {
        return programskiVodicID;
    }

    public void setProgramskiVodicID(long programskiVodicID) {
        this.programskiVodicID = programskiVodicID;
    }

    public Date getDan() {
        return dan;
    }

    public void setDan(Date dan) {
        this.dan = dan;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getUrednik() {
        return urednik;
    }

    public void setUrednik(String urednik) {
        this.urednik = urednik;
    }

    public ArrayList<StavkaProgramskogVodica> getStavkeProgramskogVodica() {
        return stavkeProgramskogVodica;
    }

    public void setStavkeProgramskogVodica(ArrayList<StavkaProgramskogVodica> stavkeProgramskogVodica) {
        this.stavkeProgramskogVodica = stavkeProgramskogVodica;
    }
    
}
