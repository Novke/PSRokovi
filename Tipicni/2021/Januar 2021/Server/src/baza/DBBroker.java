/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baza;

import domen.Paket;
import domen.Pretplatnik;
import domen.StavkaIzvestaja;
import domen.Ugovor;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public ArrayList<Pretplatnik> vratiPretplatnike() {
        ArrayList<Pretplatnik> lista = new ArrayList<>();
        String upit = "SELECT * FROM PRETPLATNIK";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                Pretplatnik p = new Pretplatnik(rs.getInt("PretplatnikID"),
                        rs.getString("Ime"), rs.getString("Prezime"));
                lista.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public ArrayList<Paket> vratiPakete() {
        ArrayList<Paket> lista = new ArrayList<>();
        String upit = "SELECT * FROM PAKET";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                Paket p = new Paket(rs.getInt("PaketID"), rs.getString("Naziv"),
                        rs.getString("Opis"), rs.getDouble("Cena"), rs.getBoolean("Aktivan"));
                lista.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public ArrayList<StavkaIzvestaja> vratiIzvestaj() {
        ArrayList<StavkaIzvestaja> lista = new ArrayList<>();
        String upit = "SELECT u.ugovorid as ugovorid, "
                + "CONCAT(p.ime, CONCAT(' ', p.prezime)) AS pretplatnik, pak.naziv AS naziv, "
                + "u.vrstaUgovora AS vrsta_ugovora, u.dodatneUsluge AS dodatne_usluge, "
                + "u.datumEvidentiranja AS datum_evidentiranja, u.cena AS cena "
                + "FROM ugovor u JOIN paket pak ON (u.paketid = pak.paketid) "
                + "JOIN pretplatnik p ON (u.pretplatnikid = p.pretplatnikid);";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                StavkaIzvestaja si = new StavkaIzvestaja(rs.getLong("ugovorid"), rs.getString("pretplatnik"),
                        rs.getString("naziv"), rs.getString("vrsta_ugovora"),
                        rs.getBoolean("dodatne_usluge"), rs.getDate("datum_evidentiranja"),
                        rs.getDouble("cena"));
                lista.add(si);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public boolean sacuvajUgovore(ArrayList<Ugovor> listaUgovora) throws SQLException {
        String upit = "INSERT INTO UGOVOR (DatumEvidentiranja, VrstaUgovora, "
                + "DodatneUsluge, Cena, PaketID, PretplatnikID) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);

            for (Ugovor u : listaUgovora) {
                ps.setDate(1, new Date(u.getDatumEvidentiranja().getTime()));
                ps.setString(2, u.getVrstaUgovora());
                ps.setBoolean(3, u.isDodatneUsluge());
                ps.setDouble(4, u.getCena());
                ps.setLong(5, u.getPaket().getPaketID());
                ps.setLong(6, u.getPretplatnik().getPretplatnikID());

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

    public boolean ponistiUgovor(long idUgovora) throws SQLException {
        String upit = "DELETE FROM UGOVOR WHERE UGOVORID = ?";
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);

            ps.setLong(1, idUgovora);

            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();

            return true;

        } catch (SQLException ex) {
            Konekcija.getInstance().getConnection().rollback();
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
