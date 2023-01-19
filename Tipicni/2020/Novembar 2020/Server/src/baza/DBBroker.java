/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baza;

import domen.Dogadjaj;
import domen.StavkaIzvestaja;
import domen.Korisnik;
import domen.Ucesce;
import domen.UcesnikZaDogadjaj;
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
                Korisnik k = new Korisnik(rs.getInt("KorisnikID"),
                        rs.getString("Ime"), rs.getString("Prezime"),
                        rs.getString("KorisnickoIme"), rs.getString("Lozinka"));
                if (k.getKorisnickoIme().equals(user) && k.getLozinka().equals(pass)) {
                    return k;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public ArrayList<Korisnik> vratiKorisnike() {
        ArrayList<Korisnik> lista = new ArrayList<>();
        String upit = "SELECT * FROM KORISNIK";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                Korisnik k = new Korisnik(rs.getInt(1),
                        rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5));
                lista.add(k);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public boolean sacuvajDogadjaj(Dogadjaj dog) throws SQLException {

        String upit = "INSERT INTO DOGADJAJ (Naziv, Opis, DatumOd, DatumDo, "
                + "TipDogadjaja, KorisnikOrganizatorID) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement ps
                    = Konekcija.getInstance().getConnection()
                            .prepareStatement(upit, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, dog.getNaziv());
            ps.setString(2, dog.getOpis());
            ps.setTimestamp(3, new Timestamp(dog.getDatumOd().getTime()));
            ps.setTimestamp(4, new Timestamp(dog.getDatumDo().getTime()));
            ps.setString(5, dog.getTipDogadjaja());
            ps.setLong(6, dog.getKorisnikOrganizator().getKorisnikID());

            ps.executeUpdate();

            ResultSet tableKeys = ps.getGeneratedKeys();
            tableKeys.next();
            long autoDogadjajID = tableKeys.getLong(1);

            dog.setDogadjajID(autoDogadjajID);

            if (sacuvajUcescaZaDogadjaj(dog)) {
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

    private boolean sacuvajUcescaZaDogadjaj(Dogadjaj dog) throws SQLException {

        String upit = "INSERT INTO UCESCE VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);

            for (Ucesce u : dog.getListaUcesca()) {

                ps.setLong(1, dog.getDogadjajID());
                ps.setInt(2, u.getRb());
                ps.setString(3, u.getOpisUcesca());
                ps.setBoolean(4, u.isObaveznoPrisustvo());
                ps.setLong(5, u.getKorisnik().getKorisnikID());

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
        String upit = "SELECT d.dogadjajid, CONCAT(k.ime, CONCAT(' ', k.prezime)) "
                + "AS ime_prezime, d.naziv, d.datumod, d.datumdo "
                + "FROM dogadjaj d JOIN korisnik k ON "
                + "(d.korisnikorganizatorid = k.korisnikid) " + dodatniUpit;
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                StavkaIzvestaja i = new StavkaIzvestaja(rs.getInt("d.dogadjajid"),
                        rs.getString("ime_prezime"), rs.getString("d.naziv"),
                        rs.getTimestamp("d.datumod"), rs.getTimestamp("d.datumdo"));
                lista.add(i);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public ArrayList<UcesnikZaDogadjaj> vratiUcescaZaDogadjaj(int dogadjajID) {
        ArrayList<UcesnikZaDogadjaj> lista = new ArrayList<>();
        String upit = "SELECT u.dogadjajid, u.rb, u.opisucesca, u.obaveznoprisustvo,"
                + " CONCAT(k.ime, CONCAT(' ', k.prezime)) as ime_prezime"
                + " FROM UCESCE u JOIN KORISNIK k on"
                + " (u.korisnikid = k.korisnikid) WHERE DOGADJAJID = " + dogadjajID;
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                UcesnikZaDogadjaj ucesnik = new UcesnikZaDogadjaj(rs.getInt("DogadjajID"),
                        rs.getInt("RB"), rs.getString("OpisUcesca"),
                        rs.getBoolean("ObaveznoPrisustvo"), rs.getString("ime_prezime"));
                lista.add(ucesnik);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }
}
