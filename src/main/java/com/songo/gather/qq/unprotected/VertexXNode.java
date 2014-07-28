/**
 * 
 */
package com.songo.gather.qq.unprotected;

import java.util.List;

import com.songo.gather.algorithm.graphtheory.Vertex;

/**
 * <p>decription:</p>
 * <p>date:2014年5月19日 下午2:14:51</p>
 * @author gsu·napoleon
 */
public class VertexXNode {
	
	private List<Vertex> nodes;
	
	public VertexXNode(List<Vertex> nodes) {
		this.nodes = nodes;
	}
	
	public void initFromX1ToX2() {
		nodes.add(new Vertex("X1", "X1"));
		nodes.add(new Vertex("L1-3", "L1-3"));
		nodes.add(new Vertex("L1-4", "L1-4"));
		nodes.add(new Vertex("X2", "X2"));
	}
	
	public void initFromX1ToX6() {
		nodes.add(new Vertex("X1", "X1"));
		nodes.add(new Vertex("L1-2", "L1-2"));
		nodes.add(new Vertex("L1-1", "L1-1"));
		nodes.add(new Vertex("L1-14", "L1-14"));
		nodes.add(new Vertex("X6", "X6"));
	}
	
	public void initFromX1ToX4() {
		nodes.add(new Vertex("X1", "X1"));
		nodes.add(new Vertex("L3-4", "L3-4"));
		nodes.add(new Vertex("L3-5", "L3-5"));
		nodes.add(new Vertex("L3-6", "L3-6"));
		nodes.add(new Vertex("L3-7", "L3-7"));
		nodes.add(new Vertex("X4", "X4"));
	}
	
	public void initFromX2ToX3() {
		nodes.add(new Vertex("X2", "X2"));
		nodes.add(new Vertex("X3", "X3"));
	}
	
	public void initFromX2ToX4() {
		nodes.add(new Vertex("X2", "X2"));
		nodes.add(new Vertex("X4", "X4"));
	}
	
	public void initFromX3ToX4() {
		nodes.add(new Vertex("X3", "X3"));
		nodes.add(new Vertex("X4", "X4"));
	}

	public void initFromX3ToX8() {
		nodes.add(new Vertex("X3", "X3"));
		nodes.add(new Vertex("L1-5", "L1-5"));
		nodes.add(new Vertex("L1-6", "L1-6"));
		nodes.add(new Vertex("L1-7", "L1-7"));
		nodes.add(new Vertex("X8", "X8"));
	}
	
	public void initFromX4ToX6() {
		nodes.add(new Vertex("X4", "X4"));
		nodes.add(new Vertex("L2-9", "L2-9"));
		nodes.add(new Vertex("L2-10", "L2-10"));
		nodes.add(new Vertex("L2-11", "L2-11"));
		nodes.add(new Vertex("L2-12", "L2-12"));
		nodes.add(new Vertex("X6", "X6"));
	}
	
	public void initFromX4ToX5() {
		nodes.add(new Vertex("X4", "X4"));
		nodes.add(new Vertex("L5-6", "L5-6"));
		nodes.add(new Vertex("L5-5", "L5-5"));
		nodes.add(new Vertex("X5", "X5"));
	}
	
	public void initFromX4ToX8() {
		nodes.add(new Vertex("X4", "X4"));
		nodes.add(new Vertex("L3-8", "L3-8"));
		nodes.add(new Vertex("L3-9", "L3-9"));
		nodes.add(new Vertex("X8", "X8"));
	}
	
	public void initFromX5ToX6() {
		nodes.add(new Vertex("X5", "X5"));
		nodes.add(new Vertex("L1-12", "L1-12"));
		nodes.add(new Vertex("L1-13", "L1-13"));
		nodes.add(new Vertex("X6", "X6"));
	}

	public void initFromX5ToX7() {
		nodes.add(new Vertex("X5", "X5"));
		nodes.add(new Vertex("L1-11", "L1-11"));
		nodes.add(new Vertex("X7", "X7"));
	}
	
	public void initFromX7ToX8() {
		nodes.add(new Vertex("X7", "X7"));
		nodes.add(new Vertex("L4-6", "L4-6"));
		nodes.add(new Vertex("L4-7", "L4-7"));
		nodes.add(new Vertex("L4-8", "L4-8"));
		nodes.add(new Vertex("X8", "X8"));
	}

	public void initFromX8ToX7() {
		nodes.add(new Vertex("X8", "X8"));
		nodes.add(new Vertex("L1-8", "L1-8"));
		nodes.add(new Vertex("L1-9", "L1-9"));
		nodes.add(new Vertex("L1-10", "L1-10"));
		nodes.add(new Vertex("X7", "X7"));
	}
}
