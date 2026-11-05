package operacije.klijenti;

import domen.Klijent;
import operacije.ApstraktnaGenerickaOperacija;

public class AzurirajKlijentaSO extends ApstraktnaGenerickaOperacija {

    @Override
    protected void preduslovi(Object param) throws Exception {
        if (param == null || !(param instanceof Klijent)) {
            throw new Exception("Sistem ne može da ažurira klijenta: neispravan objekat.");
        }

        Klijent k = (Klijent) param;
        if (k.getIdKlijent() <= 0) {
            throw new Exception("ID klijenta nije ispravan.");
        }
        if (k.getIme() == null || k.getIme().trim().length() < 2) {
            throw new Exception("Ime klijenta mora imati bar 2 slova.");
        }
        if (k.getPrezime() == null || k.getPrezime().trim().length() < 2) {
            throw new Exception("Prezime klijenta mora imati bar 2 slova.");
        }
        if (k.getEmailAdresa() == null || !k.getEmailAdresa().matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")) {
            throw new Exception("Email adresa klijenta nije ispravna.");
        }
        if (k.getKontaktTelefon() == null || k.getKontaktTelefon().trim().length() < 6 || !k.getKontaktTelefon().matches("^06[0-9]-[0-9]{3}-[0-9]{2}-[0-9]{2}$")) {
            throw new Exception("Kontakt telefon klijenta nije ispravan.");
        }
        if (k.getStatus() == null || k.getStatus().getIdStatus() <= 0) {
            throw new Exception("Status klijenta je obavezan.");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        broker.edit((Klijent) param);
    }
}
