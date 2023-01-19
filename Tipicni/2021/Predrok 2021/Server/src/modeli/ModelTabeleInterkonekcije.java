/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Interkonekcija;
import domen.Let;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class ModelTabeleInterkonekcije extends AbstractTableModel{
    
    ArrayList<Interkonekcija> lista;
    String[] kolone = {"Redni broj", "Aerodrom", "Datum i vreme leta"};

    public ModelTabeleInterkonekcije() {
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
        Interkonekcija i = lista.get(rowIndex);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        
        switch(columnIndex){
            case 0: return i.getRb();
            case 1: return i.getAerodrom();
            case 2: return sdf.format(i.getDatumVremeLeta());
            
            default: return "return!";
        }
    }

    public void dodajInterkonekcije(ArrayList<Interkonekcija> interkonekcije) {
        lista = interkonekcije;
        fireTableDataChanged();
    }

    
    
}
