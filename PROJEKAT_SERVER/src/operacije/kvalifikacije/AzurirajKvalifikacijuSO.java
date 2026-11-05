package operacije.kvalifikacije;

import domen.Kvalifikacija;
import operacije.ApstraktnaGenerickaOperacija;

public class AzurirajKvalifikacijuSO extends ApstraktnaGenerickaOperacija {

    @Override
    protected void preduslovi(Object param) throws Exception {
        if (param == null || !(param instanceof Kvalifikacija)) {
            throw new Exception("Sistem ne može da ažurira kvalifikaciju: neispravan objekat.");
        }

        Kvalifikacija k = (Kvalifikacija) param;
        if (k.getIdKvalifikacija() <= 0) {
            throw new Exception("ID kvalifikacije nije ispravan.");
        }
        if (k.getNaziv() == null || k.getNaziv().trim().length() < 2) {
            throw new Exception("Naziv kvalifikacije mora imati bar 2 slova.");
        }
        if (k.getOpis() == null || k.getOpis().trim().isEmpty()) {
            throw new Exception("Opis kvalifikacije je obavezan.");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        broker.edit((Kvalifikacija) param);
    }
}
