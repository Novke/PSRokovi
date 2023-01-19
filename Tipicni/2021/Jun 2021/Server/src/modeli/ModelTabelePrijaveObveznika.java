/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.PoreskaPrijava;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class ModelTabelePrijaveObveznika extends AbstractTableModel{
    
    ArrayList<PoreskaPrijava> lista;
    String[] kolone = {"PoreskaPrijavaID","Adresa", "Mesto nepokretnosti", "Mesto prebivalista", "Broj lista", 
                        "Godina izgradnje", "Datum pocetka koriscenja", "Povrsina", 
                        "Datum podnosenja prijave", "Vrsta nepokretnosti"};

    public ModelTabelePrijaveObveznika() {
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
    public Class<?> getColumnClass(int i) {
        if(i == 3)
            return Boolean.class;
        return super.getColumnClass(i); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PoreskaPrijava pp = lista.get(rowIndex);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        
        switch(columnIndex){
            case 0: return pp.getPoreskaPrijavaID();
            case 1: return pp.getAdresa();
            case 2: return pp.getMestoNepokretnosti();
            case 3: return pp.isMestoPrebivalista();
            case 4: return pp.getBrojListaNepokretnosti();
            case 5: return pp.getGodinaIzgradnje();
            case 6: return sdf.format(pp.getDatumPocetkaKoriscenja());
            case 7: return pp.getPovrsina();
            case 8: return sdf.format(pp.getDatumPodnosenjaPrijave());
            case 9: return pp.getVrstaNepokretnosti();
            
            default: return "return!";
        }
    }

    public void popuniTabelu(ArrayList<PoreskaPrijava> prijave) {
        lista = prijave;
        fireTableDataChanged();
    }
    
}
