package edu.ncsu.csc316.dsa.graph;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.Weighted;
import edu.ncsu.csc316.dsa.graph.Graph.Edge;
import edu.ncsu.csc316.dsa.graph.Graph.Vertex;
import edu.ncsu.csc316.dsa.list.positional.PositionalList;

/**
 * Test MinimumSpanningTreeUtil class
 * @author TungTran
 *
 */
public class MinimumSpanningTreeUtilTest {

	/** directed graph used for testing  */
	private Graph<Integer, Highway> directedGraph;
	
	/** undirected graph used for testing  */
	private Graph<Integer, Highway> undirectedGraph;
	
	/**
	 * Class used to get the name and weight of an edge
	 * @author TungTran
	 *
	 */
	public class Highway implements Weighted {
		/** name of highway */
        private String name;
        
        /** weight of edge */
        private int length;
        
        /**
         * Constructor for Highway
         * @param n is name of highway
         * @param l is weight of highway
         */
        public Highway(String n, int l) {
            setName(n);
            setLength(l);
        }

        /**
         * Set name of highway
         * @param name of highway
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * Get weight of highway
         * @return weight of highway
         */
        public int getLength() {
            return length;
        }

        /**
         * Set weight of highway
         * @param length of highway
         */
        public void setLength(int length) {
            this.length = length;
        }

        @Override
        public int getWeight() {
            return getLength();
        }
        
        /**
         * Return highway name
         * @return highway name
         */
        public String getName() {
        	return name;
        }
    }
	
	/**
	 * Executes first when testing methods
	 */
	@Before
	public void setUp() {
		directedGraph = new AdjacencyListGraph<Integer, Highway>(true);
		undirectedGraph = new AdjacencyListGraph<Integer, Highway>();
	}
	
	/**
	 * Test PrimJarnik method
	 */
	@Test
	public void testPrimJarnik() {
		Vertex<Integer> v0 = directedGraph.insertVertex(0);
		Vertex<Integer> v1 = directedGraph.insertVertex(1);
		Vertex<Integer> v2 = directedGraph.insertVertex(2);
		Vertex<Integer> v3 = directedGraph.insertVertex(3);
		Vertex<Integer> v4 = directedGraph.insertVertex(4);
		Vertex<Integer> v5 = directedGraph.insertVertex(5);
		Highway h0 = new Highway("0-5", 3);
		Highway h1 = new Highway("0-4", 6);
		Highway h2 = new Highway("5-4", 1);
		Highway h3 = new Highway("4-3", 3);
		Highway h4 = new Highway("5-3", 3);
		Highway h5 = new Highway("3-2", 4);
		Highway h6 = new Highway("1-2", 6);
		Highway h7 = new Highway("3-1", 1);
		Highway h8 = new Highway("3-4", 1);
		Highway h9 = new Highway("4-1", 1);
		directedGraph.insertEdge(v0, v5, h0);
		directedGraph.insertEdge(v0, v4, h1);
		directedGraph.insertEdge(v5, v4, h2);
		directedGraph.insertEdge(v4, v3, h3);
		directedGraph.insertEdge(v5, v3, h4);
		directedGraph.insertEdge(v3, v2, h5);
		directedGraph.insertEdge(v1, v2, h6);
		directedGraph.insertEdge(v3, v1, h7);
		directedGraph.insertEdge(v3, v4, h8);
		directedGraph.insertEdge(v4, v1, h9);
		PositionalList<Edge<Highway>> e = MinimumSpanningTreeUtil.primJarnik(directedGraph);
		Iterator<Edge<Highway>> it = e.iterator();
		assertEquals(3, it.next().getElement().length);
		assertEquals(1, it.next().getElement().length);
		assertEquals(1, it.next().getElement().length);
		assertEquals(3, it.next().getElement().length);
		assertEquals(4, it.next().getElement().length);
		
	}
	
	/**
	 * Test kruskal method
	 */
	@Test
	public void testKruskal() {
		Vertex<Integer> vA = undirectedGraph.insertVertex(1);
		Vertex<Integer> vB = undirectedGraph.insertVertex(2);
		Vertex<Integer> vC = undirectedGraph.insertVertex(3);
		Vertex<Integer> vD = undirectedGraph.insertVertex(4);
		Vertex<Integer> vE = undirectedGraph.insertVertex(5);
		Vertex<Integer> vF = undirectedGraph.insertVertex(6);
		Highway h0 = new Highway("A-B", 3);
		Highway h1 = new Highway("A-F", 7);
		Highway h2 = new Highway("B-C", 5);
		Highway h3 = new Highway("B-E", 5);
		Highway h4 = new Highway("C-D", 9);
		Highway h5 = new Highway("C-E", 4);
		Highway h6 = new Highway("D-E", 8);
		Highway h7 = new Highway("D-F", 5);
		Highway h8 = new Highway("E-F", 6);
		undirectedGraph.insertEdge(vA, vB, h0);
		undirectedGraph.insertEdge(vA, vF, h1);
		undirectedGraph.insertEdge(vB, vC, h2);
		undirectedGraph.insertEdge(vB, vE, h3);
		undirectedGraph.insertEdge(vC, vD, h4);
		undirectedGraph.insertEdge(vC, vE, h5);
		undirectedGraph.insertEdge(vD, vE, h6);
		undirectedGraph.insertEdge(vD, vF, h7);
		undirectedGraph.insertEdge(vE, vF, h8);
		PositionalList<Edge<Highway>> e = MinimumSpanningTreeUtil.kruskal(undirectedGraph);
		Iterator<Edge<Highway>> it = e.iterator();
		assertEquals(3, it.next().getElement().length);
		assertEquals(4, it.next().getElement().length);
		assertEquals(5, it.next().getElement().length);
		assertEquals(5, it.next().getElement().length);
		assertEquals(6, it.next().getElement().length);
	}

}
