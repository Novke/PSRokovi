/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baza;

import domen.PoreskaPrijava;
import domen.PoreskiObveznik;
import domen.VrstaNepokretnosti;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    public PoreskiObveznik login(String username, String password) {
        String upit = "SELECT * FROM PORESKIOBVEZNIK";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                PoreskiObveznik po = new PoreskiObveznik(rs.getInt("PoreskiObveznikID"),
                        rs.getString("Ime"), rs.getString("Prezime"), rs.getString("JMBG"),
                        rs.getString("KorisnickoIme"), rs.getString("Lozinka"), rs.getString("Telefon"));

                if (po.getKorisnickoIme().equals(username) && po.getLozinka().equals(password)) {
                    return po;
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public ArrayList<VrstaNepokretnosti> vratiNepokretnosti() {
        ArrayList<VrstaNepokretnosti> lista = new ArrayList<>();
        String upit = "SELECT * FROM VRSTANEPOKRETNOSTI";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                VrstaNepokretnosti vn = new VrstaNepokretnosti(rs.getInt("VrstaNepokretnostiID"),
                        rs.getString("NazivVrsteNepokretnosti"), rs.getString("PoreskaGrupa"));
                lista.add(vn);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public boolean sacuvajPrijave(ArrayList<PoreskaPrijava> prijave) throws SQLException {
        String upit = "INSERT INTO PORESKAPRIJAVA (Adresa, MestoNepokretnosti, MestoPrebivalista, "
                + "BrojListaNepokretnosti, GodinaIzgradnje, DatumPocetkaKoriscenja, Povrsina, "
                + "DatumPodnosenjaPrijave, PoreskiObveznikID, VrstaNepokretnostiID) VALUES "
                + "(?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);

            for (PoreskaPrijava pp : prijave) {
                ps.setString(1, pp.getAdresa());
                ps.setString(2, pp.getMestoNepokretnosti());
                ps.setBoolean(3, pp.isMestoPrebivalista());
                ps.setInt(4, pp.getBrojListaNepokretnosti());
                ps.setInt(5, pp.getGodinaIzgradnje());
                ps.setDate(6, new Date(pp.getDatumPocetkaKoriscenja().getTime()));
                ps.setDouble(7, pp.getPovrsina());
                ps.setDate(8, new Date(System.currentTimeMillis()));
                ps.setInt(9, pp.getPoreskiObveznik().getPoreskiObveznikID());
                ps.setInt(10, pp.getVrstaNepokretnosti().getVrstaNepokretnostiID());

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

    public ArrayList<PoreskiObveznik> vratiObveznike(String dodatniUpit) {
        ArrayList<PoreskiObveznik> lista = new ArrayList<>();
        String upit = "SELECT * FROM PORESKIOBVEZNIK " + dodatniUpit;
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                PoreskiObveznik po = new PoreskiObveznik(rs.getInt("PoreskiObveznikID"),
                        rs.getString("Ime"), rs.getString("Prezime"), rs.getString("JMBG"),
                        "Nije nam potreban", "ni username ni password", rs.getString("Telefon"));
                lista.add(po);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public ArrayList<PoreskaPrijava> vratiPrijaveObveznika(PoreskiObveznik po) {
        ArrayList<PoreskaPrijava> lista = new ArrayList<>();
        String upit = "SELECT * FROM PORESKAPRIJAVA pp JOIN VRSTANEPOKRETNOSTI vp ON "
                + "(pp.vrstanepokretnostiid = vp.vrstanepokretnostiid) "
                + "WHERE PORESKIOBVEZNIKID = " + po.getPoreskiObveznikID();
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {

                VrstaNepokretnosti vrstaNepokretnosti = new VrstaNepokretnosti(rs.getInt("VrstaNepokretnostiID"),
                        rs.getString("NazivVrsteNepokretnosti"), rs.getString("PoreskaGrupa"));

                PoreskaPrijava pp = new PoreskaPrijava(rs.getInt("PoreskaPrijavaID"),
                        rs.getString("Adresa"), rs.getString("MestoNepokretnosti"),
                        rs.getBoolean("MestoPrebivalista"), rs.getInt("BrojListaNepokretnosti"),
                        rs.getInt("GodinaIzgradnje"), rs.getDate("DatumPocetkaKoriscenja"), 
                        rs.getInt("Povrsina"), rs.getDate("DatumPodnosenjaPrijave"), po, vrstaNepokretnosti);

                lista.add(pp);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }
}
