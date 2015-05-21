/**
 * 
 */
package com.songo.gather.concurrent.disruptor.study;

import com.lmax.disruptor.EventFactory;

/**
 * <p>decription:</p>
 * <p>date:2014年4月16日 上午11:35:49</p>
 * @author gsu·napoleon
 */
public class StudyEventFactory implements EventFactory<StudyEvent> {

	/* (non-Javadoc)
	 * @see com.lmax.disruptor.EventFactory#newInstance()
	 */
	@Override
	public StudyEvent newInstance() {
		return new StudyEvent();
	}

}
