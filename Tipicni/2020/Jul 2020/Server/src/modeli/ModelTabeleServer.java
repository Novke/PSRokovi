/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.StavkaIzvestaja;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author USER
 */
public class ModelTabeleServer extends AbstractTableModel{

    ArrayList<StavkaIzvestaja> lista;
    String[] kolone = {"Meteorolog", "Dan", "Prognoza za regione"};

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
        StavkaIzvestaja pzd = lista.get(rowIndex);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        
        switch(columnIndex){
            case 0: return pzd.getImePrezimeMeteorologa();
            case 1: return sdf.format(pzd.getDan());
            case 2: return pzd.getPrognozaZaRegione();
            
            default: return "Greska";
        }
    }

    public void dodajIzvestaj(ArrayList<StavkaIzvestaja> listaPrognozaZaDan) {
        lista = listaPrognozaZaDan;
        fireTableDataChanged();
    }
    
}
