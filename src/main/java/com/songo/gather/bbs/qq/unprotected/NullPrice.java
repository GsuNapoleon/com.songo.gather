/**
 * 
 */
package com.songo.gather.bbs.qq.unprotected;

import java.math.BigDecimal;

/**
 * <p>decription:</p>
 * <p>date:2014年5月16日 下午2:46:04</p>
 * @author gsu·napoleon
 */
public class NullPrice implements Price {

	/* (non-Javadoc)
	 * @see com.songo.gather.qq.unprotected.Price#calculatePrice()
	 */
	@Override
	public BigDecimal calculatePrice() {
		throw new UnsupportedOperationException("滚!!!");
	}

}
