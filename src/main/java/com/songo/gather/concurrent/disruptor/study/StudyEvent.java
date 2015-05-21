/**
 * 
 */
package com.songo.gather.concurrent.disruptor.study;


/**
 * <p>decription:</p>
 * <p>date:2014年4月16日 上午11:32:37</p>
 * @author gsu·napoleon
 */
public class StudyEvent {
	
	private long value;

	/**
	 * @param value the value to set
	 */
	public void setValue(long value) {
		this.value = value;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Study Event : { value = " + this.value + "}" ;
	}
	
}
