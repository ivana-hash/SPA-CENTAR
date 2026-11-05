package operacije.rezervacije;

import domen.Rezervacija;
import domen.StavkaRezervacije;
import java.util.ArrayList;
import java.util.List;
import operacije.ApstraktnaGenerickaOperacija;

public class UcitajRezervacijeSO
        extends ApstraktnaGenerickaOperacija {

    private List<Rezervacija> rezervacije;

    @Override
    protected void preduslovi(Object param) throws Exception {
        // Nema posebnih preduslova.
    }

    @Override
    protected void izvrsiOperaciju(
            Object param,
            String kljuc
    ) throws Exception {

        String uslov =
                " INNER JOIN ("
                + "SELECT idRadnik, ime, prezime, "
                + "ime AS radnikIme, "
                + "prezime AS radnikPrezime "
                + "FROM radnik"
                + ") radnik ON (radnik.idRadnik = "
                + "rezervacija.idRadnik) "

                + "INNER JOIN ("
                + "SELECT idKlijent, ime, prezime, "
                + "ime AS klijentIme, "
                + "prezime AS klijentPrezime, "
                + "emailAdresa AS klijentEmail, "
                + "kontaktTelefon AS klijentTelefon "
                + "FROM klijent"
                + ") klijent ON (klijent.idKlijent = "
                + "rezervacija.idKlijent) ";

        if (kljuc != null && !kljuc.trim().isEmpty()) {
            uslov += " " + kljuc;
        }

        List<Rezervacija> lista =
                broker.getAll(new Rezervacija(), uslov);

        for (Rezervacija r : lista) {

            String uslovStavke =
                    " INNER JOIN ("
                    + "SELECT idTretman, "
                    + "naziv AS tretmanNaziv, "
                    + "cena AS tretmanCena, "
                    + "trajanjeUMin AS tretmanTrajanjeUMin, "
                    + "benefitiTretmana AS tretmanBenefiti "
                    + "FROM tretman"
                    + ") tretman ON (tretman.idTretman = "
                    + "stavkarezervacije.idTretman) "
                    + "WHERE stavkarezervacije.idRezervacija="
                    + r.getIdRezervacija()
                    + " ORDER BY stavkarezervacije.rb";

            List<StavkaRezervacije> stavke =
                    broker.getAll(
                            new StavkaRezervacije(),
                            uslovStavke
                    );

            r.setStavke(
                    stavke != null
                            ? stavke
                            : new ArrayList<>()
            );
        }

        rezervacije = lista;
    }

    public List<Rezervacija> getRezervacije() {
        return rezervacije;
    }
}