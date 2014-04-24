/**
 * 
 */
package com.songo.gather.bbs.stackoverflow.jonskeet;

/**
 * <p>decription:Why is super.super.method(); not allowed in Java?</p>
 * <p>date:2014年4月24日 上午8:34:37</p>
 * @author gsu·napoleon
 */
public class BigRedItems extends RedItems {

	/* (non-Javadoc)
	 * @see com.songo.gather.bbs.stackoverflow.jonskeet.RedItems#add(com.songo.gather.bbs.stackoverflow.jonskeet.Item)
	 */
	@Override
	public void add(Item item) {
		if (!item.isBig()) {
			throw new UnsupportedOperationException();
		}
		super.add(item);
	}

	public static void main(String[] args) {
		
	}
}
