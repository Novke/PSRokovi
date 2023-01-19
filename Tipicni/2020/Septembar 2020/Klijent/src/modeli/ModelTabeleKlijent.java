/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Zahtev;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author USER
 */
public class ModelTabeleKlijent extends AbstractTableModel {

    ArrayList<Zahtev> lista;
    String[] kolone = {"Datum i vreme test.", "Hitno", "Tip", "Rezultat",
        "Napomena", "Status", "Osigurano lice", "Laboratorija", "Laborant"};

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
    public Class<?> getColumnClass(int i) {
        if(i == 1)
            return Boolean.class;
        return super.getColumnClass(i); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Zahtev z = lista.get(rowIndex);
        // HH veliko jer uzima evropsko vreme!
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");

        switch (columnIndex) {
            case 0:
                return sdf.format(z.getDatumVremeTestiranja());
            case 1:
                return z.isHitno();
            case 2:
                return z.getTip();
            case 3:
                return z.getRezultat();
            case 4:
                return z.getNapomena();
            case 5:
                return z.getStatus();
            case 6:
                return z.getOsiguranoLice();
            case 7:
                return z.getLaboratorija();
            case 8:
                return z.getLaborant();

            default:
                return "return!";
        }
    }

    public void dodajZahteve(ArrayList<Zahtev> neobradjeni) {
        lista = neobradjeni;
        fireTableDataChanged();
    }

    public Zahtev vratiZahtev(int selectedRow) {
        return lista.get(selectedRow);
    }

    public void izmeniZahtev(Zahtev z, int selectedRow) {
        lista.set(selectedRow, z);
        fireTableDataChanged();
    }

    public ArrayList<Zahtev> vratiObradjene() {

        ArrayList<Zahtev> obradjeniZahtevi = new ArrayList<>();

        for (Zahtev zahtev : lista) {
            if (zahtev.getStatus().equals("Obradjen")) {
                obradjeniZahtevi.add(zahtev);
            }
        }
        
        return obradjeniZahtevi;

    }

}
