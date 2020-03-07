package ulamek;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class UlamekTest {
    static private Ulamek ZERO = new Ulamek(0);
    static private Ulamek ONE = new Ulamek(1);
    static private Ulamek TWO = new Ulamek(2);
    static private Ulamek HALF = new Ulamek(1,2);

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testSimple() {
        Ulamek u1 = new Ulamek(1,2);
        assertTrue(u1.compareTo(new Ulamek(1,1))<0);
        assertEquals(u1.dodaj(u1).compareTo(new Ulamek(1,1)),0);
    }

    @Test
    public void testConstructors() {
        assertEquals("2/3", new Ulamek(2,3).toString());
        assertEquals("2/3", new Ulamek(4,6).toString());
        assertEquals("3/2", new Ulamek(6,4).toString());
        assertEquals("6", new Ulamek(6).toString());
        assertEquals("0", new Ulamek(0).toString());
        assertEquals("-1", new Ulamek(-1).toString());
    }

    @Test
    public void testToString() {
        assertEquals("1/2", new Ulamek(2,4).toString());
    }

    @Test
    public void testZero() {
        assertEquals("0", new Ulamek(0).toString());
        assertEquals("0", new Ulamek(0,10).toString());
        assertEquals("0", new Ulamek(0,1).toString());
    }

    @Test
    public void testNegative() {
        assertEquals("-1/2", new Ulamek(1,-2).toString());
        assertEquals("-1/2", new Ulamek(-1,2).toString());
        assertEquals("1/2", new Ulamek(-1,-2).toString());
    }

    @Test
    public void testAdd() {
        Ulamek u = ZERO.dodaj(HALF).dodaj(1);
        assertEquals("3/2", u.toString());
    }

    @Test
    public void testSub() {
        Ulamek u = ZERO.odejmij(HALF).odejmij(1);
        assertEquals("-3/2", u.toString());
    }

    @Test
    public void testMul() {
        Ulamek u = ONE.pomnoz(HALF).pomnoz(3);
        assertEquals("3/2", u.toString());
    }

    @Test
    public void testDiv() {
        Ulamek u = ONE.podziel(HALF).podziel(3);
        assertEquals("2/3", u.toString());
    }

    @Test
    public void testCompare() {
        assertEquals(0, ONE.compareTo(ONE));
        assertTrue(ONE.compareTo(TWO)<0);
        assertTrue(TWO.compareTo(ONE)>0);
        assertTrue(ONE.compareTo(HALF)>0);
        assertTrue(HALF.compareTo(ONE)<0);
    }

    @Test
    public void testCompare2() {
        Ulamek u1 = new Ulamek(1, 1_000_000_000);
        Ulamek u2 = new Ulamek(3, 1_000_000_000);
        assertTrue(u2.compareTo(u1)>0);
        assertTrue(u1.compareTo(u2)<0);
        assertEquals(0, u1.compareTo(u1));
        assertEquals(0, u2.compareTo(u2));
    }


}
