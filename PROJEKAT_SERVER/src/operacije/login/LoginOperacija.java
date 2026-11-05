package operacije.login;

import domen.Radnik;
import java.util.List;
import operacije.ApstraktnaGenerickaOperacija;

public class LoginOperacija extends ApstraktnaGenerickaOperacija {

    private Radnik radnik;

    @Override
    protected void preduslovi(Object param) throws Exception {
        if (param == null || !(param instanceof Radnik)) {
            throw new Exception("Sistem ne može da prijavi radnika: neispravan objekat.");
        }

        Radnik r = (Radnik) param;

        if (r.getKorisnickoIme() == null || r.getKorisnickoIme().trim().isEmpty()
                || r.getSifra() == null || r.getSifra().trim().isEmpty()) {
            throw new Exception("Korisničko ime i šifra su obavezni.");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        Radnik unetiRadnik = (Radnik) param;
        List<Radnik> sviRadnici = broker.getAll(new Radnik(), "");

        radnik = null;

        for (Radnik r : sviRadnici) {
            if (r.getKorisnickoIme().equals(unetiRadnik.getKorisnickoIme())
                    && r.getSifra().equals(unetiRadnik.getSifra())) {
                radnik = r;
                return;
            }
        }
    }

    public Radnik getRadnik() {
        return radnik;
    }
}
