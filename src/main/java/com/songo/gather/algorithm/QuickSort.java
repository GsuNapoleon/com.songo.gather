/**
 * 
 */
package com.songo.gather.algorithm;

/**
 * <p>decription:快速排序</p>
 * <p>快速排序是基于分治模式处理的，对一个典型子数组A[p...r]排序的分治过程为三个步骤：</p>
 * <p>1.分解：A[p..r]被划分为俩个（可能空）的子数组A[p ..q-1]和A[q+1 ..r]，使得A[p ..q-1] <= A[q] <= A[q+1 ..r]</p>
 * <p>2.解决：通过递归调用快速排序，对子数组A[p ..q-1]和A[q+1 ..r]排序。
 * <p>3.合并。</p>
 * <p>date:2014年6月27日 上午10:04:49</p>
 * @author gsu·napoleon
 */
public class QuickSort {

	/**
	 * 
	 * <p>decription:快速排序的实现方法</p>
	 * <p>date:2014年6月27日 下午12:11:50</p>
	 * @author gsu·napoleon
	 * @param sorts			待排序的数组
	 * @param startIndex	最开始的索引
	 * @param pivotIndex	基准数的下标	
	 */
	public void sorts(int [] sorts, int startIndex, int pivotIndex) {
		if (sorts == null || pivotIndex <= 1) {
			return;
		}
		int partitionIndex = 0;
		if (startIndex < pivotIndex) {
			partitionIndex = partition(sorts, startIndex, pivotIndex);
			sorts(sorts, startIndex, partitionIndex - 1);
			sorts(sorts, partitionIndex + 1, pivotIndex);
		}
	}

	/**
	 * <p>decription:</p>
	 * <p>date:2014年6月27日 下午12:18:35</p>
	 * @author gsu·napoleon
	 * @param sorts
	 * @param startIndex
	 * @param pivotIndex
	 * @return
	 */
	private int partition(int[] sorts, int startIndex, int pivotIndex) {
		
		int swapNumber = 0;					// 交换数组中间变量
		int swapIndex = startIndex - 1;		// 交换数组的索引变量
		int pivotNumber = sorts[pivotIndex];// 选中的基数
		
		// 将小于基数的值,换到数组的左边
		for (int j = startIndex; j < pivotIndex; j ++) {
			if (sorts[j] < pivotNumber) {	// 如果小于基数,则将swapIndex与j下标的值,进行互换
				swapIndex ++;
				swapNumber = sorts[swapIndex];
				sorts[swapIndex] = sorts[j];
				sorts[j] = swapNumber;
			}
		}
		swapIndex ++;	// 交换基数 +1
		// 将基数的位置,移到交换位置上
		swapNumber = sorts[swapIndex];
		sorts[swapIndex] = sorts[pivotIndex];
		sorts[pivotIndex] = swapNumber;
		return swapIndex;
	}
	
}
