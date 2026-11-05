/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author HomePC
 */
public class Pozicija implements ApstraktniDomenskiObjekat {
    private String naziv;

    public Pozicija() {
    }

    public Pozicija(String naziv) {
        this.naziv = naziv;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
      @Override
    public String toString() {
        return naziv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pozicija)) return false;
        return Objects.equals(naziv, ((Pozicija) o).naziv);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(naziv);
    }

    @Override
    public String vratiNazivTabele() {
           return "pozicija";
       }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
         List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            lista.add(new Pozicija(rs.getString("naziv")));
        }
        return lista; 
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "naziv";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
          return "'" + naziv + "'";
    }

    @Override
    public String vratiPrimarniKljuc() {
           return "naziv='" + naziv + "'";
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
            return new Pozicija(rs.getString("naziv"));
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
       return "naziv='" + naziv + "'";
    }
    
}
