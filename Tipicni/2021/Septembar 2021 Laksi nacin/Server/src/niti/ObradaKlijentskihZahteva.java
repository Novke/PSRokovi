/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import domen.Intervencija;
import domen.StambenaZajednica;
import domen.Upravnik;
import domen.VrstaIntervencije;
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

public class ObradaKlijentskihZahteva extends Thread {

    private Socket s;

    public ObradaKlijentskihZahteva(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        while (true) {
            KlijentskiZahtev kz = primiZahtev();
            ServerskiOdgovor so = new ServerskiOdgovor();
            switch (kz.getOperacija()) {
                case Operacije.LOGIN:
                    HashMap<String, String> mapa = (HashMap<String, String>) kz.getParametar();
                    String username = mapa.get("username");
                    String password = mapa.get("password");
                    Upravnik upravnik = Kontroler.getInstance().login(username, password);
                    so.setOdgovor(upravnik);
                    break;
                case Operacije.VRATI_INTERVENCIJE_UPRAVNIKA:
                    Upravnik u = (Upravnik) kz.getParametar();
                    ArrayList<Intervencija> intervencijeBaza = Kontroler.getInstance().vratiIntervencije(u);
                    so.setOdgovor(intervencijeBaza);
                    break;
                case Operacije.VRATI_STAMBENE_ZAJEDNICE:
                    ArrayList<StambenaZajednica> stambeneZajednice = Kontroler.getInstance().vratiStambeneZajednice();
                    so.setOdgovor(stambeneZajednice);
                    break;
                case Operacije.VRATI_VRSTE_INTERVENCIJA:
                    ArrayList<VrstaIntervencije> vrsteIntervencija = Kontroler.getInstance().vratiVrsteIntervencija();
                    so.setOdgovor(vrsteIntervencija);
                    break;
                case Operacije.SACUVAJ_IZMENE:
                    ArrayList<Intervencija> intervencije = (ArrayList<Intervencija>) kz.getParametar();
                    boolean uspesno = Kontroler.getInstance().sacuvajIntervencije(intervencije);
                    so.setOdgovor(uspesno);
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

    private void posaljiOdgovor(ServerskiOdgovor so) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(so);
            oos.flush();
        } catch (IOException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
