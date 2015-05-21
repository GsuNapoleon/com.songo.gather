/**
 * 
 */
package com.songo.gather.concurrent.disruptor.study;

import java.nio.ByteBuffer;

import com.lmax.disruptor.RingBuffer;

/**
 * <p>decription:</p>
 * <p>date:2014年4月16日 上午11:39:35</p>
 * @author gsu·napoleon
 */
public class StudyEventProducer {

	private RingBuffer<StudyEvent> studyRingBuffer;
	
	public StudyEventProducer(RingBuffer<StudyEvent> ringBuffer) {
		this.studyRingBuffer = ringBuffer;
	}
	
	public void onData(ByteBuffer byteBuffer) {
		long sequence = this.studyRingBuffer.next();
		
		try {
			StudyEvent studyEvent = studyRingBuffer.get(sequence);
			studyEvent.setValue(byteBuffer.getLong(0));
		} finally {
			this.studyRingBuffer.publish(sequence);
		}
	}
}
