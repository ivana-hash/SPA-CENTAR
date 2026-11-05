package operacije.kvalifikacije;

import domen.Kvalifikacija;
import java.util.List;
import operacije.ApstraktnaGenerickaOperacija;

public class UcitajKvalifikacijeSO extends ApstraktnaGenerickaOperacija {

    private List<Kvalifikacija> kvalifikacije;

    @Override
    protected void preduslovi(Object param) throws Exception {
        // Nema posebnih preduslova.
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        kvalifikacije = broker.getAll(new Kvalifikacija(), kljuc != null ? kljuc : "");
    }

    public List<Kvalifikacija> getKvalifikacije() {
        return kvalifikacije;
    }
}
