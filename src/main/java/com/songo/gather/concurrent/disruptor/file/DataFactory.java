/**
 * 
 */
package com.songo.gather.concurrent.disruptor.file;

import com.lmax.disruptor.EventFactory;

/**
 * <p>decription:</p>
 * <p>date:2015年8月12日 上午10:52:28</p>
 * @author gsu·napoleon
 */
public class DataFactory implements EventFactory<Data> {

	/* (non-Javadoc)
	 * @see com.lmax.disruptor.EventFactory#newInstance()
	 */
	@Override
	public Data newInstance() {
		return new Data();
	}

}
