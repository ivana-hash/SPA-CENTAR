package forme.model;

import domen.Klijent;
import domen.Radnik;
import domen.Status;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

public class ModelTabeleRadnik extends OsnovniModelTabele<Radnik> {

    private final String[] kolone = {
        "ID", "Ime", "Prezime", "Zaposlen", "Pozicija", "Korisničko ime"
    };
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");

    public ModelTabeleRadnik(List<Radnik> lista) {
        super(lista);
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Radnik r = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return r.getIdRadnik();
            case 1:
                return r.getIme();
            case 2:
                return r.getPrezime();
            case 3:
                return r.getDatumZaposlenja() != null
                        ? sdf.format(r.getDatumZaposlenja()) : "";
            case 4:
                return r.getPozicija();
            case 5:
                return r.getKorisnickoIme();
            default:
                return "";
        }
    }

    @Override
    public void pretrazi(Object... kriterijumi) {
   
        String imePrezPoz=(String) kriterijumi[0];

     List<Radnik> filteredList = lista.stream()
            .filter(k ->
                    (imePrezPoz == null
                    || imePrezPoz.isEmpty()
                    || k.getIme().toLowerCase().contains(imePrezPoz.toLowerCase())
                    || k.getPrezime().toLowerCase().contains(imePrezPoz.toLowerCase()))
                    ||
                       k.getPozicija().toLowerCase().contains(imePrezPoz.toLowerCase())
            )
            .collect(Collectors.toList());

    this.lista=filteredList;
    fireTableDataChanged();}
}
