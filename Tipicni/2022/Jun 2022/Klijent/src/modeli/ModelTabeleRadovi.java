/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Rad;
import domen.RasporedSekcije;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModelTabeleRadovi extends AbstractTableModel {

    ArrayList<RasporedSekcije> lista;
    String[] kolone = {"Rb", "Rad", "Autori", "Status"};
    int rb = 0;

    public ModelTabeleRadovi() {
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
        RasporedSekcije rs = lista.get(rowIndex);
//        String[] kolone = {"Rb", "Rad", "Autori", "Status"};

        switch (columnIndex) {
            case 0:
                return rs.getRb();
            case 1:
                return rs.getRad();
            case 2:
                if (rs.getRad().getAutor2().isEmpty()) {
                    return rs.getRad().getAutor1();
                } else if (rs.getRad().getAutor3().isEmpty()) {
                    return rs.getRad().getAutor1() + ", "
                            + rs.getRad().getAutor2();
                } else if (!rs.getRad().getAutor3().isEmpty()) {
                    return rs.getRad().getAutor1() + ", "
                            + rs.getRad().getAutor2() + ", " + rs.getRad().getAutor3();
                }
            case 3:
                return rs.getStatus();

            default:
                return "return!";
        }
    }

    public ArrayList<RasporedSekcije> getLista() {
        return lista;
    }

    public void dodajRad(RasporedSekcije rs) {
        rb = lista.size();
        rs.setRb(++rb);
        lista.add(rs);
        fireTableDataChanged();
    }

    public void obrisiRad(int row) {
        lista.remove(row);
        
        rb = 0;
        for (RasporedSekcije rasporedSekcije : lista) {
            rasporedSekcije.setRb(++rb);
        }
        
        fireTableDataChanged();
    }

    public boolean postojiRad(Rad rad) {
        for (RasporedSekcije rasporedSekcije : lista) {
            if(rasporedSekcije.getRad().getRadID() == rad.getRadID()){
                return true;
            }
        }
        return false;
    }

}
