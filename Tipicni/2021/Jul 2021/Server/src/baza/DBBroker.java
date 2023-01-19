/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baza;

import domen.Organizator;
import domen.StavkaIzvestaja;
import domen.Takmicar;
import domen.Takmicenje;
import domen.Ucesce;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBBroker {

    public ArrayList<Object> vrati() {
        ArrayList<Object> lista = new ArrayList<>();
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

    public boolean cuvajIzmeniBrisi() throws Exception {
        String upit = "";
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);

            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();

            return true;

        } catch (SQLException ex) {
            Konekcija.getInstance().getConnection().rollback();
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }

    public Organizator login(String username, String password) {
        String upit = "SELECT * FROM ORGANIZATOR";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                Organizator m = new Organizator(rs.getInt("OrganizatorID"),
                        rs.getString("Ime"), rs.getString("Prezime"),
                        rs.getString("KorisnickoIme"), rs.getString("Lozinka"));

                if (m.getKorisnickoIme().equals(username) && m.getLozinka().equals(password)) {
                    return m;
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public ArrayList<Takmicenje> vratiTakmicenja() {
        ArrayList<Takmicenje> lista = new ArrayList<>();
        String upit = "SELECT * FROM TAKMICENJE";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                Takmicenje t = new Takmicenje(rs.getInt("TakmicenjeD"), rs.getString("NazivTakmicenja"),
                        rs.getString("VrstaTrke"), rs.getString("Opis"), rs.getDate("Datum"));
                lista.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public ArrayList<Takmicar> vratiTakmicare() {
        ArrayList<Takmicar> lista = new ArrayList<>();
        String upit = "SELECT * FROM TAKMICAR";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                Takmicar t = new Takmicar(rs.getInt("TakmicarID"), rs.getString("Ime"),
                        rs.getString("Prezime"), rs.getString("Pol"), rs.getString("Kontakt"));
                lista.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public boolean sacuvajUcesca(ArrayList<Ucesce> ucesca) throws SQLException {
        String upit = "INSERT INTO UCESCE (VRSTATRKE, DATUMVREMEPOCETKA, "
                + "DATUMVREMEZAVRSETKA, TAKMICENJEID, TAKMICARID, ORGANIZATORID) "
                + "VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);

            for (Ucesce u : ucesca) {
                ps.setString(1, u.getVrstaTrke());
                ps.setTimestamp(2, new Timestamp(u.getDatumVremePocetka().getTime()));
                ps.setTimestamp(3, new Timestamp(u.getDatumVremeZavrsetka().getTime()));
                ps.setInt(4, u.getTakmicenje().getTakmicenjeID());
                ps.setInt(5, u.getTakmicar().getTakmicarID());
                ps.setInt(6, u.getOrganizator().getOrganizatorID());

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

    public ArrayList<StavkaIzvestaja> vratiIzvestaj() {
        ArrayList<StavkaIzvestaja> lista = new ArrayList<>();
        String upit = "SELECT t.takmicarID, CONCAT(t.ime, ' ', t.prezime) AS imePrezime, "
                + "tak.nazivTakmicenja AS takmicenje, u.datumVremePocetka, u.datumVremeZavrsetka,"
                + "CAST((u.datumVremeZavrsetka-u.datumVremePocetka) AS TIME(0)) AS vremeTrajanja "
                + "FROM takmicar t JOIN ucesce u ON (t.takmicarid = u.takmicarid) "
                + "JOIN takmicenje tak ON (u.takmicenjeid = tak.takmicenjed)";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                StavkaIzvestaja si = new StavkaIzvestaja(rs.getInt("TakmicarID"), 
                        rs.getString("imePrezime"), rs.getString("takmicenje"), 
                        rs.getTimestamp("datumVremePocetka"), rs.getTimestamp("datumVremeZavrsetka"),
                        rs.getString("vremeTrajanja"));
                lista.add(si);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

}
