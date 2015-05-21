/**
 * 
 */
package com.songo.gather.pattern.memento;

/**
 * <p>decription:</p>
 * <p>date:2014年10月11日 上午11:55:24</p>
 * @author gsu·napoleon
 */
public class Caretaker {

	private Memento memento;
	
	public Memento retrieveMemento() {
		return this.memento;
	}
	
	public void saveMemento(Memento memento) {
		this.memento = memento;
	}
	
}
