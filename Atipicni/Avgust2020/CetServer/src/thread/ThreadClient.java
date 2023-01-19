/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import domain.Operation;
import domain.Poruka;
import domain.Request;
import domain.Response;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rastko
 */
public class ThreadClient extends Thread{
    private Socket socket;
    private String imeKorisnika;
    private ThreadServer threadServer;
    
    public ThreadClient(Socket socket, ThreadServer threadServer) {
        imeKorisnika="";
        this.socket = socket;
        this.threadServer=threadServer;
        
    }

    @Override
    public void run() {
        while(!isInterrupted()){
            try{
                ObjectInputStream in=new ObjectInputStream(socket.getInputStream());
                Request request=(Request)in.readObject();
                Response response=handleRequest(request);
                ObjectOutputStream out=new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(response);
            }catch(Exception ex){
               // ex.printStackTrace();
            }
        }
    }

    private Response handleRequest(Request request) {
        Response res=new Response(null);
        switch(request.getOperation()){
            case Operation.LOGIN:
                String ime=(String)request.getData();
                if(threadServer.posotojiKorisnik(ime))
                    res.setData(new Exception("Ne postoji korinsik sa tim korisnickim imenom"));
                imeKorisnika=ime;
                return res;
            case Operation.RECIEVE:
                res.setData(threadServer.vratiSvePorukeZaKorisnika(imeKorisnika));
                return res;
            case Operation.SEND:
                try {
                    threadServer.dodajPoruke((Poruka)request.getData());
                } catch (Exception ex) {
                    res.setData(ex);
                }
            return res;
            default:
                return null;
        }
    }

    public String getImeKorsinika() {
        return imeKorisnika;
    }
    
    
}
