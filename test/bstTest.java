package bst;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;
import java.util.TreeSet;

public class bstTest {

    @Test
    public void testKonstuktury() {
        BST<Integer> t1 = new BST<>();
        BST<String> t2 = new BST<>();
        BST<Double> t3 = new BST<>();
    }

    @Test
    public void testAdd() {
        BST<Integer> t = new BST<>();
        t.add(2);
        t.add(1);
        t.add(3);
        assertEquals(t.size(), 3);
        t.add(1);
        assertEquals(t.size(), 3);
    }

    @Test
    public void testRemove() {
        BST<Integer> t = new BST<>();
        t.add(1);
        assertEquals(t.size(), 1);
        t.remove(1);
        assertEquals(t.size(), 0);
        t.remove(1);
        assertEquals(t.size(), 0);
    }

    @Test
    public void testExists() {
        BST<Integer> t = new BST<>();
        t.add(20);
        t.add(10);
        t.add(30);
        t.add(15);
        assertEquals(t.size(), 4);
        assertTrue(t.exists(10));
        assertTrue(t.exists(20));
        assertTrue(t.exists(30));
        assertTrue(t.exists(15));
        assertFalse(t.exists(16));
        assertFalse(t.exists(21));
        assertFalse(t.exists(35));
        assertFalse(t.exists(7));
    }

    @Test
    public void testRandom() {
        TreeSet<Integer> ts = new TreeSet<Integer>();
        BST<Integer> t = new BST<>();
        Random gen = new Random(42);
        for(int i=0;i<1000;i++) {
            int v=gen.nextInt(100000);
            assertEquals(t.exists(v), ts.contains(v));
            t.add(v);
            ts.add(v);
            assertEquals(t.size(), ts.size());
        }
    }



}