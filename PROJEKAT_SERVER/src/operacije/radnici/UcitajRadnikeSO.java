package operacije.radnici;

import domen.Radnik;
import java.util.List;
import operacije.ApstraktnaGenerickaOperacija;

public class UcitajRadnikeSO extends ApstraktnaGenerickaOperacija {

    private List<Radnik> radnici;

    @Override
    protected void preduslovi(Object param) throws Exception {
        // Nema posebnih preduslova.
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        radnici = broker.getAll(
                new Radnik(),
                kljuc != null ? kljuc : ""
        );
    }

    public List<Radnik> getRadnici() {
        return radnici;
    }
}
