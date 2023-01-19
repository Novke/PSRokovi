/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Ucesce;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModelTabeleKlijent extends AbstractTableModel {

    ArrayList<Ucesce> lista;
    String[] kolone = {"Takmicenje", "Takmicar", "Vrsta trke", "Datum i vreme pocetka", "Datum i vreme zavrsetka"};

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
        Ucesce u = lista.get(rowIndex);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");

        switch (columnIndex) {
            case 0:
                return u.getTakmicenje();
            case 1:
                return u.getTakmicar();
            case 2:
                return u.getVrstaTrke();
            case 3:
                return sdf.format(u.getDatumVremePocetka());
            case 4:
                return sdf.format(u.getDatumVremeZavrsetka());

            default:
                return "return!";
        }
    }

    public ArrayList<Ucesce> getLista() {
        return lista;
    }

    public void dodajUcesce(Ucesce u) {
        lista.add(u);
        fireTableDataChanged();
    }

    public void obrisiUcesce(int row) {
        lista.remove(row);
        fireTableDataChanged();
    }

}
