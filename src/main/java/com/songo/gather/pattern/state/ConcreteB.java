/**
 * 
 */
package com.songo.gather.pattern.state;

import org.apache.commons.lang3.StringUtils;

/**
 * <p>decription:</p>
 * <p>date:2014年5月12日 上午11:32:04</p>
 * @author gsu·napoleon
 */
public class ConcreteB implements State {

	/* (non-Javadoc)
	 * @see com.songo.gather.pattern.state.State#handle(java.lang.String)
	 */
	@Override
	public boolean handle(String request) {
		return StringUtils.isEmpty(request);
	}

}
