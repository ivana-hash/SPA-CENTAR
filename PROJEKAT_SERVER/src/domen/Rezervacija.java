package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Rezervacija implements ApstraktniDomenskiObjekat {

    private int idRezervacija;
    private double ukupanIznos;
    private Date datumKreiranja;
    private Radnik radnik;
    private Klijent klijent;
    private List<StavkaRezervacije> stavke;

    public Rezervacija() {
        stavke = new ArrayList<>();
    }

    public Rezervacija(int idRezervacija, double ukupanIznos,
                       Date datumKreiranja, Radnik radnik,
                       Klijent klijent) {
        this.idRezervacija = idRezervacija;
        this.ukupanIznos = ukupanIznos;
        this.datumKreiranja = datumKreiranja;
        this.radnik = radnik;
        this.klijent = klijent;
        this.stavke = new ArrayList<>();
    }

    public int getIdRezervacija() {
        return idRezervacija;
    }

    public void setIdRezervacija(int idRezervacija) {
        this.idRezervacija = idRezervacija;
    }

    public double getUkupanIznos() {
        return ukupanIznos;
    }

    public void setUkupanIznos(double ukupanIznos) {
        this.ukupanIznos = ukupanIznos;
    }

    public Date getDatumKreiranja() {
        return datumKreiranja;
    }

    public void setDatumKreiranja(Date datumKreiranja) {
        this.datumKreiranja = datumKreiranja;
    }

    public Radnik getRadnik() {
        return radnik;
    }

    public void setRadnik(Radnik radnik) {
        this.radnik = radnik;
    }

    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
    }

    public List<StavkaRezervacije> getStavke() {
        return stavke;
    }

    public void setStavke(List<StavkaRezervacije> stavke) {
        this.stavke = stavke;
    }

    @Override
    public String toString() {
        return "Rezervacija " + idRezervacija + " - " + klijent;
    }

    @Override
    public String vratiNazivTabele() {
        return "rezervacija";
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "ukupanIznos, datumKreiranja, idRadnik, idKlijent";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return ukupanIznos + ", '"
                + new java.sql.Date(datumKreiranja.getTime()) + "', "
                + radnik.getIdRadnik() + ", " + klijent.getIdKlijent();
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "idRezervacija=" + idRezervacija;
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "ukupanIznos=" + ukupanIznos
                + ", datumKreiranja='" + new java.sql.Date(datumKreiranja.getTime())
                + "', idRadnik=" + radnik.getIdRadnik()
                + ", idKlijent=" + klijent.getIdKlijent();
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();

        while (rs.next()) {
            lista.add(napraviRezervaciju(rs));
        }

        return lista;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        return napraviRezervaciju(rs);
    }

    private Rezervacija napraviRezervaciju(ResultSet rs) throws Exception {
        Rezervacija r = new Rezervacija();
        r.setIdRezervacija(rs.getInt("idRezervacija"));
        r.setUkupanIznos(rs.getDouble("ukupanIznos"));
        r.setDatumKreiranja(rs.getDate("datumKreiranja"));

        Radnik radnikObj = new Radnik();
        radnikObj.setIdRadnik(rs.getInt("idRadnik"));
        radnikObj.setIme(rs.getString("radnikIme"));
        radnikObj.setPrezime(rs.getString("radnikPrezime"));
        r.setRadnik(radnikObj);

        Klijent klijentObj = new Klijent();
        klijentObj.setIdKlijent(rs.getInt("idKlijent"));
        klijentObj.setIme(rs.getString("klijentIme"));
        klijentObj.setPrezime(rs.getString("klijentPrezime"));
        klijentObj.setEmailAdresa(rs.getString("klijentEmailAdresa"));
        klijentObj.setKontaktTelefon(rs.getString("klijentKontaktTelefon"));
        r.setKlijent(klijentObj);

        r.setStavke(new ArrayList<>());
        return r;
    }
}
