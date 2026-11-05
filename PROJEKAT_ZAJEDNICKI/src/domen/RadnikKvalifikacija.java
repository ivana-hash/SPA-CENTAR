package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RadnikKvalifikacija implements ApstraktniDomenskiObjekat {

    private Radnik radnik;
    private Kvalifikacija kvalifikacija;
    private Date datumPostizanja;

    public RadnikKvalifikacija() {
    }

    public RadnikKvalifikacija(Radnik radnik,
                               Kvalifikacija kvalifikacija,
                               Date datumPostizanja) {
        this.radnik = radnik;
        this.kvalifikacija = kvalifikacija;
        this.datumPostizanja = datumPostizanja;
    }

    public Radnik getRadnik() {
        return radnik;
    }

    public void setRadnik(Radnik radnik) {
        this.radnik = radnik;
    }

    public Kvalifikacija getKvalifikacija() {
        return kvalifikacija;
    }

    public void setKvalifikacija(Kvalifikacija kvalifikacija) {
        this.kvalifikacija = kvalifikacija;
    }

    public Date getDatumPostizanja() {
        return datumPostizanja;
    }

    public void setDatumPostizanja(Date datumPostizanja) {
        this.datumPostizanja = datumPostizanja;
    }

    @Override
    public String toString() {
        return radnik + " - " + kvalifikacija;
    }

    @Override
    public String vratiNazivTabele() {
        return "radnikkvalifikacija";
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "idRadnik, idKvalifikacija, datumPostizanja";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return radnik.getIdRadnik() + ", " +
                kvalifikacija.getIdKvalifikacija() + ", '" +
                new java.sql.Date(datumPostizanja.getTime()) + "'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "idRadnik=" + radnik.getIdRadnik() +
                " AND idKvalifikacija=" +
                kvalifikacija.getIdKvalifikacija();
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "datumPostizanja='" +
                new java.sql.Date(datumPostizanja.getTime()) + "'";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();

        while (rs.next()) {
            RadnikKvalifikacija rk = new RadnikKvalifikacija();

            Radnik r = new Radnik();
            r.setIdRadnik(rs.getInt("idRadnik"));
            r.setIme(rs.getString("radnikIme"));
            r.setPrezime(rs.getString("radnikPrezime"));
            rk.setRadnik(r);

            Kvalifikacija k = new Kvalifikacija();
            k.setIdKvalifikacija(rs.getInt("idKvalifikacija"));
            k.setNaziv(rs.getString("kvalifikacijaNaziv"));
            k.setOpis(rs.getString("kvalifikacijaOpis"));
            rk.setKvalifikacija(k);

            rk.setDatumPostizanja(rs.getDate("datumPostizanja"));

            lista.add(rk);
        }

        return lista;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        RadnikKvalifikacija rk = new RadnikKvalifikacija();

        Radnik r = new Radnik();
        r.setIdRadnik(rs.getInt("idRadnik"));
        r.setIme(rs.getString("radnikIme"));
        r.setPrezime(rs.getString("radnikPrezime"));
        rk.setRadnik(r);

        Kvalifikacija k = new Kvalifikacija();
        k.setIdKvalifikacija(rs.getInt("idKvalifikacija"));
        k.setNaziv(rs.getString("kvalifikacijaNaziv"));
        k.setOpis(rs.getString("kvalifikacijaOpis"));
        rk.setKvalifikacija(k);

        rk.setDatumPostizanja(rs.getDate("datumPostizanja"));

        return rk;
    }
}