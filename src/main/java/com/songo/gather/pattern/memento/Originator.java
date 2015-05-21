/**
 * 
 */
package com.songo.gather.pattern.memento;

/**
 * <p>decription:</p>
 * <p>date:2014年10月11日 上午11:50:27</p>
 * @author gsu·napoleon
 */
public class Originator {

	private String state;
	
	public Memento createMemento() {
		return new Memento(state);
	}
	
	public void restoreMemento(Memento memento) {
		this.state = memento.getState();
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
