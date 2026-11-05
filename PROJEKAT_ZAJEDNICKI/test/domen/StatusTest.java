
package domen;

import java.util.Calendar;
import java.util.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StatusTest {

    private Status s;
    private Date datum;

    @Before
    public void setUp() {
        Calendar c = Calendar.getInstance();
        c.set(2025, Calendar.JANUARY, 10, 0, 0, 0);
        c.set(Calendar.MILLISECOND, 0);

        datum = c.getTime();

        s = new Status(
            2,
            "Zlatni",
            datum,
            "10% popusta na sve tretmane"
        );

        s.setPopust(10);
    }

    @After
    public void tearDown() {
        s = null;
    }

    @Test
    public void testGetIdStatus() {
        assertEquals(2, s.getIdStatus());
    }

    @Test
    public void testSetIdStatus() {
        s.setIdStatus(5);
        assertEquals(5, s.getIdStatus());
    }

    @Test
    public void testGetNaziv() {
        assertEquals("Zlatni", s.getNaziv());
    }

    @Test
    public void testSetNaziv() {
        s.setNaziv("Srebrni");
        assertEquals("Srebrni", s.getNaziv());
    }

    @Test
    public void testGetDatumPostizanja() {
        assertEquals(datum, s.getDatumPostizanja());
    }

    @Test
    public void testSetDatumPostizanja() {
        Date novi = new Date();

        s.setDatumPostizanja(novi);

        assertEquals(novi, s.getDatumPostizanja());
    }

    @Test
    public void testGetPogodnosti() {
        assertEquals(
            "10% popusta na sve tretmane",
            s.getPogodnosti()
        );
    }

    @Test
    public void testSetPogodnosti() {
        s.setPogodnosti("Besplatan tretman");

        assertEquals(
            "Besplatan tretman",
            s.getPogodnosti()
        );
    }

    @Test
    public void testGetPopust() {
        assertEquals(10, s.getPopust());
    }

    @Test
    public void testSetPopust() {
        s.setPopust(20);

        assertEquals(20, s.getPopust());
    }

    @Test
    public void testToString() {
        assertEquals("Zlatni", s.toString());
    }

    @Test
    public void testVratiNazivTabele() {
        assertEquals(
            "status",
            s.vratiNazivTabele()
        );
    }

    @Test
    public void testVratiKoloneZaUbacivanje() {
        assertEquals(
            "naziv, datumPostizanja, pogodnosti, popust",
            s.vratiKoloneZaUbacivanje()
        );
    }

    @Test
    public void testVratiVrednostiZaUbacivanje() {
        assertEquals(
            "'Zlatni', '2025-01-10', " +
            "'10% popusta na sve tretmane', 10",
            s.vratiVrednostiZaUbacivanje()
        );
    }

    @Test
    public void testVratiPrimarniKljuc() {
        assertEquals(
            "idStatus=2",
            s.vratiPrimarniKljuc()
        );
    }

    @Test
    public void testVratiVrednostiZaIzmenu() {
        assertEquals(
            "naziv='Zlatni', " +
            "datumPostizanja='2025-01-10', " +
            "pogodnosti='10% popusta na sve tretmane', " +
            "popust=10",
            s.vratiVrednostiZaIzmenu()
        );
    }

    @Test
    public void testEqualsIstiId() {
        Status drugi = new Status(
            2,
            "Drugo ime",
            new Date(),
            "x"
        );

        drugi.setPopust(50);

        assertEquals(s, drugi);
    }

    @Test
    public void testEqualsRazlicitId() {
        Status drugi = new Status(
            3,
            "Zlatni",
            datum,
            "10% popusta na sve tretmane"
        );

        drugi.setPopust(10);

        assertNotEquals(s, drugi);
    }

    @Test
    public void testEqualsNull() {
        assertNotEquals(s, null);
    }

    @Test
    public void testEqualsDrugaKlasa() {
        assertNotEquals(s, "Zlatni");
    }

    @Test
    public void testHashCodeIstiZaJednake() {
        Status drugi = new Status(
            2,
            "Drugo ime",
            new Date(),
            "x"
        );

        drugi.setPopust(50);

        assertEquals(
            s.hashCode(),
            drugi.hashCode()
        );
    }
}
