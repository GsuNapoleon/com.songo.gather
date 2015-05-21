/**
 * 
 */
package com.songo.gather.concurrent.disruptor.study;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lmax.disruptor.EventHandler;

/**
 * <p>decription:</p>
 * <p>date:2014年4月16日 上午11:36:33</p>
 * @author gsu·napoleon
 */
public class StudyEventHandler implements EventHandler<StudyEvent> {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	/* (non-Javadoc)
	 * @see com.lmax.disruptor.EventHandler#onEvent(java.lang.Object, long, boolean)
	 */
	@Override
	public void onEvent(StudyEvent event, long sequence, boolean endOfBatch)
			throws Exception {
		logger.info("Run {}, {}", sequence, event);
	}

}
