package forme.model;

import domen.Klijent;
import domen.Status;
import java.util.List;
import java.util.stream.Collectors;

public class ModelTabeleKlijent extends OsnovniModelTabele<Klijent> {

    private final String[] kolone = {"ID", "Ime", "Prezime", "Email", "Telefon", "Status"};

    public ModelTabeleKlijent(List<Klijent> lista) {
        super(lista);
    }

    @Override public int getColumnCount() { return kolone.length; }
    @Override public String getColumnName(int column) { return kolone[column]; }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Klijent k = lista.get(rowIndex);
        switch (columnIndex) {
            case 0: return k.getIdKlijent();
            case 1: return k.getIme();
            case 2: return k.getPrezime();
            case 3: return k.getEmailAdresa();
            case 4: return k.getKontaktTelefon();
            case 5: return k.getStatus() != null ? k.getStatus().getNaziv() : "";
            default: return "";
        }
    }


@Override

public void pretrazi(Object... kriterijumi) {

    String imePrezime = (String) kriterijumi[0];
    Status izabraniStatus = (Status) kriterijumi[1];

    List<Klijent> filteredList = lista.stream()
            .filter(k ->
                    (imePrezime == null
                    || imePrezime.isEmpty()
                    || k.getIme().toLowerCase().contains(imePrezime.toLowerCase())
                    || k.getPrezime().toLowerCase().contains(imePrezime.toLowerCase()))

                    &&

                    (izabraniStatus == null
                    || k.getStatus().equals(izabraniStatus))
            )
            .collect(Collectors.toList());

    this.lista = filteredList;
    fireTableDataChanged();
}

}
