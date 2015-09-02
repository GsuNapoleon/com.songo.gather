/**
 * 
 */
package com.songo.gather.io.test;

import java.util.Stack;
import java.util.Vector;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * <p>decription:</p>
 * <p>date:2015年7月20日 下午12:05:21</p>
 * @author gsu·napoleon
 */
public class FileFilter {

	private int nthreads = 128;
	private AtomicLong ato = new AtomicLong(1L);
	
	public void filter() {
		try {
			ExecutorService executorService = Executors.newFixedThreadPool(nthreads, new MyThreadFactory());
			Future<String> future = executorService.submit(new FilterTask(ato), "");
			System.err.println(future.get());
			executorService.shutdown();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		stack.add("");
		FileFilter ff = new FileFilter();
		for (int i = 0; i < 10000; i ++) {
			ff.filter();
		}
	}
	
}
class MyThreadFactory implements ThreadFactory {
	
	private static final AtomicInteger poolNumber = new AtomicInteger(1);
    private final ThreadGroup group;
    private final AtomicInteger threadNumber = new AtomicInteger(1);
    private final String namePrefix;
    
    public MyThreadFactory() {
    	SecurityManager sm = System.getSecurityManager();
    	group = sm != null ? sm.getThreadGroup() : Thread.currentThread().getThreadGroup();
    	namePrefix = "my-pool-" + poolNumber.getAndIncrement() + "-thread-";
    }

	/* (non-Javadoc)
	 * @see java.util.concurrent.ThreadFactory#newThread(java.lang.Runnable)
	 */
	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(group, r, namePrefix + threadNumber.getAndIncrement(), 0);
		if (t.isDaemon()) {
			t.setDaemon(false);
		}
		if (t.getPriority() != Thread.NORM_PRIORITY) {
			t.setPriority(Thread.NORM_PRIORITY);
		}
		return t;
	}
	
}
class FilterTask implements Runnable {
	
	private AtomicLong ato;
	
	public FilterTask(AtomicLong ato) {
		this.ato = ato;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		System.err.println(ato.getAndIncrement());
	}
	
}