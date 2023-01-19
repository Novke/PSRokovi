/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Pitanje;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import transfer.Operation;
import transfer.Request;
import transfer.Response;

/**
 *
 * @author Rastko
 */
public class KlijentController {
    private static KlijentController instance;
    private Socket socket;

    public KlijentController() {
        try{
            socket=new Socket("127.0.0.1",9000);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public static KlijentController getInstance() {
        if(instance==null)
            instance=new KlijentController();
        return instance;
    }
    
    public synchronized boolean login(String name) throws Exception{
        return (boolean)posaljiZahtev(name, Operation.LOGIN).getData();
    }
    
    public synchronized Pitanje getPitanje()throws Exception{
        return (Pitanje)posaljiZahtev(null, Operation.GET_PITANJE).getData();
    }
    
    public synchronized boolean daLiJeKraj() throws Exception{
        return (boolean)posaljiZahtev(null, Operation.DA_LI_JE_KRAJ).getData();
    }
    
    public synchronized String koJePobednik() throws Exception{
        return (String)posaljiZahtev(null, Operation.KO_JE_POBEDNIK).getData();
    }
    
    public synchronized String posaljiOdgovor(Pitanje pitanje) throws Exception{
        return (String)posaljiZahtev(pitanje, Operation.ODGOVOR).getData();
    }
    
    public synchronized double getBrojBodova() throws Exception{
        return (double)posaljiZahtev(null, Operation.GET_BROJ_BODOVA).getData();
    }
    
    public synchronized boolean mozeDaPocne() throws Exception{
        return (boolean)posaljiZahtev(null, Operation.DA_LI_MOZE_DA_POCNE).getData();
    }
    public synchronized Response posaljiZahtev(Object data, int operation)throws Exception{
        ObjectOutputStream out=new ObjectOutputStream(socket.getOutputStream());
        Request request=new Request(data, operation);
        out.writeObject(request);
        ObjectInputStream in=new ObjectInputStream(socket.getInputStream());
        Response response=(Response)in.readObject();
        if(response.getError()!=null)
            throw response.getError();
        return response;
    }
    
}
