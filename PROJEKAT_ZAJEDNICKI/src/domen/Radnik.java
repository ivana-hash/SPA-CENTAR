package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Radnik implements ApstraktniDomenskiObjekat {

    private int idRadnik;
    private String ime;
    private String prezime;
    private Date datumZaposlenja;
    private String pozicija;
    private String korisnickoIme;
    private String sifra;

    public Radnik() {
    }

    public Radnik(int idRadnik, String ime, String prezime,
                  Date datumZaposlenja, String pozicija,
                  String korisnickoIme, String sifra) {
        this.idRadnik = idRadnik;
        this.ime = ime;
        this.prezime = prezime;
        this.datumZaposlenja = datumZaposlenja;
        this.pozicija = pozicija;
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
    }

    public int getIdRadnik() {
        return idRadnik;
    }

    public void setIdRadnik(int idRadnik) {
        this.idRadnik = idRadnik;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Date getDatumZaposlenja() {
        return datumZaposlenja;
    }

    public void setDatumZaposlenja(Date datumZaposlenja) {
        this.datumZaposlenja = datumZaposlenja;
    }

    public String getPozicija() {
        return pozicija;
    }

    public void setPozicija(String pozicija) {
        this.pozicija = pozicija;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public String vratiNazivTabele() {
        return "radnik";
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "ime, prezime, datumZaposlenja, pozicija, korisnickoIme, sifra";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'" + ime + "', '" + prezime + "', '" +
                new java.sql.Date(datumZaposlenja.getTime()) + "', '" +
                pozicija + "', '" + korisnickoIme + "', '" + sifra + "'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "idRadnik=" + idRadnik;
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "ime='" + ime +
                "', prezime='" + prezime +
                "', datumZaposlenja='" +
                new java.sql.Date(datumZaposlenja.getTime()) +
                "', pozicija='" + pozicija +
                "', korisnickoIme='" + korisnickoIme +
                "', sifra='" + sifra + "'";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();

        while (rs.next()) {
            Radnik r = new Radnik();
            r.setIdRadnik(rs.getInt("idRadnik"));
            r.setIme(rs.getString("ime"));
            r.setPrezime(rs.getString("prezime"));
            r.setDatumZaposlenja(rs.getDate("datumZaposlenja"));
            r.setPozicija(rs.getString("pozicija"));
            r.setKorisnickoIme(rs.getString("korisnickoIme"));
            r.setSifra(rs.getString("sifra"));

            lista.add(r);
        }

        return lista;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        Radnik r = new Radnik();
        r.setIdRadnik(rs.getInt("idRadnik"));
        r.setIme(rs.getString("ime"));
        r.setPrezime(rs.getString("prezime"));
        r.setDatumZaposlenja(rs.getDate("datumZaposlenja"));
        r.setPozicija(rs.getString("pozicija"));
        r.setKorisnickoIme(rs.getString("korisnickoIme"));
        r.setSifra(rs.getString("sifra"));

        return r;
    }
}