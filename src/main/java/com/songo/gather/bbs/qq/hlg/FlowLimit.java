/**
 * 
 */
package com.songo.gather.bbs.qq.hlg;

/**
 * <p>
 * decription:
 * </p>
 * <p>
 * date:2015年2月6日 下午2:01:32
 * </p>
 * 
 * @author gsu·napoleon
 */
public class FlowLimit {

	private int maxCount;

	/**
	 * 每秒允许的最大访问量
	 * 
	 * @param count
	 */
	public FlowLimit(int maxCount) {
		this.maxCount = maxCount;
	}

	public int getMaxCount() {
		return maxCount;
	}

	public static interface FlowAccessor {
		boolean access();
	}
	
	class Safety implements FlowAccessor {
		
		private static final int MAX_COUNT = 100;
		
		private FlowLimit safetyFlowLimit;
		
		public Safety(FlowLimit safetyFlowLimit) {
			this.safetyFlowLimit = safetyFlowLimit;
		}

		/* (non-Javadoc)
		 * @see com.songo.gather.qq.gbw.FlowLimit.FlowAccessor#access()
		 */
		@Override
		public boolean access() {
			return safetyFlowLimit.getMaxCount() <= MAX_COUNT;
		}
		
	}

	/**
	 * <p>
	 * decription:
	 * </p>
	 * <p>
	 * date:2015年2月6日 下午2:01:32
	 * </p>
	 * 
	 * @author gsu·napoleon
	 * @param args
	 */
	public static void main(String[] args) {
		FlowLimit fl = new FlowLimit(99);
		FlowAccessor fa = FlowLimit.Safety(fl);
		if (fa.access()) {
			System.out.println("→→→→→→→→→→→→→→→");
		}
	}

	/**
	 * <p>decription:</p>
	 * <p>date:2015年2月6日 下午2:20:18</p>
	 * @author gsu·napoleon
	 * @param fl
	 * @return
	 */
	private static FlowAccessor Safety(FlowLimit fl) {
		// TODO Auto-generated method stub
		return null;
	}

}
