/**
 * 
 */
package com.songo.gather.algorithm;

/**
 * <p>decription:</p>
 * <p>date:2014年4月28日 下午4:21:37</p>
 * @author gsu·napoleon
 */
public class StableSortAlgorithm {
	
	/**
	 * 冒泡排序:它重复地走访过要排序的数列,一次比较两个元素,如果他们的顺序错误就把他们交换过来.<br/>
	 * 冒泡排序如果能在内部循环第一次执行时,使用一个旗标来表示有无需要交换的可能,也有可能把最好的复杂度降低到.<br/>
	 * 冒泡排序算法的运作如下：<br/>
	 * 比较相邻的元素.如果第一个比第二个大，就交换他们两个.<br/>
	 * 对每一对相邻元素作同样的工作,从开始第一对到结尾的最后一对.在这一点,最后的元素应该会是最大的数.<br/>
	 * 针对所有的元素重复以上的步骤,除了最后一个.<br/>
	 * 持续每次对越来越少的元素重复上面的步骤,直到没有任何一对数字需要比较.<br/>
	 */
	public static void bubbleSort(int[] sorts, int count) {
		int temp = 0; // 中间值
		int exchangeFlag = count - 1; // 设置交换标识
		while (exchangeFlag > 0) { // 如果大于0
			int bound = exchangeFlag; // 数组的最大范围
			exchangeFlag = 0; // 每次请求,置为0
			for (int i = 0; i < bound; i++) {
				if (sorts[i] > sorts[i + 1]) {
					temp = sorts[i];
					sorts[i] = sorts[i + 1];
					sorts[i + 1] = temp;
					exchangeFlag = i + 1;
				}
			}
		}
	}

	/**
	 * 鸡尾酒排序: 定向冒泡排序,鸡尾酒搅拌排序,搅拌排序 (也可以视作选择排序的一种变形),涟漪排序,来回排序 or
	 * 快乐小时排序,是冒泡排序的一种变形.<br/>
	 * 
	 */
	public static void cocktailSort(int[] sorts) {
		int temp = 0;
		int top = sorts.length - 1;
		int bottom = 0;
		boolean swapFlag = true;
		while (swapFlag) {
			swapFlag = false;
			for (int i = 0; i < top; i++) {
				if (sorts[i] > sorts[i + 1]) {
					temp = sorts[i];
					sorts[i] = sorts[i + 1];
					sorts[i + 1] = temp;
					swapFlag = true;
				}
			}
			top--;
			for (int j = top; j > bottom; j--) {
				if (sorts[j - 1] > sorts[j]) {
					temp = sorts[j - 1];
					sorts[j - 1] = sorts[j];
					sorts[j] = temp;
					swapFlag = true;
				}
			}
			bottom++;
		}
	}

	/**
	 * 计数排序:计数排序使用一个额外的数组C,其中第i个元素是待排序数组A中值等于i的元素的个数.然后根据数组C来将A中的元素排到正确的位置.<br/>
	 * 算法的步骤如下：<br/>
	 * 找出待排序的数组中最大和最小的元素.<br/>
	 * 统计数组中每个值为i的元素出现的次数，存入数组C的第i项.<br/>
	 * 对所有的计数累加（从C中的第一个元素开始，每一项和前一项相加）.<br/>
	 * 反向填充目标数组：将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减去1.<br/>
	 * 
	 * @param sorts
	 */
	public static int[] countingSort(int[] a) {
		int[] b = new int[a.length];
		// 假设A中的数据a'有，0<=a' && a' < k并且k=1000
		int k = 1000;
		countingSort(a, b, k);
		return b;
	}

	/**
	 * @param a
	 * @param b
	 * @param k
	 */
	private static void countingSort(int[] a, int[] b, int k) {
		int[] c = new int[k];
		// 计数
		for (int j = 0; j < a.length; j++) {
			int a1 = a[j];
			c[a1] += 1;
		}
		// 求计数和
		for (int i = 1; i < k; i++) {
			c[i] = c[i] + c[i - 1];
		}
		// 整理
		for (int j = a.length - 1; j >= 0; j--) {
			int a2 = a[j];
			b[c[a2] - 1] = a2;
			c[a2] -= 1;
		}
	}

	/**
	 * 插入算法：工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。<br/>
	 * 具体算法描述如下：<br/>
	 * 从第一个元素开始，该元素可以认为已经被排序;<br/>
	 * 取出下一个元素，在已经排序的元素序列中从后向前扫描;<br/>
	 * 如果该元素（已排序）大于新元素，将该元素移到下一位置;<br/>
	 * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置;<br/>
	 * 将新元素插入到该位置中;<br/>
	 * 重复步骤2~5.<br/>
	 * 
	 * @param sorts
	 */
	public static void insertionSort(int[] sorts) {
		int temp = 0;
		int m = 0;
		for (int i = 1; i <= sorts.length - 1; i++) {
			temp = sorts[i];
			m = i - 1;
			while ((m >= 0) && (temp < sorts[m])) {
				sorts[m + 1] = sorts[m];
				m--;
			}
			sorts[m + 1] = temp;
		}
	}

	/**
	 * 桶排序：又称箱排序.工作的原理是将阵列分到有限数量的桶子里.<br/>
	 * 桶排序以下列程序进行：<br/>
	 * 设置一个定量的阵列当作空桶子。<br/>
	 * 寻访序列，并且把项目一个一个放到对应的桶子去。<br/>
	 * 对每个不是空的桶子进行排序。<br/>
	 * 从不是空的桶子里把项目再放回原来的序列中。<br/>
	 */
	public static void bucketSort(int[] sorts) {

	}

	/**
	 * 归并排序（Merge sort,台湾译作：合并排序）是建立在归并操作上的一种有效的排序算法.该算法是采用分治法（Divide and
	 * Conquer）的一个非常典型的应用.<br/>
	 * 归并操作的过程如下：<br/>
	 * 申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列<br/>
	 * 设定两个指针，最初位置分别为两个已经排序序列的起始位置<br/>
	 * 比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置<br/>
	 * 重复步骤3直到某一指针达到序列尾<br/>
	 * 将另一序列剩下的所有元素直接复制到合并序列尾<br/>
	 * 
	 * @param sorts
	 */
	public static void mergeSort(int[] sorts, int length) {
		int[] bsorts = new int[length];
		int s = 1;
		while (s < length) {
			mergePass(sorts, bsorts, s, length);
			s += s;
			mergePass(bsorts, sorts, s, length);
			s += s;
		}
	}

	public static void merge(int[] asorts, int[] bsorts, int low, int mid,
			int high) {
		int m = low;
		int n = mid + 1;
		int k = low;
		while (m <= mid && n <= high) {
			if (asorts[m] < asorts[n]) {
				bsorts[k++] = asorts[m++];
			} else {
				bsorts[k++] = asorts[n++];
			}
		}
		while (m <= mid) {
			bsorts[k++] = asorts[m++];
		}
		while (n <= high) {
			bsorts[k++] = asorts[n++];
		}
	}

	public static void mergePass(int[] asorts, int[] bsorts, int s, int n) {
		int i = 0;
		while (i < (n - (2 * s))) {
			merge(asorts, bsorts, i, i + s - 1, i + (2 * s) - 1);
			i = i + (2 * s);
		}
		if ((i + s) < n) {
			merge(asorts, bsorts, i, i + s - 1, n - 1);
		} else {
			for (int j = i; j <= (n - 1); j++) {
				bsorts[j] = asorts[j];
			}
		}
	}

	/**
	 * 二叉查找树（Binary Search
	 * Tree），或者是一棵空树，或者是具有下列性质的二叉树：若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值
	 * ；若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；它的左、右子树也分别为二叉排序树.<br/>
	 * 
	 */
	public static void binaryTreeSort(int[] sorts) {

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] sorts = { 638, 194, 124, 482, 469, 245, 852, 294, 484, 243, 623 };
		// bubbleSort(sorts, sorts.length);
		// cocktailSort(sorts);
		// int [] sts = countingSort(sorts);
		// insertionSort(sorts);
		mergeSort(sorts, sorts.length);
	}
}
