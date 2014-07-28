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
 * <p>date:2014年7月28日 下午2:09:58</p>
 * @author gsu·napoleon
 */
public class MetroGraphTest {

	/**
	 * <p>decription:</p>
	 * <p>date:2014年7月28日 下午2:09:58</p>
	 * @author gsu·napoleon
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}
	
	private final List<Vertex> vertexes = new ArrayList<Vertex>();
	private final List<Edge> edges = new ArrayList<Edge>();
	
	@Test
	public void test() {
		createVertexesAndEdges();
		System.out.println(vertexes);
		System.out.println(edges);
		Graph graph = new Graph(vertexes, edges);
		Dijkstra dijkstra = new Dijkstra(graph);
		Vertex source = new Vertex("L3-1", "L3-1");
		dijkstra.execute(source);
		Vertex dest = new Vertex("X4", "X4");
		int distance = dijkstra.getShortestDistance(dest);
		System.out.println(distance);
	}

	private void createVertexesAndEdges() {
		List<Vertex> l1 = getVertexes("L1-", 14);
		List<Vertex> l2 = getVertexes("L2-", 16);
		List<Vertex> l3 = getVertexes("L3-", 13);
		List<Vertex> l4 = getVertexes("L4-", 16);
		List<Vertex> l5 = getVertexes("L5-", 10);
		List<Vertex> x = getVertexes("X", 8);
		createLine1Edges(l1, x);
		createLine2Edges(l2, x);
		createLine3Edges(l3, x);
		createLine4Edges(l4, x);
		createLine5Edges(l5, x);
		addVertexAll(l1);
		addVertexAll(l2);
		addVertexAll(l3);
		addVertexAll(l4);
		addVertexAll(l5);
		addVertexAll(x);
	}
	
	private void createLine1Edges(List<Vertex> l1, List<Vertex> x) {
		l1.add(2, x.get(0));
		l1.add(5, x.get(1));
		l1.add(6, x.get(2));
		l1.add(10, x.get(7));
		l1.add(14, x.get(6));
		l1.add(16, x.get(4));
		l1.add(19, x.get(5));
		System.out.println("线路一的顶点集合：" + l1);
		int size = l1.size() - 1;
		createEdge(l1, "E1-");
		addEdgeAll(new Edge("E1-" + size, l1.get(0), l1.get(size)));
		addEdgeAll(new Edge("E1-u-" + size, l1.get(size), l1.get(0)));
	}
	
	private void createLine2Edges(List<Vertex> l2, List<Vertex> x) {
		l2.add(8, x.get(1));
		l2.add(9, x.get(3));
		l2.add(14, x.get(5));
		System.out.println("线路二的顶点集合：" + l2);
		createEdge(l2, "E2-");
	}
	
	private void createLine3Edges(List<Vertex> l3, List<Vertex> x) {
		l3.add(3, x.get(0));
		l3.add(8, x.get(3));
		l3.add(11, x.get(7));
		System.out.println("线路三的顶点集合：" + l3);
		createEdge(l3, "E3-");
	}
	
	private void createLine4Edges(List<Vertex> l4, List<Vertex> x) {
		l4.add(5, x.get(6));
		l4.add(9, x.get(7));
		System.out.println("线路四的顶点集合：" + l4);
		createEdge(l4, "E4-");
	}

	private void createLine5Edges(List<Vertex> l5, List<Vertex> x) {
		l5.add(4, x.get(4));
		l5.add(7, x.get(3));
		l5.add(8, x.get(2));
		System.out.println("线路五的顶点集合：" + l5);
		createEdge(l5, "E5-");
	}
	
	private void createEdge(List<Vertex> vs, String prefix) {
		int size = vs.size() - 1;
		for (int i = 0; i < size; i ++) {
			Edge e = new Edge(prefix + i, vs.get(i), vs.get(i + 1));
			addEdgeAll(e);
		}
		for (int i = size; i > 0; i --) {
			Edge e = new Edge(prefix + "u-" + i, vs.get(i), vs.get(i - 1));
			addEdgeAll(e);
		}
	}
	
	private void addEdgeAll(Edge e) {
		edges.add(e);
	}
	
	private void addVertexAll(List<Vertex> concreteVertexes) {
		vertexes.addAll(concreteVertexes);
	}
	
	private List<Vertex> getVertexes(String prefix, int length) {
		List<Vertex> result = new ArrayList<Vertex>();
		if (length <= 0) {
			return result;
		}
		
		for (int i = 1; i <= length; i ++) {
			Vertex v = new Vertex(prefix + i, prefix + i);
			result.add(v);
		}
		
		return result;
	}
	
}
