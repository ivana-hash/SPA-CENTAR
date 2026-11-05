package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Kvalifikacija implements ApstraktniDomenskiObjekat {

    private int idKvalifikacija;
    private String naziv;
    private String opis;

    public Kvalifikacija() {
    }

    public Kvalifikacija(int idKvalifikacija, String naziv, String opis) {
        this.idKvalifikacija = idKvalifikacija;
        this.naziv = naziv;
        this.opis = opis;
    }

    public int getIdKvalifikacija() {
        return idKvalifikacija;
    }

    public void setIdKvalifikacija(int idKvalifikacija) {
        this.idKvalifikacija = idKvalifikacija;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public String vratiNazivTabele() {
        return "kvalifikacija";
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "naziv, opis";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'" + naziv + "', '" + opis + "'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "idKvalifikacija=" + idKvalifikacija;
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "naziv='" + naziv + "', opis='" + opis + "'";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();

        while (rs.next()) {
            Kvalifikacija k = new Kvalifikacija();
            k.setIdKvalifikacija(rs.getInt("idKvalifikacija"));
            k.setNaziv(rs.getString("naziv"));
            k.setOpis(rs.getString("opis"));

            lista.add(k);
        }

        return lista;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        Kvalifikacija k = new Kvalifikacija();
        k.setIdKvalifikacija(rs.getInt("idKvalifikacija"));
        k.setNaziv(rs.getString("naziv"));
        k.setOpis(rs.getString("opis"));

        return k;
    }
}