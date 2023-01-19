/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baza;

import domen.Aerodrom;
import domen.Interkonekcija;
import domen.Let;
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

    public ArrayList<Aerodrom> vratiAerodrome() {
        ArrayList<Aerodrom> lista = new ArrayList<>();
        String upit = "SELECT * FROM AERODROM";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                Aerodrom a = new Aerodrom(rs.getInt("AerodromID"),
                        rs.getString("Naziv"), rs.getString("Kod"),
                        rs.getString("Adresa"), rs.getString("Drzava"));
                lista.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public boolean sacuvajLet(Let let) throws SQLException {
        String upit = "INSERT INTO LET (DatumVremePocetka, DatumVremeKraja, "
                + "Opis, TipAviona, RedovanLet, PocetniAerodromID, KrajnjiAerodromID)"
                + " VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection()
                    .prepareStatement(upit, Statement.RETURN_GENERATED_KEYS);

            ps.setTimestamp(1, new Timestamp(let.getDatumVremePocetka().getTime()));
            ps.setTimestamp(2, new Timestamp(let.getDatumVremeKraja().getTime()));
            ps.setString(3, let.getOpis());
            ps.setString(4, let.getTipAviona());
            ps.setBoolean(5, let.isRedovanLet());
            ps.setLong(6, let.getPocetniAerodrom().getAerodromID());
            ps.setLong(7, let.getKrajnjiAerodrom().getAerodromID());

            ps.executeUpdate();

            ResultSet tableKeys = ps.getGeneratedKeys();
            tableKeys.next();
            long autoLetID = tableKeys.getLong(1);

            let.setLetID(autoLetID);

            if (sacuvajInterkonekcije(let)) {
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

    private boolean sacuvajInterkonekcije(Let let) throws SQLException {
        String upit = "INSERT INTO INTERKONEKCIJA VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);

            ArrayList<Interkonekcija> interkonekcije = let.getInterkonekcije();

            for (Interkonekcija i : interkonekcije) {
                ps.setLong(1, let.getLetID());
                ps.setLong(2, i.getRb());
                ps.setLong(3, i.getAerodrom().getAerodromID());
                ps.setTimestamp(4, new Timestamp(i.getDatumVremeLeta().getTime()));

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

    public ArrayList<Let> vratiIzvestaj() {
        ArrayList<Let> lista = new ArrayList<>();
        String upit = "SELECT * FROM LET l JOIN AERODROM pocetni ON "
                + "(pocetni.aerodromid = l.pocetniAerodromid) "
                + "JOIN aerodrom krajnji ON (krajnji.aerodromid = l.krajnjiaerodromid)";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {

                Aerodrom pocetniAerodrom = new Aerodrom(rs.getLong(9),
                        rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13));

                Aerodrom krajnjiAerodrom = new Aerodrom(rs.getLong(14),
                        rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18));

                Let l = new Let(rs.getLong("LetID"), rs.getTimestamp("datumVremePocetka"),
                        rs.getTimestamp("DatumVremeKraja"), rs.getString("Opis"),
                        rs.getString("TipAviona"), rs.getBoolean("RedovanLet"),
                        pocetniAerodrom, krajnjiAerodrom, null);

                lista.add(l);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public ArrayList<Interkonekcija> vratiInterkonekcijeZaLet(Let let) {
        ArrayList<Interkonekcija> lista = new ArrayList<>();
        String upit = "SELECT * "
                + "FROM INTERKONEKCIJA i "
                + "JOIN aerodrom a ON (a.aerodromid = i.aerodromid) "
                + "WHERE LETID = " + let.getLetID();
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {

                Aerodrom aerodrom = new Aerodrom(rs.getInt("AerodromID"),
                        rs.getString("Naziv"), rs.getString("Kod"),
                        rs.getString("Adresa"), rs.getString("Drzava"));

                Interkonekcija i = new Interkonekcija(let, rs.getLong("RB"),
                        aerodrom, rs.getTimestamp("DatumVremeLeta"));

                lista.add(i);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }
}
