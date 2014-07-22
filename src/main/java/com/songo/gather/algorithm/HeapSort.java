/**
 * 
 */
package com.songo.gather.algorithm;

/**
 * <p>decription:堆排序</p>
 * <p>堆排序（Heapsort）是指利用堆这种数据结构所设计的一种排序算法。</p>
 * <p>堆积是一个近似完全二叉树的结构，并同时满足堆积的性质：即子结点的键值或索引总是小于（或者大于）它的父节点。</p>
 * <p>堆实际上是一棵完全二叉树，其任何一非叶节点满足性质： </p>
 * <p>Key[i]<=key[2i+1]&&Key[i]<=key[2i+2]或者Key[i]>=Key[2i+1]&&key>=key[2i+2]</p>
 * <p>即任何一非叶节点的关键字不大于或者不小于其左右孩子节点的关键字。</p>
 * <p>满足Key[i]>=Key[2i+1]&&key>=key[2i+2]称为大顶堆,堆顶的值为最大值。</p>
 * <p>满足Key[i]<=key[2i+1]&&Key[i]<=key[2i+2]称为小顶堆,堆顶的值为最小值。</p>
 * <p></p>
 * <p></p>
 * <p></p>
 * <p></p>
 * <p></p>
 * <p>date:2014年6月27日 下午1:53:58</p>
 * @author gsu·napoleon
 */
public class HeapSort {

	private int left(int index) {
		return 2 * index + 1;
	}
	
	private int right(int index) {
		return 2 * (index + 1);
	}
	
	private int parent(int index) {
		return index / 2;
	}
	
	private void maxHeapify(int [] sorts, int index, int length) {
		int leftIndex = left(index);
		int rightIndex = right(index);
		int largestIndex = 0;
		if (leftIndex < length && sorts[leftIndex] > sorts[index]) {
			largestIndex = leftIndex;
		} else {
			largestIndex = index;
		}
		if (rightIndex < length && sorts[rightIndex] > sorts[largestIndex]) {
			largestIndex = rightIndex;
		}
		if (largestIndex != index) {
			System.out.println("largestIndex = " + largestIndex + "; index = " + index);
			System.out.println("max = " + sorts[largestIndex] + "; min = " + sorts[index]);
			int temp = sorts[largestIndex];
			sorts[largestIndex] = sorts[index];
			sorts[index] = temp;
//			swap(sorts[largestIndex], sorts[index]);
			maxHeapify(sorts, largestIndex, length);
		}
	}
	
	public void builderHeap(int [] sorts, int length) {
		if (isNotNullArrays(sorts, length)) {
			return;
		}
		int index = parent(length) + 1;
		for (int i = index; i >= 0; i --) {
			System.out.println(i);
			maxHeapify(sorts, i, length);
		}
	}
	
	public void heapSort(int [] sorts, int length) {
		if (isNotNullArrays(sorts, length)) {
			return;
		}
		builderHeap(sorts, length);
		for (int i : sorts) {
			System.out.println(i);
		}
		for (int i = length - 1; i >= 1; i --) {
			System.out.println(i);
//			swap(sorts[0], sorts[i]);
			int temp = sorts[0];
			sorts[0] = sorts[i];
			sorts[i] = temp;
			length --;
			maxHeapify(sorts, i, length);
		}
	}
	
	
	private boolean isNotNullArrays(int [] sorts, int length) {
		return sorts == null || length <= 1;
	}
}
