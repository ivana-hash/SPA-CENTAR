package operacije.statusi;

import domen.Status;
import java.util.List;
import operacije.ApstraktnaGenerickaOperacija;

public class UcitajStatuseSO extends ApstraktnaGenerickaOperacija {

    private List<Status> statusi;

    @Override
    protected void preduslovi(Object param) throws Exception {
        // Nema posebnih preduslova.
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        statusi = broker.getAll(new Status(), kljuc != null ? kljuc : "");
    }

    public List<Status> getStatusi() {
        return statusi;
    }
}
