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
    String[] kolone = {"Tip testa", "Ukupno pozitivnih", "Ukupno negativnih"};

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
            case 0: return i.getTipTesta();
            case 1: return i.getUkupnoPozitivnih();
            case 2: return i.getUkupnoNegativnih();
        
            default: return "Greska!";
        }
    }

    public void dodajIzvestaj(ArrayList<StavkaIzvestaja> listaBaza) {
        lista = listaBaza;
        fireTableDataChanged();
    }
    
}
