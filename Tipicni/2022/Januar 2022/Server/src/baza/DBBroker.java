/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baza;

import domen.Dostupnost;
import domen.Igra;
import domen.Izdavac;
import domen.StavkaIzvestaja;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBBroker {
    
    // za slucaj da je pokrenuto vise klijenata
    // sa ovim kodom ispod za generisanje igreID
    // uvek bi vracalo isti ID svakom klijentu
    // pa bi doslo do greska DUPLICATE ENTRY FOR KEY PRIMARY
    // da bi se resio taj problem, koristio bi se ovaj kod ispod
    // odnosno napravili bismo globalne varijable igraID i vecVracenID
    // da bismo proverili da li je taj ID vec vracen nekom klijentu
    // jer ako jeste onda bismo poslednji ID povecali za 1
    
    // int igraID = 0;
    // boolean vecVracenID = false;
    
//    public int vratiIgruID() {
//        String upit = "SELECT MAX(IGRAID) AS MAX FROM IGRA";
//        
//        if (!vecVracenID) {
//            try {
//                Statement st = Konekcija.getInstance().getConnection().createStatement();
//                ResultSet rs = st.executeQuery(upit);
//                while (rs.next()) {
//                    igraID = rs.getInt("MAX");
//                    vecVracenID = true;
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//
//        return ++igraID;
//    }

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

    public ArrayList<Izdavac> vratiIzdavace() {
        ArrayList<Izdavac> lista = new ArrayList<>();
        String upit = "SELECT * FROM IZDAVAC";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                Izdavac i = new Izdavac(rs.getInt("IzdavacID"), rs.getString("Naziv"),
                        rs.getString("Adresa"), rs.getString("URL"));
                lista.add(i);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public int vratiIgruID() {
        String upit = "SELECT MAX(IGRAID) AS MAX FROM IGRA";
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

    public boolean sacuvajIgru(Igra i) throws SQLException {
        String upit = "INSERT INTO IGRA VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);

            ps.setInt(1, i.getIgraID());
            ps.setString(2, i.getNaziv());
            ps.setString(3, i.getZanr());
            ps.setString(4, i.getOpis());
            ps.setString(5, i.getKorisnik());
            ps.setInt(6, i.getIzdavac().getIzdavacID());

            ps.executeUpdate();

            if (sacuvajDostupnosti(i)) {
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

    private boolean sacuvajDostupnosti(Igra i) throws SQLException {
        String upit = "INSERT INTO DOSTUPNOST VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);

            for (Dostupnost d : i.getListaDostupnosti()) {
                ps.setInt(1, i.getIgraID());
                ps.setInt(2, d.getRb());
                ps.setString(3, d.getPlatforma());
                ps.setDate(4, new Date(d.getDatumObjave().getTime()));
                ps.setString(5, d.getStatus());

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
        String upit = "SELECT i.naziv AS naziv, "
                + "CASE WHEN SUM(CASE WHEN D.PLATFORMA = 'PC' THEN 1 ELSE 0 END) = 1 THEN 'Da' "
                + "	ELSE 'Ne' "
                + "	END AS PC, "
                + "CASE WHEN SUM(CASE WHEN D.PLATFORMA = 'Playstation' THEN 1 ELSE 0 END) = 1 THEN 'Da' "
                + "	ELSE 'Ne' "
                + "	END AS Playstation, "
                + "CASE WHEN SUM(CASE WHEN D.PLATFORMA = 'XBOX' THEN 1 ELSE 0 END) = 1 THEN 'Da' "
                + "	ELSE 'Ne' "
                + "	END AS XBOX, "
                + "CASE WHEN SUM(CASE WHEN D.PLATFORMA = 'Steam' THEN 1 ELSE 0 END) = 1 THEN 'Da' "
                + "	ELSE 'Ne' "
                + "	END AS Steam "
                + "FROM IGRA I JOIN DOSTUPNOST D ON (I.IGRAID = D.IGRAID) "
                + dodatniUpit
                + "GROUP BY naziv";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                StavkaIzvestaja si = new StavkaIzvestaja(rs.getString("Naziv"), 
                        rs.getString("PC"), rs.getString("Playstation"), 
                        rs.getString("XBOX"), rs.getString("Steam"));
                lista.add(si);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

}
