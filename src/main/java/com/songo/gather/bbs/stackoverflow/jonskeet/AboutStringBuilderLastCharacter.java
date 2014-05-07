/**
 * 
 */
package com.songo.gather.bbs.stackoverflow.jonskeet;

/**
 * <p>decription:</p>
 * <p>date:2014年5月7日 下午2:10:19</p>
 * @author gsu·napoleon
 */
public class AboutStringBuilderLastCharacter {

	/**
	 * <p>decription:</p>
	 * <p>date:2014年5月7日 下午2:10:19</p>
	 * @author gsu·napoleon
	 * @param args
	 */
	public static void main(String[] args) {
		String prefix = "";
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			builder.append(prefix);
			prefix = ",";
			builder.append("A_0" + i);
		}
		System.out.println(builder.toString());
	}

}
