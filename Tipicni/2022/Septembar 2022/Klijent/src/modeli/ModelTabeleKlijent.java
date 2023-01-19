/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Komponenta;
import domen.StavkaPrevoznogSredstva;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModelTabeleKlijent extends AbstractTableModel {

    ArrayList<StavkaPrevoznogSredstva> lista;
    String[] kolone = {"RB", "Ugradjena komponenta", "Kolicina", "Kontrolisano"};
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
    public String getColumnName(int columnIndex) {
        return kolone[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 3) {
            return Boolean.class;
        }
        return super.getColumnClass(columnIndex); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkaPrevoznogSredstva sps = lista.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return sps.getRb();
            case 1:
                return sps.getKomponenta();
            case 2:
                return sps.getKolicina();
            case 3:
                return sps.isKontrolisano();

            default:
                return "return!";
        }
    }

    public ArrayList<StavkaPrevoznogSredstva> getLista() {
        return lista;
    }

    public void dodajKomponentu(StavkaPrevoznogSredstva sps) {
        rb = lista.size();
        sps.setRb(++rb);
        lista.add(sps);
        fireTableDataChanged();
    }

    public void obrisiStavku(int row) {
        lista.remove(row);

        rb = 0;
        for (StavkaPrevoznogSredstva stavkaPrevoznogSredstva : lista) {
            stavkaPrevoznogSredstva.setRb(++rb);
        }

        fireTableDataChanged();
    }

}
