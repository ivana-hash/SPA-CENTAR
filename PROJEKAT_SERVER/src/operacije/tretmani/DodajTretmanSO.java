package operacije.tretmani;

import domen.Tretman;
import operacije.ApstraktnaGenerickaOperacija;

public class DodajTretmanSO extends ApstraktnaGenerickaOperacija {

    @Override
    protected void preduslovi(Object param) throws Exception {
        validiraj(param, false);
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        broker.add((Tretman) param);
    }

    private void validiraj(Object param, boolean zahtevaId) throws Exception {
        if (param == null || !(param instanceof Tretman)) {
            throw new Exception("Sistem ne može da doda tretman: neispravan objekat.");
        }

        Tretman t = (Tretman) param;
        if (zahtevaId && t.getIdTretman() <= 0) {
            throw new Exception("ID tretmana nije ispravan.");
        }
        if (t.getNaziv() == null || t.getNaziv().trim().length() < 2) {
            throw new Exception("Naziv tretmana mora imati bar 2 slova.");
        }
        if (t.getCena() <= 0) {
            throw new Exception("Cena tretmana mora biti veća od 0.");
        }
        if (t.getTrajanjeUMin() <= 0) {
            throw new Exception("Trajanje tretmana mora biti veće od 0 minuta.");
        }
        if (t.getBenefitiTretmana() == null || t.getBenefitiTretmana().trim().isEmpty()) {
            throw new Exception("Benefiti tretmana su obavezni.");
        }
    }
}
