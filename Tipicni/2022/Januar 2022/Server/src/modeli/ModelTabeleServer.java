/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.StavkaIzvestaja;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class ModelTabeleServer extends AbstractTableModel{
    
    ArrayList<StavkaIzvestaja> lista;
    String[] kolone = {"Igra", "PC", "Playstation", "XBOX", "Steam"};

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
        StavkaIzvestaja si = lista.get(rowIndex);
        
        switch(columnIndex){
            case 0: 
                return si.getIgra();
            case 1: 
                return si.getPC();
            case 2:
                return si.getPlaystation();
            case 3:
                return si.getXBOX();
            case 4:
                return si.getSteam();
            
            default: return "return!";
        }
    }

    public void dodajIzvestaj(ArrayList<StavkaIzvestaja> listaBaza) {
        lista = listaBaza;
        fireTableDataChanged();
    }

}
