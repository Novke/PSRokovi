/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baza;

import domen.Meteorolog;
import domen.Prognoza;
import domen.PrognozaRegion;
import domen.StavkaIzvestaja;
import domen.Region;
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

    public ArrayList<String> vrati() {
        ArrayList<String> lista = new ArrayList<>();
        String upit = "";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {

            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public void cuvaj() throws Exception {
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

    public Meteorolog login(String user, String pass) {

        String upit = "SELECT * FROM METEOROLOG";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                Meteorolog m = new Meteorolog(rs.getInt("MeteorologID"),
                        rs.getString("Ime"), rs.getString("Prezime"),
                        rs.getString("KorisnickoIme"), rs.getString("Lozinka"));

                if (m.getKorisnickoIme().equals(user) && m.getLozinka().equals(pass)) {
                    return m;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    public ArrayList<Region> vratiRegione() {
        ArrayList<Region> lista = new ArrayList<>();
        String upit = "SELECT * FROM REGION";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                Region r = new Region(rs.getInt("RegionID"),
                        rs.getString("Naziv"), rs.getString("Opis"));
                lista.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public boolean sacuvajPrognozu(Prognoza prognoza) throws SQLException {
        String upit = "INSERT INTO PROGNOZA VALUES (?,?,?,?)";
        int prognozaId = getPrognozaId();
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);

            ps.setInt(1, prognozaId);
            ps.setDate(2, new Date(prognoza.getDan().getTime()));
            ps.setString(3, prognoza.getOpis());
            ps.setInt(4, prognoza.getMeteorolog().getMeteorologId());

            prognoza.setPrognozaId(prognozaId);

            ps.executeUpdate();
            
            if (sacuvajPrognozeZaRegion(prognoza)) {
                Konekcija.getInstance().getConnection().commit();
                return true;
            } else {
                Konekcija.getInstance().getConnection().rollback();
                return false;
            }

        } catch (SQLException ex) {
            Konekcija.getInstance().getConnection().rollback();
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    private int getPrognozaId() {
        String upit = "SELECT MAX(PROGNOZAID) AS MAX FROM PROGNOZA";
        int id = 0;
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                id = rs.getInt("MAX");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ++id;
    }

    private boolean sacuvajPrognozeZaRegion(Prognoza prognoza) throws SQLException {
        String upit = "INSERT INTO PROGNOZAREGION VALUES (?,?,?,?,?,?)";
        int rb = 0;
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);

            for (PrognozaRegion pr : prognoza.getPrognozeZaRegion()) {
                ps.setInt(1, prognoza.getPrognozaId());
                ps.setInt(2, ++rb);
                ps.setDouble(3, pr.getTemperatura());
                ps.setString(4, pr.getMeteoAlarm());
                ps.setString(5, pr.getPojava());
                ps.setInt(6, pr.getRegion().getRegionId());

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
        String upit = "SELECT CONCAT(m.ime, CONCAT(' ', m.prezime)) AS meteorolog, p.dan AS dan, "
                + "GROUP_CONCAT(r.naziv, ': ', pzr.temperatura, ' (', pzr.meteoalarm, "
                + "', ', pzr.pojava, ');') AS prognoza_za_regione "
                + "FROM meteorolog m JOIN prognoza p ON (m.meteorologid = p.meteorologid) "
                + "JOIN prognozaregion pzr ON (p.prognozaid = pzr.prognozaid) "
                + "JOIN region r ON (pzr.regionid = r.regionid) "
                + dodatniUpit
                + "GROUP BY meteorolog, dan";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                StavkaIzvestaja pzr = new StavkaIzvestaja(rs.getString("meteorolog"),
                        rs.getDate("dan"), rs.getString("prognoza_za_regione"));
                lista.add(pzr);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }
}
