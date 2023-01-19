/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domain.Kviz;
import domain.Pitanje;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Rastko
 */
public class DBBroker {
    private Connection connection;
    private static DBBroker instance;

    public DBBroker() {
        
        try{
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/prosoftjan19","root","");
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public static DBBroker getInstance() {
        if(instance==null)
            instance=new DBBroker();
        return instance;
    }
    
    public List<Kviz> getAllKvizovi(){
        try{
            List<Kviz> lista=new LinkedList<>();
            String query="Select * from kviz inner join pitanje on kviz.kvizID=pitanje.kvizID";
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(query);
            while(rs.next()){
                int kvizID=rs.getInt("KvizID");
                String naziv=rs.getString("Naziv");
                String pobednik=rs.getString("Pobednik");
                
                int pitanjeID=rs.getInt("PitanjeID");
                String pitanje=rs.getString("Pitanje");
                String tacanOdgovor=rs.getString("TacanOdgovor");
                int brojPoena=rs.getInt("BrojPoena");
                Pitanje pit=new Pitanje(pitanjeID, pitanje, tacanOdgovor, brojPoena);
                List<Pitanje> listaPitanja=new LinkedList<>();
                listaPitanja.add(pit);
                
                Kviz kviz=new Kviz(kvizID, naziv, null, null, pobednik, listaPitanja);
                
                if(lista.contains(kviz)){
                    lista.get(lista.indexOf(kviz)).getPitanja().add(pit);
                }else
                    lista.add(kviz);
            }
            rs.close();
            return lista;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    public void updateKvizDatumPocetka(Kviz kviz){
        try{
            PreparedStatement ps=connection.prepareStatement("Update kviz set DatumVremePocetka=(?) where KvizID=(?) ");
            ps.setDate(1, new java.sql.Date(kviz.getDatumVremePocetka().getTime()));
            ps.setInt(2, kviz.getKvizId());
            ps.execute();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public void updateKvizDatumKrajaIPobednik(Kviz kviz){
        try{
            PreparedStatement ps=connection.prepareStatement("Update kviz set DatumVremeKraja=(?), Pobednik=(?) where KvizID=(?)");
            ps.setDate(1, new java.sql.Date(kviz.getDatumVremeKraja().getTime()));
            ps.setString(2, kviz.getPobednik());
            ps.setInt(3, kviz.getKvizId());
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
