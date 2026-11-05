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
public class KvalifikacijaTest {
    
    private Kvalifikacija k;
    
    public KvalifikacijaTest() {
    }
    
 @Before
    public void setUp() {
        k = new Kvalifikacija(4, "Sertifikat za masažu", "Švedska masaža, nivo 1");
    }

    @After
    public void tearDown() {
        k = null;
    }

    @Test
    public void testGetIdKvalifikacija() {
        assertEquals(4, k.getIdKvalifikacija());
    }

    @Test
    public void testSetIdKvalifikacija() {
        k.setIdKvalifikacija(8);
        assertEquals(8, k.getIdKvalifikacija());
    }

    @Test
    public void testGetNaziv() {
        assertEquals("Sertifikat za masažu", k.getNaziv());
    }

    @Test
    public void testSetNaziv() {
        k.setNaziv("Kurs kozmetike");
        assertEquals("Kurs kozmetike", k.getNaziv());
    }

    @Test
    public void testGetOpis() {
        assertEquals("Švedska masaža, nivo 1", k.getOpis());
    }

    @Test
    public void testSetOpis() {
        k.setOpis("Novi opis");
        assertEquals("Novi opis", k.getOpis());
    }

    @Test
    public void testToString() {
        assertEquals("Sertifikat za masažu", k.toString());
    }

    @Test
    public void testVratiNazivTabele() {
        assertEquals("kvalifikacija", k.vratiNazivTabele());
    }

    @Test
    public void testVratiKoloneZaUbacivanje() {
        assertEquals("naziv, opis", k.vratiKoloneZaUbacivanje());
    }

    @Test
    public void testVratiVrednostiZaUbacivanje() {
        assertEquals("'Sertifikat za masažu', 'Švedska masaža, nivo 1'", k.vratiVrednostiZaUbacivanje());
    }

    @Test
    public void testVratiPrimarniKljuc() {
        assertEquals("idKvalifikacija=4", k.vratiPrimarniKljuc());
    }

    @Test
    public void testVratiVrednostiZaIzmenu() {
        assertEquals("naziv='Sertifikat za masažu', opis='Švedska masaža, nivo 1'", k.vratiVrednostiZaIzmenu());
    }
    
}
