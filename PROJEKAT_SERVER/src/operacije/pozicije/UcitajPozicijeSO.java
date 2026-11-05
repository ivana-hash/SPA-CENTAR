/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.pozicije;

import operacije.ApstraktnaGenerickaOperacija;

import domen.ApstraktniDomenskiObjekat;
import domen.Pozicija;
import java.util.List;

/**
 *
 * @author HomePC
 */
public class UcitajPozicijeSO extends ApstraktnaGenerickaOperacija  {

    
    private List<Pozicija> pozicije;
    
    
    @Override
    protected void preduslovi(Object param) throws Exception {
               // Nema posebnih preduslova.
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
          pozicije = broker.getAll(new Pozicija(), kljuc != null ? kljuc : "");
  
    }

public List<Pozicija> getPozicije() {
        return pozicije;
    }
    
}
