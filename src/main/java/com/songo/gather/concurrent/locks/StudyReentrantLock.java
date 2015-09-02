/**
 * 
 */
package com.songo.gather.concurrent.locks;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * decription:
 * </p>
 * <p>
 * date:2015年8月21日 上午11:24:30
 * </p>
 * 
 * @author gsu·napoleon
 */
public class StudyReentrantLock {

	private static final Logger logger = LoggerFactory
			.getLogger(StudyReentrantLock.class);

	private final transient ReentrantLock nonfairLock = new ReentrantLock();
	private final transient ReentrantLock fairLock = new ReentrantLock(
			Boolean.TRUE);
	private int signal = -1;

	public void nonfairAdd() {
		for (int i = 0; i < 5; i++) {
			Job job = new Job(nonfairLock);
			Thread thread = new Thread(job);
			thread.setName("" + i + "_" + job.getValues());
			thread.start();
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void fairAdd() {
		for (int i = 0; i < 5; i++) {
			Job job = new Job(fairLock);
			Thread thread = new Thread(job);
			thread.setName("" + i + "_" + job.getValues());
			thread.start();
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	/**
	 * <p>
	 * decription:
	 * </p>
	 * <p>
	 * date:2015年8月21日 上午11:24:30
	 * </p>
	 * 
	 * @author gsu·napoleon
	 * @param args
	 */
	public static void main(String[] args) {
		StudyReentrantLock srl = new StudyReentrantLock();
		srl.fairAdd();
		srl.nonfairAdd();
	}
	
	private static class Job implements Runnable {
		
		private final transient ReentrantLock lock;
		private AtomicLong values = new AtomicLong(0);
		
		public Job(ReentrantLock lock) {
			this.lock = lock;
		}

		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run() {
			for (int i = 0; i < 10; i ++) {
				final ReentrantLock localLock = this.lock;
				localLock.lock();
				try {
					this.values.addAndGet(0);
					logger.info("Lock by:[{}]", Thread.currentThread().getName());
				} finally {
					localLock.unlock();
				}
			}
		}

		/**
		 * @return the values
		 */
		public AtomicLong getValues() {
			return values;
		}
		
	}

	/**
	 * @return the signal
	 */
	public int getSignal() {
		return signal;
	}

}
