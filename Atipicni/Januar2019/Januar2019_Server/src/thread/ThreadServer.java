/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import controller.ServerController;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;


public class ThreadServer extends Thread{
    
    private ServerSocket serverSocket;
    private List<ThreadClient> list;

    public ThreadServer() {
        try{
            serverSocket=new ServerSocket(ServerController.getInstance().getBrojPorta());
            list=new LinkedList<>();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try{
            while(!isInterrupted()){
                Socket socket=serverSocket.accept();
                ThreadClient th=new ThreadClient(socket);
                th.start();
                list.add(th);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public List<ThreadClient> getList() {
        return list;
    }
    
    
    
}
