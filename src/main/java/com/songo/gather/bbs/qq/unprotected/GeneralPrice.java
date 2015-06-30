/**
 * 
 */
package com.songo.gather.bbs.qq.unprotected;

import java.math.BigDecimal;

/**
 * <p>decription:</p>
 * <p>date:2014年5月16日 下午2:27:52</p>
 * @author gsu·napoleon
 */
public class GeneralPrice implements Price {

	/* (non-Javadoc)
	 * @see com.songo.gather.qq.unprotected.PriceState#calculatePrice()
	 */
	@Override
	public BigDecimal calculatePrice() {
		return new BigDecimal("2.00");
	}

}
