/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.PoreskiObveznik;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class ModelTabeleServer extends AbstractTableModel{
    
    ArrayList<PoreskiObveznik> lista;
    String[] kolone = {"PoreskiObveznikID", "Ime", "Prezime", "JMBG", "Telefon"};

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
        PoreskiObveznik po = lista.get(rowIndex);
        
        switch(columnIndex){
            case 0: return po.getPoreskiObveznikID();
            case 1: return po.getIme();
            case 2: return po.getPrezime();
            case 3: return po.getJMBG();
            case 4: return po.getTelefon();
            
            default: return "return!";
        }
    }

    public void dodajListu(ArrayList<PoreskiObveznik> listaBaza) {
        lista = listaBaza;
        fireTableDataChanged();
    }

    public PoreskiObveznik vratiIzabranogObveznika(int selectedRow) {
        return lista.get(selectedRow);
    }
    
}
