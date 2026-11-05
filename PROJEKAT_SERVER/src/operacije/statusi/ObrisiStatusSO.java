package operacije.statusi;

import domen.Status;
import operacije.ApstraktnaGenerickaOperacija;

public class ObrisiStatusSO extends ApstraktnaGenerickaOperacija {

    @Override
    protected void preduslovi(Object param) throws Exception {
        if (param == null || !(param instanceof Status)) {
            throw new Exception("Sistem ne može da obriše status: neispravan objekat.");
        }

        if (((Status) param).getIdStatus() <= 0) {
            throw new Exception("ID statusa nije ispravan.");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        broker.delete((Status) param);
    }
}
