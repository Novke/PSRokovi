/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Dostupnost;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModelTabeleKlijent extends AbstractTableModel {

    ArrayList<Dostupnost> lista;
    String[] kolone = {"Rb", "Platforma", "Datum objave", "Status"};
    int rb = 0;

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
        Dostupnost d = lista.get(rowIndex);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

        switch (columnIndex) {
            case 0:
                return d.getRb();
            case 1:
                return d.getPlatforma();
            case 2:
                return sdf.format(d.getDatumObjave());
            case 3:
                return d.getStatus();

            default:
                return "return!";
        }
    }

    public ArrayList<Dostupnost> getLista() {
        return lista;
    }

    public void dodajDostupnost(Dostupnost d) {
        d.setRb(++rb);
        lista.add(d);
        fireTableDataChanged();
    }

    public void obrisiDostupnost(int row) {
        lista.remove(row);
        fireTableDataChanged();
    }

    public boolean postojiDostupnostNaPlatformi(Dostupnost d) {
        for (Dostupnost dostupnost : lista) {
            if(dostupnost.getPlatforma().equals(d.getPlatforma())){
                return true;
            }
        }
        return false;
    }

}
