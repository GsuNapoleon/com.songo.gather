/**
 * 
 */
package com.songo.gather.algorithm.graphtheory;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * <p>decription:</p>
 * <p>date:2014年7月25日 下午3:15:24</p>
 * @author gsu·napoleon
 */
public class DijkstraTest {

	/**
	 * <p>decription:</p>
	 * <p>date:2014年7月25日 下午3:15:24</p>
	 * @author gsu·napoleon
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		
		List<Vertex> vertexes = createVertexes();
		if (vertexes == null || vertexes.isEmpty()) {
			return;
		}
		for (Vertex v : vertexes) {
			System.out.println(v);
		}
		
		List<Edge> edges = createEdges();
		if (edges == null || edges.isEmpty()) {
			return;
		}
		for (Edge e : edges) {
			System.out.println(e);
		}
		
		Graph graph = new Graph(vertexes, edges);
		
//		DijkstraAlgorithm da = new DijkstraAlgorithm(graph);
//		da.execute(new Vertex("1", "A"));
		Vertex destVertex = new Vertex("5", "E");
		Dijkstra dijkstra = new Dijkstra(graph);
		dijkstra.execute(new Vertex("1", "A"));
		int distance = dijkstra.getShortestDistance(destVertex);
		System.out.println(distance);
		List<Vertex> shortPaths = dijkstra.getPath(destVertex);
		for (Vertex path : shortPaths) {
			System.out.println(path);
		}
	}

	private List<Vertex> createVertexes() {
		List<Vertex> vertexes = new ArrayList<Vertex>();
		vertexes.add(new Vertex("1", "A"));
		vertexes.add(new Vertex("2", "B"));
		vertexes.add(new Vertex("3", "C"));
		vertexes.add(new Vertex("4", "D"));
		vertexes.add(new Vertex("5", "E"));
		vertexes.add(new Vertex("6", "F"));
		return vertexes;
	}
	
	private List<Edge> createEdges() {
		List<Edge> edges = new ArrayList<Edge>();
		edges.add(new Edge("AB", new Vertex("1", "A"), new Vertex("2", "B"), 7));
		edges.add(new Edge("AC", new Vertex("1", "A"), new Vertex("3", "C"), 9));
		edges.add(new Edge("AF", new Vertex("1", "A"), new Vertex("6", "F"), 14));
		edges.add(new Edge("BC", new Vertex("2", "B"), new Vertex("3", "C"), 10));
		edges.add(new Edge("BD", new Vertex("2", "B"), new Vertex("4", "D"), 15));
		edges.add(new Edge("CD", new Vertex("3", "C"), new Vertex("4", "D"), 11));
		edges.add(new Edge("CF", new Vertex("3", "C"), new Vertex("6", "F"), 2));
		edges.add(new Edge("FE", new Vertex("6", "F"), new Vertex("5", "E"), 9));
		edges.add(new Edge("DE", new Vertex("4", "D"), new Vertex("5", "E"), 6));
		
		return edges;
	}
}
