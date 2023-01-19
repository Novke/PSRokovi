/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import domen.Emisija;
import domen.Producent;
import domen.Radnik;
import domen.Studio;
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
                    Producent p = Kontroler.getInstance().login(username, password);
                    so.setOdgovor(p);
                    break;
                case Operacije.VRATI_AKTIVNE_RADNIKE:
                    ArrayList<Radnik> aktivniRadnici = Kontroler.getInstance().vratiAktivneRadnike();
                    so.setOdgovor(aktivniRadnici);
                    break;
                case Operacije.VRATI_AKTIVNE_STUDIJE:
                    ArrayList<Studio> aktivnaStudija = Kontroler.getInstance().vratiAktivnaStudija();
                    so.setOdgovor(aktivnaStudija);
                    break;
                case Operacije.SACUVAJ:
                    Emisija e = (Emisija) kz.getParametar();
                    boolean uspesno = Kontroler.getInstance().sacuvajEmisiju(e);
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
