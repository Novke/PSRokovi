/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baza;

import domen.Izdanje;
import domen.Pomocna;
import domen.Izvestaj;
import domen.Publikacija;
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

    public void uradi() throws Exception {
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

    public ArrayList<Publikacija> vratiPublikacije() {
        ArrayList<Publikacija> lista = new ArrayList<>();
        String upit = "SELECT * FROM PUBLIKACIJA";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                Publikacija p = new Publikacija(rs.getInt("PublikacijaID"), rs.getString("Naziv"));
                lista.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public boolean sacuvajIzdanja(Izdanje i) throws SQLException {
        String upit = "INSERT INTO IZDANJE VALUES (?,?,?,?)";
        int id = vratiIDIzdanja();
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);

            ps.setInt(1, id);
            i.setIzdanjeID(id);
            ps.setDate(2, new Date(i.getDatum().getTime()));
            ps.setInt(3, i.getBroj());
            ps.setInt(4, i.getPublikacija().getPublikacijaID());

            i.setIzdanjeID(id);

            ps.executeUpdate();

            if (sacuvajVesti(i)) {
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

    private int vratiIDIzdanja() {
        String upit = "SELECT MAX(IZDANJEID) as MAX FROM IZDANJE";
        int max = 0;
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                max = rs.getInt("MAX");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ++max;
    }

    private boolean sacuvajVesti(Izdanje i) throws SQLException {
        String upit = "INSERT INTO VEST VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);

            for (Pomocna vest : i.getPomocne()) {
                ps.setInt(1, i.getIzdanjeID());
                ps.setInt(2, vest.getRb());
                ps.setString(3, vest.getNaslov());
                ps.setString(4, vest.getTekst());

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

    public ArrayList<Izvestaj> vratiIzvestaj(String dodatniUpit) {
        ArrayList<Izvestaj> lista = new ArrayList<>();
        String upit = "SELECT p.naziv, v.rb, v.naslov, v.vest "
                + "FROM vest v inner join izdanje i on (v.izdanjeid = i.izdanjeid) "
                + "inner join publikacija p on (p.publikacijaid = i.publikacijaid) "
                + dodatniUpit;
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                Izvestaj p = new Izvestaj(rs.getString("p.naziv"), rs.getInt("v.rb"),
                        rs.getString("v.naslov"), rs.getString("v.vest"));
                lista.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public boolean daLiPostoji(Izdanje i) {
        String upit = "SELECT * FROM IZDANJE i JOIN PUBLIKACIJA p "
                + "on (i.publikacijaid = p.publikacijaid)";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                Publikacija p = new Publikacija(rs.getInt("PublikacijaID"),
                        rs.getString("Naziv"));

                Izdanje izdanje = new Izdanje(rs.getInt("IzdanjeID"),
                        rs.getDate("Datum"), rs.getInt("Broj"),
                        p, null);

                if ((i.getDatum() == izdanje.getDatum() || i.getBroj() == izdanje.getBroj())
                        && i.getPublikacija().getPublikacijaID() == izdanje.getPublikacija().getPublikacijaID()) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
}
