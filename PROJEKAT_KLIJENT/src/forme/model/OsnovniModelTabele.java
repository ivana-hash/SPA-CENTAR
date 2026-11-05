package forme.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public abstract class OsnovniModelTabele<T> extends AbstractTableModel {

    protected List<T> lista;

    protected OsnovniModelTabele(List<T> lista) {
        this.lista = lista != null ? lista : new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    public List<T> getLista() {
        return lista;
    }

    public void setLista(List<T> lista) {
        this.lista = lista != null ? lista : new ArrayList<>();
        fireTableDataChanged();
    }

    public void dodaj(T objekat) {
        lista.add(objekat);
        fireTableDataChanged();
    }

    public void obrisi(int red) {
        lista.remove(red);
        fireTableDataChanged();
    }

    public T get(int red) {
        return lista.get(red);
    }
    
    public abstract void pretrazi(Object... kriterijumi);
    
}
