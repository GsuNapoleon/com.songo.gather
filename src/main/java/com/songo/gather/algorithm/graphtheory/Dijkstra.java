/**
 * 
 */
package com.songo.gather.algorithm.graphtheory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;

/**
 * <p>decription:</p>
 * <p>date:2014年7月25日 下午4:38:45</p>
 * @author gsu·napoleon
 */
public class Dijkstra {

	private final List<Vertex> vertexes;
	private final List<Edge> edges;
	private Set<Vertex> settledVertexes;	// 记录最短路径的值顶点
	private Set<Vertex> unSettledVertexes;	// 记录其它待处理的顶点
	
	/**
	 * 记录前趋顶点.key为当前顶点,value为前趋顶点.
	 */
	private Map<Vertex, Vertex> predecessors;	
	
	/**
	 * 记录每个顶点距离出发点的距离.
	 */
	private Map<Vertex, Integer> distance;		
	
	public Dijkstra(Graph graph) {
		if (graph == null 
				|| CollectionUtils.isEmpty(graph.getVertexes())
				|| CollectionUtils.isEmpty(graph.getEdges())) {
			throw new UnsupportedOperationException("没有可操作的图对象,请检查您构造的图,谢谢!");
		}
		this.vertexes = graph.getVertexes();
		this.edges = graph.getEdges();
	}
	
	/**
	 * 
	 * <p>decription:</p>
	 * <p>date:2014年7月25日 下午4:56:18</p>
	 * @author gsu·napoleon
	 * @param vertex	出发的顶点对象
	 */
	public void execute(Vertex vertex) {
		this.settledVertexes = new HashSet<Vertex>();
		this.unSettledVertexes = new HashSet<Vertex>();
		this.predecessors = new HashMap<Vertex, Vertex>();
		this.distance = new HashMap<Vertex, Integer>();
		
		// 出发顶点自己与自己,是不需要移动
		distance.put(vertex, 0);
		
		// 将vertex加入待处理的集合中
		unSettledVertexes.add(vertex);
		
		while (unSettledVertexes.size() > 0) {
			Vertex minVertex = getMinimumVertex();			
			settledVertexes.add(minVertex);
			unSettledVertexes.remove(minVertex);
			findMinimalDistance(minVertex);
		}
		
	}
		
	/**
	 * <p>decription:从每一个具有最短距离的结点,开始拓展查询</p>
	 * <p>date:2014年7月25日 下午5:30:13</p>
	 * @author gsu·napoleon
	 * @param minVertex	已知的、具有最短路径的顶点对象
	 */
	public void findMinimalDistance(Vertex minVertex) {
		if (minVertex == null) {
			throw new UnsupportedOperationException("可拓展的节点为空");
		}
		
		List<Vertex> adjacenceVertexes = getNeighborsVertexes(minVertex);
		
		for (Vertex target : adjacenceVertexes) {
			int mixedDistance = getShortestDistance(minVertex) + getDistance(minVertex, target);
			if (getShortestDistance(target) > mixedDistance) {
				distance.put(target, mixedDistance);
				predecessors.put(target, minVertex);
				unSettledVertexes.add(target);
			}
		}
		
	}
	
	/**
	 * 
	 * <p>decription:获取指定顶点距离出发顶点的最短距离</p>
	 * <p>date:2014年7月25日 下午5:21:06</p>
	 * @author gsu·napoleon
	 * @param v	指定的顶点对象
	 * @return	如果该顶点v不在unSettledVertexes集合中,则设置该顶点距离出发顶点的距离为无穷大.
	 */
	public int getShortestDistance(Vertex v) {
		Integer result = distance.get(v);
		return result == null ? Integer.MAX_VALUE : result.intValue();
	}
	
	public List<Vertex> getPath(Vertex target) {
		LinkedList<Vertex> path = new LinkedList<Vertex>();
		Vertex step = target;
		// check if a path exists
		if (predecessors.get(step) == null) {
			return null;
		}
		path.add(step);
		while (predecessors.get(step) != null) {
			step = predecessors.get(step);
			path.add(step);
		}
		// Put it into the correct order
		Collections.reverse(path);
		return path;
	}
	

	/**
	 * <p>decription:获取拓展顶点的所有相邻顶点</p>
	 * <p>date:2014年7月25日 下午5:38:21</p>
	 * @author gsu·napoleon
	 * @param v
	 * @return
	 */
	private List<Vertex> getNeighborsVertexes(Vertex v) {
		if (v == null) {
			throw new UnsupportedOperationException("查询相邻顶点时,出发点为空");
		}
		
		List<Vertex> result = new ArrayList<Vertex>();
		for (Edge e : edges) {
			if (isNeighborsAndNotSettled(e, v)) {
				result.add(e.getDestination());
			}
		}
		
		return result;
	}
	
	private int getDistance(Vertex source, Vertex dest) {
		if (source == null || dest == null) {
			throw new UnsupportedOperationException("出发顶点或目标顶点为空");
		}
		for (Edge e : edges) {
			if (e.getSource().equals(source) && e.getDestination().equals(dest)) {
				return e.getWeight();
			}
		}
		throw new RuntimeException("获取两顶点之间的距离时,出错");
	}

	/**
	 * 
	 * <p>decription:从unSettledVertexes中获取距离最短的顶点.</p>
	 * <p>date:2014年7月25日 下午5:29:13</p>
	 * @author gsu·napoleon
	 * @return
	 */

	private Vertex getMinimumVertex() {
		if (CollectionUtils.isEmpty(unSettledVertexes)) {
			throw new UnsupportedOperationException("待角色的顶点集合为空.....");
		}
		
		Vertex result = null;
		for (Vertex vertex : unSettledVertexes) {
			if (result == null) {
				result = vertex;
			} else {
				// 如果vertex的距离小于result的距离
				if (getShortestDistance(vertex) < getShortestDistance(result)) {
					result = vertex;
				}
			}
		}
		
		return result;
	}
	
	private boolean isNeighborsAndNotSettled(Edge e, Vertex v) {
		return (e != null && v != null) &&
				(e.getSource().equals(v) && !isSettled(e.getDestination())); 
	}
	
	private boolean isSettled(Vertex v) {
		return settledVertexes.contains(v);
	}
	
}
