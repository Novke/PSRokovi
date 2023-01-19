/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Prijava;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class ModelTabeleServer extends AbstractTableModel{
    
    ArrayList<Prijava> lista;
    String[] kolone = {"Ime i prezime", "JMBG", "Drzavljanstvo", "Opstina", 
                       "El. posta", "Mobilni", "Specificna oboljenja"};

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
    public Class<?> getColumnClass(int i) {
        if(i == 6)
            return Boolean.class;
        return super.getColumnClass(i); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Prijava p = lista.get(rowIndex);
        
        switch(columnIndex){
            case 0: return p.getIme() + " " + p.getPrezime();
            case 1: return p.getJMBG();
            case 2: return p.getDrzavljanstvo();
            case 3: return p.getOpstina();
            case 4: return p.getElektronskaPosta();
            case 5: return p.getMobilniTelefon();
            case 6: return p.isSpecificnaOboljenja();
            
            default: return "return!";
        }
    }

    public void popuniTabelu(ArrayList<Prijava> listaBaza) {
        lista = listaBaza;
        fireTableDataChanged();
    }

    public Prijava vratiPrijavu(int selectedRow) {
        return lista.get(selectedRow);
    }

    
    
}
