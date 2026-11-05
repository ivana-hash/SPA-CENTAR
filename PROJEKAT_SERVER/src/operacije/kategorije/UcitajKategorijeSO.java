/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.kategorije;

import domen.Kategorija;
import java.util.List;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author HomePC
 */
public class UcitajKategorijeSO extends ApstraktnaGenerickaOperacija {
    private List<Kategorija> kategorije;
    @Override
    protected void preduslovi(Object param) throws Exception {
            // Nema posebnih preduslova.
        }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
      kategorije = broker.getAll(new Kategorija(), kljuc != null ? kljuc : "");
    }

    public List<Kategorija> getKategorije() {
        return kategorije;
    }
    
}
