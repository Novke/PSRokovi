/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baza;

import domen.ProgramskiVodic;
import domen.Stanica;
import domen.StavkaIzvestaja;
import domen.StavkaProgramskogVodica;
import domen.TipEmisije;
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

    public ArrayList<Stanica> vratiStanice() {
        ArrayList<Stanica> lista = new ArrayList<>();
        String upit = "SELECT * FROM STANICA";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                Stanica s = new Stanica(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4));
                lista.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public ArrayList<TipEmisije> vratiTipoveEmisije() {
        ArrayList<TipEmisije> lista = new ArrayList<>();
        String upit = "SELECT * FROM TIPEMISIJE WHERE NADTIPEMISIJEID IS NULL";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                TipEmisije tipEmisije = new TipEmisije(rs.getLong(1), rs.getString(2), null);
                lista.add(tipEmisije);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public ArrayList<TipEmisije> vratiPodtipoveEmisije(TipEmisije tipEmisije) {
        ArrayList<TipEmisije> lista = new ArrayList<>();
        String upit = "SELECT * FROM TIPEMISIJE WHERE NADTIPEMISIJEID = " + tipEmisije.getTipEmisijeID();
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                TipEmisije podtipoviEmisije = new TipEmisije(rs.getLong(1), rs.getString(2), tipEmisije);
                lista.add(podtipoviEmisije);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public boolean sacuvajProgramskiVodic(ProgramskiVodic pv) throws SQLException {
        String upit = "INSERT INTO PROGRAMSKIVODIC (DAN, OPIS, UREDNIK) VALUES (?,?,?)";
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection()
                    .prepareStatement(upit, Statement.RETURN_GENERATED_KEYS);

            ps.setDate(1, new Date(pv.getDan().getTime()));
            ps.setString(2, pv.getOpis());
            ps.setString(3, pv.getUrednik());

            ps.executeUpdate();

            ResultSet tableKeys = ps.getGeneratedKeys();
            tableKeys.next();
            long programskiVodicID = tableKeys.getLong(1);

            pv.setProgramskiVodicID(programskiVodicID);

            if (sacuvajStavke(pv)) {
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

    private boolean sacuvajStavke(ProgramskiVodic pv) throws SQLException {
        String upit = "INSERT INTO STAVKAPROGRAMSKOGVODICA VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);

            for (StavkaProgramskogVodica spv : pv.getStavkeProgramskogVodica()) {
                ps.setLong(1, pv.getProgramskiVodicID());
                ps.setInt(2, spv.getRb());
                ps.setString(3, spv.getNazivEmisije());
                ps.setTimestamp(4, new Timestamp(spv.getDatumVremeOd().getTime()));
                ps.setTimestamp(5, new Timestamp(spv.getDatumVremeDo().getTime()));
                ps.setLong(6, spv.getStanica().getStanicaID());
                ps.setLong(7, spv.getTipEmisije().getTipEmisijeID());

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
        String upit = "SELECT S.NAZIV, TE.NAZIV, PV.DAN, "
                + "SUM(CASE WHEN PODTE.TIPEMISIJEID = SPV.TIPEMISIJEID THEN 1 ELSE 0 END) AS ukupnoEmisija, "
                + "SUM(spv.datumVremeDo - spv.datumVremeOd) / 10000 AS ukupnoTrajanje "
                + "FROM STANICA S JOIN STAVKAPROGRAMSKOGVODICA SPV ON (S.STANICAID = SPV.STANICAID) "
                + "JOIN TIPEMISIJE PODTE ON (PODTE.TIPEMISIJEID = SPV.TIPEMISIJEID) "
                + "JOIN TIPEMISIJE TE ON (TE.TIPEMISIJEID = PODTE.NADTIPEMISIJEID) "
                + "JOIN PROGRAMSKIVODIC PV ON (PV.PROGRAMSKIVODICID = SPV.PROGRAMSKIVODICID) "
                + dodatniUpit
                + "GROUP BY S.NAZIV, TE.NAZIV";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {

                StavkaIzvestaja si = new StavkaIzvestaja(rs.getString(1),
                        rs.getString(2), rs.getDate(3), rs.getInt(4), rs.getInt(5));
                lista.add(si);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }
}
