package operacije.radnici;

import domen.Radnik;
import operacije.ApstraktnaGenerickaOperacija;

public class ObrisiRadnikaSO extends ApstraktnaGenerickaOperacija {

    @Override
    protected void preduslovi(Object param) throws Exception {
        if (param == null || !(param instanceof Radnik)) {
            throw new Exception("Sistem ne može da obriše radnika: neispravan objekat.");
        }

        if (((Radnik) param).getIdRadnik() <= 0) {
            throw new Exception("ID radnika nije ispravan.");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        Radnik radnik = (Radnik) param;

        broker.deleteWhere(
                "radnikkvalifikacija",
                "idRadnik=" + radnik.getIdRadnik()
        );

        broker.delete(radnik);
    }
}
