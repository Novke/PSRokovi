/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baza;

import domen.DnevnaProizvodnjaIzvestaj;
import domen.DnevnaProizvodnjaStavkaIzvestaja;
import domen.Proizvodjac;
import domen.StavkaIzvestaja;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    public Proizvodjac login(String username, String password) {
        String upit = "SELECT * FROM Proizvodjac";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                Proizvodjac p = new Proizvodjac(rs.getInt("ProizvodjacID"),
                        rs.getString("Naziv"), rs.getString("Adresa"),
                        rs.getString("KorisnickoIme"), rs.getString("Lozinka"));

                if (p.getKorisnickoIme().equals(username) && p.getLozinka().equals(password)) {
                    return p;
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public boolean sacuvajDnevniIzvestaj(DnevnaProizvodnjaIzvestaj dpi) throws SQLException {
        String upit = "INSERT INTO DNEVNAPROIZVODNJAIZVESTAJ "
                + "(DATUM, OPIS, PROIZVODJACID) VALUES (?,?,?)";
        try {
            PreparedStatement ps = Konekcija.getInstance()
                    .getConnection().prepareStatement(upit, Statement.RETURN_GENERATED_KEYS);

            ps.setDate(1, new Date(dpi.getDatum().getTime()));
            ps.setString(2, dpi.getOpis());
            ps.setLong(3, dpi.getProizvodjac().getProizvodjacID());

            ps.executeUpdate();

            ResultSet tableKeys = ps.getGeneratedKeys();
            tableKeys.next();
            long dpiID = tableKeys.getLong(1);

            dpi.setDnevnaProizvodnjaIzvestajID(dpiID);

            if (sacuvajStavke(dpi)) {
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

    private boolean sacuvajStavke(DnevnaProizvodnjaIzvestaj dpi) throws SQLException {
        String upit = "INSERT INTO DNEVNAPROIZVODNJASTAVKAIZVESTAJA "
                + "VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);

            for (DnevnaProizvodnjaStavkaIzvestaja si : dpi.getListaStavki()) {
                ps.setLong(1, dpi.getDnevnaProizvodnjaIzvestajID());
                ps.setInt(2, si.getRb());
                ps.setString(3, si.getVrstaKapaciteta());
                ps.setDouble(4, si.getKolicina());
                ps.setString(5, si.getJedinicaMere());
                ps.setString(6, si.getNapomena());

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
        String upit = "SELECT p.naziv, dpi.datum, dpi.opis, "
                + "CASE WHEN SUM(dps.kolicina) IS NOT NULL THEN "
                + "SUM(dps.kolicina) ELSE 0 END AS proizvedenoElEng "
                + "FROM proizvodjac p LEFT JOIN dnevnaproizvodnjaizvestaj dpi USING (proizvodjacid) "
                + "LEFT JOIN dnevnaproizvodnjastavkaizvestaja "
                + "dps ON (dpi.dnevnaproizvodnjaizvestajid = dps.dnevnaproizvodnjaizvestajid) "
                + "GROUP BY p.naziv, dpi.datum, dpi.opis "
                + "ORDER BY proizvedenoElEng DESC";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                StavkaIzvestaja si = new StavkaIzvestaja(rs.getString("naziv"), 
                        rs.getDate("datum"), rs.getString("opis"), rs.getDouble("proizvedenoElEng"));
                lista.add(si);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

}
