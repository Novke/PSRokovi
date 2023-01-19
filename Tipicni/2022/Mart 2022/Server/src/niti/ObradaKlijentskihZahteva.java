/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import domen.Festival;
import domen.Izvodjenje;
import domen.Koncert;
import domen.Korisnik;
import domen.Predstava;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import konstante.Operacije;
import logika.Kontroler;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;


public class ObradaKlijentskihZahteva extends Thread{
    private Socket s;

    public ObradaKlijentskihZahteva(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        while(true){
            KlijentskiZahtev kz = primiZahtev();
            ServerskiOdgovor so = new ServerskiOdgovor();
            switch(kz.getOperacija()){
                case Operacije.LOGIN:
                    HashMap<String, String> mapa = (HashMap<String, String>) kz.getParametar();
                    String username = mapa.get("username");
                    String password = mapa.get("password");
                    Korisnik k = Kontroler.getInstance().login(username, password);
                    so.setOdgovor(k);
                    break;
                case Operacije.VRATI_FESTIVALE:
                    ArrayList<Festival> festivali = Kontroler.getInstance().vratiFestivale();
                    so.setOdgovor(festivali);
                    break;
                case Operacije.VRATI_PREDSTAVE:
                    ArrayList<Predstava> predstave = Kontroler.getInstance().vratiPredstave();
                    so.setOdgovor(predstave);
                    break;
                case Operacije.VRATI_KONCERTE:
                    ArrayList<Koncert> koncerti = Kontroler.getInstance().vratiKoncerte();
                    so.setOdgovor(koncerti);
                    break;
                case Operacije.IZMENI_FESTIVAL:
                    Festival f = (Festival) kz.getParametar();
                    boolean uspesno = Kontroler.getInstance().izmeniFestival(f);
                    so.setOdgovor(uspesno);
                    break;
                case Operacije.VRATI_IZVODJENJA_FESTIVALA:
                    Festival festival = (Festival) kz.getParametar();
                    ArrayList<Izvodjenje> izvodjenjaFestivala = Kontroler.getInstance().vratiIzvodjenjaFestivala(festival);
                    so.setOdgovor(izvodjenjaFestivala);
                    break;
            }
            posaljiOdgovor(so);
        }
    }

    private KlijentskiZahtev primiZahtev() {
        try {
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            return (KlijentskiZahtev) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, "Klijent se odjavio!", ex);
        }
        return null;
    }
    private void posaljiOdgovor(ServerskiOdgovor so){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(so);
            oos.flush();
        } catch (IOException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
