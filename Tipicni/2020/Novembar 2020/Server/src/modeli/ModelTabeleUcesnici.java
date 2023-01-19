/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.UcesnikZaDogadjaj;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author USER
 */
public class ModelTabeleUcesnici extends AbstractTableModel{
    
    ArrayList<UcesnikZaDogadjaj> lista; 
    String[] kolone = {"RB", "Ucesnik", "Opis ucesca", "Obavezno prisustvo"};

    public ModelTabeleUcesnici() {
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
    public Class<?> getColumnClass(int i) {
        if(i == 3)
            return Boolean.class;
        return super.getColumnClass(i); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        UcesnikZaDogadjaj up = lista.get(rowIndex);
        
        switch(columnIndex){
            case 0: return up.getRb();
            case 1: return up.getImePrezimeKorisnika();
            case 2: return up.getOpisUcesca();
            case 3: return up.isObaveznoPrisustvo();
            
            default: return "";
        }
        
    }

    public void dodajUcesnike(ArrayList<UcesnikZaDogadjaj> listaUcesnika) {
        lista = listaUcesnika;
        fireTableDataChanged();
    }
    
    
    
}
