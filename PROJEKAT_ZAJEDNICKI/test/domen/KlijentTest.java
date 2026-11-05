/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package domen;

import java.sql.ResultSet;
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
public class KlijentTest {
    private Klijent k;
    private Status status;
    
    public KlijentTest() {
    }
   
    
    @Before
    public void setUp() {
      status = new Status(2, "Zlatni", new Date(), "10% popusta");
      k = new Klijent(7, "Ana", "Anić", "ana@gmail.com", "0641234567", status);
    }
    
    @After
    public void tearDown() {
       k = null;
       status = null;
    }

    @Test
    public void testGetIdKlijent() {      
        assertEquals(7, k.getIdKlijent());
          }

    /**
     * Test of setIdKlijent method, of class Klijent.
     */
    @Test
    public void testSetIdKlijent() {
      k.setIdKlijent(11);
      assertEquals(11, k.getIdKlijent());
    }

    /**
     * Test of getIme method, of class Klijent.
     */
    @Test
    public void testGetIme() {
           assertEquals("Ana", k.getIme());
    }

    /**
     * Test of setIme method, of class Klijent.
     */
    @Test
    public void testSetIme() {
       k.setIme("Mila");
       assertEquals("Mila", k.getIme());
    
    }

    /**
     * Test of getPrezime method, of class Klijent.
     */
    @Test
    public void testGetPrezime() {
          assertEquals("Anić", k.getPrezime());
    }

    /**
     * Test of setPrezime method, of class Klijent.
     */
    @Test
    public void testSetPrezime() {
         k.setPrezime("Milić");
        assertEquals("Milić", k.getPrezime());
    
         }

    /**
     * Test of getEmailAdresa method, of class Klijent.
     */
    @Test
    public void testGetEmailAdresa() {
         assertEquals("ana@gmail.com", k.getEmailAdresa());
    }

    /**
     * Test of setEmailAdresa method, of class Klijent.
     */
    @Test
    public void testSetEmailAdresa() {
         k.setEmailAdresa("mila@gmail.com");
        assertEquals("mila@gmail.com", k.getEmailAdresa());
    }
    /**
     * Test of getKontaktTelefon method, of class Klijent.
     */
    @Test
    public void testGetKontaktTelefon() {   
       assertEquals("0641234567", k.getKontaktTelefon());
    }

    /**
     * Test of setKontaktTelefon method, of class Klijent.
     */
    @Test
    public void testSetKontaktTelefon() {
          k.setKontaktTelefon("0659876543");
        assertEquals("0659876543", k.getKontaktTelefon());
    
    }

    /**
     * Test of getStatus method, of class Klijent.
     */
    @Test
    public void testGetStatus() {
        assertSame(status, k.getStatus());
    }
    /**
     * Test of setStatus method, of class Klijent.
     */
    @Test
    public void testSetStatus() {
        Status novi = new Status(3, "Srebrni", new Date(), "5%");
        k.setStatus(novi);
        assertSame(novi, k.getStatus());

    }

    /**
     * Test of toString method, of class Klijent.
     */
    @Test
    public void testToString() {
         assertEquals("Ana Anić", k.toString());
         }

    /**
     * Test of vratiNazivTabele method, of class Klijent.
     */
    @Test
    public void testVratiNazivTabele() {
        assertEquals("klijent", k.vratiNazivTabele());
     }

    /**
     * Test of vratiKoloneZaUbacivanje method, of class Klijent.
     */
    @Test
    public void testVratiKoloneZaUbacivanje() {
     assertEquals("ime, prezime, emailAdresa, kontaktTelefon, idStatus", k.vratiKoloneZaUbacivanje());
    }

    @Test
    public void testVratiVrednostiZaUbacivanje() {
        assertEquals("'Ana', 'Anić', 'ana@gmail.com', '0641234567', 2", k.vratiVrednostiZaUbacivanje());
    }

    @Test
    public void testVratiPrimarniKljuc() {
        assertEquals("idKlijent=7", k.vratiPrimarniKljuc());
    }

    @Test
    public void testVratiVrednostiZaIzmenu() {
        assertEquals("ime='Ana', prezime='Anić', emailAdresa='ana@gmail.com', kontaktTelefon='0641234567', idStatus=2",
                k.vratiVrednostiZaIzmenu());
    }

    @Test(expected = NullPointerException.class)
    public void testVratiVrednostiZaUbacivanjeBezStatusa() {
        k.setStatus(null);
        k.vratiVrednostiZaUbacivanje();
    }
  
}
