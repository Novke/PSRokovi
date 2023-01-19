/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Prijava;
import domen.PrijavaVolontiranje;
import forme.KlijentskaForma;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;


public class ModelTabeleKlijent extends AbstractTableModel{
    
    ArrayList<PrijavaVolontiranje> lista;
    String[] kolone = {"RB", "Vrsta volontiranja"};

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
        PrijavaVolontiranje stavkaListe = lista.get(rowIndex);
        
        switch(columnIndex){
            case 0: return stavkaListe.getRb();
            case 1: return stavkaListe.getVrstaVolontiranja();
            
            default: return "return!";
        }
    }

    public boolean dodajVrstu(String vrstaVolontiranja) {
        
        for (PrijavaVolontiranje prijavaVolontiranje : lista) {
            if(prijavaVolontiranje.getVrstaVolontiranja().equals(vrstaVolontiranja))
                return false;
        }
        
        int rb = 0;
        for (PrijavaVolontiranje prijavaVolontiranje : lista) {
            rb++;
        }
        
        PrijavaVolontiranje pv = new PrijavaVolontiranje(new Prijava(), ++rb, vrstaVolontiranja);
        lista.add(pv);
        
        fireTableDataChanged();
        
        return true;
    }

    public void obrisiRed(int selectedRow) {
        
        lista.remove(selectedRow);
        
        int rb = 0;
        for (PrijavaVolontiranje prijavaVolontiranje : lista) {
            prijavaVolontiranje.setRb(++rb);
        }
        
        fireTableDataChanged();
        
    }

    public ArrayList<PrijavaVolontiranje> getLista() {
        return lista;
    }
    
    
    
}
