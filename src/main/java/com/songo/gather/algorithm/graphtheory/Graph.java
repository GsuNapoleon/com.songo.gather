/**
 * 
 */
package com.songo.gather.algorithm.graphtheory;

import java.util.List;

/**
 * <p>
 * decription:
 * </p>
 * <p>
 * date:2014年5月16日 下午4:41:02
 * </p>
 * 
 * @author gsu·napoleon
 */
public class Graph {

	private final List<Vertex> vertexes;	// 所有顶点集合
	private final List<Edge> edges;			// 所有边集合

	public Graph(List<Vertex> vertexes, List<Edge> edges) {
		this.vertexes = vertexes;
		this.edges = edges;
	}

	public List<Vertex> getVertexes() {
		return vertexes;
	}

	public List<Edge> getEdges() {
		return edges;
	}

}
