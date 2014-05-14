/**
 * 
 */
package com.songo.gather.pattern.state;

/**
 * <p>decription:</p>
 * <p>date:2014年5月12日 上午11:23:09</p>
 * @author gsu·napoleon
 */
public class Context {
	
	private State state;
	
	public void setState(State state) {
		this.state = state;
	}
	
	public void request(String request) {
		state.handle(request);
	}

}
