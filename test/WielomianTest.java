package wielomian;

/**
 * Zaimplementuj klasÄ Wielomian udostÄpniajÄcÄ:
 * - tworzenie wielomianĂłw poprzez konstruktor ze zmiennÄ liczbÄ argumentĂłw
 *   (moĹźna zaĹoĹźyÄ, Ĺźe wspĂłĹczynniki wielomianu bÄdÄ liczbami caĹkowitymi)
 * - wypisywanie wielomianu w sposĂłb czytelny dla czĹowieka (metoda toString)
 * - obliczanie wartoĹci wielomianu w punkcie
 * - dodawanie i mnoĹźenie wielomianĂłw
 * - obliczanie pochodnej
 * - wyznaczanie miejsc zerowych
 * Przydatne linki:
 * - https://pl.wikipedia.org/wiki/Schemat_Hornera
 * - https://pl.wikipedia.org/wiki/Metoda_r%C3%B3wnego_podzia%C5%82u
 */
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class WielomianTest {

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    @Test
    public void test_wypisywanie() {
        assertEquals("2x+1",new Wielomian(1,2).toString());
        assertEquals("0",new Wielomian(0).toString());
        assertEquals("1",new Wielomian(1).toString());
        assertEquals("-1",new Wielomian(-1).toString());
        assertEquals("-x^3-1",new Wielomian(-1,0,0,-1).toString());
        assertEquals("x^10+x",new Wielomian(0,1,0,0,0,0,0,0,0,0,1).toString());
        assertEquals("2x^2+x+1",new Wielomian(1,1,2).toString());
    }

    @Test
    public void test_normalizacja() {
        assertEquals("2x+1",new Wielomian(1,2,0,0,0,0).toString());
        assertEquals("0",new Wielomian(0,0,0,0,0).toString());
    }

    @Test
    public void test_dodawanie() {
        assertEquals("4x+2",new Wielomian(1,2).dodaj(new Wielomian(1,2)).toString());
        assertEquals("0",new Wielomian(1,2).dodaj(new Wielomian(-1,-2)).toString());
    }

    @Test
    public void test_mnozenie() {
        assertEquals("2x^2+x",new Wielomian(1,2).pomnoz(new Wielomian(0,1)).toString());
    }

    @Test
    public void test_wartosc() {
        Wielomian w=new Wielomian(2,0,1);
        for(double x=-1.0;x<1.0;x=x+0.1) {
            assertEquals(x*x+2, w.wartosc(x), 000001);
        }
    }

    @Test
    public void test_pochodna() {
        assertEquals("2x+1",new Wielomian(0,1,1).pochodna().toString());
        assertEquals("0",new Wielomian(0).pochodna().toString());
        assertEquals("0",new Wielomian(42).pochodna().toString());
    }

    @Test
    public void test_miejsca_zerowe() {
        assertArrayEquals(new double[]{0}, new Wielomian(0).miejscaZerowe(), 0.001);
        assertArrayEquals(new double[]{}, new Wielomian(1).miejscaZerowe(), 0.001);
        assertArrayEquals(new double[]{2}, new Wielomian(-2,1).miejscaZerowe(), 0.001);
        assertArrayEquals(new double[]{-2,2}, new Wielomian(-4,0,1).miejscaZerowe(), 0.001);
        assertArrayEquals(new double[]{-1.0514,2.5173,4.5341}, new Wielomian(12,4,-6,1).miejscaZerowe(), 0.001);
    }

    @Test
    public void test_stopien() {
        assertEquals( 0, new Wielomian(1).stopien());
        assertEquals( 1, new Wielomian(0, 1).stopien());
        assertEquals( 3, new Wielomian(0, 1, 2, 3).stopien());
        assertEquals( 3, new Wielomian(0, 1, 3, 4, 0).stopien());
        assertEquals( 4, new Wielomian(0, 0, 1, 2, 10).stopien());
    }

    @Test
    public void test_wspolczynnik() {
        assertEquals(0, new Wielomian(0, 1, 2).wspolczynnik(0));
        assertEquals(0, new Wielomian(0, 1, 2).wspolczynnik(5));
        assertEquals(5, new Wielomian(0, 1, 2, 3, 5).wspolczynnik(4));
        assertEquals(0, new Wielomian(0, 1, 2).wspolczynnik(-1));
    }
}
