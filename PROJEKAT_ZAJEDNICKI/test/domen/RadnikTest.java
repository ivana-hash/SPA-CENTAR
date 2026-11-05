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
public class RadnikTest {
    
    private Radnik r;
    private Date datum;
    
   
    @Before
    public void setUp() {
        Calendar c = Calendar.getInstance();
        c.set(2024, Calendar.MARCH, 1, 0, 0, 0);
        c.set(Calendar.MILLISECOND, 0);
        datum = c.getTime();
         r = new Radnik(3, "Marko", "Marković", datum, new Pozicija("Maser"), "marko", "lozinka1");
    }

    @After
    public void tearDown() {
        r = null;
    }

    @Test
    public void testGetIdRadnik() {
        assertEquals(3, r.getIdRadnik());
    }

    @Test
    public void testSetIdRadnik() {
        r.setIdRadnik(10);
        assertEquals(10, r.getIdRadnik());
    }

    @Test
    public void testGetIme() {
        assertEquals("Marko", r.getIme());
    }

    @Test
    public void testSetIme() {
        r.setIme("Petar");
        assertEquals("Petar", r.getIme());
    }

    @Test
    public void testGetPrezime() {
        assertEquals("Marković", r.getPrezime());
    }

    @Test
    public void testSetPrezime() {
        r.setPrezime("Petrović");
        assertEquals("Petrović", r.getPrezime());
    }

    @Test
    public void testGetDatumZaposlenja() {
        assertEquals(datum, r.getDatumZaposlenja());
    }

    @Test
    public void testSetDatumZaposlenja() {
        Date novi = new Date();
        r.setDatumZaposlenja(novi);
        assertEquals(novi, r.getDatumZaposlenja());
    }

    @Test
    public void testGetPozicija() {
        assertEquals("Maser", r.getPozicija().getNaziv());
    }

    @Test
    public void testSetPozicija() {
      r.setPozicija(new Pozicija("Frizer"));
assertEquals("Frizer", r.getPozicija().getNaziv());
    }


    @Test
    public void testGetKorisnickoIme() {
        assertEquals("marko", r.getKorisnickoIme());
    }

    @Test
    public void testSetKorisnickoIme() {
        r.setKorisnickoIme("marko1");
        assertEquals("marko1", r.getKorisnickoIme());
    }

    @Test
    public void testGetSifra() {
        assertEquals("lozinka1", r.getSifra());
    }

    @Test
    public void testSetSifra() {
        r.setSifra("nova");
        assertEquals("nova", r.getSifra());
    }

    @Test
    public void testGetKvalifikacijePodrazumevano() {
        assertNotNull(r.getKvalifikacije());
        assertTrue(r.getKvalifikacije().isEmpty());
    }

    @Test
    public void testSetKvalifikacije() {
        List<RadnikKvalifikacija> lista = new ArrayList<>();
        lista.add(new RadnikKvalifikacija(r, new Kvalifikacija(1, "K", "O"), datum));
        r.setKvalifikacije(lista);
        assertEquals(1, r.getKvalifikacije().size());
        assertSame(lista, r.getKvalifikacije());
    }

    @Test
    public void testToString() {
        assertEquals("Marko Marković", r.toString());
    }

    @Test
    public void testVratiNazivTabele() {
        assertEquals("radnik", r.vratiNazivTabele());
    }

    @Test
    public void testVratiKoloneZaUbacivanje() {
        assertEquals("ime, prezime, datumZaposlenja, pozicija, korisnickoIme, sifra", r.vratiKoloneZaUbacivanje());
    }

    @Test
    public void testVratiVrednostiZaUbacivanje() {
        assertEquals("'Marko', 'Marković', '2024-03-01', 'Maser', 'marko', 'lozinka1'", r.vratiVrednostiZaUbacivanje());
    }

    @Test
    public void testVratiPrimarniKljuc() {
        assertEquals("idRadnik=3", r.vratiPrimarniKljuc());
    }

    @Test
    public void testVratiVrednostiZaIzmenu() {
        assertEquals("ime='Marko', prezime='Marković', datumZaposlenja='2024-03-01', pozicija='Maser', korisnickoIme='marko', sifra='lozinka1'",
                r.vratiVrednostiZaIzmenu());
    }
}
