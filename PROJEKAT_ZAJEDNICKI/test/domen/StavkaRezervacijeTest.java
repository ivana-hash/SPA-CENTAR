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
public class StavkaRezervacijeTest {
    
    private StavkaRezervacije s;
    private Tretman t;
    
    public StavkaRezervacijeTest() {
    }
    
 
    @Before
    public void setUp() {
        
     t = new Tretman(3, "Piling lica", 2000, 30, "Čišćenje pora i otklanjanje mrtvih ćelija sa kože lica.", new Kategorija("Beauty tretman"));
     s = new StavkaRezervacije(1, 2000, 2, 4000, 10, t);    
    }
    
    @After
    public void tearDown() {
        s = null;
        t = null;
    }

    /**
     * Test of getRb method, of class StavkaRezervacije.
     */
    @Test
    public void testGetRb() {
         assertEquals(1, s.getRb());
        }

    /**
     * Test of setRb method, of class StavkaRezervacije.
     */
    @Test
    public void testSetRb() {
        s.setRb(3);
        assertEquals(3, s.getRb());
    }

    /**
     * Test of getCena method, of class StavkaRezervacije.
     */
    @Test
    public void testGetCena() {
           assertEquals(2000, s.getCena(), 0.001);
    }

    /**
     * Test of setCena method, of class StavkaRezervacije.
     */
    @Test
    public void testSetCena() {
        
        s.setCena(2500);
        assertEquals(2500, s.getCena(), 0.001);
    }

    /**
     * Test of getBrojPaketaTretmana method, of class StavkaRezervacije.
     */
    @Test
    public void testGetBrojPaketaTretmana() {
         assertEquals(2, s.getBrojPaketaTretmana()); }

    /**
     * Test of setBrojPaketaTretmana method, of class StavkaRezervacije.
     */
    @Test
    public void testSetBrojPaketaTretmana() {
        s.setBrojPaketaTretmana(5);
        assertEquals(5, s.getBrojPaketaTretmana());
    }

    /**
     * Test of getIznosStavke method, of class StavkaRezervacije.
     */
    @Test
    public void testGetIznosStavke() {
            assertEquals(4000, s.getIznosStavke(), 0.001);
  }

    /**
     * Test of setIznosStavke method, of class StavkaRezervacije.
     */
    @Test
    public void testSetIznosStavke() {
        s.setIznosStavke(6000);
        assertEquals(6000, s.getIznosStavke(), 0.001);
     }

    /**
     * Test of getRezervacijaId method, of class StavkaRezervacije.
     */
    @Test
    public void testGetRezervacijaId() {
     assertEquals(10, s.getRezervacijaId());
    }

    /**
     * Test of setRezervacijaId method, of class StavkaRezervacije.
     */
    @Test
    public void testSetRezervacijaId() {
        s.setRezervacijaId(12);
        assertEquals(12, s.getRezervacijaId());
    }

    /**
     * Test of getTretman method, of class StavkaRezervacije.
     */
    @Test
    public void testGetTretman() {  assertSame(t, s.getTretman());
       }

    /**
     * Test of setTretman method, of class StavkaRezervacije.
     */
    @Test
    public void testSetTretman() {
      Tretman novi = new Tretman(8, "Masaža stopala", 3000, 45, "Opušta umorna stopala i otklanja napetost.", new Kategorija("Masaža"));
      s.setTretman(novi);
        assertSame(novi, s.getTretman());
     }

  
    @Test
    public void testGetStatusStavkePodrazumevano() {
        assertEquals(StatusStavke.NEIZMENJENA, s.getStatusStavke());
        assertEquals(StatusStavke.NEIZMENJENA, new StavkaRezervacije().getStatusStavke());
    }

    @Test
    public void testSetStatusStavke() {
        s.setStatusStavke(StatusStavke.OBRISANA);
        assertEquals(StatusStavke.OBRISANA, s.getStatusStavke());
    }
    @Test
    public void testToString() {
            assertEquals("1. Piling lica - 2 paket/a", s.toString());
       }
 @Test
    public void testToStringBezTretmana() {
        s.setTretman(null);
        assertEquals("1.  - 2 paket/a", s.toString());
    }

    @Test
    public void testVratiNazivTabele() {
          assertEquals("stavkarezervacije", s.vratiNazivTabele());
    }
    /**
     * Test of vratiKoloneZaUbacivanje method, of class StavkaRezervacije.
     */
    @Test
    public void testVratiKoloneZaUbacivanje() {
      assertEquals("rb, cena, brojPaketaTretmana, iznosStavke, idRezervacija, idTretman", s.vratiKoloneZaUbacivanje()); 
    }

    /**
     * Test of vratiVrednostiZaUbacivanje method, of class StavkaRezervacije.
     */
    @Test
    public void testVratiVrednostiZaUbacivanje() {
        assertEquals("1, 2000.0, 2, 4000.0, 10, 3", s.vratiVrednostiZaUbacivanje());
    }

    /**
     * Test of vratiPrimarniKljuc method, of class StavkaRezervacije.
     */
    @Test
    public void testVratiPrimarniKljuc() {
         assertEquals("idRezervacija=10 AND rb=1", s.vratiPrimarniKljuc());
    }

    /**
     * Test of vratiVrednostiZaIzmenu method, of class StavkaRezervacije.
     */
    @Test
    public void testVratiVrednostiZaIzmenu() {
         assertEquals("cena=2000.0, brojPaketaTretmana=2, iznosStavke=4000.0, idTretman=3", s.vratiVrednostiZaIzmenu());
  }
}
   
