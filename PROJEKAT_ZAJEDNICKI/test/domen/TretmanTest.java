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
public class TretmanTest {
    private Tretman t;
    
    public TretmanTest() {
    }
    
    @Before
    public void setUp() {
          t = new Tretman(5, "Masaža leđa", 3000, 45, "Opuštanje mišića i otklanjanje napetosti u donjim i gornjim leđima.", new Kategorija("Masaža"));
    }
    
    @After
    public void tearDown() {
        t=null;
    }

    /**
     * Test of getIdTretman method, of class Tretman.
     */
    @Test
    public void testGetIdTretman() {
        assertEquals(5, t.getIdTretman());
       }

    /**
     * Test of setIdTretman method, of class Tretman.
     */
    @Test
    public void testSetIdTretman() {
          t.setIdTretman(9);
        assertEquals(9, t.getIdTretman());
    }

    /**
     * Test of getNaziv method, of class Tretman.
     */
    @Test
    public void testGetNaziv() {
          assertEquals("Masaža leđa", t.getNaziv());
    }

    /**
     * Test of setNaziv method, of class Tretman.
     */
    @Test
    public void testSetNaziv() {
         t.setNaziv("Piling");
        assertEquals("Piling", t.getNaziv());
         }

    /**
     * Test of getCena method, of class Tretman.
     */
    @Test
    public void testGetCena() {
          assertEquals(3000, t.getCena(), 0.001);
    }

    /**
     * Test of setCena method, of class Tretman.
     */
    @Test
    public void testSetCena() {
        t.setCena(2500);
        assertEquals(2500, t.getCena(), 0.001);
    }

    /**
     * Test of getTrajanjeUMin method, of class Tretman.
     */
    @Test
    public void testGetTrajanjeUMin() {
        assertEquals(45, t.getTrajanjeUMin());
    }

    /**
     * Test of setTrajanjeUMin method, of class Tretman.
     */
    @Test
    public void testSetTrajanjeUMin() {
         t.setTrajanjeUMin(60);
        assertEquals(60, t.getTrajanjeUMin());
    }

    /**
     * Test of getBenefitiTretmana method, of class Tretman.
     */
    @Test
    public void testGetBenefitiTretmana() {
         assertEquals("Opuštanje mišića i otklanjanje napetosti u donjim i gornjim leđima.", t.getBenefitiTretmana());
    }

    /**
     * Test of setBenefitiTretmana method, of class Tretman.
     */
    @Test
    public void testSetBenefitiTretmana() {
         t.setBenefitiTretmana("Novi opis");
        assertEquals("Novi opis", t.getBenefitiTretmana());
    }

    /**
     * Test of getKategorija method, of class Tretman.
     */
    @Test
    public void testGetKategorija() {
      assertEquals("Masaža", t.getKategorija().getNaziv());
              }

    /**
     * Test of setKategorija method, of class Tretman.
     */
    @Test
    public void testSetKategorija() {
     t.setKategorija(new Kategorija("Kozmetički tretman"));
assertEquals("Kozmetički tretman", t.getKategorija().getNaziv());}

    /**
     * Test of toString method, of class Tretman.
     */
    

    @Test
    public void testToString() {
            assertEquals("Masaža leđa", t.toString());
    }

    /**
     * Test of vratiNazivTabele method, of class Tretman.
     */
    @Test
    public void testVratiNazivTabele() {
     assertEquals("tretman", t.vratiNazivTabele());
    }

    /**
     * Test of vratiKoloneZaUbacivanje method, of class Tretman.
     */
    @Test
    public void testVratiKoloneZaUbacivanje() {
      assertEquals("naziv, cena, trajanjeUMin, benefitiTretmana, kategorija", t.vratiKoloneZaUbacivanje());
      }

    /**
     * Test of vratiVrednostiZaUbacivanje method, of class Tretman.
     */
    @Test
    public void testVratiVrednostiZaUbacivanje() {
          assertEquals("'Masaža leđa', 3000.0, 45, 'Opuštanje mišića i otklanjanje napetosti u donjim i gornjim leđima.', 'Masaža'",
                t.vratiVrednostiZaUbacivanje());
    }

    /**
     * Test of vratiPrimarniKljuc method, of class Tretman.
     */
    @Test
    public void testVratiPrimarniKljuc() {
         assertEquals("idTretman=5", t.vratiPrimarniKljuc());
    }

    /**
     * Test of vratiVrednostiZaIzmenu method, of class Tretman.
     */
    @Test
    public void testVratiVrednostiZaIzmenu() {
   assertEquals("naziv='Masaža leđa', cena=3000.0, trajanjeUMin=45, benefitiTretmana='Opuštanje mišića i otklanjanje napetosti u donjim i gornjim leđima.', kategorija='Masaža'",
                t.vratiVrednostiZaIzmenu());
    /**
     * Test of vratiListu method, of class Tretman.
     */
    }
}
