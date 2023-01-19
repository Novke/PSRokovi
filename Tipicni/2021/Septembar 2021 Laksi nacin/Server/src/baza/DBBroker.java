/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baza;

import domen.Intervencija;
import domen.StambenaZajednica;
import domen.Upravnik;
import domen.VrstaIntervencije;
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

    public Upravnik login(String username, String password) {
        String upit = "SELECT * FROM UPRAVNIK";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                Upravnik u = new Upravnik(rs.getInt("UpravnikID"), rs.getString("Ime"),
                        rs.getString("Prezime"), rs.getString("KorisnickoIme"),
                        rs.getString("Lozinka"));

                if (u.getKorisnickoIme().equals(username) && u.getLozinka().equals(password)) {
                    return u;
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public ArrayList<Intervencija> vratiIntervencije(Upravnik u) {
        ArrayList<Intervencija> lista = new ArrayList<>();
        String upit = "SELECT * FROM intervencija i "
                + "JOIN vrstaintervencije vi ON (i.vrstaintervencijeid = vi.vrstaintervencijeid) "
                + "JOIN stambenazajednica sz ON (i.stambenazajednicaid = sz.stambenazajednicaid) "
                + "JOIN upravnik u ON (i.upravnikid = u.upravnikid) "
                + "WHERE i.upravnikid = " + u.getUpravnikID();
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {

                VrstaIntervencije vrstaIntervencije
                        = new VrstaIntervencije(rs.getInt("VrstaIntervencijeID"), rs.getString("NazivVrste"));

                StambenaZajednica stambenaZajednica = new StambenaZajednica(rs.getInt("StambenaZajednicaID"),
                        rs.getString("Naziv"), rs.getString("Adresa"), rs.getString("Mesto"), u);

                Intervencija i = new Intervencija(rs.getInt("IntervencijaID"),
                        rs.getTimestamp("DatumVremePocetka"), rs.getTimestamp("DatumVremeZavrsetka"),
                        rs.getString("Opis"), rs.getBoolean("AngazovanjeIzvodjacaRadova"),
                        rs.getDouble("Cena"), rs.getString("Status"), vrstaIntervencije,
                        stambenaZajednica, u);

                lista.add(i);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public ArrayList<StambenaZajednica> vratiStambeneZajednice() {
        ArrayList<StambenaZajednica> lista = new ArrayList<>();
        String upit = "SELECT * FROM stambenazajednica sz "
                + "JOIN upravnik u ON (u.upravnikid = sz.upravnikid)";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {

                Upravnik u = new Upravnik(rs.getInt("UpravnikID"), rs.getString("Ime"),
                        rs.getString("Prezime"), rs.getString("KorisnickoIme"),
                        rs.getString("Lozinka"));

                StambenaZajednica stambenaZajednica = new StambenaZajednica(rs.getInt("StambenaZajednicaID"),
                        rs.getString("Naziv"), rs.getString("Adresa"), rs.getString("Mesto"), u);

                lista.add(stambenaZajednica);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public ArrayList<Intervencija> vratiIzvestaj(String dodatniUpit) {
        ArrayList<Intervencija> lista = new ArrayList<>();
        String upit = "SELECT * FROM intervencija i "
                + "JOIN vrstaintervencije vi ON (i.vrstaintervencijeid = vi.vrstaintervencijeid) "
                + "JOIN stambenazajednica sz ON (i.stambenazajednicaid = sz.stambenazajednicaid) "
                + "JOIN upravnik u ON (i.upravnikid = u.upravnikid) " + dodatniUpit;
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {

                Upravnik u = new Upravnik(rs.getInt("UpravnikID"), rs.getString("Ime"),
                        rs.getString("Prezime"), rs.getString("KorisnickoIme"),
                        rs.getString("Lozinka"));

                VrstaIntervencije vrstaIntervencije
                        = new VrstaIntervencije(rs.getInt("VrstaIntervencijeID"), rs.getString("NazivVrste"));

                StambenaZajednica stambenaZajednica = new StambenaZajednica(rs.getInt("StambenaZajednicaID"),
                        rs.getString("Naziv"), rs.getString("Adresa"), rs.getString("Mesto"), u);

                Intervencija i = new Intervencija(rs.getInt("IntervencijaID"),
                        rs.getTimestamp("DatumVremePocetka"), rs.getTimestamp("DatumVremeZavrsetka"),
                        rs.getString("Opis"), rs.getBoolean("AngazovanjeIzvodjacaRadova"),
                        rs.getDouble("Cena"), rs.getString("Status"), vrstaIntervencije,
                        stambenaZajednica, u);

                lista.add(i);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public ArrayList<VrstaIntervencije> vratiVrsteIntervencija() {
        ArrayList<VrstaIntervencije> lista = new ArrayList<>();
        String upit = "SELECT * FROM VRSTAINTERVENCIJE";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                VrstaIntervencije vrstaIntervencije
                        = new VrstaIntervencije(rs.getInt("VrstaIntervencijeID"), rs.getString("NazivVrste"));
                lista.add(vrstaIntervencije);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }
    
    private boolean obrisiStareIntervencije(int upravnikID) throws SQLException {
        String upit = "DELETE FROM INTERVENCIJA WHERE UPRAVNIKID = " + upravnikID;
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

    public boolean sacuvajIntervencije(ArrayList<Intervencija> intervencije) throws SQLException {

        if (obrisiStareIntervencije(intervencije.get(0).getUpravnik().getUpravnikID())) {

            String upit = "INSERT INTO INTERVENCIJA  "
                    + "(datumVremePocetka, datumVremeZavrsetka, Opis,  "
                    + "AngazovanjeIzvodjacaRadova, Cena, STATUS,  "
                    + "VrstaIntervencijeID, StambenaZajednicaID, UpravnikID) "
                    + "VALUES (?,?,?,?,?,?,?,?,?)";
            try {
                PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);

                for (Intervencija i : intervencije) {
                    ps.setTimestamp(1, new Timestamp(i.getDatumVremePocetka().getTime()));

                    if (i.getDatumVremeZavrsetka() != null) {
                        ps.setTimestamp(2, new Timestamp(i.getDatumVremeZavrsetka().getTime()));
                    }else{
                        ps.setTimestamp(2, null);
                    }

                    ps.setString(3, i.getOpis());
                    ps.setBoolean(4, i.isAngazovanjeIzvodjacaRadova());
                    ps.setDouble(5, i.getCena());
                    ps.setString(6, i.getStatus());
                    ps.setInt(7, i.getVrstaIntervencije().getVrstaIntervencijeID());
                    ps.setInt(8, i.getStambenaZajednica().getStambenaZajednicaID());
                    ps.setInt(9, i.getUpravnik().getUpravnikID());

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

        return false;

    }

}
