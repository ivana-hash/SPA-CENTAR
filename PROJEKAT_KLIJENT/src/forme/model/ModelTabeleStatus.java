package forme.model;

import domen.Kvalifikacija;
import domen.Status;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

public class ModelTabeleStatus extends OsnovniModelTabele<Status> {

    private final String[] kolone = {"ID", "Naziv", "Datum postizanja", "Pogodnosti"};
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");

    public ModelTabeleStatus(List<Status> lista) { super(lista); }
    @Override public int getColumnCount() { return kolone.length; }
    @Override public String getColumnName(int column) { return kolone[column]; }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Status s = lista.get(rowIndex);
        switch (columnIndex) {
            case 0: return s.getIdStatus();
            case 1: return s.getNaziv();
            case 2: return s.getDatumPostizanja() != null ? sdf.format(s.getDatumPostizanja()) : "";
            case 3: return s.getPogodnosti();
            default: return "";
        }
    }

    @Override
    public void pretrazi(Object... kriterijumi) {
        
       String naziv = (String) kriterijumi[0];
      
       List<Status> filteredList = lista.stream()
            .filter(s ->
                    (naziv== null
                    || naziv.isEmpty()
                    || s.getNaziv().toLowerCase().contains(naziv.toLowerCase())
               
            )).collect(Collectors.toList());

    this.lista=filteredList;
    fireTableDataChanged();
        }
}
