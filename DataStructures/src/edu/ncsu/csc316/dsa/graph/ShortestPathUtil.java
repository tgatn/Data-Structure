package edu.ncsu.csc316.dsa.graph;

import edu.ncsu.csc316.dsa.Weighted;
import edu.ncsu.csc316.dsa.graph.Graph.Edge;
import edu.ncsu.csc316.dsa.graph.Graph.Vertex;
import edu.ncsu.csc316.dsa.map.Map;
import edu.ncsu.csc316.dsa.map.hashing.LinearProbingHashMap;
import edu.ncsu.csc316.dsa.priority_queue.AdaptablePriorityQueue;
import edu.ncsu.csc316.dsa.priority_queue.HeapAdaptablePriorityQueue;
import edu.ncsu.csc316.dsa.priority_queue.PriorityQueue.Entry;
import edu.ncsu.csc316.dsa.set.HashSet;
import edu.ncsu.csc316.dsa.set.Set;

/**
 * ShortestPathUtil provides a collection of behaviors for computing shortest
 * path spanning trees for a given graph.
 * 
 * The ShortestPathUtil class is based on the textbook:
 *
 * Data Structures and Algorithms in Java, Sixth Edition Michael T. Goodrich,
 * Roberto Tamassia, and Michael H. Goldwasser John Wiley and Sons, 2014
 * 
 * @author Dr. King
 * @author Tung Tran
 *
 */
public class ShortestPathUtil {
    
    /**
     * For a connected graph, returns a map that represents shortest path costs to
     * all vertices computed using Dijkstra's single-source shortest path algorithm.
     * 
     * @param <V>   the type of data in the graph vertices
     * @param <E>   the type of data in the graph edges
     * @param graph the graph for which to compute the shortest path spanning tree
     * @param start the vertex at which to start computing the shorest path spanning
     *              tree
     * @return a map that represents the shortest path costs to all vertices in the
     *         graph
     */ 
    public static <V, E extends Weighted> Map<Vertex<V>, Integer> dijkstra(Graph<V, E> graph, Vertex<V> start) {
        //NOTE: since Dijkstra's algorithm is very similar to Prim-Jarnik's algorithm,
        //     you should review the provided Prim-Jarnik implementation in the next
        //     section of the lab on Minimum Spanning Trees
    	AdaptablePriorityQueue<Integer, Vertex<V>> q = new HeapAdaptablePriorityQueue<>();
    	Map<Vertex<V>, Integer> cost = new LinearProbingHashMap<>();
    	Set<Vertex<V>> found = new HashSet<>();
    	Map<Vertex<V>, Entry<Integer, Vertex<V>>> e = new LinearProbingHashMap<>();
    	
    	for (Vertex<V> v : graph.vertices()) {
    		if (v == start) {
    			cost.put(v, 0);
    		} else {
    			cost.put(v, Integer.MAX_VALUE);
    		}
    		e.put(v, q.insert(cost.get(v), v));
    	}
    	while (!q.isEmpty()) {
    		Entry<Integer, Vertex<V>> entry = q.deleteMin();
    		Vertex<V> u = entry.getValue();
    		found.add(u);
    		for (Edge<E> edge : graph.outgoingEdges(u)) {
    			Vertex<V> z = graph.opposite(u, edge);
    			if (!found.contains(z)) {
    				int r = edge.getElement().getWeight() + cost.get(u);
    				if (r < cost.get(z)) {
    					cost.put(z, r);
    					q.replaceKey(e.get(z), r);
    				}
    			}
    		}
    	}
    	return cost;
    }
    
    /**
     * For a connected graph, returns a map that represents shortest path spanning
     * tree edges computed using Dijkstra's single-source shortest path algorithm.
     * 
     * @param <V>       the type of data in the graph vertices
     * @param <E>       the type of data in the graph edges
     * @param graph         the graph for which to compute the shortest path spanning
     *                  tree
     * @param start         the vertex at which to start computing the shortest path
     *                  spanning tree
     * @param costs the map of shortest path costs to reach each vertex in the
     *                  graph
     * @return a map that represents the shortest path spanning tree edges
     */ 
    public static <V, E extends Weighted> Map<Vertex<V>, Edge<E>> shortestPathTree(Graph<V, E> graph, Vertex<V> start, Map<Vertex<V>, Integer> costs) {
    	Map<Vertex<V>, Edge<E>> m = new LinearProbingHashMap<>();
    	for (Vertex<V> v : costs) {
    		if (v != start) {
    			for (Edge<E> e : graph.incomingEdges(v)) {
    				Vertex<V> u = graph.opposite(v, e);
    				if (costs.get(v) == costs.get(u) + e.getElement().getWeight()) {
    					m.put(v, e);
    				}
    			}
    		}
    	}
    	return m;
    }
}