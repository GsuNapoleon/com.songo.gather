/**
 * 
 */
package com.songo.gather.pattern.chainresponsibility;

/**
 * <p>decription:</p>
 * <p>date:2015年6月11日 上午9:18:02</p>
 * @author gsu·napoleon
 */
public abstract class ChainLogger {

	private int mask;
	private ChainLogger next;
	
	public ChainLogger(int mask) {
		this.mask = mask;
	}
	
	public void setNext(ChainLogger next) {
		this.next = next;
	}
	
	public abstract void writeMsg(String msg);
	
	public void message(String msg, int priority) {
		if (priority <= this.mask) {
			writeMsg(msg);
		}
		if (next != null) {
			next.message(msg, priority);
		}
	}
	
	public static enum Level {
		
		ERROR(3), INFO(5), DEBUG(7);
		
		int level;
		
		private Level(int level) {
			this.level = level;
		}

		/**
		 * @return the level
		 */
		public int getLevel() {
			return level;
		}
		
	}
	
}
