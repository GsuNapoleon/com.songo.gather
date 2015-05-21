/**
 * 
 */
package com.songo.gather.concurrent.disruptor.study;

import java.nio.ByteBuffer;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

/**
 * <p>decription:</p>
 * <p>date:2014年4月16日 上午11:50:23</p>
 * @author gsu·napoleon
 */
public class StudyEventMain {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@SuppressWarnings("unchecked")
	public void run() throws InterruptedException {
		logger.debug("Yes!开始Disruptor之旅!!!");
		Disruptor<StudyEvent> disruptor = 
				new Disruptor<StudyEvent>(new StudyEventFactory(), 8, Executors.newCachedThreadPool());
		disruptor.handleEventsWith(new StudyEventHandler());
		disruptor.start();
		RingBuffer<StudyEvent> ringBuffer = disruptor.getRingBuffer();
		StudyEventProducer producer = new StudyEventProducer(ringBuffer);
		
		ByteBuffer bb = ByteBuffer.allocate(512);
		
		for (long l = 0; true; l ++) {
			bb.putLong(0, l);
			producer.onData(bb);
			Thread.sleep(2000);
		}
	}

}
