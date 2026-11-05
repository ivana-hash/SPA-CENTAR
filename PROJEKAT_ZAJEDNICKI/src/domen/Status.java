package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Status implements ApstraktniDomenskiObjekat {

    private int idStatus;
    private String naziv;
    private Date datumPostizanja;
    private String pogodnosti;

    public Status() {
    }

    public Status(int idStatus, String naziv,
                  Date datumPostizanja, String pogodnosti) {
        this.idStatus = idStatus;
        this.naziv = naziv;
        this.datumPostizanja = datumPostizanja;
        this.pogodnosti = pogodnosti;
    }

    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Date getDatumPostizanja() {
        return datumPostizanja;
    }

    public void setDatumPostizanja(Date datumPostizanja) {
        this.datumPostizanja = datumPostizanja;
    }

    public String getPogodnosti() {
        return pogodnosti;
    }

    public void setPogodnosti(String pogodnosti) {
        this.pogodnosti = pogodnosti;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public String vratiNazivTabele() {
        return "status";
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "naziv, datumPostizanja, pogodnosti";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'" + naziv + "', '" +
                new java.sql.Date(datumPostizanja.getTime()) +
                "', '" + pogodnosti + "'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "idStatus=" + idStatus;
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "naziv='" + naziv +
                "', datumPostizanja='" +
                new java.sql.Date(datumPostizanja.getTime()) +
                "', pogodnosti='" + pogodnosti + "'";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();

        while (rs.next()) {
            Status s = new Status();
            s.setIdStatus(rs.getInt("idStatus"));
            s.setNaziv(rs.getString("naziv"));
            s.setDatumPostizanja(rs.getDate("datumPostizanja"));
            s.setPogodnosti(rs.getString("pogodnosti"));

            lista.add(s);
        }

        return lista;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        Status s = new Status();
        s.setIdStatus(rs.getInt("idStatus"));
        s.setNaziv(rs.getString("naziv"));
        s.setDatumPostizanja(rs.getDate("datumPostizanja"));
        s.setPogodnosti(rs.getString("pogodnosti"));

        return s;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Status other = (Status) obj;
        return this.idStatus == other.idStatus;
    }
    
    
}