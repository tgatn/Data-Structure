package edu.ncsu.csc316.dsa.graph;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.Weighted;
import edu.ncsu.csc316.dsa.graph.Graph.Vertex;

/**
 * Test ShortestPathUtil class
 * @author TungTran
 *
 */
public class ShortestPathUtilTest {

	/** directed graph used for testing  */
	private Graph<Integer, Highway> directedGraph;
	
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
	}
	
	/**
	 * Test methods in ShortestPathUtil
	 */
	@Test
	public void testShortestPathUtil() {
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
		assertEquals(3, (int) ShortestPathUtil.dijkstra(directedGraph, v0).get(v5));
		assertEquals(6, (int) ShortestPathUtil.dijkstra(directedGraph, v0).get(v3));
		assertEquals(4, (int) ShortestPathUtil.dijkstra(directedGraph, v0).get(v4));
		assertEquals(10, (int) ShortestPathUtil.dijkstra(directedGraph, v0).get(v2));
		assertEquals(5, (int) ShortestPathUtil.dijkstra(directedGraph, v0).get(v1));
		
		assertEquals(directedGraph.insertEdge(v0, v5, h0), ShortestPathUtil.shortestPathTree(directedGraph, v0, ShortestPathUtil.dijkstra(directedGraph, v0)).get(v5));
		assertEquals(directedGraph.insertEdge(v5, v3, h4), ShortestPathUtil.shortestPathTree(directedGraph, v0, ShortestPathUtil.dijkstra(directedGraph, v0)).get(v3));
		assertEquals(directedGraph.insertEdge(v3, v2, h5), ShortestPathUtil.shortestPathTree(directedGraph, v0, ShortestPathUtil.dijkstra(directedGraph, v0)).get(v2));
		assertEquals(directedGraph.insertEdge(v5, v4, h2), ShortestPathUtil.shortestPathTree(directedGraph, v0, ShortestPathUtil.dijkstra(directedGraph, v0)).get(v4));
		assertEquals(directedGraph.insertEdge(v4, v1, h9), ShortestPathUtil.shortestPathTree(directedGraph, v0, ShortestPathUtil.dijkstra(directedGraph, v0)).get(v1));
	}

}
