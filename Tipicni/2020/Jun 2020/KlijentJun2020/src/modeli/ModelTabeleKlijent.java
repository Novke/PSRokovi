/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Zaposleni;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author USER
 */
public class ModelTabeleKlijent extends AbstractTableModel{

    ArrayList<Zaposleni> lista;
    String[] kolone = {"Ime", "Prezime", "JMBG", "Banka", "Ziro-racun"};
    
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
        Zaposleni z = lista.get(rowIndex);
        
        switch(columnIndex){
            case 0: return z.getIme();
            case 1: return z.getPrezime();
            case 2: return z.getJmbg();
            case 3: return z.getBanka().getNaziv();
            case 4: return z.getZiroRacun();
            
            default: return "";
        }
    }

    public ArrayList<Zaposleni> getLista() {
        return lista;
    }

    public void dodajZaposlenog(Zaposleni z) {
        lista.add(z);
        fireTableDataChanged();
    }

    public void obrisiZaposlenog(int selectedRow) {
        lista.remove(selectedRow);
        fireTableDataChanged();
    }
    
}
