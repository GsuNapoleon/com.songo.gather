/**
 * 
 */
package com.songo.gather.bbs.stackoverflow.peterlawrey;

/**
 * <p>decription:how to count the exact number of words in a string that has empty spaces between words?</p>
 * <p>date:2014年6月18日 下午12:10:07</p>
 * @author gsu·napoleon
 */
public class CountExactNumberOfWords {

	/**
	 * <p>decription:</p>
	 * <p>date:2014年6月18日 下午12:10:07</p>
	 * @author gsu·napoleon
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "A B C D E F G H";
		String trimmed = str.trim();
		int words = trimmed.isEmpty() ? 0 : trimmed.split("\\s+").length;
		System.out.println(words);
	}

}
