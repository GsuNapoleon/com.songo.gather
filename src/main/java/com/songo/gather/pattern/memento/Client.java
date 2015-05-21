/**
 * 
 */
package com.songo.gather.pattern.memento;

/**
 * <p>decription:</p>
 * <p>date:2014年10月11日 上午11:57:07</p>
 * @author gsu·napoleon
 */
public class Client {

	private static Originator originator = new Originator();
	private static Caretaker caretaker = new Caretaker();
	
	public static void main(String[] args) {
		originator.setState("ON");
		caretaker.saveMemento(originator.createMemento());
		originator.setState("OFF");
		originator.restoreMemento(caretaker.retrieveMemento());
	}
	
}
