package operacije.klijenti;

import domen.Klijent;
import java.util.List;
import operacije.ApstraktnaGenerickaOperacija;

public class UcitajKlijenteSO extends ApstraktnaGenerickaOperacija {

    private List<Klijent> klijenti;

    @Override
    protected void preduslovi(Object param) throws Exception {
        // Nema posebnih preduslova.
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        String uslov =
                " INNER JOIN ("
                + "SELECT idStatus, "
                + "naziv AS statusNaziv, "
                + "datumPostizanja AS statusDatumPostizanja, "
                + "pogodnosti AS statusPogodnosti "
                + "FROM status"
                + ") status ON (status.idStatus = klijent.idStatus) ";

        if (kljuc != null && !kljuc.trim().isEmpty()) {
            uslov += " " + kljuc;
        }

        klijenti = broker.getAll(new Klijent(), uslov);
    }

    public List<Klijent> getKlijenti() {
        return klijenti;
    }
}
