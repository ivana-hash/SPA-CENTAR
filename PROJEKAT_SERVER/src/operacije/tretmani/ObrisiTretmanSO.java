package operacije.tretmani;

import domen.Tretman;
import operacije.ApstraktnaGenerickaOperacija;

public class ObrisiTretmanSO extends ApstraktnaGenerickaOperacija {

    @Override
    protected void preduslovi(Object param) throws Exception {
        if (param == null || !(param instanceof Tretman)) {
            throw new Exception("Sistem ne može da obriše tretman: neispravan objekat.");
        }

        if (((Tretman) param).getIdTretman() <= 0) {
            throw new Exception("ID tretmana nije ispravan.");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        broker.delete((Tretman) param);
    }
}
