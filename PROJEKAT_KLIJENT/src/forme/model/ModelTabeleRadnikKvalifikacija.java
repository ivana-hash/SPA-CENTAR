package forme.model;

import domen.RadnikKvalifikacija;
import java.text.SimpleDateFormat;
import java.util.List;

public class ModelTabeleRadnikKvalifikacija extends OsnovniModelTabele<RadnikKvalifikacija> {

    private final String[] kolone = {"Kvalifikacija", "Datum postizanja"};
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    public ModelTabeleRadnikKvalifikacija(List<RadnikKvalifikacija> lista) { super(lista); }
    @Override public int getColumnCount() { return kolone.length; }
    @Override public String getColumnName(int column) { return kolone[column]; }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RadnikKvalifikacija rk = lista.get(rowIndex);
        switch (columnIndex) {
            case 0: return rk.getKvalifikacija();
            case 1: return rk.getDatumPostizanja() != null ? sdf.format(rk.getDatumPostizanja()) : "";
            default: return "";
        }
    }

    @Override
    public void pretrazi(Object... kriterijumi) {
     }
}
