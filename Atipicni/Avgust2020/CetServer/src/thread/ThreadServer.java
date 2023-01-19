/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import domain.Poruka;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rastko
 */
public class ThreadServer extends Thread{
    private ServerSocket serverSocket;
    private List<Poruka> poruke;
    private List<ThreadClient> clients;

    public ThreadServer() {
        try{
            serverSocket=new ServerSocket(10000);
            poruke=new LinkedList<>();
            clients=new LinkedList<>();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(!isInterrupted()){
            try {
                    Socket socket=serverSocket.accept();
                    ThreadClient thc=new ThreadClient(socket, this);
                    clients.add(thc);
                    thc.start();
                } catch (IOException ex) {
                    ex.printStackTrace();
            }
        }
    }
    
    
    public void dodajPoruke(Poruka poruka) throws Exception{
        boolean postoji=false;
        if(poruka.getPosiljalac().equals("server"))
            poruke.add(poruka);
        else{
            for(ThreadClient thc:clients)
                if(thc.getImeKorsinika().toLowerCase().equals(poruka.getPrijemnik()))
                    postoji=true;
            if(postoji)
                poruke.add(poruka);
            else
                throw new Exception("Ne postoji korinsik sa tim korisnickim imenom");
        }
    }
    
    public boolean posotojiKorisnik(String ime){
        for(ThreadClient thc:clients)
            if(thc.getImeKorsinika().toLowerCase().equals(ime.toLowerCase()) || ime.toLowerCase().equals("server"))
                return true;
        return false;
    }
    
    public List<Poruka> vratiSvePorukeZaKorisnika(String ime){
        List<Poruka> list=new LinkedList<>();
        for(Poruka p:poruke)
            if(p.getPrijemnik().toLowerCase().equals(ime.toLowerCase()) || p.getPosiljalac().equals("server"))
                list.add(p);
        return list;
    }
    
    
}
