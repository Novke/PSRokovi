/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import domain.Poruka;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import thread.ThreadServer;

/**
 *
 * @author Rastko
 */
public class Main {
    public static void main(String[] args) {
        ThreadServer threadServer=new ThreadServer();
        threadServer.start();
        Scanner scanner=new Scanner(System.in);
        System.out.println("[FON] chat server");
        while(true){
            try {
                System.out.print("Poruka za aktivne korisnike: ");
                String text=scanner.nextLine();
                Poruka poruka=new Poruka(0, "server", "", text, new Date());
                threadServer.dodajPoruke(poruka);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
            
}
