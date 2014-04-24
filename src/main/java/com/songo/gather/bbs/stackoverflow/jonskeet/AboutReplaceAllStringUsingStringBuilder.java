/**
 * 
 */
package com.songo.gather.bbs.stackoverflow.jonskeet;

/**
 * <p>decription:Replace all occurences of a String using StringBuilder?</p>
 * <p>date:2014年4月24日 下午3:21:14</p>
 * @author gsu·napoleon
 */
public class AboutReplaceAllStringUsingStringBuilder {
	
	public static void replaceAll(StringBuilder builder, String from, String to) {
		int index = builder.indexOf(from);
		while (index != -1) {
			builder.replace(index, from.length() + index, to);
			index += to.length();
			index = builder.indexOf(from, index);
		}
	}

	/**
	 * <p>decription:</p>
	 * <p>date:2014年4月24日 下午3:21:14</p>
	 * @author gsu·napoleon
	 * @param args
	 */
	public static void main(String[] args) {
		StringBuilder builder = new StringBuilder(32);
		builder.append("AA_BB_CC");
		builder.append("AA_BB_CC");
		replaceAll(builder, "A", "D");
		System.out.println(builder.toString());
	}

}
