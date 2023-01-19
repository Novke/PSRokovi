/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import domain.Pitanje;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Rastko
 */
public class TableModel extends AbstractTableModel{

    private List<Pitanje> tacniOdgovoriServer;
    private List<Pitanje> netacniOdgovoriServer;
    private List<Pitanje> tacniOdgovoriTim;
    private List<Pitanje> netacniOdgovoriTim;
    private String []index =new String [] {"Igrac","Broj tacnih odgovora","Broj netacnih odgovora","Ukupno poena"};

    public TableModel() {
        tacniOdgovoriServer=new LinkedList<>();
        netacniOdgovoriServer= new LinkedList<>();
        tacniOdgovoriTim=new LinkedList<>();
        netacniOdgovoriTim=new LinkedList<>();
    }
    
    public void addTacanOdgovorServer(Pitanje pitanje){
        tacniOdgovoriServer.add(pitanje);
        fireTableDataChanged();
    }
    
    public void addNetacanOdgovorServer(Pitanje pitanje){
        netacniOdgovoriServer.add(pitanje);
        fireTableDataChanged();
    }
    public void addTacanOdgovorTim(Pitanje pitanje){
        tacniOdgovoriTim.add(pitanje);
        fireTableDataChanged();
    }
    public void addNetacanOdgovorTim(Pitanje pitanje){
        netacniOdgovoriTim.add(pitanje);
        fireTableDataChanged();
    }
    
    @Override
    public String getColumnName(int i) {
        return index[i];
    }

    
    @Override
    public int getRowCount() {
        return 2;
    }

    @Override
    public int getColumnCount() {
        return index.length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        if(i ==0){
            switch(i1){
                case 0: return "Tim";
                case 1: return tacniOdgovoriTim.size();
                case 2: return  netacniOdgovoriTim.size();
                case 3: double brBodova=0;
                for(Pitanje p: tacniOdgovoriTim)
                    brBodova+=p.getBrojPoena();
                for(Pitanje p: netacniOdgovoriTim)
                    brBodova-= p.getBrojPoena()*0.2;
                return brBodova;
                default : return null;
            }
        }else{
            switch(i1){
                case 0: return "Server";
                case 1: return tacniOdgovoriServer.size();
                case 2: return netacniOdgovoriServer.size();
                case 3: double brBodova=0;
                for(Pitanje p: tacniOdgovoriServer)
                    brBodova+=p.getBrojPoena();
                for(Pitanje p: netacniOdgovoriServer)
                    brBodova-= p.getBrojPoena()*0.2;
                return brBodova;
                default : return null;
            }
        }
    }
    
}
