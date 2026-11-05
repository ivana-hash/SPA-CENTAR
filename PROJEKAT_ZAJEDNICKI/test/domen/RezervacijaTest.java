/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
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
public class RezervacijaTest {
    private Rezervacija r;
    private Radnik radnik;
    private Klijent klijent;
    private Date datumKreiranja;
    private Date datumTermina;
    
    public RezervacijaTest() {
    }
    
    
    @Before
    public void setUp() {
        radnik = new Radnik();
        radnik.setIdRadnik(2);
        radnik.setIme("Marko");
        radnik.setPrezime("Marković");

        klijent = new Klijent();
        klijent.setIdKlijent(7);
        klijent.setIme("Ana");
        klijent.setPrezime("Anić");
        
        Calendar c = Calendar.getInstance();
        c.set(2026, Calendar.SEPTEMBER, 21, 0, 0, 0);
        c.set(Calendar.MILLISECOND, 0);
        datumKreiranja = c.getTime();
        c.set(2026, Calendar.SEPTEMBER, 25, 10, 30, 0);
        datumTermina = c.getTime();

        r = new Rezervacija(12, 5000, datumKreiranja, datumTermina, radnik, klijent);
    
        
    }
    
    @After
    public void tearDown() {
         r = null;
    }

    /**
     * Test of getIdRezervacija method, of class Rezervacija.
     */
    @Test
    public void testGetIdRezervacija() {
            assertEquals(12, r.getIdRezervacija());
         }

    /**
     * Test of setIdRezervacija method, of class Rezervacija.
     */
    @Test
    public void testSetIdRezervacija() {
      r.setIdRezervacija(20);
       assertEquals(20, r.getIdRezervacija());
    }

    /**
     * Test of getUkupanIznos method, of class Rezervacija.
     */
    @Test
    public void testGetUkupanIznos() {
        assertEquals(5000, r.getUkupanIznos(), 0.001);
    }

    /**
     * Test of setUkupanIznos method, of class Rezervacija.
     */
    @Test
    public void testSetUkupanIznos() {
         r.setUkupanIznos(7500);
        assertEquals(7500, r.getUkupanIznos(), 0.001);
    }

    /**
     * Test of getDatumKreiranja method, of class Rezervacija.
     */
    @Test
    public void testGetDatumKreiranja() {
         assertEquals(datumKreiranja, r.getDatumKreiranja());
    }
    /**
     * Test of setDatumKreiranja method, of class Rezervacija.
     */
    @Test
    public void testSetDatumKreiranja() {
       Date novi = new Date();
        r.setDatumKreiranja(novi);
        assertEquals(novi, r.getDatumKreiranja());
    
    }
    /**
     * Test of getDatumTermina method, of class Rezervacija.
     */
    @Test
    public void testGetDatumTermina() {
      assertEquals(datumTermina, r.getDatumTermina());
    }

    /**
     * Test of setDatumTermina method, of class Rezervacija.
     */
    @Test
    public void testSetDatumTermina() {
       Date novi = new Date();
        r.setDatumTermina(novi);
        assertEquals(novi, r.getDatumTermina());
     }

    /**
     * Test of getRadnik method, of class Rezervacija.
     */
    @Test
    public void testGetRadnik() {
         assertSame(radnik, r.getRadnik());
         }

    /**
     * Test of setRadnik method, of class Rezervacija.
     */
    @Test
    public void testSetRadnik() {
        Radnik novi = new Radnik();
        novi.setIdRadnik(5);
        r.setRadnik(novi);
        assertSame(novi, r.getRadnik());
   
    }

    /**
     * Test of getKlijent method, of class Rezervacija.
     */
    @Test
    public void testGetKlijent() {
        assertSame(klijent, r.getKlijent());}

    /**
     * Test of setKlijent method, of class Rezervacija.
     */
    @Test
    public void testSetKlijent() {
       Klijent novi = new Klijent();
        novi.setIdKlijent(9);
        r.setKlijent(novi);
        assertSame(novi, r.getKlijent());
    }

    /**
     * Test of getStavke method, of class Rezervacija.
     */
    @Test
    public void testGetStavke() {
        assertNotNull(r.getStavke());
        assertTrue(r.getStavke().isEmpty());
        assertTrue(new Rezervacija().getStavke().isEmpty());
   
          }

    /**
     * Test of setStavke method, of class Rezervacija.
     */
    @Test
    public void testSetStavke() {
        List<StavkaRezervacije> lista = new ArrayList<>();
        lista.add(new StavkaRezervacije());
        r.setStavke(lista);
        assertSame(lista, r.getStavke());
        assertEquals(1, r.getStavke().size());}

    /**
     * Test of toString method, of class Rezervacija.
     */
    @Test
    public void testToString() {
        assertEquals("Rezervacija 12 - Ana Anić", r.toString());
    }

    /**
     * Test of vratiNazivTabele method, of class Rezervacija.
     */
    @Test
    public void testVratiNazivTabele() {
          assertEquals("rezervacija", r.vratiNazivTabele());
    }

    /**
     * Test of vratiKoloneZaUbacivanje method, of class Rezervacija.
     */
    @Test
    public void testVratiKoloneZaUbacivanje() {
         assertEquals("ukupanIznos, datumKreiranja, datumTermina, idRadnik, idKlijent", r.vratiKoloneZaUbacivanje());
    }

    /**
     * Test of vratiVrednostiZaUbacivanje method, of class Rezervacija.
     */
    @Test
    public void testVratiVrednostiZaUbacivanje() {
               assertEquals("5000.0, '2026-09-21', '2026-09-25 10:30:00.0', 2, 7", r.vratiVrednostiZaUbacivanje());
    }

    /**
     * Test of vratiPrimarniKljuc method, of class Rezervacija.
     */
    @Test
    public void testVratiPrimarniKljuc() {
       assertEquals("idRezervacija=12", r.vratiPrimarniKljuc());
    }
    /**
     * Test of vratiVrednostiZaIzmenu method, of class Rezervacija.
     */
    @Test
    public void testVratiVrednostiZaIzmenu() {
  assertEquals("ukupanIznos=5000.0, datumKreiranja='2026-09-21', datumTermina='2026-09-25 10:30:00.0', idRadnik=2, idKlijent=7",
                r.vratiVrednostiZaIzmenu());
    }
    /**
     * Test of vratiListu method, of class Rezervacija.
     */
    
    
}
