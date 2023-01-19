/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Angazovanje;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class ModelTabeleKlijent extends AbstractTableModel{
    
    ArrayList<Angazovanje> lista;
    String[] kolone = {"Vrsta angazovanja", "Opis posla", "Broj sati", "Radnik"};
    
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
        Angazovanje a = lista.get(rowIndex);
        
        switch(columnIndex){
            case 0: return a.getVrstaAngazovanja();
            case 1: return a.getOpisPosla();
            case 2: return a.getBrojSati();
            case 3: return a.getRadnik();
            
            default: return "return!";
        }
    }

    public ArrayList<Angazovanje> getLista() {
        return lista;
    }

    public void dodajAngazovanje(Angazovanje a) {
        lista.add(a);
        fireTableDataChanged();
    }

    public void obrisiAngazovanje(int row) {
        lista.remove(row);
        fireTableDataChanged();
    }
    
}
