package edu.ncsu.csc316.dsa.disjoint_set;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.Position;

/**
 * Test class for UpTreeDisjointSetForest
 * Checks the expected outputs of the Disjoint Set abstract data type 
 * behaviors when using an up-tree data structure
 *
 * @author Dr. King
 * @author Tung Tran
 *
 */
public class UpTreeDisjointSetForestTest {

	/** set used for testing */
    private DisjointSetForest<String> set;

    /**
     * Create a new instance of a up-tree forest before each test case executes
     */     
    @Before
    public void setUp() {
        set = new UpTreeDisjointSetForest<>();
    }
    
    /**
     * Test the output of the makeSet behavior
     */ 
    @Test
    public void testMakeSet() {
        Position<String> one = set.makeSet("one");
        assertEquals("one", one.getElement());
        Position<String> two = set.makeSet("two");
        assertEquals("two", two.getElement());
        Position<String> three = set.makeSet("three");
        assertEquals("three", three.getElement());
        Position<String> four = set.makeSet("four");
        assertEquals("four", four.getElement());
        Position<String> five = set.makeSet("five");
        assertEquals("five", five.getElement());
        
    }

    /**
     * Test the output of the union-find behaviors
     */     
    @Test
    public void testUnionFind() {
        Position<String> one = set.makeSet("one");
        Position<String> two = set.makeSet("two");
        Position<String> three = set.makeSet("three");
        Position<String> four = set.makeSet("four");
        Position<String> five = set.makeSet("five");
        Position<String> six = set.makeSet("six");
        Position<String> seven = set.makeSet("seven");
        Position<String> eight = set.makeSet("eight");
        Position<String> nine = set.makeSet("nine");
        Position<String> ten = set.makeSet("ten");
        
        assertEquals(one, set.find("one"));
        assertNull(set.find("random"));
        // you should draw out examples by hand (or use the examples
        // in the lecture slides or textbook) to help guide your test cases.
        // Be sure to perform find operations followed by union
        // operations to make sure the appropriate root notes are
        // returned and used when union-ing
        
        assertThrows(IllegalArgumentException.class, () -> set.union(null, one));
        
        set.union(one, two);
        assertEquals("two", set.find("two").getElement());
        set.union(three, one);
        assertEquals("two", set.find("three").getElement());
        set.union(five, four);
        assertEquals("four", set.find("five").getElement());
        set.union(six, four);
        assertEquals("four", set.find("six").getElement());
        set.union(seven, four);
        assertEquals("four", set.find("seven").getElement());
        set.union(eight, six);
        assertEquals("four", set.find("eight").getElement());
        set.union(nine, six);
        assertEquals("four", set.find("nine").getElement());
        set.union(ten, five);
        assertEquals("four", set.find("five").getElement());
        set.union(four, two);
        
        assertEquals("four", set.find("ten").getElement());
        
    }
}