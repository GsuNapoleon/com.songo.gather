/**
 * 
 */
package com.songo.gather.qq.unprotected;

import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

/**
 * <p>decription:
题三：根据某市地铁线路图写一个地铁票价计算程序
需求描述：
1.起步价2元，超过5站以后，每站加收0.5元，最终票价四舍五入取整元
2.程序初始化以后监听控制台输入
3.输入起始站与终点站的编号，格式：L3-2,L1-3 （L3-2表示起点为3号线第2站，L1-3表示终点为1号线第3站，以此类推）
4.系统按最短路径原则（站数最少）规划路线，计算票价，并把路线和票价输出到控制台，格式2:L3-2,L3-3,X1,L1-3（2表示价格2元，后面的表示路线）
5.输出票价后，程序继续监听下次输入，始终不退出。
 
扩展需求：假设2号与5号线每站加收价格为1.5元，每次输入起始站与终点站后，系统分别计算出最短路径与最廉价路径，并且输出到控制台（即每次输出两个结果）
地铁线路图如下：共有5条线路，X开头的站点表示换乘车站</p>
 * <p>date:2014年5月16日 下午2:19:26</p>
 * @author gsu·napoleon
 */
public class ThroughUnprotected {
	
	public static void main(String[] args) {
		int stationNumbers = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入站数：");
		while (true) {
			String next = scanner.nextLine();
			System.out.println(">>>>>>> " + next);
			if ("exit".equals(next)) {
				break;
			}
			stationNumbers = Integer.parseInt(next);
			Price price = PriceFactory.getPrice(stationNumbers);
			System.out.println(price.calculatePrice().toString() + "￥");
		}
		scanner.close();
	}

	public static void test() {
		String start = "L2-1";
		String end = "L1-14";
		int [] arrays = getLines(start, end);
	}
	
	public static int [] getLines(String start, String end) {
		int startInt = 0;
		if (StringUtils.isNotEmpty(start)) {
			startInt = Integer.parseInt(start.split("-")[0].split("")[1]);
		}
		int endInt = 0;
		if (StringUtils.isNotEmpty(end)) {
			endInt = Integer.parseInt(end.split("-")[0].split("")[1]);
		}
		int [] arrays = new int[2];
		if (startInt == endInt && (startInt != 0 || endInt != 0)) {
			arrays[0] = startInt;
			return arrays;
		} else if (startInt != endInt) {
			arrays[0] = startInt;
			arrays[1] = endInt;
			return arrays;
		} else {
			return null;
		}
	}
}
