/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.StavkaProgramskogVodica;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModelTabeleStavke extends AbstractTableModel {

    ArrayList<StavkaProgramskogVodica> lista;
    String[] kolone = {"RB", "Stanica", "Naziv emisije", "Datum i vreme od", "Datum i vreme do",
        "Tip emisije", "Podtip emisije"};
    int rb = 0;

    public ModelTabeleStavke() {
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
        StavkaProgramskogVodica spv = lista.get(rowIndex);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");

        switch (columnIndex) {
            case 0:
                return spv.getRb();
            case 1:
                return spv.getStanica();
            case 2:
                return spv.getNazivEmisije();
            case 3:
                return sdf.format(spv.getDatumVremeOd());
            case 4:
                return sdf.format(spv.getDatumVremeDo());
            case 5:
                return spv.getTipEmisije().getNadtipEmisije();
            case 6:
                return spv.getTipEmisije();

            default:
                return "return!";
        }
    }

    public ArrayList<StavkaProgramskogVodica> getLista() {
        return lista;
    }

    public void dodajStavku(StavkaProgramskogVodica spv) {
        rb = lista.size();
        spv.setRb(++rb);
        lista.add(spv);
        fireTableDataChanged();
    }

    public void obrisiStavku(int row) {
        lista.remove(row);
        
        rb = 0;
        for (StavkaProgramskogVodica stavkaProgramskogVodica : lista) {
            stavkaProgramskogVodica.setRb(++rb);
        }
        
        fireTableDataChanged();
    }

    public boolean postojiNazivEmisije(String nazivEmisije) {
        for (StavkaProgramskogVodica stavkaProgramskogVodica : lista) {
            if(stavkaProgramskogVodica.getNazivEmisije().equals(nazivEmisije)){
                return true;
            }
        }
        return false;
    }

}
