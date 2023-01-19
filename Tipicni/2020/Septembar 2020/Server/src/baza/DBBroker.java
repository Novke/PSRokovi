/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baza;

import domen.StavkaIzvestaja;
import domen.Laborant;
import domen.Laboratorija;
import domen.OsiguranoLice;
import domen.Zahtev;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
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

    public void cuvajIzmeniBrisi() throws Exception {
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

    public Laborant login(String user, String pass) {
        String upit = "SELECT * "
                + "FROM LABORATORIJA LAB JOIN LABORANT L ON"
                + " (l.laboratorijaid = lab.laboratorijaid);";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {

                Laboratorija laboratorija = new Laboratorija(rs.getInt("LaboratorijaID"),
                        rs.getString("Naziv"), rs.getInt("DnevniKapacitetTestova"),
                        rs.getString("Grad"));

                Laborant laborant = new Laborant(rs.getInt("LaborantID"),
                        rs.getString("Ime"), rs.getString("Prezime"), rs.getString("KorisnickoIme"),
                        rs.getString("Lozinka"), laboratorija);

                if (laborant.getKorisnickoIme().equals(user)
                        && laborant.getLozinka().equals(pass)) {
                    return laborant;
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public ArrayList<Zahtev> vratiNeobradjeneZahteve(int labID) {
        ArrayList<Zahtev> lista = new ArrayList<>();
        String upit = "SELECT * "
                + "FROM ZAHTEV z JOIN laboratorija lab ON (z.laboratorijaid = lab.laboratorijaid) "
                + "JOIN osiguranolice ol ON (ol.osiguranoliceid = z.osiguranoliceid) "
                + "WHERE z.status = 'Neobradjen' "
                + "AND lab.laboratorijaid = " + labID;
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {

                OsiguranoLice ol = new OsiguranoLice(rs.getInt("OsiguranoLiceID"),
                        rs.getString("Ime"), rs.getString("Prezime"), rs.getString("LBO"),
                        rs.getString("KrvnaGrupa"));

                Laboratorija laboratorija = new Laboratorija(rs.getInt("LaboratorijaID"),
                        rs.getString("Naziv"), rs.getInt("DnevniKapacitetTestova"),
                        rs.getString("Grad"));

                Zahtev z = new Zahtev(rs.getInt("ZahtevID"), rs.getTimestamp("DatumVremeTestiranja"),
                        rs.getBoolean("Hitno"), rs.getString("Tip"), rs.getString("Rezultat"),
                        rs.getTimestamp("DatumVremeRezultata"), rs.getString("Napomena"),
                        rs.getString("Status"), ol, laboratorija, null);

                lista.add(z);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public boolean sacuvajObradjene(ArrayList<Zahtev> listaObradjenih) throws SQLException {

        String upit = "UPDATE ZAHTEV SET tip = ?, rezultat = ?, status = ?,"
                + " laborantid = ?, datumvremerezultata = ? WHERE zahtevid = ?";
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);

            for (Zahtev zahtev : listaObradjenih) {
                ps.setString(1, zahtev.getTip());
                ps.setString(2, zahtev.getRezultat());
                ps.setString(3, zahtev.getStatus());
                ps.setInt(4, zahtev.getLaborant().getLaborantId());
                ps.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
                ps.setInt(6, zahtev.getZahtevId());

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

    public ArrayList<Laboratorija> vratiLaboratorije() {
        ArrayList<Laboratorija> lista = new ArrayList<>();
        String upit = "SELECT * FROM LABORATORIJA";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                Laboratorija lab = new Laboratorija(rs.getInt("LaboratorijaID"),
                        rs.getString("Naziv"), rs.getInt("DnevniKapacitetTestova"),
                        rs.getString("Grad"));

                lista.add(lab);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public ArrayList<StavkaIzvestaja> vratiIzvestaj(String dodatniUpit) {
        ArrayList<StavkaIzvestaja> lista = new ArrayList<>();
        String upit = "SELECT tip, "
                + "SUM(CASE WHEN rezultat = 'Pozitivan' THEN 1 ELSE 0 END) AS ukupno_pozitivnih, "
                + "SUM(CASE WHEN rezultat = 'Negativan' THEN 1 ELSE 0 END) AS ukupno_negativnih "
                + "FROM zahtev z "
                + "WHERE z.status = 'Obradjen' " 
                + dodatniUpit
                + " GROUP BY tip ";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                StavkaIzvestaja i = new StavkaIzvestaja(rs.getString("tip"), 
                        rs.getInt("ukupno_pozitivnih"), rs.getInt("ukupno_negativnih"));
                lista.add(i);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }
}
