import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.io.*;
import java.util.*;

/**
 * Zaimplementuj klasę BSTImmutableSet spełniającą następujący interfejs:
 * 
 * public interface ImmutableSet<E> extends Iterable<E> {
 *   ImmutableSet<E> add(E e);
 *   boolean contains(E e);
 *   ImmutableSet<E> remove(E e);
 *   boolean isEmpty();
 *   int size();
 * }
 */
public class ImmutableSetTest {

    @Test
    public void test1() {
        BSTImmutableSet<Integer> set1 = new BSTImmutableSet<Integer>();
        BSTImmutableSet<String> set2 = new BSTImmutableSet<String>();
    }

    @Test
    public void test2() {
        ImmutableSet<String> set1 = new BSTImmutableSet<String>();
        ImmutableSet<String> set2 = set1.add("aa").add("bb");
        ImmutableSet<String> set3 = set2.add("cc").add("dd").add("bb");
        ImmutableSet<String> set4 = set2.add("ee").remove("bb");

        assertFalse(set1.contains("bb"));
        assertFalse(set1.contains("cc"));

        assertTrue(set2.contains("bb"));
        assertFalse(set2.contains("cc"));

        assertTrue(set3.contains("bb"));
        assertTrue(set3.contains("cc"));

        assertFalse(set4.contains("bb"));
        assertFalse(set4.contains("dd"));
        assertTrue(set4.contains("aa"));
        assertTrue(set4.contains("ee"));
    }

    @Test
    public void test_iteracji_prosty() {
        ImmutableSet<Integer> empty = new BSTImmutableSet<Integer>();
        ImmutableSet<Integer> s = empty.add(2).add(1).add(3);
        ArrayList<Integer> elems = new ArrayList<>();
        for(Integer x : s) elems.add(x);
        Collections.sort(elems);
        assertEquals(3, (int) elems.size());
        assertEquals(1, (int) elems.get(0));
        assertEquals(2, (int) elems.get(1));
        assertEquals(3, (int) elems.get(2));
    }

    @Test
    public void test_iteracji() {
        ImmutableSet<Integer> empty = new BSTImmutableSet<Integer>();
        ImmutableSet<Integer> s = empty.add(2).add(1).add(3);
        ArrayList<Integer> elems = new ArrayList<>();
        for(Integer x : s) elems.add(x);
        assertEquals(3, (int) elems.size());
        assertEquals(1, (int) elems.get(0));
        assertEquals(2, (int) elems.get(1));
        assertEquals(3, (int) elems.get(2));
    }

}
/* Tests taken from: https://www.mimuw.edu.pl/\~walen/teaching/2019-po/ */
