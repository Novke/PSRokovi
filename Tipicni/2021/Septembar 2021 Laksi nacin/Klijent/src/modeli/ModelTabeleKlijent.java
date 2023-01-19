/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Intervencija;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class ModelTabeleKlijent extends AbstractTableModel{
    
    ArrayList<Intervencija> lista;
    String[] kolone = {"Stambena zajednica", "Vrsta intervencije", "Datum i vreme pocetka",
                        "Datum i vreme zavrsetka", "Opis", "Cena", "Angaz. izvodjaca radova", "Status"};
    
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
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex == 6)
            return Boolean.class;
        return super.getColumnClass(columnIndex); //To change body of generated methods, choose Tools | Templates.
    }

    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Intervencija i = lista.get(rowIndex);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        
        switch(columnIndex){
            case 0: return i.getStambenaZajednica();
            case 1: return i.getVrstaIntervencije();
            case 2: return sdf.format(i.getDatumVremePocetka());
            case 3: if(i.getDatumVremeZavrsetka() == null)
                            return "";
                    return sdf.format(i.getDatumVremeZavrsetka());
            case 4: return i.getOpis();
            case 5: return i.getCena();
            case 6: return i.isAngazovanjeIzvodjacaRadova();
            case 7: return i.getStatus();
            
            default: return "return!";
        }
    }

    public ArrayList<Intervencija> getLista() {
        return lista;
    }

    public void dodajIntervencije(ArrayList<Intervencija> intervencije) {
        lista = intervencije;
        fireTableDataChanged();
    }

    public void dodajIntervenciju(Intervencija i) {
        lista.add(i);
        fireTableDataChanged();
    }

    public Intervencija vratiIzabranuIntervenciju(int row) {
        return lista.get(row);
    }

    public void izmeniIntervenciju(int selectedRow, Intervencija i) {
        lista.set(selectedRow, i);
        fireTableDataChanged();
    }

    public void obrisiIntervenciju(int row) {
        lista.remove(row);
        fireTableDataChanged();
    }
    
}
