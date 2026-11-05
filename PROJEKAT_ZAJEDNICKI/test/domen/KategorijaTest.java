/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author HomePC
 */
public class KategorijaTest {
    
    private Kategorija k;

    @Before
    public void setUp() {
        k = new Kategorija("Masaža", new Pozicija("Maser"));
    }

    @After
    public void tearDown() {
        k = null;
    }

    @Test
    public void testGetNaziv() {
        assertEquals("Masaža", k.getNaziv());
    }

    @Test
    public void testSetNaziv() {
        k.setNaziv("Wellness tretman");
        assertEquals("Wellness tretman", k.getNaziv());
    }

    @Test
    public void testGetPozicija() {
        assertEquals("Maser", k.getPozicija().getNaziv());
    }

    @Test
    public void testSetPozicija() {
        k.setPozicija(new Pozicija("Wellness terapeut"));
        assertEquals("Wellness terapeut", k.getPozicija().getNaziv());
    }

    @Test
    public void testToString() {
        assertEquals("Masaža", k.toString());
    }

    @Test
    public void testEqualsIstiNaziv() {
        assertEquals(new Kategorija("Masaža"), k);
    }

    @Test
    public void testEqualsRazlicitNaziv() {
        assertNotEquals(new Kategorija("Beauty tretman"), k);
    }

    @Test
    public void testVratiNazivTabele() {
        assertEquals("kategorija", k.vratiNazivTabele());
    }

    @Test
    public void testVratiKoloneZaUbacivanje() {
        assertEquals("naziv, pozicija", k.vratiKoloneZaUbacivanje());
    }

    @Test
    public void testVratiVrednostiZaUbacivanje() {
        assertEquals("'Masaža', 'Maser'", k.vratiVrednostiZaUbacivanje());
    }

    @Test
    public void testVratiPrimarniKljuc() {
        assertEquals("naziv='Masaža'", k.vratiPrimarniKljuc());
    }

    @Test
    public void testVratiVrednostiZaIzmenu() {
        assertEquals("pozicija='Maser'", k.vratiVrednostiZaIzmenu());
    }
    
}
