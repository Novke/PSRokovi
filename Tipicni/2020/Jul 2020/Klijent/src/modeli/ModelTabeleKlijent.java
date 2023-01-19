/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.PrognozaRegion;
import domen.Region;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author USER
 */
public class ModelTabeleKlijent extends AbstractTableModel{
    
    ArrayList<PrognozaRegion> listaPrognozaZaRegion;
    String[] kolone = {"Temperatura", "Region", "Meteo alarm", "Pojava"};

    public ModelTabeleKlijent() {
        listaPrognozaZaRegion = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return listaPrognozaZaRegion.size();
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

        PrognozaRegion pr = listaPrognozaZaRegion.get(rowIndex);
        
        switch(columnIndex){
            case 0: return pr.getTemperatura();
            case 1: return pr.getRegion().getNaziv();
            case 2: return pr.getMeteoAlarm();
            case 3: return pr.getPojava();
            
            default: return "greska";
        }
        
    }

    public void dodajPrognozuZaRegion(PrognozaRegion pr) {
        listaPrognozaZaRegion.add(pr);
        fireTableDataChanged();
    }

    public void obrisi(int selectedRow) {
        listaPrognozaZaRegion.remove(selectedRow);
        fireTableDataChanged();
    }

    public ArrayList<PrognozaRegion> getListaPrognozaZaRegion() {
        return listaPrognozaZaRegion;
    }

    public boolean unetaPrognozaZaRegion(Region region) {
        for (PrognozaRegion prognozaRegion : listaPrognozaZaRegion) {
            if(prognozaRegion.getRegion().equals(region))
                return true;
        }
        return false;
    }
    
    
    
    
}
