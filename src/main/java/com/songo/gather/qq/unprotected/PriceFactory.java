/**
 * 
 */
package com.songo.gather.qq.unprotected;

/**
 * <p>decription:</p>
 * <p>date:2014年5月16日 下午2:39:13</p>
 * @author gsu·napoleon
 */
public class PriceFactory {

	public static Price getPrice(int stationNumbers) {
		if (stationNumbers < 5) {
			return new GeneralPrice();
		} else if (stationNumbers >= 5) {
			return new RaisePrice(stationNumbers);
		} else {
			return new NullPrice();
		}
	}
	
}
