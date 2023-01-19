/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Festival;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModelTabeleKlijent extends AbstractTableModel {

    ArrayList<Festival> lista;
    String[] kolone = {"Naziv", "Datum od", "Datum do", "Opis"};

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
        Festival f = lista.get(rowIndex);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

        switch (columnIndex) {
            case 0:
                return f.getNaziv();
            case 1:
                return sdf.format(f.getDatumOd());
            case 2:
                return sdf.format(f.getDatumDo());
            case 3:
                return f.getOpis();

            default:
                return "return!";
        }
    }

    public ArrayList<Festival> getLista() {
        return lista;
    }

    public void dodajFestivale(ArrayList<Festival> festivali) {
        lista = festivali;
        fireTableDataChanged();
    }

    public Festival vratiIzabraniFestival(int row) {
        return lista.get(row);
    }

}
