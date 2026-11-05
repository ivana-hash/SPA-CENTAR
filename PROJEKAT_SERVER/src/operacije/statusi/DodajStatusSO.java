package operacije.statusi;

import domen.Status;
import operacije.ApstraktnaGenerickaOperacija;

public class DodajStatusSO extends ApstraktnaGenerickaOperacija {

    @Override
    protected void preduslovi(Object param) throws Exception {
        if (param == null || !(param instanceof Status)) {
            throw new Exception("Sistem ne može da doda status: neispravan objekat.");
        }

        Status s = (Status) param;
        if (s.getNaziv() == null || s.getNaziv().trim().length() < 2) {
            throw new Exception("Naziv statusa mora imati bar 2 slova.");
        }
        if (s.getDatumPostizanja() == null) {
            throw new Exception("Datum postizanja statusa je obavezan.");
        }
        if (s.getPogodnosti() == null || s.getPogodnosti().trim().isEmpty()) {
            throw new Exception("Pogodnosti statusa su obavezne.");
        }
       
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        broker.add((Status) param);
    }
}
