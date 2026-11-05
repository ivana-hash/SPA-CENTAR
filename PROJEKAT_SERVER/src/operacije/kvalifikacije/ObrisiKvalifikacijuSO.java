package operacije.kvalifikacije;

import domen.Kvalifikacija;
import operacije.ApstraktnaGenerickaOperacija;

public class ObrisiKvalifikacijuSO extends ApstraktnaGenerickaOperacija {

    @Override
    protected void preduslovi(Object param) throws Exception {
        if (param == null || !(param instanceof Kvalifikacija)) {
            throw new Exception("Sistem ne može da obriše kvalifikaciju: neispravan objekat.");
        }

        if (((Kvalifikacija) param).getIdKvalifikacija() <= 0) {
            throw new Exception("ID kvalifikacije nije ispravan.");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        broker.delete((Kvalifikacija) param);
    }
}
