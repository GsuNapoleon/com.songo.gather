/**
 * 
 */
package com.songo.gather.bbs.stackoverflow.balusc;

import java.util.Arrays;

/**
 * <p>decription:</p>
 * <p>date:2014年5月26日 下午5:38:27</p>
 * @author gsu·napoleon
 */
public class QuickRandom {
	
	private double prevNum;
    private double magicNumber;

    public QuickRandom(double seed1, double seed2) {
        if (seed1 >= 1 || seed1 < 0) {
        	throw new IllegalArgumentException("Seed 1 must be >= 0 and < 1, not " + seed1);
        }
        prevNum = seed1;
        if (seed2 <= 1 || seed2 > 10) {
        	throw new IllegalArgumentException("Seed 2 must be > 1 and <= 10, not " + seed2);
        }
        magicNumber = seed2;
    }

    public QuickRandom() {
        this(Math.random(), Math.random() * 10);
    }

    public double random() {
        return prevNum = (prevNum * magicNumber) % 1;
    }

	/**
	 * <p>decription:</p>
	 * <p>date:2014年5月26日 下午5:38:27</p>
	 * @author gsu·napoleon
	 * @param args
	 */
    public static void main(String[] args) throws Exception {
        QuickRandom qr = new QuickRandom();
        int[] frequencies = new int[10];
        for (int i = 0; i < 100000; i++) {
            frequencies[(int) (qr.random() * 10)]++;
        }
        printDistribution("QR", frequencies);

        frequencies = new int[10];
        for (int i = 0; i < 100000; i++) {
            frequencies[(int) (Math.random() * 10)]++;
        }
        printDistribution("MR", frequencies);
    }

    public static void printDistribution(String name, int[] frequencies) {
        System.out.printf("%n%s distribution |8000     |9000     |10000    |11000    |12000%n", name);
        for (int i = 0; i < 10; i++) {
            char[] bar = "                                                  ".toCharArray(); // 50 chars.
            Arrays.fill(bar, 0, Math.max(0, Math.min(50, frequencies[i] / 100 - 80)), '#');
            System.out.printf("0.%dxxx: %6d  :%s%n", i, frequencies[i], new String(bar));
        }
    }

}
