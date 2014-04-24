/**
 * 
 */
package com.songo.gather.bbs.stackoverflow.jonskeet;

/**
 * <p>Asker:Bad to use very large strings? (Java)</p>
 * <p>Answer:When you can stream, you can handle files of any size.</p>
 * <p>decription:</p>
 * <p>date:2014年4月24日 下午4:58:15</p>
 * @author gsu·napoleon
 */
public class FakeScanner {

	/**
	 * <p>decription:</p>
	 * <p>date:2014年4月24日 下午4:58:15</p>
	 * @author gsu·napoleon
	 * @param args
	 */
	public static void main(String[] args) {
		Fake fake = new Fake(30000, "test");
		System.out.println(args[0]);
		boolean b = "fast".equals(args[0]);
		long starts = System.currentTimeMillis();
		String s;
		if (b) {
			StringBuilder builder = new StringBuilder();
			while (fake.hasNext()) {
				builder.append(fake.next());
			}
			s = builder.toString();
		} else {
			s = "";
			while (fake.hasNext()) {
				s += fake.next();
			}
		}
		long ends = System.currentTimeMillis();
		System.out.println("Building a string of length " 
                + s.length()
                + (b ? " with" : " without")
                + " StringBuilder took " + (ends - starts) + "ms");
	}

}
class Fake {
	
	private int linesLeft;
	private final String line;
	
	public Fake(int linesLeft, String line) {
		this.linesLeft = linesLeft;
		this.line = line;
	}
	
	public boolean hasNext() {
		return linesLeft > 0;
	}
	
	public String next() {
		linesLeft --;
		return line;
	}
}