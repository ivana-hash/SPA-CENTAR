package niti;

import controller.Controller;
import domen.Klijent;
import domen.Kvalifikacija;
import domen.Radnik;
import domen.Rezervacija;
import domen.Status;
import domen.Tretman;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;
import komunikacija.Odgovor;
import komunikacija.Posiljalac;
import komunikacija.Primalac;
import komunikacija.Zahtev;

public class ObradaKlijentskihZahteva extends Thread {

    private final Socket socket;
    private final Posiljalac posiljalac;
    private final Primalac primalac;
    private boolean kraj;

    public ObradaKlijentskihZahteva(Socket socket) throws IOException {
        this.socket = socket;
        this.posiljalac = new Posiljalac(socket);
        this.primalac = new Primalac(socket);
    }

    @Override
    public void run() {
        while (!kraj) {
            try {
                Zahtev zahtev = (Zahtev) primalac.primi();
                Odgovor odgovor = new Odgovor();

                try {
                    obradiZahtev(zahtev, odgovor);
                } catch (Exception ex) {
                    odgovor.setOdgovor(ex);
                }

                posiljalac.posalji(odgovor);
            } catch (Exception ex) {
                if (!kraj) ex.printStackTrace();
            }
        }
    }

    private void obradiZahtev(Zahtev zahtev, Odgovor odgovor) throws Exception {
        switch (zahtev.getOperacija()) {
            case LOGIN: {
                Radnik radnik = Controller.getInstance().login((Radnik) zahtev.getParametar());
                odgovor.setOdgovor(radnik);
                break;
            }

            case UCITAJ_KLIJENTE: {
                String kljuc = (String) zahtev.getParametar();
                List<Klijent> lista = Controller.getInstance().ucitajKlijente(kljuc);
                odgovor.setOdgovor(lista);
                break;
            }
            case DODAJ_KLIJENTA:
                Controller.getInstance().dodajKlijenta((Klijent) zahtev.getParametar());
                odgovor.setOdgovor(null);
                break;
            case AZURIRAJ_KLIJENTA:
                Controller.getInstance().azurirajKlijenta((Klijent) zahtev.getParametar());
                odgovor.setOdgovor(null);
                break;
            case OBRISI_KLIJENTA:
                Controller.getInstance().obrisiKlijenta((Klijent) zahtev.getParametar());
                odgovor.setOdgovor(null);
                break;

            case UCITAJ_STATUSE: {
                String kljuc = (String) zahtev.getParametar();
                List<Status> lista = Controller.getInstance().ucitajStatuse(kljuc);
                odgovor.setOdgovor(lista);
                break;
            }
            case DODAJ_STATUS:
                Controller.getInstance().dodajStatus((Status) zahtev.getParametar());
                odgovor.setOdgovor(null);
                break;
            case AZURIRAJ_STATUS:
                Controller.getInstance().azurirajStatus((Status) zahtev.getParametar());
                odgovor.setOdgovor(null);
                break;
            case OBRISI_STATUS:
                Controller.getInstance().obrisiStatus((Status) zahtev.getParametar());
                odgovor.setOdgovor(null);
                break;

            case UCITAJ_TRETMANE: {
                String kljuc = (String) zahtev.getParametar();
                List<Tretman> lista = Controller.getInstance().ucitajTretmane(kljuc);
                odgovor.setOdgovor(lista);
                break;
            }
            case DODAJ_TRETMAN:
                Controller.getInstance().dodajTretman((Tretman) zahtev.getParametar());
                odgovor.setOdgovor(null);
                break;
            case AZURIRAJ_TRETMAN:
                Controller.getInstance().azurirajTretman((Tretman) zahtev.getParametar());
                odgovor.setOdgovor(null);
                break;
            case OBRISI_TRETMAN:
                Controller.getInstance().obrisiTretman((Tretman) zahtev.getParametar());
                odgovor.setOdgovor(null);
                break;

            case UCITAJ_KVALIFIKACIJE: {
                String kljuc = (String) zahtev.getParametar();
                List<Kvalifikacija> lista = Controller.getInstance().ucitajKvalifikacije(kljuc);
                odgovor.setOdgovor(lista);
                break;
            }
            case DODAJ_KVALIFIKACIJU:
                Controller.getInstance().dodajKvalifikaciju((Kvalifikacija) zahtev.getParametar());
                odgovor.setOdgovor(null);
                break;
            case AZURIRAJ_KVALIFIKACIJU:
                Controller.getInstance().azurirajKvalifikaciju((Kvalifikacija) zahtev.getParametar());
                odgovor.setOdgovor(null);
                break;
            case OBRISI_KVALIFIKACIJU:
                Controller.getInstance().obrisiKvalifikaciju((Kvalifikacija) zahtev.getParametar());
                odgovor.setOdgovor(null);
                break;

            case UCITAJ_RADNIKE: {
                String kljuc = (String) zahtev.getParametar();
                List<Radnik> lista = Controller.getInstance().ucitajRadnike(kljuc);
                odgovor.setOdgovor(lista);
                break;
            }
            case DODAJ_RADNIKA: {
                int id = Controller.getInstance().dodajRadnika((Radnik) zahtev.getParametar());
                odgovor.setOdgovor(id);
                break;
            }
            case AZURIRAJ_RADNIKA:
                Controller.getInstance().azurirajRadnika((Radnik) zahtev.getParametar());
                odgovor.setOdgovor(null);
                break;
            case OBRISI_RADNIKA:
                Controller.getInstance().obrisiRadnika((Radnik) zahtev.getParametar());
                odgovor.setOdgovor(null);
                break;

            case UCITAJ_REZERVACIJE: {
                String kljuc = (String) zahtev.getParametar();
                List<Rezervacija> lista = Controller.getInstance().ucitajRezervacije(kljuc);
                odgovor.setOdgovor(lista);
                break;
            }
            case DODAJ_REZERVACIJU: {
                int id = Controller.getInstance().dodajRezervaciju((Rezervacija) zahtev.getParametar());
                odgovor.setOdgovor(id);
                break;
            }
            case AZURIRAJ_REZERVACIJU:
                Controller.getInstance().azurirajRezervaciju((Rezervacija) zahtev.getParametar());
                odgovor.setOdgovor(null);
                break;
            case OBRISI_REZERVACIJU:
                Controller.getInstance().obrisiRezervaciju((Rezervacija) zahtev.getParametar());
                odgovor.setOdgovor(null);
                break;

            default:
                throw new Exception("Nepoznata operacija.");
        }
    }

    public void prekini() {
        kraj = true;
        try {
            socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        interrupt();
    }
}
