/**
 * 
 */
package com.songo.gather.pattern.memento;

/**
 * <p>decription:</p>
 * <p>date:2014年10月11日 上午11:48:59</p>
 * @author gsu·napoleon
 */
public class Memento {

	private String state;
	
	public Memento(String _state) {
		this.state = _state;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	
}
