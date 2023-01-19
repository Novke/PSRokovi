/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Intervju;
import domen.Kandidat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author USER
 */
public class ModelTabeleKlijent extends AbstractTableModel{

    ArrayList<Intervju> listaIntervjua;
    String[] kolone = {"Kandidat", "Datum", "Broj poena", "Vozacka dozvola", "Prethodno iskustvo"};

    public ModelTabeleKlijent() {
        listaIntervjua = new ArrayList<>();
    }
    
    @Override
    public int getRowCount() {
        return listaIntervjua.size();
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
        if(i == 4)
            return Boolean.class;
        return super.getColumnClass(i); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        Intervju i = listaIntervjua.get(rowIndex);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        
        switch(columnIndex){
            case 0: return i.getKandidat().getImePrezime();
            case 1: return sdf.format(i.getDatum());
            case 2: return i.getBrojPoenaTest();
            case 3: return i.getVozackaDozvola();
            case 4: return i.isPrethodnoIskustvo();
            
            default: return "";
        }
        
    }

    public void dodajIntervju(Intervju i) {
        listaIntervjua.add(i);
        fireTableDataChanged();
    }

    public void obrisiIntervju(int selectedRow) {
        listaIntervjua.remove(selectedRow);
        fireTableDataChanged();
    }

    public ArrayList<Intervju> getListaIntervjua() {
        return listaIntervjua;
    }

    public boolean kandidatVecUTabeli(Kandidat kandidat) {
        for (Intervju intervju : listaIntervjua) {
            if(intervju.getKandidat().equals(kandidat))
                return true;
        }
        return false;
    }

    
    
}
