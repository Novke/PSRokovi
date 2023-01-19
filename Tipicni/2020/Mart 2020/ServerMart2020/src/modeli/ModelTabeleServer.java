/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Izvestaj;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author USER
 */
public class ModelTabeleServer extends AbstractTableModel{

    ArrayList<Izvestaj> lista;
    String[] kolone = {"Publikacija", "RB", "Naslov", "Tekst"};

    public ModelTabeleServer() {
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
        Izvestaj p = lista.get(rowIndex);
        
        switch(columnIndex){
            case 0: return p.getPublikacija();
            case 1: return p.getRb();
            case 2: return p.getNaslov();
            case 3: return p.getTekst();
            
            default: return "";
        }
    }

    
    public void dodaj(ArrayList<Izvestaj> l) {
        lista = l;
        fireTableDataChanged();
    }


    
}
