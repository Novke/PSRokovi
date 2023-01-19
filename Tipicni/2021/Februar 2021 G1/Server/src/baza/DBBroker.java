/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baza;

import domen.Opstina;
import domen.Prijava;
import domen.StavkaPrijave;
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

    public ArrayList<Opstina> vratiOpstine() {
        ArrayList<Opstina> lista = new ArrayList<>();
        String upit = "SELECT * FROM OPSTINA";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                Opstina o = new Opstina(rs.getLong("OpstinaID"), rs.getInt("PttBroj"),
                        rs.getString("Naziv"));
                lista.add(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public boolean sacuvajPrijavu(Prijava p) throws SQLException {
        String upit = "INSERT INTO PRIJAVA (Drzavljanstvo, JMBG, Ime, Prezime, "
                + "ElektronskaPosta, MobilniTelefon, SpecificnaOboljenja, DatumPrijave,"
                + "OpstinaID) VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection()
                    .prepareStatement(upit, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, p.getDrzavljanstvo());
            ps.setString(2, p.getJMBG());
            ps.setString(3, p.getIme());
            ps.setString(4, p.getPrezime());
            ps.setString(5, p.getElektronskaPosta());
            ps.setString(6, p.getMobilniTelefon());
            ps.setBoolean(7, p.isSpecificnaOboljenja());
            ps.setTimestamp(8, new Timestamp(System.currentTimeMillis()));
            ps.setLong(9, p.getOpstina().getOpstinaID());

            ps.executeUpdate();
            
            ResultSet tableKeys = ps.getGeneratedKeys();
            tableKeys.next();
            long prijavaID = tableKeys.getLong(1);
            
            p.setPrijavaID(prijavaID);

            if (sacuvajStavkePrijave(p)) {
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

    private boolean sacuvajStavkePrijave(Prijava p) throws SQLException {
        String upit = "INSERT INTO STAVKAPRIJAVE VALUES (?,?,?)";
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);

            ArrayList<StavkaPrijave> stavkePrijave = p.getStavkePrijave();

            for (StavkaPrijave sp : stavkePrijave) {
                ps.setLong(1, p.getPrijavaID());
                ps.setInt(2, sp.getRedniBroj());
                ps.setString(3, sp.getTipVakcine());

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

    public ArrayList<Prijava> vratiIzvestaj() {
        ArrayList<Prijava> lista = new ArrayList<>();
        String upit = "SELECT * FROM PRIJAVA P JOIN OPSTINA O ON (p.opstinaid = o.opstinaid)";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {

                Opstina opstina = new Opstina(rs.getLong("OpstinaID"), rs.getInt("PttBroj"),
                        rs.getString("Naziv"));

                Prijava p = new Prijava(rs.getLong("PrijavaID"), rs.getString("Drzavljanstvo"),
                        rs.getString("JMBG"), rs.getString("Ime"), rs.getString("Prezime"),
                        rs.getString("ElektronskaPosta"), rs.getString("MobilniTelefon"),
                        rs.getBoolean("SpecificnaOboljenja"), rs.getTimestamp("DatumPrijave"),
                        opstina, null);

                lista.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public boolean ponistiStavkePrijave(Prijava p) throws SQLException {
        String upit = "DELETE FROM STAVKAPRIJAVE WHERE PRIJAVAID = ?";
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);

            ps.setLong(1, p.getPrijavaID());

            ps.executeUpdate();

            if (ponistiPrijavu(p)) {
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

    private boolean ponistiPrijavu(Prijava p) throws SQLException {
        String upit = "DELETE FROM PRIJAVA WHERE PRIJAVAID = ?";
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);

            ps.setLong(1, p.getPrijavaID());

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
