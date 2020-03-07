package onp;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ONPTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    private int policz(String s) throws Exception {
        return new ONP().policz(s);
    }

    @Test(expected = PustyStos.class)
    public void testPustyNapis() throws Exception {
        new ONP().policz("");
    }

    @Test(expected = PustyStos.class)
    public void testPustyStos() throws Exception {
        new ONP().policz("11+++");
    }

    @Test(expected = ZaMaloOperatorow.class)
    public void testZaMaloOperatorow() throws Exception {
        new ONP().policz("123");
    }

    @Test(expected = DzieleniePrzezZero.class)
    public void testDzieleniePrzezZero() throws Exception {
        new ONP().policz("10/");
    }

    @Test(expected = BlednyZnak.class)
    public void testBlednyZnak() throws Exception {
        new ONP().policz("10x+");
    }

    @Test
    public void testStale() throws Exception {
        assertEquals(policz("1"), 1);
        assertEquals(policz("9"), 9);
    }

    @Test
    public void testProsteOperacje() throws Exception {
        assertEquals(policz("12+"), 3);
        assertEquals(policz("31-"), 2);
        assertEquals(policz("23*"), 6);
        assertEquals(policz("62/"), 3);
        assertEquals(policz("65/"), 1); // dzielenie calkowite
    }

    @Test
    public void testZlozoneOperacje() throws Exception {
        assertEquals(policz("12+34+*"), 21);
    }

}