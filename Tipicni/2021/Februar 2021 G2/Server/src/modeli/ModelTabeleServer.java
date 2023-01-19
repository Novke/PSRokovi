/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.StavkaIzvestaja;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class ModelTabeleServer extends AbstractTableModel{
    
    ArrayList<StavkaIzvestaja> lista;
    String[] kolone = {"Ime i prezime", "JMBG", "Strucna sprema", "Lokacija",
                       "Elektronska posta", "Telefon", "Zdravstveno osiguran"};

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
        StavkaIzvestaja stavkaListe = lista.get(rowIndex);
        
        switch(columnIndex){
            case 0: return stavkaListe.getImePrezime();
            case 1: return stavkaListe.getJMBG();
            case 2: return stavkaListe.getStrucnaSprema();
            case 3: return stavkaListe.getLokacija();
            case 4: return stavkaListe.getElektronskaPosta();
            case 5: return stavkaListe.getTelefon();
            case 6: return stavkaListe.isZdravstvenoOsiguran();
            
            default: return "return!";
        }
    }

    public void dodajIzvestaj(ArrayList<StavkaIzvestaja> listaBaza) {
        lista = listaBaza;
        fireTableDataChanged();
    }

    public int getID(int selectedRow) {
        return lista.get(selectedRow).getPrijavaID();
    }
    
}
