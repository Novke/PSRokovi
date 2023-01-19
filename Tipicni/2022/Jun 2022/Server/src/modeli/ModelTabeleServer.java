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

public class ModelTabeleServer extends AbstractTableModel {

    ArrayList<StavkaIzvestaja> lista;
    String[] kolone = {"Kategorija", "Potkategorija", "Naziv", "Datum",
        "Ukupno radova", "Prezentovanih radova"};

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
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        
        switch (columnIndex) {
            case 0:
                return si.getKategorija();
            case 1:
                return si.getPotkategorija();
            case 2:
                return si.getNazivSekcije();
            case 3:
                return sdf.format(si.getDatum());
            case 4:
                return si.getUkupnoRadova();
            case 5:
                return si.getPrezentovanoRadova();

            default:
                return "return!";
        }
    }

    public void dodajIzvestaj(ArrayList<StavkaIzvestaja> listaBaza) {
        lista = listaBaza;
        fireTableDataChanged();
    }

}
