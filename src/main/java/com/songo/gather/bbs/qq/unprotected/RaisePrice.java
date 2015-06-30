/**
 * 
 */
package com.songo.gather.bbs.qq.unprotected;

import java.math.BigDecimal;

/**
 * <p>decription:</p>
 * <p>date:2014年5月16日 下午2:32:02</p>
 * @author gsu·napoleon
 */
public class RaisePrice implements Price {

	private final BigDecimal factory = new BigDecimal("0.50");
	private int stationNumbers;
	
	public RaisePrice(int stationNumbers) {
		this.stationNumbers = stationNumbers;
	}
	
	/* (non-Javadoc)
	 * @see com.songo.gather.qq.unprotected.Price#calculatePrice()
	 */
	@Override
	public BigDecimal calculatePrice() {
		BigDecimal initValue = new BigDecimal("2.00");
		if (stationNumbers >= 5) {
			for (int i = 5; i < stationNumbers; i ++) {
				initValue = initValue.add(factory);
			}
		}
		return initValue;
	}

}
