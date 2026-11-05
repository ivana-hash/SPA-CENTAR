package forme.model;

import domen.StavkaRezervacije;
import java.util.List;

public class ModelTabeleStavkaRezervacije extends OsnovniModelTabele<StavkaRezervacije> {

    private final String[] kolone = {"RB", "Tretman", "Cena", "Broj paketa", "Iznos stavke"};

    public ModelTabeleStavkaRezervacije(List<StavkaRezervacije> lista) { super(lista); }
    @Override public int getColumnCount() { return kolone.length; }
    @Override public String getColumnName(int column) { return kolone[column]; }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkaRezervacije s = lista.get(rowIndex);
        switch (columnIndex) {
            case 0: return rowIndex + 1;
            case 1: return s.getTretman();
            case 2: return s.getCena();
            case 3: return s.getBrojPaketaTretmana();
            case 4: return s.getIznosStavke();
            default: return "";
        }
    }

    public double izracunajUkupanIznos() {
        return lista.stream().mapToDouble(StavkaRezervacije::getIznosStavke).sum();
    }

    @Override
    public void pretrazi(Object... kriterijumi) {
     }
}
