/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baza;

import domen.Angazovanje;
import domen.Emisija;
import domen.Radnik;
import domen.StavkaIzvestaja;
import domen.Studio;
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

    public ArrayList<Radnik> vratiAktivneRadnike() {
        ArrayList<Radnik> lista = new ArrayList<>();
        String upit = "SELECT * FROM RADNIK WHERE STATUS = 'Aktivan'";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                Radnik r = new Radnik(rs.getInt("RadnikID"), rs.getString("Ime"),
                        rs.getString("Prezime"), rs.getInt("BrojLicence"), rs.getString("StrucnaSprema"),
                        rs.getString("Status"));
                lista.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public ArrayList<Studio> vratiAktivnaStudija() {
        ArrayList<Studio> lista = new ArrayList<>();
        String upit = "SELECT * FROM STUDIO WHERE STATUS = 'Aktivan'";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                Studio s = new Studio(rs.getInt("StudioID"), rs.getString("Naziv"),
                        rs.getString("Lokacija"), rs.getString("Status"));
                lista.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public boolean sacuvajEmisiju(Emisija e) throws SQLException {
        String upit = "INSERT INTO EMISIJA (NazivEmisije, DatumVremePocetka, DatumVremeKraja, "
                + "NacinEmitovanja, Producent, VoditeljRadnikID, StudioID) VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection()
                    .prepareStatement(upit, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, e.getNazivEmisije());
            ps.setTimestamp(2, new Timestamp(e.getDatumVremePocetka().getTime()));
            ps.setTimestamp(3, new Timestamp(e.getDatumVremeKraja().getTime()));
            ps.setString(4, e.getNacinEmitovanja());
            ps.setString(5, e.getProducent());
            ps.setInt(6, e.getVoditeljRadnik().getRadnikID());
            ps.setInt(7, e.getStudio().getStudioID());

            ps.executeUpdate();

            ResultSet tableKeys = ps.getGeneratedKeys();
            tableKeys.next();
            int emisijaID = tableKeys.getInt(1);

            e.setEmisijaID(emisijaID);

            if (sacuvajAngazovanja(e)) {
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

    private boolean sacuvajAngazovanja(Emisija e) throws SQLException {
        String upit = "INSERT INTO ANGAZOVANJE (VrstaAngazovanja, OpisPosla, BrojSati, EmisijaID, "
                + "RadnikID) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);

            for (Angazovanje a : e.getAngazovanja()) {
                ps.setString(1, a.getVrstaAngazovanja());
                ps.setString(2, a.getOpisPosla());
                ps.setInt(3, a.getBrojSati());
                ps.setInt(4, e.getEmisijaID());
                ps.setInt(5, a.getRadnik().getRadnikID());

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

    public ArrayList<Studio> vratiStudija() {
        ArrayList<Studio> lista = new ArrayList<>();
        String upit = "SELECT * FROM STUDIO";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                Studio s = new Studio(rs.getInt("StudioID"), rs.getString("Naziv"),
                        rs.getString("Lokacija"), rs.getString("Status"));
                lista.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public ArrayList<StavkaIzvestaja> vratiIzvestaj(String dodatniUpit) {
        ArrayList<StavkaIzvestaja> lista = new ArrayList<>();
        String upit = "SELECT s.naziv, COUNT(DISTINCT a.emisijaID) AS ukupnoEmisija, "
                + "SUM(a.brojSati) AS ukupnoAngazovanihSati "
                + "FROM studio s JOIN emisija e ON (s.studioid = e.studioid) "
                + "JOIN angazovanje a ON (e.emisijaid = a.emisijaid) "
                + dodatniUpit
                + "GROUP BY s.naziv "
                + "ORDER BY ukupnoAngazovanihSati DESC";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                StavkaIzvestaja si = new StavkaIzvestaja(rs.getString("Naziv"),
                        rs.getInt("ukupnoEmisija"), rs.getInt("ukupnoAngazovanihSati"));
                lista.add(si);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }
}
