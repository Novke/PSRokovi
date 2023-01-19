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
    String[] kolone = {"Stanica", "Tip emisije", "Broj emisija", "Ukupno trajanje"};

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

        switch (columnIndex) {
            case 0:
                return si.getStanica();
            case 1:
                return si.getTipEmisije();
            case 2:
                return si.getBrojEmisija();
            case 3:
                // uradio sam ovako jer ne znam funkiju u SQLYogu koja
                // vraca onaj format koji su trazili u zadatku
                // u SQL Developeru to moze preko to_char funkcije
                // ali ovde toga nema
                return si.getUkupnoTrajanje() + " sati";
            
            default:
                return "return!";
        }
    }

    public void dodajIzvestaj(ArrayList<StavkaIzvestaja> listaBaza) {
        lista = listaBaza;
        fireTableDataChanged();
    }

}
