/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Korisnik;
import domen.Ucesce;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author USER
 */
public class ModelTabeleKlijent extends AbstractTableModel{
    
    ArrayList<Ucesce> listaUcesca; 
    String[] kolone = {"RB", "Ucesnik", "Opis ucesca", "Obavezno prisustvo"};
    int rb = 0;

    public ModelTabeleKlijent() {
        listaUcesca = new ArrayList<>();
    }
    
    @Override
    public int getRowCount() {
        return listaUcesca.size();
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
        
        Ucesce u = listaUcesca.get(rowIndex);
        
        switch(columnIndex){
            case 0: return u.getRb();
            case 1: return u.getKorisnik();
            case 2: return u.getOpisUcesca();
            case 3: return u.isObaveznoPrisustvo();
            
            default: return "";
        }
        
    }

    public void dodajUcesce(Ucesce u) {
        
        u.setRb(++rb);
        listaUcesca.add(u);
        fireTableDataChanged();
        
    }

    public void obrisi(int selectedRow) {
        listaUcesca.remove(selectedRow);
        
        rb = 0;
        for (Ucesce ucesce : listaUcesca) {
            ucesce.setRb(++rb);
        }
        
        fireTableDataChanged();
    }

    public ArrayList<Ucesce> getListaUcesca() {
        return listaUcesca;
    }

    public void dodajOrganizatora(Korisnik korisnik) {
        
        Ucesce u = new Ucesce(null, ++rb, "Organizator", true, korisnik);
        
        listaUcesca.add(u);
        fireTableDataChanged();
        
    }
    
}
