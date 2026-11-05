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
public class Kategorija implements ApstraktniDomenskiObjekat {
 private String naziv;
 private Pozicija pozicija;

    public Kategorija() {
    }
    public Kategorija(String naziv) {
        this.naziv = naziv;
    }
    public Kategorija(String naziv, Pozicija pozicija) {
        this.naziv = naziv;
        this.pozicija = pozicija;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Pozicija getPozicija() {
        return pozicija;
    }

    public void setPozicija(Pozicija pozicija) {
        this.pozicija = pozicija;
    }

  @Override
    public String toString() {
        return naziv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Kategorija)) return false;
        return Objects.equals(naziv, ((Kategorija) o).naziv);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(naziv);
    }

    
    @Override
    public String vratiNazivTabele() {
              return "kategorija";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {  List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            lista.add(vratiObjekatIzRS(rs));
        }
        return lista;
         }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "naziv, pozicija";
      }

    @Override
    public String vratiVrednostiZaUbacivanje() {
       return "'" + naziv + "', '" + pozicija.getNaziv() + "'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "naziv='" + naziv + "'";
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
    return new Kategorija(rs.getString("naziv"), new Pozicija(rs.getString("pozicija")));  
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
         return "pozicija='" + pozicija.getNaziv() + "'";
    }
    
}
