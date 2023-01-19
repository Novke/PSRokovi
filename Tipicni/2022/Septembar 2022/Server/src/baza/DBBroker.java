/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baza;

import domen.Komponenta;
import domen.PrevoznoSredstvo;
import domen.ProizvodniPogon;
import domen.StavkaIzvestaja;
import domen.StavkaPrevoznogSredstva;
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

    public ArrayList<ProizvodniPogon> vratiPogone() {
        ArrayList<ProizvodniPogon> lista = new ArrayList<>();
        String upit = "SELECT * FROM PROIZVODNIPOGON";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {

                ProizvodniPogon pp = new ProizvodniPogon(rs.getLong(1), rs.getString(2), rs.getString(3));
                lista.add(pp);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public ArrayList<Komponenta> vratiKomponente() {
        ArrayList<Komponenta> lista = new ArrayList<>();
        String upit = "SELECT * FROM KOMPONENTA";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {

                Komponenta k = new Komponenta(rs.getLong(1), rs.getString(2), rs.getString(3));
                lista.add(k);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public boolean sacuvajPrevoznoSredstvo(PrevoznoSredstvo prevozno) throws SQLException {
        String upit = "INSERT INTO PREVOZNOSREDSTVO "
                + "(MODEL, DATUMVREMEPOCETKA, DATUMVREMEZAVRSETKA, OCEKIVANIRADNIVEK,  "
                + "RUKOVODILAC, TIPPREVOZNOGSREDSTVA, PROIZVODNIPOGONID) "
                + "VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = Konekcija.getInstance()
                    .getConnection().prepareStatement(upit, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, prevozno.getModel());
            ps.setTimestamp(2, new Timestamp(prevozno.getDatumVremePocetka().getTime()));
            ps.setTimestamp(3, new Timestamp(prevozno.getDatumVremeZavrsetka().getTime()));
            ps.setInt(4, prevozno.getOcekivaniRadniVek());
            ps.setString(5, prevozno.getRukovodilac());
            ps.setString(6, prevozno.getTipPrevoznogSredstva());
            ps.setLong(7, prevozno.getProizvodniPogon().getProizvodniPogonID());

            ps.executeUpdate();

            ResultSet tableKeys = ps.getGeneratedKeys();
            tableKeys.next();
            long psID = tableKeys.getLong(1);

            prevozno.setPrevoznoSredstvoID(psID);

            if (sacuvajStavke(prevozno)) {
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

    private boolean sacuvajStavke(PrevoznoSredstvo prevozno) throws SQLException {
        String upit = "INSERT INTO STAVKAPREVOZNOGSREDSTVA VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);

            for (StavkaPrevoznogSredstva sps : prevozno.getListaStavki()) {
                ps.setLong(1, prevozno.getPrevoznoSredstvoID());
                ps.setInt(2, sps.getRb());
                ps.setInt(3, sps.getKolicina());
                ps.setBoolean(4, sps.isKontrolisano());
                ps.setLong(5, sps.getKomponenta().getKomponentaID());

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
        String upit = "SELECT P.NAZIV AS POGON, PS.TIPPREVOZNOGSREDSTVA AS VRSTA, "
                + "COUNT(*) AS BROJ_PROIZVEDENIH_JEDINICA "
                + "FROM PREVOZNOSREDSTVO PS JOIN PROIZVODNIPOGON P ON (PS.PROIZVODNIPOGONID = "
                + "P.PROIZVODNIPOGONID) "
                + dodatniUpit
                + "GROUP BY POGON, VRSTA";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                
                StavkaIzvestaja si = new StavkaIzvestaja(rs.getString(1), rs.getString(2), 
                        rs.getInt(3), "Radim ovo kad provalim kako tacno.");
                
                lista.add(si);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

}
