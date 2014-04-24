/**
 * 
 */
package com.songo.gather.bbs.stackoverflow.jonskeet;

/**
 * <p>decription:Why is super.super.method(); not allowed in Java?</p>
 * <p>date:2014年4月24日 上午8:39:49</p>
 * @author gsu·napoleon
 */
public class NaughtyItems extends RedItems {

	/* (non-Javadoc)
	 * @see com.songo.gather.bbs.stackoverflow.jonskeet.RedItems#add(com.songo.gather.bbs.stackoverflow.jonskeet.Item)
	 */
	@Override
	public void add(Item item) {
		// I don't care if it's red or not. Take that, RedItems!
		// super.super.add(item);
	}

}
