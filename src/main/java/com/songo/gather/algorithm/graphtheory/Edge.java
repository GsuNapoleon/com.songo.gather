/**
 * 
 */
package com.songo.gather.algorithm.graphtheory;

/**
 * <p>
 * decription:
 * </p>
 * <p>
 * date:2014年5月16日 下午4:57:31
 * </p>
 * 
 * @author gsu·napoleon
 */
public class Edge {
	private final String id;
	private final Vertex source;
	private final Vertex destination;
	private final int weight;

	public Edge(String id, Vertex source, Vertex destination) {
		this(id, source, destination, 0);
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
		return source + " " + destination;
	}

}
