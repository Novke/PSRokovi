/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Operation;
import domain.Poruka;
import domain.Request;
import domain.Response;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import javax.net.ssl.SSLSocket;

/**
 *
 * @author Rastko
 */
public class Controller {
    private Socket socket;
    private static Controller instance;

    public Controller() {
        try{
            socket=new Socket("localhost",10000);
        }catch(Exception ex){
            ex.printStackTrace();
            
        }
    }

    public static Controller getInstance() {
        if(instance==null)
            instance=new Controller();
        return instance;
    }
    
    public synchronized void login(String ime) throws Exception{
        ObjectOutputStream out=new ObjectOutputStream(socket.getOutputStream());
        Request request=new Request(ime, Operation.LOGIN);
        out.writeObject(request);
        ObjectInputStream in=new ObjectInputStream(socket.getInputStream());
        Response response=(Response) in.readObject();
        if(response.getData()!=null)
            throw (Exception)response.getData();
    }
    
    public synchronized void posaljiPoruku(Poruka poruka)throws Exception{
        ObjectOutputStream out=new ObjectOutputStream(socket.getOutputStream());
        Request request=new Request(poruka, Operation.SEND);
        out.writeObject(request);
        ObjectInputStream in=new ObjectInputStream(socket.getInputStream());
        Response response=(Response) in.readObject();
        if(response.getData()!=null)
            throw (Exception)response.getData();
    }
    public synchronized List<Poruka> vratiSvePoruke() throws Exception{
        ObjectOutputStream out=new ObjectOutputStream(socket.getOutputStream());
        Request request=new Request(null, Operation.RECIEVE);
        out.writeObject(request);
        ObjectInputStream in=new ObjectInputStream(socket.getInputStream());
        Response response=(Response) in.readObject();
        return (List<Poruka> )response.getData();

    }
}
