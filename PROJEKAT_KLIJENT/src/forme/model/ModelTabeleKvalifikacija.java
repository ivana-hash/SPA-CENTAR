package forme.model;

import domen.Klijent;
import domen.Kvalifikacija;
import java.util.List;
import java.util.stream.Collectors;

public class ModelTabeleKvalifikacija extends OsnovniModelTabele<Kvalifikacija> {

    private final String[] kolone = {"ID", "Naziv", "Opis"};

    public ModelTabeleKvalifikacija(List<Kvalifikacija> lista) { super(lista); }
    @Override public int getColumnCount() { return kolone.length; }
    @Override public String getColumnName(int column) { return kolone[column]; }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Kvalifikacija k = lista.get(rowIndex);
        switch (columnIndex) {
            case 0: return k.getIdKvalifikacija();
            case 1: return k.getNaziv();
            case 2: return k.getOpis();
            default: return "";
        }
    }

    @Override
    public void pretrazi(Object... kriterijumi) {
      String naziv = (String) kriterijumi[0];
      
       List<Kvalifikacija> filteredList = lista.stream()
            .filter(k ->
                    (naziv== null
                    || naziv.isEmpty()
                    || k.getNaziv().toLowerCase().contains(naziv.toLowerCase())
               
            )).collect(Collectors.toList());

    this.lista=filteredList;
    fireTableDataChanged();
      
      
       }
}
