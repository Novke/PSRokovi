/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import domen.Banka;
import domen.Kompanija;
import domen.Korisnik;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import konstante.Operacije;
import logika.Kontroler;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author USER
 */
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
                case Operacije.ULOGUJ:
                    HashMap<String, String> mapa = (HashMap<String, String>) kz.getParametar();
                    String user = mapa.get("username");
                    String pass = mapa.get("password");
                    Korisnik k = Kontroler.getInstance().login(user, pass);
                    so.setOdgovor(k);
                    break;
                case Operacije.POPUNI_BANKE:
                    ArrayList<Banka> lista = Kontroler.getInstance().vratiBanke();
                    so.setOdgovor(lista);
                    break;
                case Operacije.SACUVAJ:
                    Kompanija kompanija = (Kompanija) kz.getParametar();
                    boolean uspesno = Kontroler.getInstance().sacuvajKompaniju(kompanija);
                    so.setOdgovor(uspesno);
                    break;
                case Operacije.SREDNJI_KURS:
                    Properties properties = new Properties();

                    try {
                        properties.load(new FileInputStream("podesavanja.properties"));
                    } catch (Exception ex) {
                        Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    double kurs = Double.parseDouble(properties.getProperty("SREDNJI_KURS_NBS"));
                    so.setOdgovor(kurs);
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
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
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
