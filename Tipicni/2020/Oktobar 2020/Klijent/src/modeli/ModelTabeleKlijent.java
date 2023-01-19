/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Nastavnik;
import domen.PredajePredmet;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class ModelTabeleKlijent extends AbstractTableModel{
    
    ArrayList<PredajePredmet> lista;
    String[] kolone = {"Predmet", "Nastavnik", "Studijski program", "Semestar"};

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
        PredajePredmet pp = lista.get(rowIndex);
        
        switch(columnIndex){
            case 0: return pp.getPredmet();
            case 1: return pp.getNastavnik();
            case 2: return pp.getStudijskiProgram();
            case 3: return pp.getSemestar();
            
            default: return "return!";
        }
    }

    public void dodajAngazovanje(PredajePredmet pp) {
        lista.add(pp);
        fireTableDataChanged();
    }

    public void obrisiAngazovanje(int selectedRow) {
        lista.remove(selectedRow);
        fireTableDataChanged();
    }

    public boolean nastavnikViseOdPet(PredajePredmet pp) {
        int brojac = 0;
        
        for (PredajePredmet predajePredmet : lista) {
            if(predajePredmet.getNastavnik().getNastavnikID() == pp.getNastavnik().getNastavnikID()){
                if(++brojac == 5) return true;
            }
        }
        return false;
    }

    public boolean nastavnikVecPredaje(PredajePredmet pp) {
        for (PredajePredmet predajePredmet : lista) {
            if(predajePredmet.getNastavnik().getNastavnikID() == pp.getNastavnik().getNastavnikID()){
                if(predajePredmet.getPredmet().getPredmetID() == pp.getPredmet().getPredmetID()) 
                    return true;
            }
        }
        return false;
    }

    public ArrayList<PredajePredmet> getLista() {
        return lista;
    }
    
    
}
