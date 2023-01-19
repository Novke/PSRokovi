/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domain.Poruka;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
           connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/cet","root","");
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public void savePoruke(List<Poruka> list) throws Exception{
        for(Poruka p:list){
            PreparedStatement ps=connection.prepareStatement("Insert into poruka(posiljalac,prijemnik,poruka,datum) values (?,?,?,?)");
            ps.setString(1, p.getPosiljalac());
            ps.setString(2, p.getPrijemnik());
            ps.setString(3, p.getPoruka());
            ps.setDate(4, new java.sql.Date(p.getDatum().getTime()));
            ps.execute();
        }
    }

    public static DBBroker getInstance() {
        if(instance==null)
            instance=new DBBroker();
        return instance;
    }
    
    
}
