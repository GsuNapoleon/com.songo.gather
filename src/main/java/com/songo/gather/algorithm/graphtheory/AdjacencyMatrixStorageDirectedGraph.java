/**
 * 
 */
package com.songo.gather.algorithm.graphtheory;

/**
 * <p>decription:邻接矩阵存储有向图</p>
 * <p>date:2014年5月27日 下午2:27:04</p>
 * @author gsu·napoleon
 */
public class AdjacencyMatrixStorageDirectedGraph {

	private final int [][] edges = new int[10][10];
	
	/**
	 * 
	 * <p>decription:</p>
	 * <p>date:2014年5月27日 下午2:34:56</p>
	 * @author gsu·napoleon
	 * @param m	顶点边数
	 * @param n	顶点个数
	 */
	public void storage(int m, int n, int _u, int _v) {
		int u = _u;	// 起点
		int v = _v;	// 终点
		int od = 0;	// 顶点的出度
		int id = 0;	// 顶点的入度
		
		for (int i = 1; i <= m; i ++) {
			edges[u - 1][v - 1] = 1;
		}
		
		for (int i = 0; i < edges.length; i ++) {
			for (int j = 0; j < edges.length; j ++) {
				System.out.print(edges[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("============================");
		for (int i = 0; i < n; i ++) {
			od = 0;
			for (int j = 0; j < n; j ++) {
				od += edges[i][j];
			}
			if (i == 0) {
				System.out.print(od);
			} else {
				System.out.print(" " + od);
			}
		}
		System.out.println();
		for (int i = 0; i < n; i ++) {
			id = 0;
			for (int j = 0; j < n; j ++) {
				id += edges[j][i];
			}
			if (i == 0) {
				System.out.print(id);
			} else {
				System.out.print(" " + id);
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		AdjacencyMatrixStorageDirectedGraph amsdg = new AdjacencyMatrixStorageDirectedGraph();
		amsdg.storage(7, 9, 1, 2);
		amsdg.storage(7, 9, 2, 3);
		amsdg.storage(7, 9, 2, 5);
		amsdg.storage(7, 9, 2, 6);
		amsdg.storage(7, 9, 3, 5);
		amsdg.storage(7, 9, 4, 3);
		amsdg.storage(7, 9, 5, 2);
		amsdg.storage(7, 9, 5, 4);
		amsdg.storage(7, 9, 6, 7);
		amsdg.storage(0, 0, 6, 7);
	}
}
