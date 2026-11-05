package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Tretman implements ApstraktniDomenskiObjekat {

    private int idTretman;
    private String naziv;
    private double cena;
    private int trajanjeUMin;
    private String benefitiTretmana;

    public Tretman() {
    }

    public Tretman(int idTretman, String naziv, double cena,
                   int trajanjeUMin, String benefitiTretmana) {
        this.idTretman = idTretman;
        this.naziv = naziv;
        this.cena = cena;
        this.trajanjeUMin = trajanjeUMin;
        this.benefitiTretmana = benefitiTretmana;
    }

    public int getIdTretman() {
        return idTretman;
    }

    public void setIdTretman(int idTretman) {
        this.idTretman = idTretman;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public int getTrajanjeUMin() {
        return trajanjeUMin;
    }

    public void setTrajanjeUMin(int trajanjeUMin) {
        this.trajanjeUMin = trajanjeUMin;
    }

    public String getBenefitiTretmana() {
        return benefitiTretmana;
    }

    public void setBenefitiTretmana(String benefitiTretmana) {
        this.benefitiTretmana = benefitiTretmana;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public String vratiNazivTabele() {
        return "tretman";
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "naziv, cena, trajanjeUMin, benefitiTretmana";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'" + naziv + "', " + cena + ", " +
                trajanjeUMin + ", '" + benefitiTretmana + "'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "idTretman=" + idTretman;
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "naziv='" + naziv +
                "', cena=" + cena +
                ", trajanjeUMin=" + trajanjeUMin +
                ", benefitiTretmana='" + benefitiTretmana + "'";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();

        while (rs.next()) {
            Tretman t = new Tretman();
            t.setIdTretman(rs.getInt("idTretman"));
            t.setNaziv(rs.getString("naziv"));
            t.setCena(rs.getDouble("cena"));
            t.setTrajanjeUMin(rs.getInt("trajanjeUMin"));
            t.setBenefitiTretmana(rs.getString("benefitiTretmana"));

            lista.add(t);
        }

        return lista;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        Tretman t = new Tretman();
        t.setIdTretman(rs.getInt("idTretman"));
        t.setNaziv(rs.getString("naziv"));
        t.setCena(rs.getDouble("cena"));
        t.setTrajanjeUMin(rs.getInt("trajanjeUMin"));
        t.setBenefitiTretmana(rs.getString("benefitiTretmana"));

        return t;
    }
}