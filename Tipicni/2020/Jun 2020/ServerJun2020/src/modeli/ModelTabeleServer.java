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
    String[] kolone = {"Kompanija", "Tip", "Ime i prezime", "Ziro-racun", "Banka", "Iznos"};

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
        StavkaIzvestaja p = lista.get(rowIndex);
        
        switch(columnIndex){
            case 0: return p.getKompanija();
            case 1: return p.getTip();
            case 2: return p.getImePrezime();
            case 3: return p.getZiroRacun();
            case 4: return p.getBanka();
            case 5: return p.getIznos();
            
            default: return "";
        }
    }

    public void dodajIzvestaj(ArrayList<StavkaIzvestaja> listaBaza) {
        lista = listaBaza;
        fireTableDataChanged();
    }
    
}
