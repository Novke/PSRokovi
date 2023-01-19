/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.StavkaIzvestaja;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author USER
 */
public class ModelTabeleServer extends AbstractTableModel{
    
    ArrayList<StavkaIzvestaja> lista;
    String[] kolone = {"Regruter", "Ukupan broj kandidata", "Imena kandidata"};

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
        
        StavkaIzvestaja i = lista.get(rowIndex);
        
        switch(columnIndex){
            case 0: return i.getImePrezimeRegrutera();
            case 1: return i.getUkupanBrojKandidata();
            case 2: return i.getImenaKandidata();
            
            default: return "";
        }
        
    }

    public void dodaj(ArrayList<StavkaIzvestaja> izvestaj) {
        lista = izvestaj;
        fireTableDataChanged();
    }
    
}
