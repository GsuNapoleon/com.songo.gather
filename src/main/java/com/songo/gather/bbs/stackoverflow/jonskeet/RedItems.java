/**
 * 
 */
package com.songo.gather.bbs.stackoverflow.jonskeet;

/**
 * <p>decription:Why is super.super.method(); not allowed in Java?</p>
 * <p>date:2014年4月24日 上午8:32:18</p>
 * @author gsu·napoleon
 */
public class RedItems extends Items {

	/* (non-Javadoc)
	 * @see com.songo.gather.bbs.stackoverflow.jonskeet.Items#add(com.songo.gather.bbs.stackoverflow.jonskeet.Item)
	 */
	@Override
	public void add(Item item) {
		if (!item.isRed()) {
			throw new UnsupportedOperationException();
		}
		super.add(item);
	}

}
