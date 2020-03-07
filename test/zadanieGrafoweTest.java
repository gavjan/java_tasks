// zmodyfikowana wersja zadania:
//
// http://main.edu.pl/pl/archive/oi/14/biu
//
// wystarczy zwracać liczbę biur/spójnych składowych (bez podziału)

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.math.BigInteger;
import java.io.*;
import java.util.Scanner;


public class zadanieGrafoweTest {

    private ByteArrayOutputStream outContent;;

    private void setUpStreams(String inp) {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        System.setIn(new ByteArrayInputStream(inp.getBytes()));
    }

    private void cleanUpStreams() {
        System.setOut(null);
        System.setIn(null);
    }

    private String runProgram(String inp) {
        try {
            setUpStreams(inp);
            Solution.main(new String[0]);
            return outContent.toString();
        } finally {
            cleanUpStreams();
        }
    }

    @Test
    public void testGrafPelny() {
      testuj("3 3\n1 2\n3 1\n3 2\n",3);
    }

    @Test
    public void testKwadrat() {
      testuj("4 4\n1 2\n3 4\n2 3\n4 1\n",2);
    }

    @Test
    public void testKwadratZPowtorzonaKrawedzia() {
      testuj("4 5\n1 2\n2 1\n3 4\n2 3\n4 1\n",2); // krawędz 1-2 jest powtórzona!
    }


    @Test
    public void testKoperta() {
      // 1---------6
      // |\       /|
      // | 3-----4 |
      // |/       \|
      // 2---------5
      testuj("6 9\n1 2\n2 3\n3 1\n3 4\n4 5\n5 6\n6 4\n1 6\n2 5\n",1); 
    }

    @Test
    public void testGrafPusty3() {
      testuj("3 0\n",1);
    }

    private void testuj(String inp, int odp) {
        String should_be=""+odp+"\n";
        assertEquals(should_be, runProgram(inp));
    }


}
