/**
 * 
 */
package com.songo.gather.algorithm.graphtheory;

/**
 * <p>decription:边的封装对象</p>
 * <p>date:2014年5月16日 下午4:57:31</p>
 * 
 * @author gsu·napoleon
 */
public class Edge {
	private final String id;			// 图中边的标识
	private final Vertex source;		// 边的起始顶点
	private final Vertex destination;	// 边的结束顶点
	private final int weight;			// 权重.可以以两点间的距离来理解,但是,又不是点之间的实际距离.

	public Edge(String id, Vertex source, Vertex destination) {
		this(id, source, destination, 1);
	}
	
	public Edge(String id, Vertex source, Vertex destination, int weight) {
		this.id = id;
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}

	public String getId() {
		return id;
	}

	public Vertex getDestination() {
		return destination;
	}

	public Vertex getSource() {
		return source;
	}

	public int getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return "{'" + id + "', [" + source + "-->" + destination + "]}";
	}

}
