/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baza;

import domen.Korisnik;
import domen.Nastavnik;
import domen.PredajePredmet;
import domen.Predmet;
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

    public void cuvajIzmeniBrisi() throws Exception {
        String upit = "";
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);

            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();

            //return true;
        } catch (SQLException ex) {
            Konekcija.getInstance().getConnection().rollback();
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Korisnik login(String username, String password) {
        String upit = "SELECT * FROM KORISNIK";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                Korisnik k = new Korisnik(rs.getInt("KorisnikID"),
                        rs.getString("Ime"), rs.getString("Prezime"),
                        rs.getString("KorisnickoIme"), rs.getString("Lozinka"));
                if (k.getKorisnickoIme().equals(username) && k.getLozinka().equals(password)) {
                    return k;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public ArrayList<Predmet> vratiPredmete() {
        ArrayList<Predmet> lista = new ArrayList<>();
        String upit = "SELECT * FROM PREDMET";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                Predmet p = new Predmet(rs.getInt("PredmetID"), rs.getString("Naziv"),
                        rs.getInt("ESPB"));
                lista.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public ArrayList<Nastavnik> vratiNastavnike() {
        ArrayList<Nastavnik> lista = new ArrayList<>();
        String upit = "SELECT * FROM NASTAVNIK";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                Nastavnik n = new Nastavnik(rs.getInt("NastavnikID"),
                        rs.getString("Ime"), rs.getString("Prezime"), rs.getString("Zvanje"));
                lista.add(n);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public boolean sacuvajAngazovanja(ArrayList<PredajePredmet> angazovanja) throws SQLException {
        String upit = "INSERT INTO PREDAJEPREDMET VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);

            for (PredajePredmet pp : angazovanja) {
                ps.setInt(1, pp.getNastavnik().getNastavnikID());
                ps.setInt(2, pp.getPredmet().getPredmetID());
                ps.setInt(3, pp.getSemestar());
                ps.setString(4, pp.getStudijskiProgram());
                ps.setDate(5, new Date(System.currentTimeMillis()));
                ps.setInt(6, pp.getKorisnik().getKorisnikID());

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
        String upit = "SELECT CONCAT(n.ime, CONCAT(' ', n.prezime)) AS ImePrezime, "
                + "COUNT(*) AS BrojPredmeta "
                + "FROM nastavnik n JOIN predajepredmet pp ON (n.nastavnikid = pp.nastavnikid) "
                + dodatniUpit
                + " GROUP BY ImePrezime;";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                StavkaIzvestaja si = new StavkaIzvestaja(rs.getString("ImePrezime"),
                        rs.getInt("BrojPredmeta"));
                lista.add(si);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }
}
