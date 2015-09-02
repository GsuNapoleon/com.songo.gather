/**
 * 
 */
package com.songo.gather.concurrent.disruptor.file;

import com.lmax.disruptor.RingBuffer;

/**
 * <p>decription:</p>
 * <p>date:2015年8月12日 上午10:02:31</p>
 * @author gsu·napoleon
 */
public class DataReader {
	
	private RingBuffer<Data> ringBuffer;
	
	public DataReader(RingBuffer<Data> ringBuffer) {
		this.ringBuffer = ringBuffer;
	}
	
	public void reader(String line) {
		long sequence = ringBuffer.next();
		
		try {
			Data data = ringBuffer.get(sequence);
			data.setLine(line);
		} finally {
			ringBuffer.publish(sequence);
		}
	}

}
