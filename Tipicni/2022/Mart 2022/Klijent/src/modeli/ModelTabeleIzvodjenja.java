/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Festival;
import domen.Izvodjenje;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import komunikacija.Komunikacija;
import konstante.Operacije;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Korisnik
 */
public class ModelTabeleIzvodjenja extends AbstractTableModel {
    
    ArrayList<Izvodjenje> lista;
    String[] kolone = {"Naziv dela", "Datum i vreme pocetka", "Datum i vreme kraja", "Sala"};
        

    public ModelTabeleIzvodjenja(Festival f) {
        // POSLACU KLIJENTSKI ZAHTEV DA VRATIM SVA IZVODJENJA
        // TOG FESTIVALA, AKO NEMA, VRACA PRAZNU LISTU, A AKO IMA, UCITA IH
        
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.VRATI_IZVODJENJA_FESTIVALA);
        kz.setParametar(f);
        
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
        
        lista = (ArrayList<Izvodjenje>) so.getOdgovor();
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int i) {
        return kolone[i];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Izvodjenje i = lista.get(rowIndex);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");

        switch (columnIndex) {
            case 0:
                return i.getDelo().getNaziv();
            case 1:
                return sdf.format(i.getDatumVremePocetka());
            case 2:
                return sdf.format(i.getDatumVremeKraja());
            case 3:
                return i.getSala();

            default:
                return "return!";
        }
    }

    public ArrayList<Izvodjenje> getLista() {
        return lista;
    }

    public void dodajIzvodjenje(Izvodjenje i) {
        lista.add(i);
        fireTableDataChanged();
    }   

    public void obrisiIzvodjenje(int row) {
        lista.remove(row);
        fireTableDataChanged();
    }
    
}
