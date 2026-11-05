package operacije.radnici;

import domen.Radnik;
import operacije.ApstraktnaGenerickaOperacija;

public class AzurirajRadnikaSO extends ApstraktnaGenerickaOperacija {

    @Override
    protected void preduslovi(Object param) throws Exception {
        if (param == null || !(param instanceof Radnik)) {
            throw new Exception("Sistem ne može da ažurira radnika: neispravan objekat.");
        }

        Radnik r = (Radnik) param;
        if (r.getIdRadnik() <= 0) {
            throw new Exception("ID radnika nije ispravan.");
        }
        if (r.getIme() == null || r.getIme().trim().length() < 2) {
            throw new Exception("Ime radnika mora imati bar 2 slova.");
        }
        if (r.getPrezime() == null || r.getPrezime().trim().length() < 2) {
            throw new Exception("Prezime radnika mora imati bar 2 slova.");
        }
        if (r.getDatumZaposlenja() == null) {
            throw new Exception("Datum zaposlenja je obavezan.");
        }
        if (r.getPozicija() == null || r.getPozicija().trim().isEmpty()) {
            throw new Exception("Pozicija radnika je obavezna.");
        }
        if (r.getKorisnickoIme() == null || r.getKorisnickoIme().trim().length() < 3) {
            throw new Exception("Korisničko ime mora imati bar 3 karaktera.");
        }
        if (r.getSifra() == null || r.getSifra().trim().length() < 4) {
            throw new Exception("Šifra mora imati bar 4 karaktera.");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        Radnik radnik = (Radnik) param;

        broker.edit(radnik);

    }
}
