/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.DnevnaProizvodnjaStavkaIzvestaja;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModelTabeleKlijent extends AbstractTableModel {

    ArrayList<DnevnaProizvodnjaStavkaIzvestaja> lista;
    String[] kolone = {"Rb", "Vrsta kapaciteta", "Kolicina", "Jedinica mere", "Napomena"};
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
        DnevnaProizvodnjaStavkaIzvestaja si = lista.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return si.getRb();
            case 1:
                return si.getVrstaKapaciteta();
            case 2:
                return si.getKolicina();
            case 3:
                return si.getJedinicaMere();
            case 4:
                return si.getNapomena();

            default:
                return "return!";
        }
    }

    public ArrayList<DnevnaProizvodnjaStavkaIzvestaja> getLista() {
        return lista;
    }

    public void dodajStavku(DnevnaProizvodnjaStavkaIzvestaja si) {
        rb = lista.size();
        si.setRb(++rb);
        lista.add(si);
        fireTableDataChanged();
    }

    public void obrisiStavku(int row) {
        lista.remove(row);
        
        rb = 0;
        for (DnevnaProizvodnjaStavkaIzvestaja si : lista) {
            si.setRb(++rb);
        }
        
        fireTableDataChanged();
    }

    public boolean postojiVrsta(DnevnaProizvodnjaStavkaIzvestaja si) {
        for (DnevnaProizvodnjaStavkaIzvestaja stavka : lista) {
            if(stavka.getVrstaKapaciteta().equals(si.getVrstaKapaciteta())){
                return true;
            }
        }
        return false;
    }

}
