/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import controller.Controller;
import domain.Poruka;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Rastko
 */
public class TableModelPoruke extends AbstractTableModel implements Runnable{

    private String index[]=new String[] {"Posiljalac", "Poruka","Datum"};
    private List<Poruka> poruke;
    

    public TableModelPoruke() {
        poruke=new LinkedList<>();
    }
    
    
    @Override
    public String getColumnName(int i) {
        return index[i];
    }
  
    
    @Override
    public int getRowCount() {
        return poruke.size();
    }

    @Override
    public int getColumnCount() {
        return index.length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        SimpleDateFormat sdf=new SimpleDateFormat("dd.MM.yyyy hh:mm");
        Poruka poruka=poruke.get(i);
        switch(i1){
            case 0:
                return poruka.getPosiljalac();
            case 1:
                return poruka.getPoruka();
            case 2:
                return sdf.format(poruka.getDatum());
            default:
                return null;
        }
    }

    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()){
            try {
                Thread.sleep(1000);
                poruke=Controller.getInstance().vratiSvePoruke();
                fireTableDataChanged();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    
}
