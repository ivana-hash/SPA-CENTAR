package komunikacija;

import domen.Klijent;
import domen.Kvalifikacija;
import domen.Radnik;
import domen.Rezervacija;
import domen.Status;
import domen.Tretman;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

public class Komunikacija {

    private static Komunikacija instanca;

    private Socket soket;
    private Posiljalac posiljalac;
    private Primalac primalac;

    private Komunikacija() {
    }

    public static Komunikacija getInstanca() {
        if (instanca == null) {
            instanca = new Komunikacija();
        }
        return instanca;
    }

    public void konekcija() throws Exception {
        if (soket != null && soket.isConnected() && !soket.isClosed()) {
            return;
        }

        try {
            soket = new Socket("localhost", 9000);
            posiljalac = new Posiljalac(soket);
            primalac = new Primalac(soket);
        } catch (IOException ex) {
            throw new Exception("Server nije pokrenut ili nije dostupan.", ex);
        }
    }

    public void zatvoriKonekciju() {
        if (soket != null) {
            try {
                soket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        soket = null;
        posiljalac = null;
        primalac = null;
    }

    private synchronized Object posaljiZahtev(Operacija operacija, Object parametar)
            throws Exception {
        if (soket == null || soket.isClosed() || posiljalac == null || primalac == null) {
            throw new Exception("Klijent nije povezan sa serverom.");
        }

        try {
            posiljalac.posalji(new Zahtev(operacija, parametar));
            Odgovor odgovor = (Odgovor) primalac.primi();
            Object rezultat = odgovor.getOdgovor();

            if (rezultat instanceof Exception) {
                throw (Exception) rezultat;
            }

            return rezultat;
        } catch (IOException | ClassNotFoundException ex) {
            throw new Exception("Greška u komunikaciji sa serverom.", ex);
        }
    }

    public Radnik login(String korisnickoIme, String sifra) throws Exception {
        Radnik radnik = new Radnik();
        radnik.setKorisnickoIme(korisnickoIme);
        radnik.setSifra(sifra);
        return (Radnik) posaljiZahtev(Operacija.LOGIN, radnik);
    }

    @SuppressWarnings("unchecked")
    public List<Klijent> ucitajKlijente(String kljuc) throws Exception {
        return (List<Klijent>) posaljiZahtev(Operacija.UCITAJ_KLIJENTE, kljuc);
    }

    public List<Klijent> ucitajKlijente() throws Exception {
        return ucitajKlijente("");
    }

    public void dodajKlijenta(Klijent klijent) throws Exception {
        posaljiZahtev(Operacija.DODAJ_KLIJENTA, klijent);
    }

    public void azurirajKlijenta(Klijent klijent) throws Exception {
        posaljiZahtev(Operacija.AZURIRAJ_KLIJENTA, klijent);
    }

    public void obrisiKlijenta(Klijent klijent) throws Exception {
        posaljiZahtev(Operacija.OBRISI_KLIJENTA, klijent);
    }

    @SuppressWarnings("unchecked")
    public List<Status> ucitajStatuse(String kljuc) throws Exception {
        return (List<Status>) posaljiZahtev(Operacija.UCITAJ_STATUSE, kljuc);
    }

    public List<Status> ucitajStatuse() throws Exception {
        return ucitajStatuse("");
    }

    public void dodajStatus(Status status) throws Exception {
        posaljiZahtev(Operacija.DODAJ_STATUS, status);
    }

    public void azurirajStatus(Status status) throws Exception {
        posaljiZahtev(Operacija.AZURIRAJ_STATUS, status);
    }

    public void obrisiStatus(Status status) throws Exception {
        posaljiZahtev(Operacija.OBRISI_STATUS, status);
    }

    @SuppressWarnings("unchecked")
    public List<Tretman> ucitajTretmane(String kljuc) throws Exception {
        return (List<Tretman>) posaljiZahtev(Operacija.UCITAJ_TRETMANE, kljuc);
    }

    public List<Tretman> ucitajTretmane() throws Exception {
        return ucitajTretmane("");
    }

    public void dodajTretman(Tretman tretman) throws Exception {
        posaljiZahtev(Operacija.DODAJ_TRETMAN, tretman);
    }

    public void azurirajTretman(Tretman tretman) throws Exception {
        posaljiZahtev(Operacija.AZURIRAJ_TRETMAN, tretman);
    }

    public void obrisiTretman(Tretman tretman) throws Exception {
        posaljiZahtev(Operacija.OBRISI_TRETMAN, tretman);
    }

    @SuppressWarnings("unchecked")
    public List<Kvalifikacija> ucitajKvalifikacije(String kljuc) throws Exception {
        return (List<Kvalifikacija>) posaljiZahtev(Operacija.UCITAJ_KVALIFIKACIJE, kljuc);
    }

    public List<Kvalifikacija> ucitajKvalifikacije() throws Exception {
        return ucitajKvalifikacije("");
    }

    public void dodajKvalifikaciju(Kvalifikacija kvalifikacija) throws Exception {
        posaljiZahtev(Operacija.DODAJ_KVALIFIKACIJU, kvalifikacija);
    }

    public void azurirajKvalifikaciju(Kvalifikacija kvalifikacija) throws Exception {
        posaljiZahtev(Operacija.AZURIRAJ_KVALIFIKACIJU, kvalifikacija);
    }

    public void obrisiKvalifikaciju(Kvalifikacija kvalifikacija) throws Exception {
        posaljiZahtev(Operacija.OBRISI_KVALIFIKACIJU, kvalifikacija);
    }

    @SuppressWarnings("unchecked")
    public List<Radnik> ucitajRadnike(String kljuc) throws Exception {
        return (List<Radnik>) posaljiZahtev(Operacija.UCITAJ_RADNIKE, kljuc);
    }

    public List<Radnik> ucitajRadnike() throws Exception {
        return ucitajRadnike("");
    }

    public int dodajRadnika(Radnik radnik) throws Exception {
        Object odgovor = posaljiZahtev(Operacija.DODAJ_RADNIKA, radnik);
        return ((Number) odgovor).intValue();
    }

    public void azurirajRadnika(Radnik radnik) throws Exception {
        posaljiZahtev(Operacija.AZURIRAJ_RADNIKA, radnik);
    }

    public void obrisiRadnika(Radnik radnik) throws Exception {
        posaljiZahtev(Operacija.OBRISI_RADNIKA, radnik);
    }

    @SuppressWarnings("unchecked")
    public List<Rezervacija> ucitajRezervacije(String kljuc) throws Exception {
        return (List<Rezervacija>) posaljiZahtev(Operacija.UCITAJ_REZERVACIJE, kljuc);
    }

    public List<Rezervacija> ucitajRezervacije() throws Exception {
        return ucitajRezervacije("");
    }

    public int dodajRezervaciju(Rezervacija rezervacija) throws Exception {
        Object odgovor = posaljiZahtev(Operacija.DODAJ_REZERVACIJU, rezervacija);
        return ((Number) odgovor).intValue();
    }

    public void azurirajRezervaciju(Rezervacija rezervacija) throws Exception {
        posaljiZahtev(Operacija.AZURIRAJ_REZERVACIJU, rezervacija);
    }

    public void obrisiRezervaciju(Rezervacija rezervacija) throws Exception {
        posaljiZahtev(Operacija.OBRISI_REZERVACIJU, rezervacija);
    }
}
