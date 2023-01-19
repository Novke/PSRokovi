/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import controller.ServerController;
import domain.Pitanje;

/**
 *
 * @author Rastko
 */
public class ThreadForm extends Thread{
    private Form forma;

    public ThreadForm(Form forma) {
        this.forma = forma;
    }

    @Override
    public void run() {
        while(!isInterrupted()){
            if(ServerController.getInstance().isMozeDaPocne()){
                forma.enablePosaljiOdgovorButton();
                forma.setBrojPoena();
                if(ServerController.getInstance().daLiJeKraj()){
                    forma.krajIgre(ServerController.getInstance().koJePobednik());
                    break;
                }
                else{
                    Pitanje pitanje=ServerController.getInstance().getTrenutnoPitanje();
                    forma.setTrenutnoPitanje(pitanje);
                }
            }
        }
    }
    
    
}
