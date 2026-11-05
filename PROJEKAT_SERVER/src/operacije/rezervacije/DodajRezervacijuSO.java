package operacije.rezervacije;

import domen.Rezervacija;
import domen.StavkaRezervacije;
import java.util.List;
import operacije.ApstraktnaGenerickaOperacija;

public class DodajRezervacijuSO extends ApstraktnaGenerickaOperacija {

    private int novaRezervacijaId;

    @Override
    protected void preduslovi(Object param) throws Exception {
        if (param == null || !(param instanceof Rezervacija)) {
            throw new Exception("Sistem ne može da doda rezervaciju: neispravan objekat.");
        }

        Rezervacija r = (Rezervacija) param;
        validirajRezervaciju(r);
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        Rezervacija rezervacija = (Rezervacija) param;

        int id = broker.addReturnKey(rezervacija);
        if (id <= 0) {
            throw new Exception("Sistem ne može da doda rezervaciju: nije generisan ID.");
        }

        rezervacija.setIdRezervacija(id);
        novaRezervacijaId = id;

        int rb = 1;
        for (StavkaRezervacije stavka : rezervacija.getStavke()) {
            stavka.setRezervacijaId(id);
            stavka.setRb(rb++);
            broker.add(stavka);
        }
    }

    private void validirajRezervaciju(Rezervacija r) throws Exception {
        if (r.getDatumKreiranja() == null) {
            throw new Exception("Datum kreiranja rezervacije je obavezan.");
        }
        if (r.getRadnik() == null || r.getRadnik().getIdRadnik() <= 0) {
            throw new Exception("Radnik koji kreira rezervaciju je obavezan.");
        }
        if (r.getKlijent() == null || r.getKlijent().getIdKlijent() <= 0) {
            throw new Exception("Klijent za kog se kreira rezervacija je obavezan.");
        }
        if (r.getStavke() == null || r.getStavke().isEmpty()) {
            throw new Exception("Rezervacija mora imati bar jednu stavku.");
        }

        r.setUkupanIznos(validirajIObracunajStavke(r.getStavke()));
    }

    private double validirajIObracunajStavke(List<StavkaRezervacije> stavke) throws Exception {
        double ukupanIznos = 0;
        int i = 1;

        for (StavkaRezervacije s : stavke) {
            if (s == null) {
                throw new Exception("Stavka rezervacije ne sme biti null.");
            }
            if (s.getTretman() == null || s.getTretman().getIdTretman() <= 0) {
                throw new Exception("Tretman je obavezan u stavci " + i + ".");
            }
            if (s.getCena() <= 0) {
                s.setCena(s.getTretman().getCena());
            }
            if (s.getCena() <= 0) {
                throw new Exception("Cena mora biti veća od 0 u stavci " + i + ".");
            }
            if (s.getBrojPaketaTretmana() <= 0) {
                throw new Exception("Broj paketa mora biti veći od 0 u stavci " + i + ".");
            }

            double iznosStavke = s.getCena() * s.getBrojPaketaTretmana();
            s.setIznosStavke(iznosStavke);
            ukupanIznos += iznosStavke;
            i++;
        }

        return ukupanIznos;
    }

    public int getNovaRezervacijaId() {
        return novaRezervacijaId;
    }
}
