/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import domen.Komponenta;
import domen.PrevoznoSredstvo;
import domen.ProizvodniPogon;
import domen.Rukovodilac;
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
                    Rukovodilac r = Kontroler.getInstance().login(username, password);
                    so.setOdgovor(r);
                    break;
                case Operacije.POPUNI_POGONE:
                    ArrayList<ProizvodniPogon> proizvodniPogoni = Kontroler.getInstance().vratiPogone();
                    so.setOdgovor(proizvodniPogoni);
                    break;
                case Operacije.POPUNI_KOMPONENTE:
                    ArrayList<Komponenta> komponente = Kontroler.getInstance().vratiKomponente();
                    so.setOdgovor(komponente);
                    break;
                case Operacije.SACUVAJ_PREVOZNO_SREDSTVO:
                    PrevoznoSredstvo ps = (PrevoznoSredstvo) kz.getParametar();
                    boolean uspesno = Kontroler.getInstance().sacuvajPrevoznoSredstvo(ps);
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
