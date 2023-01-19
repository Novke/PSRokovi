/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baza;

import domen.Lokacija;
import domen.Prijava;
import domen.PrijavaVolontiranje;
import domen.StavkaIzvestaja;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
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

    public ArrayList<Lokacija> vratiLokacije() {
        ArrayList<Lokacija> lista = new ArrayList<>();
        String upit = "SELECT * FROM LOKACIJA";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                Lokacija l = new Lokacija(rs.getLong("LokacijaID"), rs.getInt("PttBroj"),
                        rs.getString("Naziv"));
                lista.add(l);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public boolean sacuvajPrijavu(Prijava prijava) throws SQLException {
        String upit = "INSERT INTO PRIJAVA (JMBG, Ime, Prezime, ElektronskaPosta, "
                + "Telefon, ZdravstvenoOsiguran, DatumPrijave, StrucnaSprema, "
                + "LokacijaID) VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps
                    = Konekcija.getInstance().getConnection()
                            .prepareStatement(upit, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, prijava.getJMBG());
            ps.setString(2, prijava.getIme());
            ps.setString(3, prijava.getPrezime());
            ps.setString(4, prijava.getElektronskaPosta());
            ps.setString(5, prijava.getTelefon());
            ps.setBoolean(6, prijava.isZdravstvenoOsiguran());
            ps.setTimestamp(7, new Timestamp(prijava.getDatumPrijave().getTime()));
            ps.setString(8, prijava.getStrucnaSprema());
            ps.setLong(9, prijava.getLokacija().getLokacijaID());

            ps.executeUpdate();

            ResultSet tableKeys = ps.getGeneratedKeys();
            tableKeys.next();
            int autoPrijavaID = tableKeys.getInt(1);

            prijava.setPrijavaID(autoPrijavaID);

            if (sacuvajPrijaveVolontiranja(prijava)) {
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

    private boolean sacuvajPrijaveVolontiranja(Prijava prijava) throws SQLException {
        String upit = "INSERT INTO PRIJAVAVOLONTIRANJE VALUES (?,?,?)";
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);

            ArrayList<PrijavaVolontiranje> listaPV = prijava.getListaVolontiranja();

            for (PrijavaVolontiranje pv : listaPV) {
                ps.setLong(1, prijava.getPrijavaID());
                ps.setInt(2, pv.getRb());
                ps.setString(3, pv.getVrstaVolontiranja());

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
        String upit = "SELECT p.prijavaid, CONCAT(p.ime, CONCAT(' ', p.prezime))"
                + " AS ime_prezime, p.jmbg, "
                + "p.strucnasprema, l.naziv, p.elektronskaposta, p.telefon, p.zdravstvenoosiguran "
                + "FROM prijava p JOIN lokacija l ON (p.lokacijaid = l.lokacijaid);";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                StavkaIzvestaja si = new StavkaIzvestaja(rs.getInt("p.prijavaid"),
                        rs.getString("ime_prezime"),
                        rs.getString("p.jmbg"), rs.getString("p.StrucnaSprema"),
                        rs.getString("l.naziv"), rs.getString("p.elektronskaposta"),
                        rs.getString("p.telefon"), rs.getBoolean("p.zdravstvenoosiguran"));
                lista.add(si);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public boolean obrisiPrijaveVolontiranje(int prijavaID) throws SQLException {
        String upit = "DELETE FROM PrijavaVolontiranje WHERE PRIJAVAID = ?";
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);

            ps.setInt(1, prijavaID);

            ps.executeUpdate();

            if (ponistiPrijavu(prijavaID)) {
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

    private boolean ponistiPrijavu(int prijavaID) throws SQLException {
        String upit = "DELETE FROM PRIJAVA WHERE PRIJAVAID = ?";
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);

            ps.setInt(1, prijavaID);

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
