/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import controller.ServerController;
import domain.Pitanje;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import transfer.Operation;
import transfer.Request;
import transfer.Response;


public class ThreadClient extends Thread{

    private Socket socket;
    private String name;
    
    ThreadClient(Socket socket) {
        this.socket=socket;
    }

    @Override
    public void run() {
        try{
            while(!isInterrupted()){
                ObjectInputStream in=new ObjectInputStream(socket.getInputStream());
                Request req=(Request)in.readObject();
                Response res=handleRequest(req);
                ObjectOutputStream out=new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(res);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private Response handleRequest(Request req) {
        Response res=new Response(null, null);
        try{
            switch(req.getOperation()){
                case Operation.LOGIN:
                    res.setData(ServerController.getInstance().addUcesnik((String)req.getData()));
                    return res;
                case Operation.DA_LI_JE_KRAJ:
                    res.setData(ServerController.getInstance().daLiJeKraj());
                    return res;
                case Operation.KO_JE_POBEDNIK:
                    res.setData(ServerController.getInstance().koJePobednik());
                    return res;
                case Operation.ODGOVOR:
                    res.setData(ServerController.getInstance().posaljiOdgovor((Pitanje)req.getData(),"tim"));
                    return res;
                case Operation.GET_PITANJE:
                    res.setData(ServerController.getInstance().getTrenutnoPitanje());
                    return res;
                case Operation.GET_BROJ_BODOVA:
                    res.setData(ServerController.getInstance().getBrojBodovaTim());
                    return res;
                case Operation.DA_LI_MOZE_DA_POCNE:
                    res.setData(ServerController.getInstance().isMozeDaPocne());
                    return res;
            }
        }catch(Exception e){
            res.setError(e);
            res.setData(null);
        }
        return res;
    }
    
    
    
}
