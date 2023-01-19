/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baza;

import domen.Delo;
import domen.Festival;
import domen.Izvodjenje;
import domen.Koncert;
import domen.Predstava;
import domen.StavkaIzvestaja;
import java.sql.Date;
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

    public ArrayList<Festival> vratiFestivale() {
        ArrayList<Festival> lista = new ArrayList<>();
        String upit = "SELECT * FROM FESTIVAL";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                Festival f = new Festival(rs.getLong(1), rs.getString(2),
                        rs.getDate(3), rs.getDate(4), rs.getString(5), rs.getString(6), null);
                lista.add(f);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public ArrayList<Predstava> vratiPredstave() {
        ArrayList<Predstava> lista = new ArrayList<>();
        String upit = "SELECT * FROM PREDSTAVA P JOIN DELO D ON (D.DELOID = P.DELOID)";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                Delo d = new Delo(rs.getLong("DeloID"), rs.getString("Naziv"));

                Predstava p = new Predstava(d, rs.getString("reditelj"),
                        rs.getString("podela"), rs.getString("size"));

                lista.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public ArrayList<Koncert> vratiKoncerte() {
        ArrayList<Koncert> lista = new ArrayList<>();
        String upit = "SELECT * FROM KONCERT P JOIN DELO D ON (D.DELOID = P.DELOID)";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                Delo d = new Delo(rs.getLong("DeloID"), rs.getString("Naziv"));

                Koncert k = new Koncert(d, rs.getString("izvodjac"), rs.getString("program"));

                lista.add(k);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public boolean izmeniFestival(Festival f) throws SQLException {
        String upit = "UPDATE FESTIVAL "
                + "SET NAZIV = ?, DATUMOD = ?, DATUMDO = ?, OPIS = ?, KORISNIK = ? "
                + "WHERE FESTIVALID = ?";
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);

            ps.setString(1, f.getNaziv());
            ps.setDate(2, new Date(f.getDatumOd().getTime()));
            ps.setDate(3, new Date(f.getDatumDo().getTime()));
            ps.setString(4, f.getOpis());
            ps.setString(5, f.getKorisnik());
            ps.setLong(6, f.getFestivalID());

            ps.executeUpdate();

            // prvo moramo da obrisemo stara izvodjenja ako smo ih imali
            // pa da dodamo nova
            // zato sam prvo napravio metodu koja ce da obrise sva izvodjenja
            // tog festivala iz tabele izvodjenja i doda ta nova, izmenjena
            if (obrisiSvaIzvodjenjaFestivala(f) && dodajNovaIzvodjenja(f)) {
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

    private boolean obrisiSvaIzvodjenjaFestivala(Festival f) throws SQLException {
        String upit = "DELETE FROM IZVODJENJE WHERE FESTIVALID = ?";
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);

            ps.setLong(1, f.getFestivalID());

            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();

            return true;

        } catch (SQLException ex) {
            Konekcija.getInstance().getConnection().rollback();
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    private boolean dodajNovaIzvodjenja(Festival f) throws SQLException {
        String upit = "INSERT INTO IZVODJENJE VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);

            for (Izvodjenje i : f.getListaIzvodjenja()) {
                ps.setLong(1, f.getFestivalID());
                ps.setLong(2, i.getDelo().getDeloID());
                ps.setTimestamp(3, new Timestamp(i.getDatumVremePocetka().getTime()));
                ps.setTimestamp(4, new Timestamp(i.getDatumVremeKraja().getTime()));
                ps.setString(5, i.getSala());

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

    public ArrayList<Izvodjenje> vratiIzvodjenjaFestivala(Festival f) {
        ArrayList<Izvodjenje> lista = new ArrayList<>();
        String upit = "SELECT * FROM IZVODJENJE I JOIN DELO D ON (I.DELOID = D.DELOID) "
                + "WHERE FESTIVALID = " + f.getFestivalID();
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                Delo d = new Delo(rs.getLong("DeloID"), rs.getString("Naziv"));

                Izvodjenje i = new Izvodjenje(f, d, rs.getTimestamp("datumVremePocetka"),
                        rs.getTimestamp("datumVremeKraja"), rs.getString("Sala"));

                lista.add(i);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public ArrayList<StavkaIzvestaja> vratiIzvestaj(String dodatniUpit) {
        ArrayList<StavkaIzvestaja> lista = new ArrayList<>();
        String upit = "SELECT f.naziv, f.datumod, f.datumdo,  "
                + "GROUP_CONCAT(' ', d.naziv, CASE WHEN d.deloid IN (SELECT deloid FROM predstava)"
                + " THEN ' (Predstava)' ELSE ' (Koncert)' END) AS izvodjenja "
                + "FROM festival f JOIN izvodjenje i ON (f.festivalid = i.festivalid) "
                + "JOIN delo d ON (i.deloid = d.deloid) "
                + "GROUP BY f.naziv, f.datumod, f.datumdo";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                StavkaIzvestaja si = new StavkaIzvestaja(rs.getString("naziv"),
                        rs.getDate("datumOd"), rs.getDate("datumDo"), rs.getString("izvodjenja"));
                lista.add(si);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

}
