package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Klijent implements ApstraktniDomenskiObjekat {

    private int idKlijent;
    private String ime;
    private String prezime;
    private String emailAdresa;
    private String kontaktTelefon;
    private Status status;

    public Klijent() {
    }

    public Klijent(int idKlijent, String ime, String prezime,
                   String emailAdresa, String kontaktTelefon,
                   Status status) {
        this.idKlijent = idKlijent;
        this.ime = ime;
        this.prezime = prezime;
        this.emailAdresa = emailAdresa;
        this.kontaktTelefon = kontaktTelefon;
        this.status = status;
    }

    public int getIdKlijent() {
        return idKlijent;
    }

    public void setIdKlijent(int idKlijent) {
        this.idKlijent = idKlijent;
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

    public String getEmailAdresa() {
        return emailAdresa;
    }

    public void setEmailAdresa(String emailAdresa) {
        this.emailAdresa = emailAdresa;
    }

    public String getKontaktTelefon() {
        return kontaktTelefon;
    }

    public void setKontaktTelefon(String kontaktTelefon) {
        this.kontaktTelefon = kontaktTelefon;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public String vratiNazivTabele() {
        return "klijent";
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "ime, prezime, emailAdresa, kontaktTelefon, idStatus";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'" + ime + "', '" + prezime + "', '"
                + emailAdresa + "', '" + kontaktTelefon + "', "
                + status.getIdStatus();
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "idKlijent=" + idKlijent;
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "ime='" + ime
                + "', prezime='" + prezime
                + "', emailAdresa='" + emailAdresa
                + "', kontaktTelefon='" + kontaktTelefon
                + "', idStatus=" + status.getIdStatus();
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();

        while (rs.next()) {
            lista.add(napraviKlijenta(rs));
        }

        return lista;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        return napraviKlijenta(rs);
    }

    private Klijent napraviKlijenta(ResultSet rs) throws Exception {
        Klijent k = new Klijent();
        k.setIdKlijent(rs.getInt("idKlijent"));
        k.setIme(rs.getString("ime"));
        k.setPrezime(rs.getString("prezime"));
        k.setEmailAdresa(rs.getString("emailAdresa"));
        k.setKontaktTelefon(rs.getString("kontaktTelefon"));

        Status s = new Status();
        s.setIdStatus(rs.getInt("idStatus"));
        s.setNaziv(rs.getString("statusNaziv"));
        s.setDatumPostizanja(rs.getDate("statusDatumPostizanja"));
        s.setPogodnosti(rs.getString("statusPogodnosti"));
        k.setStatus(s);

        return k;
    }
}
