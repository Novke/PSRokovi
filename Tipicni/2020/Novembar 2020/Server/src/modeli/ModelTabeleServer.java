/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.StavkaIzvestaja;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author USER
 */
public class ModelTabeleServer extends AbstractTableModel{
    
    ArrayList<StavkaIzvestaja> lista;
    String[] kolone = {"DogadjajID", "Organizator", "Naziv", "Datum vreme od", "Datum vreme do"};

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
        
        StavkaIzvestaja i = lista.get(rowIndex);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        
        switch(columnIndex){
            case 0: return i.getDogadjajID();
            case 1: return i.getImePrezimeOrganizatora();
            case 2: return i.getNaziv();
            case 3: return sdf.format(i.getDatumVremeOd().getTime());
            case 4: return sdf.format(i.getDatumVremeDo().getTime());
            
            default: return "";
        }
        
    }

    public void dodajIzvestaj(ArrayList<StavkaIzvestaja> listaBaza) {
        lista = listaBaza;
        fireTableDataChanged();
    }

    public int getDogadjajID(int selectedRow) {
        return lista.get(selectedRow).getDogadjajID();
    }
    
}
