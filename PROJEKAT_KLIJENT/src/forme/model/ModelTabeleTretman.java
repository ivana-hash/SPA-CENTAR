package forme.model;

import domen.Status;
import domen.Tretman;
import java.util.List;
import java.util.stream.Collectors;

public class ModelTabeleTretman extends OsnovniModelTabele<Tretman> {

    private final String[] kolone = {"ID", "Naziv", "Cena", "Trajanje (min)", "Benefiti"};

    public ModelTabeleTretman(List<Tretman> lista) { super(lista); }
    @Override public int getColumnCount() { return kolone.length; }
    @Override public String getColumnName(int column) { return kolone[column]; }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Tretman t = lista.get(rowIndex);
        switch (columnIndex) {
            case 0: return t.getIdTretman();
            case 1: return t.getNaziv();
            case 2: return t.getCena();
            case 3: return t.getTrajanjeUMin();
            case 4: return t.getBenefitiTretmana();
            default: return "";
        }
    }

    @Override
    public void pretrazi(Object... kriterijumi) {
          
       String naziv = (String) kriterijumi[0];
      
       List<Tretman> filteredList = lista.stream()
            .filter(t ->
                    (naziv== null
                    || naziv.isEmpty()
                    || t.getNaziv().toLowerCase().contains(naziv.toLowerCase())
               
            )).collect(Collectors.toList());

    this.lista=filteredList;
    fireTableDataChanged();
        }
}
