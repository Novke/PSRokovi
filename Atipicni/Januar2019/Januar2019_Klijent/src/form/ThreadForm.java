/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import controller.KlijentController;

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
            try{
                if(KlijentController.getInstance().mozeDaPocne()){
                    forma.setBtnPosaljiOdgovorEnabled();
                    forma.setBrojBodova();
                    if(KlijentController.getInstance().daLiJeKraj()){
                        forma.krajIgre(KlijentController.getInstance().koJePobednik());
                        break;
                    }
                    forma.setTrenutnoPitanje(KlijentController.getInstance().getPitanje());
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }

    
    
}
