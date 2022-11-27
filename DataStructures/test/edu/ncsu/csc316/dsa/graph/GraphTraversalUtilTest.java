package edu.ncsu.csc316.dsa.graph;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.dsa.graph.Graph.Edge;
import edu.ncsu.csc316.dsa.graph.Graph.Vertex;

/**
 * Test GraphTraversalUtil class
 * @author TungTran
 *
 */
public class GraphTraversalUtilTest {

	/**
	 * Test DFS
	 */
	@Test
	public void testDFS() {
		Graph<Integer, String> undirectedGraph = new AdjacencyListGraph<Integer, String>();
		Vertex<Integer> v1 = undirectedGraph.insertVertex(1);
		Vertex<Integer> v2 = undirectedGraph.insertVertex(2);
		Vertex<Integer> v3 = undirectedGraph.insertVertex(3);
		Vertex<Integer> v4 = undirectedGraph.insertVertex(4);
		Vertex<Integer> v5 = undirectedGraph.insertVertex(5);
		Vertex<Integer> v6 = undirectedGraph.insertVertex(6);
		Vertex<Integer> v7 = undirectedGraph.insertVertex(7);
		Vertex<Integer> v8 = undirectedGraph.insertVertex(8);
		Vertex<Integer> v9 = undirectedGraph.insertVertex(9);
		Vertex<Integer> v10 = undirectedGraph.insertVertex(10);
		Vertex<Integer> v11 = undirectedGraph.insertVertex(11);
		Edge<String> e1 = undirectedGraph.insertEdge(v1, v2, "1-2");
		Edge<String> e2 = undirectedGraph.insertEdge(v2, v3, "2-3");
		Edge<String> e4 = undirectedGraph.insertEdge(v3, v11, "2-11");
		Edge<String> e5 = undirectedGraph.insertEdge(v9, v11, "9-11");
		Edge<String> e8 = undirectedGraph.insertEdge(v9, v4, "9-4");
		Edge<String> e9 = undirectedGraph.insertEdge(v10, v6, "6-10");
		Edge<String> e12 = undirectedGraph.insertEdge(v6, v4, "4-6");
		Edge<String> e13 = undirectedGraph.insertEdge(v5, v4, "4-5");
		Edge<String> e14 = undirectedGraph.insertEdge(v6, v7, "6-7");
		Edge<String> e15 = undirectedGraph.insertEdge(v7, v8, "7-8");
		assertEquals(e1, GraphTraversalUtil.depthFirstSearch(undirectedGraph, v1).get(v2));
		assertEquals(e2, GraphTraversalUtil.depthFirstSearch(undirectedGraph, v1).get(v3));
		assertEquals(e4, GraphTraversalUtil.depthFirstSearch(undirectedGraph, v1).get(v11));
		assertEquals(e5, GraphTraversalUtil.depthFirstSearch(undirectedGraph, v1).get(v9));
		assertEquals(e8, GraphTraversalUtil.depthFirstSearch(undirectedGraph, v1).get(v4));
		assertEquals(e13, GraphTraversalUtil.depthFirstSearch(undirectedGraph, v1).get(v5));
		assertEquals(e12, GraphTraversalUtil.depthFirstSearch(undirectedGraph, v1).get(v6));
		assertEquals(e14, GraphTraversalUtil.depthFirstSearch(undirectedGraph, v1).get(v7));
		assertEquals(e15, GraphTraversalUtil.depthFirstSearch(undirectedGraph, v1).get(v8));
		assertEquals(e9, GraphTraversalUtil.depthFirstSearch(undirectedGraph, v1).get(v10));
	}
	
	/**
	 * Test BFS
	 */
	@Test
	public void testBFS() {
		Graph<Integer, String> undirectedGraph = new AdjacencyListGraph<Integer, String>();
		Vertex<Integer> v1 = undirectedGraph.insertVertex(1);
		Vertex<Integer> v2 = undirectedGraph.insertVertex(2);
		Vertex<Integer> v3 = undirectedGraph.insertVertex(3);
		Vertex<Integer> v4 = undirectedGraph.insertVertex(4);
		Vertex<Integer> v5 = undirectedGraph.insertVertex(5);
		Vertex<Integer> v6 = undirectedGraph.insertVertex(6);
		Vertex<Integer> v7 = undirectedGraph.insertVertex(7);
		Vertex<Integer> v8 = undirectedGraph.insertVertex(8);
		Vertex<Integer> v9 = undirectedGraph.insertVertex(9);
		Vertex<Integer> v10 = undirectedGraph.insertVertex(10);
		Vertex<Integer> v11 = undirectedGraph.insertVertex(11);
		Edge<String> e1 = undirectedGraph.insertEdge(v1, v2, "1-2");
		Edge<String> e2 = undirectedGraph.insertEdge(v1, v3, "1-3");
		Edge<String> e3 = undirectedGraph.insertEdge(v3, v11, "2-11");
		Edge<String> e4 = undirectedGraph.insertEdge(v9, v11, "9-11");
		Edge<String> e5 = undirectedGraph.insertEdge(v9, v4, "9-4");
		Edge<String> e6 = undirectedGraph.insertEdge(v6, v9, "9-6");
		Edge<String> e7 = undirectedGraph.insertEdge(v5, v4, "4-5");
		Edge<String> e8 = undirectedGraph.insertEdge(v6, v7, "6-7");
		Edge<String> e9 = undirectedGraph.insertEdge(v6, v8, "6-8");
		Edge<String> e10 = undirectedGraph.insertEdge(v10, v11, "10-11");
		assertEquals(e1, GraphTraversalUtil.breadthFirstSearch(undirectedGraph, v1).get(v2));
		assertEquals(e2, GraphTraversalUtil.breadthFirstSearch(undirectedGraph, v1).get(v3));
		assertEquals(e3, GraphTraversalUtil.breadthFirstSearch(undirectedGraph, v1).get(v11));
		assertEquals(e4, GraphTraversalUtil.breadthFirstSearch(undirectedGraph, v1).get(v9));
		assertEquals(e10, GraphTraversalUtil.breadthFirstSearch(undirectedGraph, v1).get(v10));
		assertEquals(e5, GraphTraversalUtil.breadthFirstSearch(undirectedGraph, v1).get(v4));
		assertEquals(e6, GraphTraversalUtil.breadthFirstSearch(undirectedGraph, v1).get(v6));
		assertEquals(e7, GraphTraversalUtil.breadthFirstSearch(undirectedGraph, v1).get(v5));
		assertEquals(e8, GraphTraversalUtil.breadthFirstSearch(undirectedGraph, v1).get(v7));
		assertEquals(e9, GraphTraversalUtil.breadthFirstSearch(undirectedGraph, v1).get(v8));
		
	}

}
