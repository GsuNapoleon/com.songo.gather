/**
 * 
 */
package com.songo.gather.qq.unprotected;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 * decription:
 * </p>
 * <p>
 * date:2014年5月16日 下午5:03:30
 * </p>
 * 
 * @author gsu·napoleon
 */
public class TestDijkstra {

	private List<Vertex> nodes;
	private List<Edge> edges;

	public void testExcute() {
		nodes = new ArrayList<Vertex>();
		edges = new ArrayList<Edge>();
//		for (int i = 0; i < 11; i++) {
//			Vertex location = new Vertex("Node_" + i, "Node_" + i);
//			nodes.add(location);
//		}
		// 输入的起点站是：L2-1,终点站是L1-1
		// 如果起始站点是同一条线,只需要注意X.
		addNode("L2", Transfer.DISTANCE_L2_1_X2 - 1);
//		initL1();
//		initL2();
		
		addLane("L1", 0, 22, 20);
//		addLane("L2", 22, 22, 18);
//		addLane("L3", 0, 12, 15);
//		addLane("L4", 0, 15, 17);
//		addLane("L5", 0, 9, 12);

		// Lets check from location Loc_1 to Loc_10
		Graph graph = new Graph(nodes, edges);
		DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
		dijkstra.execute(nodes.get(0));
		LinkedList<Vertex> path = dijkstra.getPath(nodes.get(22));
		
		assertNotNull(path);
		assertTrue(path.size() > 0);

		for (Vertex vertex : path) {
			System.out.println(vertex);
		}

	}
	
	private void addNode(String line, int duration) {
		for (int i = 1; i <= duration; i ++) {
			Vertex v = new Vertex(line + "-" + i, line + "-" + i);
			System.out.println(v);
			nodes.add(v);
		}
	}

	private void addLane(String laneId, int sourceLocNo, int destLocNo,
			int duration) {
		Edge lane = new Edge(laneId, nodes.get(sourceLocNo),
				nodes.get(destLocNo), duration);
		System.out.println(lane);
		edges.add(lane);
	}

	public static void main(String[] args) {
		TestDijkstra td = new TestDijkstra();
		td.testExcute();
	}
}
