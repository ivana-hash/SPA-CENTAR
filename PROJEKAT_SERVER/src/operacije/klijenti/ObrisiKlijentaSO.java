package operacije.klijenti;

import domen.Klijent;
import operacije.ApstraktnaGenerickaOperacija;

public class ObrisiKlijentaSO extends ApstraktnaGenerickaOperacija {

    @Override
    protected void preduslovi(Object param) throws Exception {
        if (param == null || !(param instanceof Klijent)) {
            throw new Exception("Sistem ne može da obriše klijenta: neispravan objekat.");
        }

        if (((Klijent) param).getIdKlijent() <= 0) {
            throw new Exception("ID klijenta nije ispravan.");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        broker.delete((Klijent) param);
    }
}
