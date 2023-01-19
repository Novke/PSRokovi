/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baza;

import domen.Banka;
import domen.Kompanija;
import domen.Korisnik;
import domen.StavkaIzvestaja;
import domen.Zaposleni;
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

    public Korisnik login(String user, String pass) {
        String upit = "SELECT * FROM KORISNIK";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                Korisnik k = new Korisnik(rs.getInt("KorisnikID"), rs.getString("Ime"),
                        rs.getString("Prezime"), rs.getString("KorisnickoIme"), rs.getString("Lozinka"));
                if (k.getKorisnickoIme().equals(user) && k.getLozinka().equals(pass)) {
                    return k;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public ArrayList<Banka> vratiBanke() {
        ArrayList<Banka> lista = new ArrayList<>();
        String upit = "SELECT * FROM BANKA";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                Banka b = new Banka(rs.getInt("BankaID"), rs.getString("Naziv"),
                        rs.getString("Adresa"), rs.getInt("JedinstveniBrojPlatnogPrometa"));
                lista.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public boolean sacuvajKompaniju(Kompanija kompanija) throws SQLException {
        String upit = "INSERT INTO KOMPANIJA VALUES (?,?,?,?,?,?,?,?)";
        int id = vratiIDKompanije();
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);

            ps.setInt(1, id);
            ps.setString(2, kompanija.getNaziv());
            ps.setString(3, kompanija.getTipKompanija());
            ps.setBoolean(4, kompanija.isPdvobveznik());
            ps.setString(5, kompanija.getMaticniBroj());
            ps.setTimestamp(6, new Timestamp(kompanija.getDatumVremeEvidentiranja().getTime()));
            ps.setInt(7, kompanija.getBrojZaposlenih());
            ps.setLong(8, kompanija.getKorisnik().getKorisnikID());

            kompanija.setKompanijaId(id);

            ps.executeUpdate();

            if (sacuvajZaposlene(kompanija)) {
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

    public boolean sacuvajZaposlene(Kompanija kompanija) throws SQLException {
        String upit = "INSERT INTO ZAPOSLENI (Ime, Prezime, JMBG, ZiroRacun, "
                + "Iznos, KompanijaID, BankaID) VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);

            for (Zaposleni z : kompanija.getListaZaposlenih()) {
                ps.setString(1, z.getIme());
                ps.setString(2, z.getPrezime());
                ps.setString(3, z.getJmbg());
                ps.setString(4, z.getZiroRacun());
                ps.setDouble(5, z.getIznos());
                ps.setLong(6, kompanija.getKompanijaId());
                ps.setLong(7, z.getBanka().getBankaID());

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

    private int vratiIDKompanije() {
        String upit = "SELECT MAX(KOMPANIJAID) AS MAX FROM KOMPANIJA";
        int id = 0;
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                id = rs.getInt("MAX");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ++id;
    }

    public ArrayList<StavkaIzvestaja> vratiIzvestaj(String dodatniUpit) {
        ArrayList<StavkaIzvestaja> lista = new ArrayList<>();
        String upit = "SELECT k.naziv, k.TipKompanije, "
                + "concat(z.ime, concat(' ', z.prezime)) as Ime_i_prezime, "
                + "z.ziroRacun, b.naziv, z.iznos "
                + "FROM kompanija k join zaposleni z on (k.kompanijaid = z.kompanijaid)"
                + " join banka b on (b.bankaid = z.bankaid) " + dodatniUpit;
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                StavkaIzvestaja e = new StavkaIzvestaja(rs.getString("k.naziv"), rs.getString("k.TipKompanije"),
                        rs.getString("Ime_i_prezime"), rs.getString("z.ziroRacun"),
                        rs.getDouble("z.iznos"), rs.getString("b.naziv"));
                lista.add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }
}
