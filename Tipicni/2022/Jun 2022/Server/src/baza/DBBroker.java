/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baza;

import domen.Kategorija;
import domen.Rad;
import domen.RasporedSekcije;
import domen.Sekcija;
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

    public ArrayList<Kategorija> vratiNadredjeneKategorije() {
        ArrayList<Kategorija> lista = new ArrayList<>();
        String upit = "SELECT * FROM KATEGORIJA WHERE NADREDJENAKATEGORIJAID IS NULL";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                Kategorija k = new Kategorija(rs.getLong(1), rs.getString(2), null);
                lista.add(k);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public ArrayList<Kategorija> vratiPotkategorije(Kategorija nadKategorija) {
        ArrayList<Kategorija> lista = new ArrayList<>();
        String upit = "SELECT * FROM KATEGORIJA WHERE NADREDJENAKATEGORIJAID = "
                + nadKategorija.getKategorijaID();
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                Kategorija k = new Kategorija(rs.getLong(1), rs.getString(2), nadKategorija);
                lista.add(k);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public ArrayList<Rad> vratiRadove() {
        ArrayList<Rad> lista = new ArrayList<>();
        String upit = "SELECT * FROM RAD";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                Rad rad = new Rad(rs.getLong(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5));
                lista.add(rad);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public boolean sacuvajSekciju(Sekcija s) throws SQLException {
        String upit = "INSERT INTO SEKCIJA (NAZIV, DATUMVREMEOD, DATUMVREMEDO, "
                + "SALA, MODERATOR, KATEGORIJAID) "
                + "VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = Konekcija.getInstance()
                    .getConnection().prepareStatement(upit, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, s.getNaziv());
            ps.setTimestamp(2, new Timestamp(s.getDatumVremeOd().getTime()));
            ps.setTimestamp(3, new Timestamp(s.getDatumVremeDo().getTime()));
            ps.setString(4, s.getSala());
            ps.setString(5, s.getModerator());
            ps.setLong(6, s.getKategorija().getKategorijaID());

            ps.executeUpdate();

            ResultSet tableKeys = ps.getGeneratedKeys();
            tableKeys.next();
            long sekcijaID = tableKeys.getLong(1);

            s.setSekcijaID(sekcijaID);

            if (sacuvajRaspored(s)) {
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

    private boolean sacuvajRaspored(Sekcija s) throws SQLException {
        String upit = "INSERT INTO RASPOREDSEKCIJE VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);

            for (RasporedSekcije rs : s.getRadoviSekcije()) {
                ps.setLong(1, s.getSekcijaID());
                ps.setInt(2, rs.getRb());
                ps.setString(3, rs.getStatus());
                ps.setLong(4, rs.getRad().getRadID());

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
        String upit = "SELECT K.NAZIV, PK.NAZIV, S.NAZIV, S.DATUMVREMEOD,  "
                + "COUNT(*) AS ukupnoRadova, "
                + "SUM(CASE WHEN RS.STATUS != 'Nije prezentovan' THEN 1 ELSE 0 END) AS prezentovanoRadova "
                + "FROM kategorija k JOIN kategorija pk ON (k.kategorijaid = pk.nadredjenakategorijaid) "
                + "JOIN sekcija s ON (s.kategorijaid = pk.kategorijaid) "
                + "JOIN rasporedsekcije rs ON (rs.sekcijaid = s.sekcijaid) "
                + dodatniUpit
                + "GROUP BY K.NAZIV, PK.NAZIV, S.NAZIV, S.DATUMVREMEOD";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                StavkaIzvestaja si = new StavkaIzvestaja(rs.getString(1), rs.getString(2), 
                        rs.getString(3), rs.getDate(4), rs.getInt(5), rs.getInt(6));
                lista.add(si);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }
}
