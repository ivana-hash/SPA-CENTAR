package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StavkaRezervacije implements ApstraktniDomenskiObjekat {

    private int rb;
    private double cena;
    private int brojPaketaTretmana;
    private double iznosStavke;
    private int rezervacijaId;
    private Tretman tretman;

    public StavkaRezervacije() {
    }

    public StavkaRezervacije(int rb, double cena,
                             int brojPaketaTretmana,
                             double iznosStavke,
                             int rezervacijaId,
                             Tretman tretman) {
        this.rb = rb;
        this.cena = cena;
        this.brojPaketaTretmana = brojPaketaTretmana;
        this.iznosStavke = iznosStavke;
        this.rezervacijaId = rezervacijaId;
        this.tretman = tretman;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public int getBrojPaketaTretmana() {
        return brojPaketaTretmana;
    }

    public void setBrojPaketaTretmana(int brojPaketaTretmana) {
        this.brojPaketaTretmana = brojPaketaTretmana;
    }

    public double getIznosStavke() {
        return iznosStavke;
    }

    public void setIznosStavke(double iznosStavke) {
        this.iznosStavke = iznosStavke;
    }

    public int getRezervacijaId() {
        return rezervacijaId;
    }

    public void setRezervacijaId(int rezervacijaId) {
        this.rezervacijaId = rezervacijaId;
    }

    public Tretman getTretman() {
        return tretman;
    }

    public void setTretman(Tretman tretman) {
        this.tretman = tretman;
    }

    @Override
    public String toString() {
        return rb + ". " + (tretman != null ? tretman.getNaziv() : "")
                + " - " + brojPaketaTretmana + " paket/a";
    }

    @Override
    public String vratiNazivTabele() {
        return "stavkarezervacije";
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "rb, cena, brojPaketaTretmana, iznosStavke, idRezervacija, idTretman";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return rb + ", " + cena + ", " + brojPaketaTretmana + ", "
                + iznosStavke + ", " + rezervacijaId + ", "
                + tretman.getIdTretman();
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "idRezervacija=" + rezervacijaId + " AND rb=" + rb;
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "cena=" + cena
                + ", brojPaketaTretmana=" + brojPaketaTretmana
                + ", iznosStavke=" + iznosStavke
                + ", idTretman=" + tretman.getIdTretman();
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();

        while (rs.next()) {
            lista.add(napraviStavku(rs));
        }

        return lista;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        return napraviStavku(rs);
    }

    private StavkaRezervacije napraviStavku(ResultSet rs) throws Exception {
        StavkaRezervacije sr = new StavkaRezervacije();
        sr.setRb(rs.getInt("rb"));
        sr.setCena(rs.getDouble("cena"));
        sr.setBrojPaketaTretmana(rs.getInt("brojPaketaTretmana"));
        sr.setIznosStavke(rs.getDouble("iznosStavke"));
        sr.setRezervacijaId(rs.getInt("idRezervacija"));

        Tretman t = new Tretman();
        t.setIdTretman(rs.getInt("idTretman"));
        t.setNaziv(rs.getString("tretmanNaziv"));
        t.setCena(rs.getDouble("tretmanCena"));
        t.setTrajanjeUMin(rs.getInt("tretmanTrajanjeUMin"));
        t.setBenefitiTretmana(rs.getString("tretmanBenefitiTretmana"));
        sr.setTretman(t);

        return sr;
    }
}
