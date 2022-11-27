package edu.ncsu.csc316.dsa.graph;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.graph.Graph.Edge;
import edu.ncsu.csc316.dsa.graph.Graph.Vertex;

/**
 * Test class for EdgeListGraph Checks the expected outputs of the Graph
 * abstract data type behaviors when using an edge list graph data structure
 *
 * @author Dr. King
 * @author Tung Tran
 *
 */
public class EdgeListGraphTest {

	/** undirected graph used for testing */
	private Graph<String, Integer> undirectedGraph;

	/** directed graph used for testing */
	private Graph<String, Integer> directedGraph;

	/**
	 * Create a new instance of an edge list graph before each test case executes
	 */
	@Before
	public void setUp() {
		undirectedGraph = new EdgeListGraph<String, Integer>();
		directedGraph = new EdgeListGraph<String, Integer>(true);
	}

	private void buildUndirectedSample() {
		Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
		Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
		Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
		Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
		Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");

		undirectedGraph.insertEdge(v1, v2, 5);
		undirectedGraph.insertEdge(v1, v3, 10);
		undirectedGraph.insertEdge(v1, v4, 15);
		undirectedGraph.insertEdge(v1, v5, 20);
		undirectedGraph.insertEdge(v2, v3, 25);
		undirectedGraph.insertEdge(v2, v4, 30);
		undirectedGraph.insertEdge(v2, v5, 35);
		undirectedGraph.insertEdge(v3, v4, 40);
		undirectedGraph.insertEdge(v3, v5, 45);
		undirectedGraph.insertEdge(v4, v5, 50);
	}

	private void buildDirectedSample() {
		Vertex<String> v1 = directedGraph.insertVertex("Raleigh");
		Vertex<String> v2 = directedGraph.insertVertex("Asheville");
		Vertex<String> v3 = directedGraph.insertVertex("Wilmington");
		Vertex<String> v4 = directedGraph.insertVertex("Durham");
		Vertex<String> v5 = directedGraph.insertVertex("Greenville");
		Vertex<String> v6 = directedGraph.insertVertex("Boone");

		directedGraph.insertEdge(v1, v2, 5);
		directedGraph.insertEdge(v1, v3, 10);
		directedGraph.insertEdge(v1, v4, 15);
		directedGraph.insertEdge(v1, v5, 20);
		directedGraph.insertEdge(v2, v3, 25);
		directedGraph.insertEdge(v2, v4, 30);
		directedGraph.insertEdge(v2, v5, 35);
		directedGraph.insertEdge(v3, v4, 40);
		directedGraph.insertEdge(v3, v5, 45);
		directedGraph.insertEdge(v4, v5, 50);
		directedGraph.insertEdge(v5, v6, 55);
	}

	/**
	 * Test the output of the numVertices() behavior
	 */
	@Test
	public void testNumVertices() {
		buildUndirectedSample();
		assertEquals(5, undirectedGraph.numVertices());

		buildDirectedSample();
		assertEquals(6, directedGraph.numVertices());
	}

	/**
	 * Test the output of the vertices() behavior
	 */
	@Test
	public void testVertices() {
		// We cannot call buildUndirectedSample() because
		// then we would not be able to reference specific edges
		// or vertices when testing
		Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
		Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
		Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
		Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
		Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");
		undirectedGraph.insertEdge(v1, v2, 5);
		undirectedGraph.insertEdge(v1, v3, 10);
		undirectedGraph.insertEdge(v1, v4, 15);
		undirectedGraph.insertEdge(v1, v5, 20);
		undirectedGraph.insertEdge(v2, v3, 25);
		undirectedGraph.insertEdge(v2, v4, 30);
		undirectedGraph.insertEdge(v2, v5, 35);
		undirectedGraph.insertEdge(v3, v4, 40);
		undirectedGraph.insertEdge(v3, v5, 45);
		undirectedGraph.insertEdge(v4, v5, 50);

		Iterator<Vertex<String>> it = undirectedGraph.vertices().iterator();
		assertEquals("Raleigh", it.next().getElement());
		assertEquals("Asheville", it.next().getElement());
		assertEquals("Wilmington", it.next().getElement());
		assertEquals("Durham", it.next().getElement());
		assertEquals("Greenville", it.next().getElement());

		// DIRECTED
		// We cannot call buildDirectedSample() because
		// then we would not be able to reference specific edges
		// or vertices when testing
		v1 = directedGraph.insertVertex("Raleigh");
		v2 = directedGraph.insertVertex("Asheville");
		v3 = directedGraph.insertVertex("Wilmington");
		v4 = directedGraph.insertVertex("Durham");
		v5 = directedGraph.insertVertex("Greenville");
		Vertex<String> v6 = directedGraph.insertVertex("Boone");
		directedGraph.insertEdge(v1, v2, 5);
		directedGraph.insertEdge(v1, v3, 10);
		directedGraph.insertEdge(v1, v4, 15);
		directedGraph.insertEdge(v1, v5, 20);
		directedGraph.insertEdge(v2, v3, 25);
		directedGraph.insertEdge(v2, v4, 30);
		directedGraph.insertEdge(v2, v5, 35);
		directedGraph.insertEdge(v3, v4, 40);
		directedGraph.insertEdge(v3, v5, 45);
		directedGraph.insertEdge(v4, v5, 50);
		directedGraph.insertEdge(v5, v6, 55);

		Iterator<Vertex<String>> it2 = directedGraph.vertices().iterator();
		assertEquals("Raleigh", it2.next().getElement());
		assertEquals("Asheville", it2.next().getElement());
		assertEquals("Wilmington", it2.next().getElement());
		assertEquals("Durham", it2.next().getElement());
		assertEquals("Greenville", it2.next().getElement());
		assertEquals("Boone", it2.next().getElement());
	}

	/**
	 * Test the output of the numEdges() behavior
	 */
	@Test
	public void testNumEdges() {
		buildUndirectedSample();
		assertEquals(10, undirectedGraph.numEdges());

		buildDirectedSample();
		assertEquals(11, directedGraph.numEdges());
	}

	/**
	 * Test the output of the edges() behavior
	 */
	@Test
	public void testEdges() {
		Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
		Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
		Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
		Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
		Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");
		Edge<Integer> e1 = undirectedGraph.insertEdge(v1, v2, 5);
		Edge<Integer> e2 = undirectedGraph.insertEdge(v1, v3, 10);
		Edge<Integer> e3 = undirectedGraph.insertEdge(v1, v4, 15);
		Edge<Integer> e4 = undirectedGraph.insertEdge(v1, v5, 20);
		Edge<Integer> e5 = undirectedGraph.insertEdge(v2, v3, 25);
		Edge<Integer> e6 = undirectedGraph.insertEdge(v2, v4, 30);
		Edge<Integer> e7 = undirectedGraph.insertEdge(v2, v5, 35);
		Edge<Integer> e8 = undirectedGraph.insertEdge(v3, v4, 40);
		Edge<Integer> e9 = undirectedGraph.insertEdge(v3, v5, 45);
		Edge<Integer> e10 = undirectedGraph.insertEdge(v4, v5, 50);

		Iterator<Edge<Integer>> it = undirectedGraph.edges().iterator();
		assertEquals(e1, it.next());
		assertEquals(e2, it.next());
		assertEquals(e3, it.next());
		assertEquals(e4, it.next());
		assertEquals(e5, it.next());
		assertEquals(e6, it.next());
		assertEquals(e7, it.next());
		assertEquals(e8, it.next());
		assertEquals(e9, it.next());
		assertEquals(e10, it.next());

		// DIRECTED
		v1 = directedGraph.insertVertex("Raleigh");
		v2 = directedGraph.insertVertex("Asheville");
		v3 = directedGraph.insertVertex("Wilmington");
		v4 = directedGraph.insertVertex("Durham");
		v5 = directedGraph.insertVertex("Greenville");
		Vertex<String> v6 = directedGraph.insertVertex("Boone");
		e1 = directedGraph.insertEdge(v1, v2, 5);
		e2 = directedGraph.insertEdge(v1, v3, 10);
		e3 = directedGraph.insertEdge(v1, v4, 15);
		e4 = directedGraph.insertEdge(v1, v5, 20);
		e5 = directedGraph.insertEdge(v2, v3, 25);
		e6 = directedGraph.insertEdge(v2, v4, 30);
		e7 = directedGraph.insertEdge(v2, v5, 35);
		e8 = directedGraph.insertEdge(v3, v4, 40);
		e9 = directedGraph.insertEdge(v3, v5, 45);
		e10 = directedGraph.insertEdge(v4, v5, 50);
		Edge<Integer> e11 = directedGraph.insertEdge(v5, v6, 55);

		Iterator<Edge<Integer>> it2 = directedGraph.edges().iterator();
		assertEquals(e1, it2.next());
		assertEquals(e2, it2.next());
		assertEquals(e3, it2.next());
		assertEquals(e4, it2.next());
		assertEquals(e5, it2.next());
		assertEquals(e6, it2.next());
		assertEquals(e7, it2.next());
		assertEquals(e8, it2.next());
		assertEquals(e9, it2.next());
		assertEquals(e10, it2.next());
		assertEquals(e11, it2.next());
	}

	/**
	 * Test the output of the getEdge(v1,v2) behavior
	 */
	@Test
	public void testGetEdge() {
		Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
		Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
		Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
		Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
		Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");
		Vertex<String> v6 = undirectedGraph.insertVertex("Boone");
		Edge<Integer> e1 = undirectedGraph.insertEdge(v1, v2, 5);
		Edge<Integer> e2 = undirectedGraph.insertEdge(v1, v3, 10);
		Edge<Integer> e3 = undirectedGraph.insertEdge(v1, v4, 15);
		Edge<Integer> e4 = undirectedGraph.insertEdge(v1, v5, 20);
		Edge<Integer> e5 = undirectedGraph.insertEdge(v2, v3, 25);
		Edge<Integer> e6 = undirectedGraph.insertEdge(v2, v4, 30);
		Edge<Integer> e7 = undirectedGraph.insertEdge(v2, v5, 35);
		Edge<Integer> e8 = undirectedGraph.insertEdge(v3, v4, 40);
		Edge<Integer> e9 = undirectedGraph.insertEdge(v3, v5, 45);
		Edge<Integer> e10 = undirectedGraph.insertEdge(v4, v5, 50);

		assertEquals(e1, undirectedGraph.getEdge(v1, v2));
		assertEquals(e2, undirectedGraph.getEdge(v1, v3));
		assertEquals(e3, undirectedGraph.getEdge(v1, v4));
		assertEquals(e4, undirectedGraph.getEdge(v1, v5));
		assertEquals(e5, undirectedGraph.getEdge(v2, v3));
		assertEquals(e6, undirectedGraph.getEdge(v2, v4));
		assertEquals(e7, undirectedGraph.getEdge(v2, v5));
		assertEquals(e8, undirectedGraph.getEdge(v3, v4));
		assertEquals(e9, undirectedGraph.getEdge(v3, v5));
		assertEquals(e10, undirectedGraph.getEdge(v4, v5));

		// DIRECTED
		v1 = directedGraph.insertVertex("Raleigh");
		v2 = directedGraph.insertVertex("Asheville");
		v3 = directedGraph.insertVertex("Wilmington");
		v4 = directedGraph.insertVertex("Durham");
		v5 = directedGraph.insertVertex("Greenville");
		v6 = directedGraph.insertVertex("Boone");
		e1 = directedGraph.insertEdge(v1, v2, 5);
		e2 = directedGraph.insertEdge(v1, v3, 10);
		e3 = directedGraph.insertEdge(v1, v4, 15);
		e4 = directedGraph.insertEdge(v1, v5, 20);
		e5 = directedGraph.insertEdge(v2, v3, 25);
		e6 = directedGraph.insertEdge(v2, v4, 30);
		e7 = directedGraph.insertEdge(v2, v5, 35);
		e8 = directedGraph.insertEdge(v3, v4, 40);
		e9 = directedGraph.insertEdge(v3, v5, 45);
		e10 = directedGraph.insertEdge(v4, v5, 50);
		Edge<Integer> e11 = directedGraph.insertEdge(v5, v6, 55);

		assertEquals(e1.getElement(), directedGraph.getEdge(v1, v2).getElement());
		assertEquals(e2.toString(), directedGraph.getEdge(v1, v3).toString());
		assertEquals(e3, directedGraph.getEdge(v1, v4));
		assertEquals(e4, directedGraph.getEdge(v1, v5));
		assertEquals(e5, directedGraph.getEdge(v2, v3));
		assertEquals(e6, directedGraph.getEdge(v2, v4));
		assertEquals(e7, directedGraph.getEdge(v2, v5));
		assertEquals(e8, directedGraph.getEdge(v3, v4));
		assertEquals(e9, directedGraph.getEdge(v3, v5));
		assertEquals(e10, directedGraph.getEdge(v4, v5));
		assertEquals(e11, directedGraph.getEdge(v5, v6));
	}

	/**
	 * Test the output of the endVertices(e) behavior
	 */
	@Test
	public void testEndVertices() {
		Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
		Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
		Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
		Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
		Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");
		Vertex<String> v6 = undirectedGraph.insertVertex("Boone");
		Edge<Integer> e1 = undirectedGraph.insertEdge(v1, v2, 5);
		Edge<Integer> e2 = undirectedGraph.insertEdge(v1, v3, 10);
		Edge<Integer> e3 = undirectedGraph.insertEdge(v1, v4, 15);
		Edge<Integer> e4 = undirectedGraph.insertEdge(v1, v5, 20);
		Edge<Integer> e5 = undirectedGraph.insertEdge(v2, v3, 25);
		Edge<Integer> e6 = undirectedGraph.insertEdge(v2, v4, 30);
		Edge<Integer> e7 = undirectedGraph.insertEdge(v2, v5, 35);
		Edge<Integer> e8 = undirectedGraph.insertEdge(v3, v4, 40);
		Edge<Integer> e9 = undirectedGraph.insertEdge(v3, v5, 45);
		Edge<Integer> e10 = undirectedGraph.insertEdge(v4, v5, 50);

		assertEquals(v1, undirectedGraph.endVertices(e1)[0]);
		assertEquals(v2, undirectedGraph.endVertices(e1)[1]);
		assertEquals(v1, undirectedGraph.endVertices(e2)[0]);
		assertEquals(v3, undirectedGraph.endVertices(e2)[1]);
		assertEquals(v1, undirectedGraph.endVertices(e3)[0]);
		assertEquals(v4, undirectedGraph.endVertices(e3)[1]);
		assertEquals(v1, undirectedGraph.endVertices(e4)[0]);
		assertEquals(v5, undirectedGraph.endVertices(e4)[1]);
		assertEquals(v2, undirectedGraph.endVertices(e5)[0]);
		assertEquals(v3, undirectedGraph.endVertices(e5)[1]);
		assertEquals(v2, undirectedGraph.endVertices(e6)[0]);
		assertEquals(v4, undirectedGraph.endVertices(e6)[1]);
		assertEquals(v2, undirectedGraph.endVertices(e7)[0]);
		assertEquals(v5, undirectedGraph.endVertices(e7)[1]);
		assertEquals(v3, undirectedGraph.endVertices(e8)[0]);
		assertEquals(v4, undirectedGraph.endVertices(e8)[1]);
		assertEquals(v3, undirectedGraph.endVertices(e9)[0]);
		assertEquals(v5, undirectedGraph.endVertices(e9)[1]);
		assertEquals(v4, undirectedGraph.endVertices(e10)[0]);
		assertEquals(v5, undirectedGraph.endVertices(e10)[1]);

		// DIRECTED
		v1 = directedGraph.insertVertex("Raleigh");
		v2 = directedGraph.insertVertex("Asheville");
		v3 = directedGraph.insertVertex("Wilmington");
		v4 = directedGraph.insertVertex("Durham");
		v5 = directedGraph.insertVertex("Greenville");
		v6 = directedGraph.insertVertex("Boone");
		e1 = directedGraph.insertEdge(v1, v2, 5);
		e2 = directedGraph.insertEdge(v1, v3, 10);
		e3 = directedGraph.insertEdge(v1, v4, 15);
		e4 = directedGraph.insertEdge(v1, v5, 20);
		e5 = directedGraph.insertEdge(v2, v3, 25);
		e6 = directedGraph.insertEdge(v2, v4, 30);
		e7 = directedGraph.insertEdge(v2, v5, 35);
		e8 = directedGraph.insertEdge(v3, v4, 40);
		e9 = directedGraph.insertEdge(v3, v5, 45);
		e10 = directedGraph.insertEdge(v4, v5, 50);
		Edge<Integer> e11 = directedGraph.insertEdge(v5, v6, 55);

		assertEquals(v1, directedGraph.endVertices(e1)[0]);
		assertEquals(v2, directedGraph.endVertices(e1)[1]);
		assertEquals(v1, directedGraph.endVertices(e2)[0]);
		assertEquals(v3, directedGraph.endVertices(e2)[1]);
		assertEquals(v1, directedGraph.endVertices(e3)[0]);
		assertEquals(v4, directedGraph.endVertices(e3)[1]);
		assertEquals(v1, directedGraph.endVertices(e4)[0]);
		assertEquals(v5, directedGraph.endVertices(e4)[1]);
		assertEquals(v2, directedGraph.endVertices(e5)[0]);
		assertEquals(v3, directedGraph.endVertices(e5)[1]);
		assertEquals(v2, directedGraph.endVertices(e6)[0]);
		assertEquals(v4, directedGraph.endVertices(e6)[1]);
		assertEquals(v2, directedGraph.endVertices(e7)[0]);
		assertEquals(v5, directedGraph.endVertices(e7)[1]);
		assertEquals(v3, directedGraph.endVertices(e8)[0]);
		assertEquals(v4, directedGraph.endVertices(e8)[1]);
		assertEquals(v3, directedGraph.endVertices(e9)[0]);
		assertEquals(v5, directedGraph.endVertices(e9)[1]);
		assertEquals(v4, directedGraph.endVertices(e10)[0]);
		assertEquals(v5, directedGraph.endVertices(e10)[1]);
		assertEquals(v5, directedGraph.endVertices(e11)[0]);
		assertEquals(v6, directedGraph.endVertices(e11)[1]);
	}

	/**
	 * Test the output of the opposite(v, e) behavior
	 */
	@Test
	public void testOpposite() {
		Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
		Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
		Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
		Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
		Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");
		Vertex<String> v6 = undirectedGraph.insertVertex("Boone");
		Edge<Integer> e1 = undirectedGraph.insertEdge(v1, v2, 5);
		Edge<Integer> e2 = undirectedGraph.insertEdge(v1, v3, 10);
		Edge<Integer> e3 = undirectedGraph.insertEdge(v1, v4, 15);
		Edge<Integer> e4 = undirectedGraph.insertEdge(v1, v5, 20);
		Edge<Integer> e5 = undirectedGraph.insertEdge(v2, v3, 25);
		Edge<Integer> e6 = undirectedGraph.insertEdge(v2, v4, 30);
		Edge<Integer> e7 = undirectedGraph.insertEdge(v2, v5, 35);
		Edge<Integer> e8 = undirectedGraph.insertEdge(v3, v4, 40);
		Edge<Integer> e9 = undirectedGraph.insertEdge(v3, v5, 45);
		Edge<Integer> e10 = undirectedGraph.insertEdge(v4, v5, 50);

		assertEquals(v2, undirectedGraph.opposite(v1, e1));
		assertEquals(v1, undirectedGraph.opposite(v2, e1));
		assertEquals(v3, undirectedGraph.opposite(v1, e2));
		assertEquals(v1, undirectedGraph.opposite(v3, e2));
		assertEquals(v4, undirectedGraph.opposite(v1, e3));
		assertEquals(v1, undirectedGraph.opposite(v4, e3));
		assertEquals(v5, undirectedGraph.opposite(v1, e4));
		assertEquals(v1, undirectedGraph.opposite(v5, e4));
		assertEquals(v2, undirectedGraph.opposite(v3, e5));
		assertEquals(v3, undirectedGraph.opposite(v2, e5));
		assertEquals(v2, undirectedGraph.opposite(v4, e6));
		assertEquals(v4, undirectedGraph.opposite(v2, e6));
		assertEquals(v2, undirectedGraph.opposite(v5, e7));
		assertEquals(v5, undirectedGraph.opposite(v2, e7));
		assertEquals(v4, undirectedGraph.opposite(v3, e8));
		assertEquals(v3, undirectedGraph.opposite(v4, e8));
		assertEquals(v5, undirectedGraph.opposite(v3, e9));
		assertEquals(v3, undirectedGraph.opposite(v5, e9));
		assertEquals(v5, undirectedGraph.opposite(v4, e10));
		assertEquals(v4, undirectedGraph.opposite(v5, e10));

		// DIRECTED
		v1 = directedGraph.insertVertex("Raleigh");
		v2 = directedGraph.insertVertex("Asheville");
		v3 = directedGraph.insertVertex("Wilmington");
		v4 = directedGraph.insertVertex("Durham");
		v5 = directedGraph.insertVertex("Greenville");
		v6 = directedGraph.insertVertex("Boone");
		e1 = directedGraph.insertEdge(v1, v2, 5);
		e2 = directedGraph.insertEdge(v1, v3, 10);
		e3 = directedGraph.insertEdge(v1, v4, 15);
		e4 = directedGraph.insertEdge(v1, v5, 20);
		e5 = directedGraph.insertEdge(v2, v3, 25);
		e6 = directedGraph.insertEdge(v2, v4, 30);
		e7 = directedGraph.insertEdge(v2, v5, 35);
		e8 = directedGraph.insertEdge(v3, v4, 40);
		e9 = directedGraph.insertEdge(v3, v5, 45);
		e10 = directedGraph.insertEdge(v4, v5, 50);
		Edge<Integer> e11 = directedGraph.insertEdge(v5, v6, 55);

		assertEquals(v2, directedGraph.opposite(v1, e1));
		assertEquals(v1, directedGraph.opposite(v2, e1));
		assertEquals(v3, directedGraph.opposite(v1, e2));
		assertEquals(v1, directedGraph.opposite(v3, e2));
		assertEquals(v4, directedGraph.opposite(v1, e3));
		assertEquals(v1, directedGraph.opposite(v4, e3));
		assertEquals(v5, directedGraph.opposite(v1, e4));
		assertEquals(v1, directedGraph.opposite(v5, e4));
		assertEquals(v2, directedGraph.opposite(v3, e5));
		assertEquals(v3, directedGraph.opposite(v2, e5));
		assertEquals(v2, directedGraph.opposite(v4, e6));
		assertEquals(v4, directedGraph.opposite(v2, e6));
		assertEquals(v2, directedGraph.opposite(v5, e7));
		assertEquals(v5, directedGraph.opposite(v2, e7));
		assertEquals(v4, directedGraph.opposite(v3, e8));
		assertEquals(v3, directedGraph.opposite(v4, e8));
		assertEquals(v5, directedGraph.opposite(v3, e9));
		assertEquals(v3, directedGraph.opposite(v5, e9));
		assertEquals(v5, directedGraph.opposite(v4, e10));
		assertEquals(v4, directedGraph.opposite(v5, e10));
		assertEquals(v5, directedGraph.opposite(v6, e11));
		assertEquals(v6, directedGraph.opposite(v5, e11));
	}

	/**
	 * Test the output of the outDegree(v) behavior
	 */
	@Test
	public void testOutDegree() {
		Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
		Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
		Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
		Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
		Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");
		Vertex<String> v6 = undirectedGraph.insertVertex("Boone");
		undirectedGraph.insertEdge(v1, v2, 5);
		undirectedGraph.insertEdge(v1, v3, 10);
		undirectedGraph.insertEdge(v1, v4, 15);
		undirectedGraph.insertEdge(v1, v5, 20);
		undirectedGraph.insertEdge(v2, v3, 25);
		undirectedGraph.insertEdge(v2, v4, 30);
		undirectedGraph.insertEdge(v2, v5, 35);
		undirectedGraph.insertEdge(v3, v4, 40);
		undirectedGraph.insertEdge(v3, v5, 45);
		undirectedGraph.insertEdge(v4, v5, 50);

		assertEquals(4, undirectedGraph.outDegree(v1));
		assertEquals(4, undirectedGraph.outDegree(v2));
		assertEquals(4, undirectedGraph.outDegree(v3));
		assertEquals(4, undirectedGraph.outDegree(v4));
		assertEquals(4, undirectedGraph.outDegree(v5));

		// DIRECTED
		v1 = directedGraph.insertVertex("Raleigh");
		v2 = directedGraph.insertVertex("Asheville");
		v3 = directedGraph.insertVertex("Wilmington");
		v4 = directedGraph.insertVertex("Durham");
		v5 = directedGraph.insertVertex("Greenville");
		v6 = directedGraph.insertVertex("Boone");
		directedGraph.insertEdge(v1, v2, 5);
		directedGraph.insertEdge(v1, v3, 10);
		directedGraph.insertEdge(v1, v4, 15);
		directedGraph.insertEdge(v1, v5, 20);
		directedGraph.insertEdge(v2, v3, 25);
		directedGraph.insertEdge(v2, v4, 30);
		directedGraph.insertEdge(v2, v5, 35);
		directedGraph.insertEdge(v3, v4, 40);
		directedGraph.insertEdge(v3, v5, 45);
		directedGraph.insertEdge(v4, v5, 50);
		directedGraph.insertEdge(v5, v6, 55);

		assertEquals(4, directedGraph.outDegree(v1));
		assertEquals(3, directedGraph.outDegree(v2));
		assertEquals(2, directedGraph.outDegree(v3));
		assertEquals(1, directedGraph.outDegree(v4));
		assertEquals(1, directedGraph.outDegree(v5));
		assertEquals(0, directedGraph.outDegree(v6));
	}

	/**
	 * Test the output of the inDegree(v) behavior
	 */
	@Test
	public void testInDegree() {
		Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
		Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
		Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
		Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
		Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");
		Vertex<String> v6 = undirectedGraph.insertVertex("Boone");
		undirectedGraph.insertEdge(v1, v2, 5);
		undirectedGraph.insertEdge(v1, v3, 10);
		undirectedGraph.insertEdge(v1, v4, 15);
		undirectedGraph.insertEdge(v1, v5, 20);
		undirectedGraph.insertEdge(v2, v3, 25);
		undirectedGraph.insertEdge(v2, v4, 30);
		undirectedGraph.insertEdge(v2, v5, 35);
		undirectedGraph.insertEdge(v3, v4, 40);
		undirectedGraph.insertEdge(v3, v5, 45);
		undirectedGraph.insertEdge(v4, v5, 50);

		assertEquals(4, undirectedGraph.inDegree(v1));
		assertEquals(4, undirectedGraph.inDegree(v2));
		assertEquals(4, undirectedGraph.inDegree(v3));
		assertEquals(4, undirectedGraph.inDegree(v4));
		assertEquals(4, undirectedGraph.inDegree(v5));

		// DIRECTED
		v1 = directedGraph.insertVertex("Raleigh");
		v2 = directedGraph.insertVertex("Asheville");
		v3 = directedGraph.insertVertex("Wilmington");
		v4 = directedGraph.insertVertex("Durham");
		v5 = directedGraph.insertVertex("Greenville");
		v6 = directedGraph.insertVertex("Boone");
		directedGraph.insertEdge(v1, v2, 5);
		directedGraph.insertEdge(v1, v3, 10);
		directedGraph.insertEdge(v1, v4, 15);
		directedGraph.insertEdge(v1, v5, 20);
		directedGraph.insertEdge(v2, v3, 25);
		directedGraph.insertEdge(v2, v4, 30);
		directedGraph.insertEdge(v2, v5, 35);
		directedGraph.insertEdge(v3, v4, 40);
		directedGraph.insertEdge(v3, v5, 45);
		directedGraph.insertEdge(v4, v5, 50);
		directedGraph.insertEdge(v5, v6, 55);

		assertEquals(0, directedGraph.inDegree(v1));
		assertEquals(1, directedGraph.inDegree(v2));
		assertEquals(2, directedGraph.inDegree(v3));
		assertEquals(3, directedGraph.inDegree(v4));
		assertEquals(4, directedGraph.inDegree(v5));
		assertEquals(1, directedGraph.inDegree(v6));
	}

	/**
	 * Test the output of the outgoingEdges(v) behavior
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testOutgoingEdges() {
		Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
		Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
		Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
		Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
		Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");
		Vertex<String> v6 = undirectedGraph.insertVertex("Boone");
		Edge<Integer> e1 = undirectedGraph.insertEdge(v1, v2, 5);
		Edge<Integer> e2 = undirectedGraph.insertEdge(v1, v3, 10);
		Edge<Integer> e3 = undirectedGraph.insertEdge(v1, v4, 15);
		Edge<Integer> e4 = undirectedGraph.insertEdge(v1, v5, 20);
		Edge<Integer> e5 = undirectedGraph.insertEdge(v2, v3, 25);
		Edge<Integer> e6 = undirectedGraph.insertEdge(v2, v4, 30);
		Edge<Integer> e7 = undirectedGraph.insertEdge(v2, v5, 35);
		Edge<Integer> e8 = undirectedGraph.insertEdge(v3, v4, 40);
		Edge<Integer> e9 = undirectedGraph.insertEdge(v3, v5, 45);
		Edge<Integer> e10 = undirectedGraph.insertEdge(v4, v5, 50);

		// We can use a custom arrayContains() helper method to check that
		// an array *contains* a certain target edge.
		// This is helpful for testing graph ADT behaviors where an order
		// of edges cannot be guaranteed (such as .outgoingEdges or .incomingEdges
		// in adjacencyMaps, etc.)
		Edge<Integer>[] temp = (Edge<Integer>[]) (new Edge[4]);
		int count = 0;
		Iterator<Edge<Integer>> it = undirectedGraph.outgoingEdges(v1).iterator();
		assertTrue(it.hasNext());
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		assertFalse(it.hasNext());
		assertTrue(arrayContains(temp, e1));
		assertTrue(arrayContains(temp, e2));
		assertTrue(arrayContains(temp, e3));
		assertTrue(arrayContains(temp, e4));

		Edge<Integer>[] temp2 = (Edge<Integer>[]) (new Edge[4]);
		int count2 = 0;
		Iterator<Edge<Integer>> it2 = undirectedGraph.outgoingEdges(v2).iterator();
		assertTrue(it2.hasNext());
		temp2[count2] = it2.next();
		count2++;
		temp2[count2] = it2.next();
		count2++;
		temp2[count2] = it2.next();
		count2++;
		temp2[count2++] = it2.next();
		assertFalse(it2.hasNext());
		assertTrue(arrayContains(temp2, e5));
		assertTrue(arrayContains(temp2, e6));
		assertTrue(arrayContains(temp2, e1));
		assertTrue(arrayContains(temp2, e7));

		Edge<Integer>[] temp3 = (Edge<Integer>[]) (new Edge[4]);
		int count3 = 0;
		Iterator<Edge<Integer>> it3 = undirectedGraph.outgoingEdges(v3).iterator();
		assertTrue(it3.hasNext());
		temp3[count3++] = it3.next();
		temp3[count3++] = it3.next();
		temp3[count3++] = it3.next();
		temp3[count3++] = it3.next();
		assertFalse(it3.hasNext());
		assertTrue(arrayContains(temp3, e5));
		assertTrue(arrayContains(temp3, e2));
		assertTrue(arrayContains(temp3, e9));
		assertTrue(arrayContains(temp3, e8));

		Edge<Integer>[] temp4 = (Edge<Integer>[]) (new Edge[4]);
		int count4 = 0;
		Iterator<Edge<Integer>> it4 = undirectedGraph.outgoingEdges(v4).iterator();
		assertTrue(it4.hasNext());
		temp4[count4++] = it4.next();
		temp4[count4++] = it4.next();
		temp4[count4++] = it4.next();
		temp4[count4++] = it4.next();
		assertFalse(it4.hasNext());
		assertTrue(arrayContains(temp4, e3));
		assertTrue(arrayContains(temp4, e6));
		assertTrue(arrayContains(temp4, e10));
		assertTrue(arrayContains(temp4, e8));

		Edge<Integer>[] temp5 = (Edge<Integer>[]) (new Edge[4]);
		int count5 = 0;
		Iterator<Edge<Integer>> it5 = undirectedGraph.outgoingEdges(v5).iterator();
		assertTrue(it5.hasNext());
		temp5[count5++] = it5.next();
		temp5[count5++] = it5.next();
		temp5[count5++] = it5.next();
		temp5[count5++] = it5.next();
		assertFalse(it5.hasNext());
		assertTrue(arrayContains(temp5, e4));
		assertTrue(arrayContains(temp5, e7));
		assertTrue(arrayContains(temp5, e9));
		assertTrue(arrayContains(temp5, e10));

		// DIRECTED
		v1 = directedGraph.insertVertex("Raleigh");
		v2 = directedGraph.insertVertex("Asheville");
		v3 = directedGraph.insertVertex("Wilmington");
		v4 = directedGraph.insertVertex("Durham");
		v5 = directedGraph.insertVertex("Greenville");
		v6 = directedGraph.insertVertex("Boone");
		e1 = directedGraph.insertEdge(v1, v2, 5);
		e2 = directedGraph.insertEdge(v1, v3, 10);
		e3 = directedGraph.insertEdge(v1, v4, 15);
		e4 = directedGraph.insertEdge(v1, v5, 20);
		e5 = directedGraph.insertEdge(v2, v3, 25);
		e6 = directedGraph.insertEdge(v2, v4, 30);
		e7 = directedGraph.insertEdge(v2, v5, 35);
		e8 = directedGraph.insertEdge(v3, v4, 40);
		e9 = directedGraph.insertEdge(v3, v5, 45);
		e10 = directedGraph.insertEdge(v4, v5, 50);
		Edge<Integer> e11 = directedGraph.insertEdge(v5, v6, 55);

		Edge<Integer>[] temp6 = (Edge<Integer>[]) (new Edge[4]);
		int count6 = 0;
		Iterator<Edge<Integer>> it6 = directedGraph.outgoingEdges(v1).iterator();
		assertTrue(it6.hasNext());
		temp6[count6++] = it6.next();
		temp6[count6++] = it6.next();
		temp6[count6++] = it6.next();
		temp6[count6++] = it6.next();
		assertFalse(it6.hasNext());
		assertTrue(arrayContains(temp6, e1));
		assertTrue(arrayContains(temp6, e2));
		assertTrue(arrayContains(temp6, e3));
		assertTrue(arrayContains(temp6, e4));

		Edge<Integer>[] temp7 = (Edge<Integer>[]) (new Edge[3]);
		int count7 = 0;
		Iterator<Edge<Integer>> it7 = directedGraph.outgoingEdges(v2).iterator();
		assertTrue(it7.hasNext());
		temp7[count7++] = it7.next();
		temp7[count7++] = it7.next();
		temp7[count7++] = it7.next();
		assertFalse(it7.hasNext());
		assertTrue(arrayContains(temp7, e5));
		assertTrue(arrayContains(temp7, e6));
		assertTrue(arrayContains(temp7, e7));

		Edge<Integer>[] temp8 = (Edge<Integer>[]) (new Edge[2]);
		int count8 = 0;
		Iterator<Edge<Integer>> it8 = directedGraph.outgoingEdges(v3).iterator();
		assertTrue(it8.hasNext());
		temp8[count8++] = it8.next();
		temp8[count8++] = it8.next();
		assertFalse(it6.hasNext());
		assertTrue(arrayContains(temp8, e8));
		assertTrue(arrayContains(temp8, e9));

		Edge<Integer>[] temp9 = (Edge<Integer>[]) (new Edge[1]);
		int count9 = 0;
		Iterator<Edge<Integer>> it9 = directedGraph.outgoingEdges(v4).iterator();
		assertTrue(it9.hasNext());
		temp9[count9++] = it9.next();
		assertFalse(it9.hasNext());
		assertTrue(arrayContains(temp9, e10));

		Edge<Integer>[] temp10 = (Edge<Integer>[]) (new Edge[1]);
		int count10 = 0;
		Iterator<Edge<Integer>> it10 = directedGraph.outgoingEdges(v5).iterator();
		assertTrue(it10.hasNext());
		temp10[count10++] = it10.next();
		assertFalse(it10.hasNext());
		assertTrue(arrayContains(temp10, e11));

		Edge<Integer>[] temp11 = (Edge<Integer>[]) (new Edge[0]);
		Iterator<Edge<Integer>> it11 = directedGraph.outgoingEdges(v6).iterator();
		assertFalse(it11.hasNext());
		assertFalse(arrayContains(temp11, e11));

	}

	// Helper method to check that an array contains a certain target.
	// This is helpful for testing graph ADT behaviors where an order
	// of edges cannot be guaranteed (such as .outgoingEdges or .incomingEdges)
	private boolean arrayContains(Edge<Integer>[] temp, Edge<Integer> target) {
		for (Edge<Integer> e : temp) {
			if (e == target) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Test the output of the incomingEdges(v) behavior
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testIncomingEdges() {
		Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
		Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
		Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
		Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
		Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");
		Vertex<String> v6 = undirectedGraph.insertVertex("Boone");
		Edge<Integer> e1 = undirectedGraph.insertEdge(v1, v2, 5);
		Edge<Integer> e2 = undirectedGraph.insertEdge(v1, v3, 10);
		Edge<Integer> e3 = undirectedGraph.insertEdge(v1, v4, 15);
		Edge<Integer> e4 = undirectedGraph.insertEdge(v1, v5, 20);
		Edge<Integer> e5 = undirectedGraph.insertEdge(v2, v3, 25);
		Edge<Integer> e6 = undirectedGraph.insertEdge(v2, v4, 30);
		Edge<Integer> e7 = undirectedGraph.insertEdge(v2, v5, 35);
		Edge<Integer> e8 = undirectedGraph.insertEdge(v3, v4, 40);
		Edge<Integer> e9 = undirectedGraph.insertEdge(v3, v5, 45);
		Edge<Integer> e10 = undirectedGraph.insertEdge(v4, v5, 50);

		Edge<Integer>[] temp = (Edge<Integer>[]) (new Edge[4]);
		int count = 0;
		Iterator<Edge<Integer>> it = undirectedGraph.incomingEdges(v1).iterator();
		assertTrue(it.hasNext());
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		assertFalse(it.hasNext());
		assertTrue(arrayContains(temp, e1));
		assertTrue(arrayContains(temp, e2));
		assertTrue(arrayContains(temp, e3));
		assertTrue(arrayContains(temp, e4));

		Edge<Integer>[] temp2 = (Edge<Integer>[]) (new Edge[4]);
		int count2 = 0;
		Iterator<Edge<Integer>> it2 = undirectedGraph.incomingEdges(v2).iterator();
		assertTrue(it2.hasNext());
		temp2[count2] = it2.next();
		count2++;
		temp2[count2] = it2.next();
		count2++;
		temp2[count2] = it2.next();
		count2++;
		temp2[count2++] = it2.next();
		assertFalse(it2.hasNext());
		assertTrue(arrayContains(temp2, e5));
		assertTrue(arrayContains(temp2, e6));
		assertTrue(arrayContains(temp2, e1));
		assertTrue(arrayContains(temp2, e7));

		Edge<Integer>[] temp3 = (Edge<Integer>[]) (new Edge[4]);
		int count3 = 0;
		Iterator<Edge<Integer>> it3 = undirectedGraph.incomingEdges(v3).iterator();
		assertTrue(it3.hasNext());
		temp3[count3++] = it3.next();
		temp3[count3++] = it3.next();
		temp3[count3++] = it3.next();
		temp3[count3++] = it3.next();
		assertFalse(it3.hasNext());
		assertTrue(arrayContains(temp3, e5));
		assertTrue(arrayContains(temp3, e2));
		assertTrue(arrayContains(temp3, e9));
		assertTrue(arrayContains(temp3, e8));

		Edge<Integer>[] temp4 = (Edge<Integer>[]) (new Edge[4]);
		int count4 = 0;
		Iterator<Edge<Integer>> it4 = undirectedGraph.incomingEdges(v4).iterator();
		assertTrue(it4.hasNext());
		temp4[count4++] = it4.next();
		temp4[count4++] = it4.next();
		temp4[count4++] = it4.next();
		temp4[count4++] = it4.next();
		assertFalse(it4.hasNext());
		assertTrue(arrayContains(temp4, e3));
		assertTrue(arrayContains(temp4, e6));
		assertTrue(arrayContains(temp4, e10));
		assertTrue(arrayContains(temp4, e8));

		Edge<Integer>[] temp5 = (Edge<Integer>[]) (new Edge[4]);
		int count5 = 0;
		Iterator<Edge<Integer>> it5 = undirectedGraph.incomingEdges(v5).iterator();
		assertTrue(it5.hasNext());
		temp5[count5++] = it5.next();
		temp5[count5++] = it5.next();
		temp5[count5++] = it5.next();
		temp5[count5++] = it5.next();
		assertFalse(it5.hasNext());
		assertTrue(arrayContains(temp5, e4));
		assertTrue(arrayContains(temp5, e7));
		assertTrue(arrayContains(temp5, e9));
		assertTrue(arrayContains(temp5, e10));

		// DIRECTED
		v1 = directedGraph.insertVertex("Raleigh");
		v2 = directedGraph.insertVertex("Asheville");
		v3 = directedGraph.insertVertex("Wilmington");
		v4 = directedGraph.insertVertex("Durham");
		v5 = directedGraph.insertVertex("Greenville");
		v6 = directedGraph.insertVertex("Boone");
		e1 = directedGraph.insertEdge(v1, v2, 5);
		e2 = directedGraph.insertEdge(v1, v3, 10);
		e3 = directedGraph.insertEdge(v1, v4, 15);
		e4 = directedGraph.insertEdge(v1, v5, 20);
		e5 = directedGraph.insertEdge(v2, v3, 25);
		e6 = directedGraph.insertEdge(v2, v4, 30);
		e7 = directedGraph.insertEdge(v2, v5, 35);
		e8 = directedGraph.insertEdge(v3, v4, 40);
		e9 = directedGraph.insertEdge(v3, v5, 45);
		e10 = directedGraph.insertEdge(v4, v5, 50);
		Edge<Integer> e11 = directedGraph.insertEdge(v5, v6, 55);

		Edge<Integer>[] temp6 = (Edge<Integer>[]) (new Edge[0]);
		Iterator<Edge<Integer>> it6 = directedGraph.incomingEdges(v1).iterator();
		assertFalse(it6.hasNext());
		assertFalse(arrayContains(temp6, e1));

		Edge<Integer>[] temp7 = (Edge<Integer>[]) (new Edge[1]);
		int count7 = 0;
		Iterator<Edge<Integer>> it7 = directedGraph.incomingEdges(v2).iterator();
		assertTrue(it7.hasNext());
		temp7[count7++] = it7.next();
		assertFalse(it7.hasNext());
		assertTrue(arrayContains(temp7, e1));

		Edge<Integer>[] temp8 = (Edge<Integer>[]) (new Edge[2]);
		int count8 = 0;
		Iterator<Edge<Integer>> it8 = directedGraph.incomingEdges(v3).iterator();
		assertTrue(it8.hasNext());
		temp8[count8++] = it8.next();
		temp8[count8++] = it8.next();
		assertFalse(it6.hasNext());
		assertTrue(arrayContains(temp8, e2));
		assertTrue(arrayContains(temp8, e5));

		Edge<Integer>[] temp9 = (Edge<Integer>[]) (new Edge[3]);
		int count9 = 0;
		Iterator<Edge<Integer>> it9 = directedGraph.incomingEdges(v4).iterator();
		assertTrue(it9.hasNext());
		temp9[count9++] = it9.next();
		temp9[count9++] = it9.next();
		temp9[count9++] = it9.next();
		assertFalse(it9.hasNext());
		assertTrue(arrayContains(temp9, e3));
		assertTrue(arrayContains(temp9, e6));
		assertTrue(arrayContains(temp9, e8));

		Edge<Integer>[] temp10 = (Edge<Integer>[]) (new Edge[4]);
		int count10 = 0;
		Iterator<Edge<Integer>> it10 = directedGraph.incomingEdges(v5).iterator();
		assertTrue(it10.hasNext());
		temp10[count10++] = it10.next();
		temp10[count10++] = it10.next();
		temp10[count10++] = it10.next();
		temp10[count10++] = it10.next();
		assertFalse(it10.hasNext());
		assertTrue(arrayContains(temp10, e4));
		assertTrue(arrayContains(temp10, e7));
		assertTrue(arrayContains(temp10, e9));
		assertTrue(arrayContains(temp10, e10));

		Edge<Integer>[] temp11 = (Edge<Integer>[]) (new Edge[1]);
		int count11 = 0;
		Iterator<Edge<Integer>> it11 = directedGraph.incomingEdges(v6).iterator();
		assertTrue(it11.hasNext());
		temp11[count11++] = it11.next();
		assertFalse(it11.hasNext());
		assertTrue(arrayContains(temp11, e11));
	}

	/**
	 * Test the output of the insertVertex(x) behavior
	 */
	@Test
	public void testInsertVertex() {
		assertEquals(0, undirectedGraph.numVertices());
		Vertex<String> v1 = undirectedGraph.insertVertex("Fayetteville");
		assertEquals(1, undirectedGraph.numVertices());

		Iterator<Vertex<String>> it = undirectedGraph.vertices().iterator();
		assertTrue(it.hasNext());
		assertEquals(v1, it.next());
		assertFalse(it.hasNext());

		Vertex<String> v2 = undirectedGraph.insertVertex("v2");
		Vertex<String> v3 = undirectedGraph.insertVertex("v3");
		Vertex<String> v4 = undirectedGraph.insertVertex("v4");
		Vertex<String> v5 = undirectedGraph.insertVertex("v5");

		it = undirectedGraph.vertices().iterator();

		assertEquals(v1, it.next());
		assertEquals(v2, it.next());
		assertEquals(v3, it.next());
		assertEquals(v4, it.next());
		assertEquals(v5, it.next());

	}

	/**
	 * Test the output of the insertEdge(v1, v2, x) behavior
	 */
	@Test
	public void testInsertEdge() {
		Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
		Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");

		assertEquals(0, undirectedGraph.numEdges());
		Edge<Integer> e1 = undirectedGraph.insertEdge(v1, v2, 99);
		assertEquals(1, undirectedGraph.numEdges());
		Iterator<Edge<Integer>> it = undirectedGraph.edges().iterator();
		assertTrue(it.hasNext());
		assertEquals(e1, it.next());
		assertFalse(it.hasNext());

		Vertex<String> v3 = undirectedGraph.insertVertex("v3");
		Vertex<String> v4 = undirectedGraph.insertVertex("v4");

		Edge<Integer> e2 = undirectedGraph.insertEdge(v3, v4, 10);

		it = undirectedGraph.edges().iterator();

		assertEquals(e1, it.next());
		assertEquals(e2, it.next());

	}

	/**
	 * Test the output of the removeVertex(v) behavior
	 */
	@Test
	public void testRemoveVertex() {
		Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
		Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
		Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
		Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
		Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");
		Edge<Integer> e1 = undirectedGraph.insertEdge(v1, v2, 5);
		Edge<Integer> e2 = undirectedGraph.insertEdge(v1, v3, 10);
		Edge<Integer> e3 = undirectedGraph.insertEdge(v1, v4, 15);
		Edge<Integer> e4 = undirectedGraph.insertEdge(v1, v5, 20);
		Edge<Integer> e5 = undirectedGraph.insertEdge(v2, v3, 25);
		Edge<Integer> e6 = undirectedGraph.insertEdge(v2, v4, 30);
		Edge<Integer> e7 = undirectedGraph.insertEdge(v2, v5, 35);
		Edge<Integer> e8 = undirectedGraph.insertEdge(v3, v4, 40);
		Edge<Integer> e9 = undirectedGraph.insertEdge(v3, v5, 45);
		Edge<Integer> e10 = undirectedGraph.insertEdge(v4, v5, 50);

		assertEquals(5, undirectedGraph.numVertices());
		assertEquals(10, undirectedGraph.numEdges());
		undirectedGraph.removeVertex(v5);
		assertEquals(4, undirectedGraph.numVertices());
		assertEquals(6, undirectedGraph.numEdges());

		Iterator<Edge<Integer>> it = undirectedGraph.edges().iterator();
		assertEquals(e1, it.next());
		assertEquals(e2, it.next());
		assertEquals(e3, it.next());
		assertEquals(e5, it.next());
		assertEquals(e6, it.next());
		assertEquals(e8, it.next());

		@SuppressWarnings("unchecked")
		Edge<Integer>[] temp = (Edge<Integer>[]) (new Edge[6]);
		int count = 0;
		Iterator<Edge<Integer>> it2 = undirectedGraph.edges().iterator();
		temp[count++] = it2.next();
		temp[count++] = it2.next();
		temp[count++] = it2.next();
		temp[count++] = it2.next();
		temp[count++] = it2.next();
		temp[count++] = it2.next();
		assertFalse(it2.hasNext());
		assertFalse(arrayContains(temp, e4));
		assertFalse(arrayContains(temp, e10));
		assertFalse(arrayContains(temp, e9));
		assertFalse(arrayContains(temp, e7));

		// DIRECTED
		v1 = directedGraph.insertVertex("Raleigh");
		v2 = directedGraph.insertVertex("Asheville");
		v3 = directedGraph.insertVertex("Wilmington");
		v4 = directedGraph.insertVertex("Durham");
		v5 = directedGraph.insertVertex("Greenville");
		Vertex<String> v6 = directedGraph.insertVertex("Boone");
		e1 = directedGraph.insertEdge(v1, v2, 5);
		e2 = directedGraph.insertEdge(v1, v3, 10);
		e3 = directedGraph.insertEdge(v1, v4, 15);
		e4 = directedGraph.insertEdge(v1, v5, 20);
		e5 = directedGraph.insertEdge(v2, v3, 25);
		e6 = directedGraph.insertEdge(v2, v4, 30);
		e7 = directedGraph.insertEdge(v2, v5, 35);
		e8 = directedGraph.insertEdge(v3, v4, 40);
		e9 = directedGraph.insertEdge(v3, v5, 45);
		e10 = directedGraph.insertEdge(v4, v5, 50);
		Edge<Integer> e11 = directedGraph.insertEdge(v5, v6, 55);

		assertEquals(6, directedGraph.numVertices());
		assertEquals(11, directedGraph.numEdges());
		directedGraph.removeVertex(v6);
		assertEquals(5, directedGraph.numVertices());
		assertEquals(10, directedGraph.numEdges());

		Iterator<Edge<Integer>> it3 = directedGraph.edges().iterator();
		assertEquals(e1, it3.next());
		assertEquals(e2, it3.next());
		assertEquals(e3, it3.next());
		assertEquals(e4, it3.next());
		assertEquals(e5, it3.next());
		assertEquals(e6, it3.next());
		assertEquals(e7, it3.next());
		assertEquals(e8, it3.next());
		assertEquals(e9, it3.next());
		assertEquals(e10, it3.next());

		@SuppressWarnings("unchecked")
		Edge<Integer>[] temp2 = (Edge<Integer>[]) (new Edge[10]);
		int count3 = 0;
		Iterator<Edge<Integer>> it4 = directedGraph.edges().iterator();
		temp2[count3++] = it4.next();
		temp2[count3++] = it4.next();
		temp2[count3++] = it4.next();
		temp2[count3++] = it4.next();
		temp2[count3++] = it4.next();
		temp2[count3++] = it4.next();
		temp2[count3++] = it4.next();
		temp2[count3++] = it4.next();
		temp2[count3++] = it4.next();
		temp2[count3++] = it4.next();
		assertFalse(it2.hasNext());
		assertFalse(arrayContains(temp, e11));
	}

	/**
	 * Test the output of the removeEdge(e) behavior
	 */
	@Test
	public void testRemoveEdge() {
		Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
		Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
		Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
		Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
		Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");
		Vertex<String> v6 = undirectedGraph.insertVertex("Boone");
		Edge<Integer> e1 = undirectedGraph.insertEdge(v1, v2, 5);
		Edge<Integer> e2 = undirectedGraph.insertEdge(v1, v3, 10);
		Edge<Integer> e3 = undirectedGraph.insertEdge(v1, v4, 15);
		Edge<Integer> e4 = undirectedGraph.insertEdge(v1, v5, 20);
		Edge<Integer> e5 = undirectedGraph.insertEdge(v2, v3, 25);
		Edge<Integer> e6 = undirectedGraph.insertEdge(v2, v4, 30);
		Edge<Integer> e7 = undirectedGraph.insertEdge(v2, v5, 35);
		Edge<Integer> e8 = undirectedGraph.insertEdge(v3, v4, 40);
		Edge<Integer> e9 = undirectedGraph.insertEdge(v3, v5, 45);
		Edge<Integer> e10 = undirectedGraph.insertEdge(v4, v5, 50);
		Edge<Integer> e11 = undirectedGraph.insertEdge(v5, v6, 50);

		assertEquals(6, undirectedGraph.numVertices());
		assertEquals(11, undirectedGraph.numEdges());
		undirectedGraph.removeEdge(e1);
		assertEquals(6, undirectedGraph.numVertices());
		assertEquals(10, undirectedGraph.numEdges());

		Iterator<Edge<Integer>> it = undirectedGraph.edges().iterator();
		assertEquals(e2, it.next());
		assertEquals(e3, it.next());
		assertEquals(e4, it.next());
		assertEquals(e5, it.next());
		assertEquals(e6, it.next());
		assertEquals(e7, it.next());
		assertEquals(e8, it.next());
		assertEquals(e9, it.next());
		assertEquals(e10, it.next());
		assertEquals(e11, it.next());

		@SuppressWarnings("unchecked")
		Edge<Integer>[] temp = (Edge<Integer>[]) (new Edge[10]);
		int count = 0;
		Iterator<Edge<Integer>> it2 = undirectedGraph.edges().iterator();
		temp[count++] = it2.next();
		temp[count++] = it2.next();
		temp[count++] = it2.next();
		temp[count++] = it2.next();
		temp[count++] = it2.next();
		temp[count++] = it2.next();
		temp[count++] = it2.next();
		temp[count++] = it2.next();
		temp[count++] = it2.next();
		temp[count++] = it2.next();
		assertFalse(it2.hasNext());
		assertFalse(arrayContains(temp, e1));

		// DIRECTED
		v1 = directedGraph.insertVertex("Raleigh");
		v2 = directedGraph.insertVertex("Asheville");
		v3 = directedGraph.insertVertex("Wilmington");
		v4 = directedGraph.insertVertex("Durham");
		v5 = directedGraph.insertVertex("Greenville");
		v6 = directedGraph.insertVertex("Boone");
		e1 = directedGraph.insertEdge(v1, v2, 5);
		e2 = directedGraph.insertEdge(v1, v3, 10);
		e3 = directedGraph.insertEdge(v1, v4, 15);
		e4 = directedGraph.insertEdge(v1, v5, 20);
		e5 = directedGraph.insertEdge(v2, v3, 25);
		e6 = directedGraph.insertEdge(v2, v4, 30);
		e7 = directedGraph.insertEdge(v2, v5, 35);
		e8 = directedGraph.insertEdge(v3, v4, 40);
		e9 = directedGraph.insertEdge(v3, v5, 45);
		e10 = directedGraph.insertEdge(v4, v5, 50);

		assertEquals(6, directedGraph.numVertices());
		assertEquals(10, directedGraph.numEdges());
		directedGraph.removeEdge(e1);
		assertEquals(6, directedGraph.numVertices());
		assertEquals(9, directedGraph.numEdges());

		Iterator<Edge<Integer>> it3 = directedGraph.edges().iterator();
		assertEquals(e2, it3.next());
		assertEquals(e3, it3.next());
		assertEquals(e4, it3.next());
		assertEquals(e5, it3.next());
		assertEquals(e6, it3.next());
		assertEquals(e7, it3.next());
		assertEquals(e8, it3.next());
		assertEquals(e9, it3.next());
		assertEquals(e10, it3.next());

		@SuppressWarnings("unchecked")
		Edge<Integer>[] temp2 = (Edge<Integer>[]) (new Edge[9]);
		int count2 = 0;
		Iterator<Edge<Integer>> it4 = directedGraph.edges().iterator();
		temp2[count2++] = it4.next();
		temp2[count2++] = it4.next();
		temp2[count2++] = it4.next();
		temp2[count2++] = it4.next();
		temp2[count2++] = it4.next();
		temp2[count2++] = it4.next();
		temp2[count2++] = it4.next();
		temp2[count2++] = it4.next();
		temp2[count2++] = it4.next();
		assertFalse(it3.hasNext());
		assertFalse(arrayContains(temp, e1));
	}

}