/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Date;
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
public class RadnikKvalifikacijaTest {
    
    private RadnikKvalifikacija rk;
    private Radnik radnik;
    private Kvalifikacija kvalifikacija;
    private Date datum;

    public RadnikKvalifikacijaTest() {
    }
    
     @Before
    public void setUp() {
        Calendar c = Calendar.getInstance();
        c.set(2025, Calendar.JUNE, 15, 0, 0, 0);
        c.set(Calendar.MILLISECOND, 0);
        datum = c.getTime();

        radnik = new Radnik();
        radnik.setIdRadnik(3);
        radnik.setIme("Marko");
        radnik.setPrezime("Marković");

        kvalifikacija = new Kvalifikacija(4, "Sertifikat za masažu", "Nivo 1");
        rk = new RadnikKvalifikacija(radnik, kvalifikacija, datum);
    }

    @After
    public void tearDown() {
        rk = null;
    }

    @Test
    public void testGetRadnik() {
        assertSame(radnik, rk.getRadnik());
    }

    @Test
    public void testSetRadnik() {
        Radnik novi = new Radnik();
        novi.setIdRadnik(9);
        rk.setRadnik(novi);
        assertSame(novi, rk.getRadnik());
    }

    @Test
    public void testGetKvalifikacija() {
        assertSame(kvalifikacija, rk.getKvalifikacija());
    }

    @Test
    public void testSetKvalifikacija() {
        Kvalifikacija nova = new Kvalifikacija(6, "Kurs", "Opis");
        rk.setKvalifikacija(nova);
        assertSame(nova, rk.getKvalifikacija());
    }

    @Test
    public void testGetDatumPostizanja() {
        assertEquals(datum, rk.getDatumPostizanja());
    }

    @Test
    public void testSetDatumPostizanja() {
        Date novi = new Date();
        rk.setDatumPostizanja(novi);
        assertEquals(novi, rk.getDatumPostizanja());
    }

    @Test
    public void testToString() {
        assertEquals("Marko Marković - Sertifikat za masažu", rk.toString());
    }

    @Test
    public void testVratiNazivTabele() {
        assertEquals("radnikkvalifikacija", rk.vratiNazivTabele());
    }

    @Test
    public void testVratiKoloneZaUbacivanje() {
        assertEquals("idRadnik, idKvalifikacija, datumPostizanja", rk.vratiKoloneZaUbacivanje());
    }

    @Test
    public void testVratiVrednostiZaUbacivanje() {
        assertEquals("3, 4, '2025-06-15'", rk.vratiVrednostiZaUbacivanje());
    }

    @Test
    public void testVratiPrimarniKljuc() {
        assertEquals("idRadnik=3 AND idKvalifikacija=4", rk.vratiPrimarniKljuc());
    }

    @Test
    public void testVratiVrednostiZaIzmenu() {
        assertEquals("datumPostizanja='2025-06-15'", rk.vratiVrednostiZaIzmenu());
    }

}
