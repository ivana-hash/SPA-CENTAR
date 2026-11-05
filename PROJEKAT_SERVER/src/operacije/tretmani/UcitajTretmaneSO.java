package operacije.tretmani;

import domen.Tretman;
import java.util.List;
import operacije.ApstraktnaGenerickaOperacija;

public class UcitajTretmaneSO extends ApstraktnaGenerickaOperacija {

    private List<Tretman> tretmani;

    @Override
    protected void preduslovi(Object param) throws Exception {
        // Nema posebnih preduslova.
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        tretmani = broker.getAll(new Tretman(), kljuc != null ? kljuc : "");
    }

    public List<Tretman> getTretmani() {
        return tretmani;
    }
}
