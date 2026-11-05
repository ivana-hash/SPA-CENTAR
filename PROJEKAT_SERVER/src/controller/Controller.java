package controller;

import domen.Klijent;
import domen.Kvalifikacija;
import domen.Radnik;
import domen.Rezervacija;
import domen.Status;
import domen.Tretman;
import java.util.List;
import operacije.klijenti.AzurirajKlijentaSO;
import operacije.klijenti.DodajKlijentaSO;
import operacije.klijenti.ObrisiKlijentaSO;
import operacije.klijenti.UcitajKlijenteSO;
import operacije.kvalifikacije.AzurirajKvalifikacijuSO;
import operacije.kvalifikacije.DodajKvalifikacijuSO;
import operacije.kvalifikacije.ObrisiKvalifikacijuSO;
import operacije.kvalifikacije.UcitajKvalifikacijeSO;
import operacije.login.LoginOperacija;
import operacije.radnici.AzurirajRadnikaSO;
import operacije.radnici.DodajRadnikaSO;
import operacije.radnici.ObrisiRadnikaSO;
import operacije.radnici.UcitajRadnikeSO;
import operacije.rezervacije.AzurirajRezervacijuSO;
import operacije.rezervacije.DodajRezervacijuSO;
import operacije.rezervacije.ObrisiRezervacijuSO;
import operacije.rezervacije.UcitajRezervacijeSO;
import operacije.statusi.AzurirajStatusSO;
import operacije.statusi.DodajStatusSO;
import operacije.statusi.ObrisiStatusSO;
import operacije.statusi.UcitajStatuseSO;
import operacije.tretmani.AzurirajTretmanSO;
import operacije.tretmani.DodajTretmanSO;
import operacije.tretmani.ObrisiTretmanSO;
import operacije.tretmani.UcitajTretmaneSO;

public class Controller {

    private static Controller instance;

    private Controller() {
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public Radnik login(Radnik radnik) throws Exception {
        LoginOperacija operacija = new LoginOperacija();
        operacija.izvrsi(radnik, null);
        return operacija.getRadnik();
    }

    public List<Klijent> ucitajKlijente() throws Exception {
        return ucitajKlijente("");
    }

    public List<Klijent> ucitajKlijente(String kljuc) throws Exception {
        UcitajKlijenteSO operacija = new UcitajKlijenteSO();
        operacija.izvrsi(null, kljuc);
        return operacija.getKlijenti();
    }

    public void dodajKlijenta(Klijent klijent) throws Exception {
        DodajKlijentaSO operacija = new DodajKlijentaSO();
        operacija.izvrsi(klijent, null);
    }

    public void azurirajKlijenta(Klijent klijent) throws Exception {
        AzurirajKlijentaSO operacija = new AzurirajKlijentaSO();
        operacija.izvrsi(klijent, null);
    }

    public void obrisiKlijenta(Klijent klijent) throws Exception {
        ObrisiKlijentaSO operacija = new ObrisiKlijentaSO();
        operacija.izvrsi(klijent, null);
    }

    public List<Status> ucitajStatuse() throws Exception {
        return ucitajStatuse("");
    }

    public List<Status> ucitajStatuse(String kljuc) throws Exception {
        UcitajStatuseSO operacija = new UcitajStatuseSO();
        operacija.izvrsi(null, kljuc);
        return operacija.getStatusi();
    }

    public void dodajStatus(Status status) throws Exception {
        DodajStatusSO operacija = new DodajStatusSO();
        operacija.izvrsi(status, null);
    }

    public void azurirajStatus(Status status) throws Exception {
        AzurirajStatusSO operacija = new AzurirajStatusSO();
        operacija.izvrsi(status, null);
    }

    public void obrisiStatus(Status status) throws Exception {
        ObrisiStatusSO operacija = new ObrisiStatusSO();
        operacija.izvrsi(status, null);
    }

    public List<Tretman> ucitajTretmane() throws Exception {
        return ucitajTretmane("");
    }

    public List<Tretman> ucitajTretmane(String kljuc) throws Exception {
        UcitajTretmaneSO operacija = new UcitajTretmaneSO();
        operacija.izvrsi(null, kljuc);
        return operacija.getTretmani();
    }

    public void dodajTretman(Tretman tretman) throws Exception {
        DodajTretmanSO operacija = new DodajTretmanSO();
        operacija.izvrsi(tretman, null);
    }

    public void azurirajTretman(Tretman tretman) throws Exception {
        AzurirajTretmanSO operacija = new AzurirajTretmanSO();
        operacija.izvrsi(tretman, null);
    }

    public void obrisiTretman(Tretman tretman) throws Exception {
        ObrisiTretmanSO operacija = new ObrisiTretmanSO();
        operacija.izvrsi(tretman, null);
    }

    public List<Kvalifikacija> ucitajKvalifikacije() throws Exception {
        return ucitajKvalifikacije("");
    }

    public List<Kvalifikacija> ucitajKvalifikacije(String kljuc) throws Exception {
        UcitajKvalifikacijeSO operacija = new UcitajKvalifikacijeSO();
        operacija.izvrsi(null, kljuc);
        return operacija.getKvalifikacije();
    }

    public void dodajKvalifikaciju(Kvalifikacija kvalifikacija) throws Exception {
        DodajKvalifikacijuSO operacija = new DodajKvalifikacijuSO();
        operacija.izvrsi(kvalifikacija, null);
    }

    public void azurirajKvalifikaciju(Kvalifikacija kvalifikacija) throws Exception {
        AzurirajKvalifikacijuSO operacija = new AzurirajKvalifikacijuSO();
        operacija.izvrsi(kvalifikacija, null);
    }

    public void obrisiKvalifikaciju(Kvalifikacija kvalifikacija) throws Exception {
        ObrisiKvalifikacijuSO operacija = new ObrisiKvalifikacijuSO();
        operacija.izvrsi(kvalifikacija, null);
    }

    public List<Radnik> ucitajRadnike() throws Exception {
        return ucitajRadnike("");
    }

    public List<Radnik> ucitajRadnike(String kljuc) throws Exception {
        UcitajRadnikeSO operacija = new UcitajRadnikeSO();
        operacija.izvrsi(null, kljuc);
        return operacija.getRadnici();
    }

    public int dodajRadnika(Radnik radnik) throws Exception {
        DodajRadnikaSO operacija = new DodajRadnikaSO();
        operacija.izvrsi(radnik, null);
        return operacija.getNoviRadnikId();
    }

    public void azurirajRadnika(Radnik radnik) throws Exception {
        AzurirajRadnikaSO operacija = new AzurirajRadnikaSO();
        operacija.izvrsi(radnik, null);
    }

    public void obrisiRadnika(Radnik radnik) throws Exception {
        ObrisiRadnikaSO operacija = new ObrisiRadnikaSO();
        operacija.izvrsi(radnik, null);
    }

    public List<Rezervacija> ucitajRezervacije() throws Exception {
        return ucitajRezervacije("");
    }

    public List<Rezervacija> ucitajRezervacije(String kljuc) throws Exception {
        UcitajRezervacijeSO operacija = new UcitajRezervacijeSO();
        operacija.izvrsi(null, kljuc);
        return operacija.getRezervacije();
    }

    public int dodajRezervaciju(Rezervacija rezervacija) throws Exception {
        DodajRezervacijuSO operacija = new DodajRezervacijuSO();
        operacija.izvrsi(rezervacija, null);
        return operacija.getNovaRezervacijaId();
    }

    public void azurirajRezervaciju(Rezervacija rezervacija) throws Exception {
        AzurirajRezervacijuSO operacija = new AzurirajRezervacijuSO();
        operacija.izvrsi(rezervacija, null);
    }

    public void obrisiRezervaciju(Rezervacija rezervacija) throws Exception {
        ObrisiRezervacijuSO operacija = new ObrisiRezervacijuSO();
        operacija.izvrsi(rezervacija, null);
    }
}
