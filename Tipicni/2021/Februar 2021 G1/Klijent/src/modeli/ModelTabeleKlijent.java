/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Prijava;
import domen.StavkaPrijave;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class ModelTabeleKlijent extends AbstractTableModel{
    
    ArrayList<StavkaPrijave> lista;
    String[] kolone = {"RB", "Tip vakcine"};

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
        StavkaPrijave sp = lista.get(rowIndex);
        
        switch(columnIndex){
            case 0: return sp.getRedniBroj();
            case 1: return sp.getTipVakcine();
            
            default: return "return!";
        }
    }

    public void dodajTipVakcine(String tipVakcine) {
        
        int rb = 0;
        
        for (StavkaPrijave stavkaPrijave : lista) {
            rb++;
        }
        
        StavkaPrijave sp = new StavkaPrijave(new Prijava(), ++rb, tipVakcine);
        lista.add(sp);
        
        fireTableDataChanged();
        
    }

    public void obrisiStavku(int selectedRow) {
        lista.remove(selectedRow);
        
        int rb = 0;
        for (StavkaPrijave stavkaPrijave : lista) {
            stavkaPrijave.setRedniBroj(++rb);
        }
        
        fireTableDataChanged();
    }

    public ArrayList<StavkaPrijave> getLista() {
        return lista;
    }

    public boolean postojiTipVakcine(String tipVakcine) {
        for (StavkaPrijave stavkaPrijave : lista) {
            if(stavkaPrijave.getTipVakcine().equals(tipVakcine))
                return true;
        }
        return false;
    }
    
}
