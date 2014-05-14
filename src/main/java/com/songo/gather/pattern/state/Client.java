/**
 * 
 */
package com.songo.gather.pattern.state;

/**
 * <p>decription:</p>
 * <p>date:2014年5月12日 上午11:32:33</p>
 * @author gsu·napoleon
 */
public class Client {
	
	public void doContext(State state, String request) {
		Context context = new Context();
		context.setState(state);
		context.request(request);
	}
	
	public void doConcreteA(String request) {
		State state = new ConcreteA();
		doContext(state, request);
	}
	
	public void doConcreteB(String request) {
		State state = new ConcreteB();
		doContext(state, request);
	}

	/**
	 * <p>decription:</p>
	 * <p>date:2014年5月12日 上午11:32:33</p>
	 * @author gsu·napoleon
	 * @param args
	 */
	public static void main(String[] args) {
		Client client = new Client();
		String request = "go";
		int flag = 0;
		if (flag == 1) {
			client.doConcreteA(request);
		} else if (flag == 2) {
			client.doConcreteB(request);
		}
	}

}
