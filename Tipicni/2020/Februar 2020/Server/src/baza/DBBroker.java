/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baza;

import domen.Intervju;
import domen.StavkaIzvestaja;
import domen.Kandidat;
import domen.Regruter;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class DBBroker {
    public ArrayList<String> vrati(){
        ArrayList<String> lista = new ArrayList<>();
        String upit = "";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while(rs.next()){
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    public void cuvaj() throws Exception{
        String upit = "";
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);
            
            
            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();
        } catch (SQLException ex) {
            Konekcija.getInstance().getConnection().rollback();
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Regruter login(String user, String pass) {
        String upit = "SELECT * FROM REGRUTER";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while(rs.next()){
                Regruter r = new Regruter(rs.getInt("RegruterID"), 
                        rs.getString("ImePrezime"), rs.getString("KorisnickoIme"),
                        rs.getString("Lozinka"));
                if(r.getKorisnickoIme().equals(user) && r.getLozinka().equals(pass))
                    return r;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    public ArrayList<Kandidat> vratiKandidate() {
        ArrayList<Kandidat> lista = new ArrayList<>();
        String upit = "SELECT * FROM KANDIDAT";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while(rs.next()){
                Kandidat k = new Kandidat(rs.getInt("KandidatID"), 
                        rs.getString("ImePrezime"), rs.getString("StrucnaSprema"), 
                        rs.getString("Zanimanje"));
                lista.add(k);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }

    public boolean sacuvajIntervjue(ArrayList<Intervju> listaIntervjua) throws SQLException {
        String upit = "INSERT INTO INTERVJU (Datum, Opis, BrojPoenaTest, "
                + "VozackaDozvola, PrethodnoIskustvo, KandidatID, RegruterID) "
                + "VALUES (?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);
            
            for (Intervju i : listaIntervjua) {
                ps.setDate(1, new Date(i.getDatum().getTime()));
                ps.setString(2, i.getOpis());
                ps.setDouble(3, i.getBrojPoenaTest());
                ps.setString(4, i.getVozackaDozvola());
                ps.setBoolean(5, i.isPrethodnoIskustvo());
                ps.setInt(6, i.getKandidat().getKandidatID());
                ps.setInt(7, i.getRegruter().getRegruterID());
                
                ps.addBatch();
            }
            
            ps.executeBatch();
            Konekcija.getInstance().getConnection().commit();
            return true;
            
        } catch (SQLException ex) {
            Konekcija.getInstance().getConnection().rollback();
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<StavkaIzvestaja> vratiIzvestaj(String dodatniUpit) {
        ArrayList<StavkaIzvestaja> lista = new ArrayList<>();
        String upit = "SELECT r.imePrezime, COUNT(k.kandidatid) AS broj_kandidata, "
                + "GROUP_CONCAT(k.imePrezime) AS imena_kandidata "
                + "FROM regruter r JOIN intervju i ON (r.regruterid = i.regruterid) "
                + "JOIN kandidat k ON (k.kandidatid = i.kandidatid) "
                + dodatniUpit
                + "GROUP BY r.regruterid";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while(rs.next()){
                StavkaIzvestaja i = new StavkaIzvestaja(rs.getString("r.imePrezime"), 
                        rs.getInt("broj_kandidata"), rs.getString("imena_kandidata"));
                lista.add(i);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
}
