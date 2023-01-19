/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.StavkaIzvestaja;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModelTabeleServer extends AbstractTableModel {

    ArrayList<StavkaIzvestaja> lista;
    String[] kolone = {"Pogon", "Vrsta", "Broj proizvedenih jedinica", "Ukupno trajanje proizvodnje"};

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
    public String getColumnName(int columnIndex) {
        return kolone[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkaIzvestaja si = lista.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return si.getPogon();
            case 1:
                return si.getVrsta();
            case 2:
                return si.getBrojProizvedenihJedinica();
            case 3:
                return si.getUkupnoTrajanjeProizvodnje();

            default:
                return "return!";
        }
    }

    public void dodajIzvestaj(ArrayList<StavkaIzvestaja> listaBaza) {
        lista = listaBaza;
        fireTableDataChanged();
    }

}
