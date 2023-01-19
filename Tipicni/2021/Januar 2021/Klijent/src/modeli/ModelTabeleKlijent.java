/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Ugovor;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class ModelTabeleKlijent extends AbstractTableModel{
    
    ArrayList<Ugovor> lista;
    String[] kolone = {"Pretplatnik", "Paket", "Vrsta ugovora", "Dodatne usluge",
                        "Datum evidentiranja", "Cena"};

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
    public Class<?> getColumnClass(int i) {
        if(i == 3)
            return Boolean.class;
        return super.getColumnClass(i); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Ugovor u = lista.get(rowIndex);
        
        switch(columnIndex){
            case 0: return u.getPretplatnik();
            case 1: return u.getPaket();
            case 2: return u.getVrstaUgovora();
            case 3: return u.isDodatneUsluge();
            case 4: return u.getDatumEvidentiranja();
            case 5: return u.getCena();
            
            default: return "return!";
        }
    }

    public void dodajUgovor(Ugovor u) {
        lista.add(u);
        fireTableDataChanged();
    }

    public void obrisiUgovor(int selectedRow) {
        lista.remove(selectedRow);
        fireTableDataChanged();
    }

    public boolean postojiPretplatnik(long pretplatnikID) {
        for (Ugovor ugovor : lista) {
            if(ugovor.getPretplatnik().getPretplatnikID() == pretplatnikID)
                return true;
        }
        return false;
    }

    public ArrayList<Ugovor> getLista() {
        return lista;
    }
    
    
    
}
