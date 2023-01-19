/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Let;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class ModelTabeleServer extends AbstractTableModel{
    
    ArrayList<Let> lista;
    String[] kolone = {"LetID", "Pocetni aerodrom", "Krajnji aerodrom", "Datum i vreme pocetka",
                        "Datum i vreme kraja", "Tip aviona", "Redovan let"};

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
    public Class<?> getColumnClass(int i) {
        if(i == 6)
            return Boolean.class;
        return super.getColumnClass(i); //To change body of generated methods, choose Tools | Templates.
    }
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Let l = lista.get(rowIndex);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        
        switch(columnIndex){
            case 0: return l.getLetID();
            case 1: return l.getPocetniAerodrom();
            case 2: return l.getKrajnjiAerodrom();
            case 3: return sdf.format(l.getDatumVremePocetka());
            case 4: return sdf.format(l.getDatumVremeKraja());
            case 5: return l.getTipAviona();
            case 6: return l.isRedovanLet();
            
            default: return "return!";
        }
    }

    public void dodajIzvestaj(ArrayList<Let> listaBaza) {
        lista = listaBaza;
        fireTableDataChanged();
    }

    public Let getLet(int selectedRow) {
        return lista.get(selectedRow);
    }
    
}
