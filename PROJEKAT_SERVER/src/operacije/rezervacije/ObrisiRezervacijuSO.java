package operacije.rezervacije;

import domen.Rezervacija;
import operacije.ApstraktnaGenerickaOperacija;

public class ObrisiRezervacijuSO extends ApstraktnaGenerickaOperacija {

    @Override
    protected void preduslovi(Object param) throws Exception {
        if (param == null || !(param instanceof Rezervacija)) {
            throw new Exception("Sistem ne može da obriše rezervaciju: neispravan objekat.");
        }

        if (((Rezervacija) param).getIdRezervacija() <= 0) {
            throw new Exception("ID rezervacije nije ispravan.");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        Rezervacija rezervacija = (Rezervacija) param;

        broker.deleteWhere(
                "stavkarezervacije",
                "idRezervacija=" + rezervacija.getIdRezervacija()
        );

        broker.delete(rezervacija);
    }
}
