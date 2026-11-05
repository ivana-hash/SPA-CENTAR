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
public class PozicijaTest {
     private Pozicija p;

    @Before
    public void setUp() {
        p = new Pozicija("Maser");
    }

    @After
    public void tearDown() {
        p = null;
    }

    @Test
    public void testGetNaziv() {
        assertEquals("Maser", p.getNaziv());
    }

    @Test
    public void testSetNaziv() {
        p.setNaziv("Frizer");
        assertEquals("Frizer", p.getNaziv());
    }

    @Test
    public void testToString() {
        assertEquals("Maser", p.toString());
    }

    @Test
    public void testEqualsIstiNaziv() {
        assertEquals(new Pozicija("Maser"), p);
        assertEquals(new Pozicija("Maser").hashCode(), p.hashCode());
    }

    @Test
    public void testEqualsRazlicitNaziv() {
        assertNotEquals(new Pozicija("Frizer"), p);
    }

    @Test
    public void testVratiNazivTabele() {
        assertEquals("pozicija", p.vratiNazivTabele());
    }

    @Test
    public void testVratiKoloneZaUbacivanje() {
        assertEquals("naziv", p.vratiKoloneZaUbacivanje());
    }

    @Test
    public void testVratiVrednostiZaUbacivanje() {
        assertEquals("'Maser'", p.vratiVrednostiZaUbacivanje());
    }

    @Test
    public void testVratiPrimarniKljuc() {
        assertEquals("naziv='Maser'", p.vratiPrimarniKljuc());
    }

    @Test
    public void testVratiVrednostiZaIzmenu() {
        assertEquals("naziv='Maser'", p.vratiVrednostiZaIzmenu());
    }
}
