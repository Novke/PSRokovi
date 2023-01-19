/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Pomocna;
import domen.Publikacija;
import domen.Vest;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author USER
 */
public class ModelTabeleKlijent extends AbstractTableModel{

    ArrayList<Pomocna> lista;
    String[] kolone = {"Publikacija", "RB", "Naslov", "Tekst"};
    int rb = 0;

    public ModelTabeleKlijent() {
        lista = new ArrayList<>();
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
        Pomocna p = lista.get(rowIndex);
        
        switch(columnIndex){
            case 0: return p.getPublikacija();
            case 1: return p.getRb();
            case 2: return p.getNaslov();
            case 3: return p.getTekst();
            
            default: return "";
        }
    }

    public void dodaj(Publikacija p, Vest v) {
        Pomocna pom = new Pomocna(p, ++rb, v.getNaslov(), v.getVest());
        lista.add(pom);
        fireTableDataChanged();
    }

    public void ukloni(int selectedRow) {
        lista.remove(selectedRow);
        rb = 0;
        for (Pomocna pomocna : lista) {
            pomocna.setRb(++rb);
        }
        fireTableDataChanged();
    }

    public ArrayList<Pomocna> getLista() {
        return lista;
    }

    public ArrayList<Publikacija> vratiPublikacije() {
        ArrayList<Publikacija> listaPublikacija = new ArrayList<>();
        for (Pomocna pomocna : lista) {
            listaPublikacija.add(pomocna.getPublikacija());
        }
        return listaPublikacija;
    }

    
}
