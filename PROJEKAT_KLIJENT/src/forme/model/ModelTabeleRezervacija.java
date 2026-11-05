package forme.model;

import domen.Klijent;
import domen.Radnik;
import domen.Rezervacija;
import domen.Status;
import domen.Tretman;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

public class ModelTabeleRezervacija extends OsnovniModelTabele<Rezervacija> {

    private final String[] kolone = {"ID", "Datum", "Klijent", "Radnik", "Broj stavki", "Ukupan iznos"};
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");

    public ModelTabeleRezervacija(List<Rezervacija> lista) { super(lista); }
    @Override public int getColumnCount() { return kolone.length; }
    @Override public String getColumnName(int column) { return kolone[column]; }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Rezervacija r = lista.get(rowIndex);
        switch (columnIndex) {
            case 0: return r.getIdRezervacija();
            case 1: return r.getDatumKreiranja() != null ? sdf.format(r.getDatumKreiranja()) : "";
            case 2: return r.getKlijent();
            case 3: return r.getRadnik();
            case 4: return r.getStavke() != null ? r.getStavke().size() : 0;
            case 5: return r.getUkupanIznos();
            default: return "";
        }
    }

    @Override
    public void pretrazi(Object... kriterijumi) {
          String imePrezNaziv= (String) kriterijumi[0];
 String tekst = (String) kriterijumi[0];
    Klijent izabraniKlijent = (Klijent) kriterijumi[1];
    Radnik izabraniRadnik = (Radnik) kriterijumi[2];
    Tretman izabraniTretman = (Tretman) kriterijumi[3];

    List<Rezervacija> filteredList = lista.stream()
            .filter(r ->
                    (tekst == null
                    || tekst.isEmpty()
                    || r.getKlijent().getIme().toLowerCase().contains(tekst.toLowerCase())
                    || r.getKlijent().getPrezime().toLowerCase().contains(tekst.toLowerCase())
                    || r.getRadnik().getIme().toLowerCase().contains(tekst.toLowerCase())
                    || r.getRadnik().getPrezime().toLowerCase().contains(tekst.toLowerCase()))

                    &&

                    (izabraniKlijent == null
                    || r.getKlijent().getIdKlijent()
                       == izabraniKlijent.getIdKlijent())

                    &&

                    (izabraniRadnik == null
                    || r.getRadnik().getIdRadnik()
                       == izabraniRadnik.getIdRadnik())

                    &&

                    (izabraniTretman == null
                    || (r.getStavke() != null
                        && r.getStavke().stream()
                            .anyMatch(s ->
                                s.getTretman() != null
                                && s.getTretman().getIdTretman()
                                   == izabraniTretman.getIdTretman()
                            )))
            )
            .collect(Collectors.toList());

    this.lista = filteredList;
    fireTableDataChanged();
}
}
