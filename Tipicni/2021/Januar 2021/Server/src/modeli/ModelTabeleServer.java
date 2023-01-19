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


public class ModelTabeleServer extends AbstractTableModel{
    
    ArrayList<StavkaIzvestaja> lista;
    String[] kolone = {"Pretplatnik", "Paket", "Vrsta ugovora", "Dodatne usluge",
                       "Datum evidentiranja", "Cena"};

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
        if(i == 3)
            return Boolean.class;
        return super.getColumnClass(i); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkaIzvestaja si = lista.get(rowIndex);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        
        switch(columnIndex){
            case 0: return si.getPretplatnik();
            case 1: return si.getPaket();
            case 2: return si.getVrstaUgovora();
            case 3: return si.isDodatnaUsluga();
            case 4: return sdf.format(si.getDatumEvidentiranja());
            case 5: return si.getCena();
            
            default: return "return!";
        }
    }

    public void dodajIzvestaj(ArrayList<StavkaIzvestaja> listaBaza) {
        lista = listaBaza;
        fireTableDataChanged();
    }

    public long idUgovoraZaPonistavanje(int selectedRow) {
        return lista.get(selectedRow).getUgovorID();
    }

    public long vratiUgovorID(int row) {
        return lista.get(row).getUgovorID();
    }
    
}
