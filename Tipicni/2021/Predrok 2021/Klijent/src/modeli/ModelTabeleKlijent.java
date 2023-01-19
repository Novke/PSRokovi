/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Aerodrom;
import domen.Interkonekcija;
import domen.Let;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.AbstractTableModel;


public class ModelTabeleKlijent extends AbstractTableModel{
    
    ArrayList<Interkonekcija> lista;
    String[] kolone = {"RB", "Aerodrom", "Datum i vreme leta"};

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
        Interkonekcija i = lista.get(rowIndex);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        
        switch(columnIndex){
            case 0: return i.getRb();
            case 1: return i.getAerodrom();
            case 2: return sdf.format(i.getDatumVremeLeta());
            
            default: return "return!";
        }
    }

    public void dodajInterkonekciju(Aerodrom aerodrom, Date datumVremeLeta) {
        
        long rb = 0;
        
        for (Interkonekcija interkonekcija : lista) {
            rb++;
        }
        
        Interkonekcija i = new Interkonekcija(new Let(), ++rb, aerodrom, datumVremeLeta);
        lista.add(i);
        
        fireTableDataChanged();
        
    }

    public void obrisiInterkonekciju(int selectedRow) {
        lista.remove(selectedRow);
        int rb = 0;
        
        for (Interkonekcija interkonekcija : lista) {
            interkonekcija.setRb(++rb);
        }
        
        fireTableDataChanged();
    }

    public ArrayList<Interkonekcija> getLista() {
        return lista;
    }

    public boolean postojiAerodrom(Aerodrom aerodrom) {
        for (Interkonekcija interkonekcija : lista) {
            if(interkonekcija.getAerodrom().getAerodromID()
                    == aerodrom.getAerodromID()){
                return true;
            }
        }
        return false;
    }
    
}
