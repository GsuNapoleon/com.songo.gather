/**
 * 
 */
package com.songo.gather.bbs.stackoverflow.jonskeet;

/**
 * <p>Asker：So code reviewers are complaining about code like this:</p>
 * <p>boolean myFlag = false;</p>
 * <p>They are saying it should be:</p>
 * <p>boolean myFlag = Boolean.FALSE;</p>
 * <p>Is this just some fetish with not using keywords or is there a valid reason to do this?</p>
 * <p>Answer:No, that's completely pointless. It would make sense to use:</p>
 * <p>// Note capital B</p>
 * <p>Boolean myFlag = Boolean.FALSE;</p>
 * <p>decription:to avoid the call to Boolean.valueOf (autoboxing) but in your code there is no boxing, 
 * and their suggestion introduces an unnecessary unboxing operation.</p>
 * <p>date:2014年4月24日 上午8:47:20</p>
 * @author gsu·napoleon
 */
public class AboutBoolean {
	
	
	@SuppressWarnings("unused")
	private Boolean myFlag = Boolean.FALSE;

	/**
	 * <p>decription:</p>
	 * <p>date:2014年4月24日 上午8:47:20</p>
	 * @author gsu·napoleon
	 * @param args
	 */
	public static void main(String[] args) {
		
	}

}
