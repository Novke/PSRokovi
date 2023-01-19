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
    String[] kolone = {"TakmicarID", "Ime i prezime", "Takmicenje", "Datum i vreme pocetka",
                    "Datum i vreme zavrsetka", "Vreme takmicara"};

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
        StavkaIzvestaja si = lista.get(rowIndex);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");

        switch(columnIndex){
            case 0: return si.getTakmicarID();
            case 1:
                return si.getImePrezime();
            case 2:
                return si.getTakmicenje();
            case 3:
                return sdf.format(si.getDatumVremePocetka());
            case 4:
                return sdf.format(si.getDatumVremeZavrsetka());
            case 5:
                return si.getVremeTakmicara();
            
            default: return "return!";
        }
    }

    public void dodajIzvestaj(ArrayList<StavkaIzvestaja> listaBaza) {
        lista = listaBaza;
        fireTableDataChanged();
    }

}
