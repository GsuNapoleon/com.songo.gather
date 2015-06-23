/**
 * 
 */
package com.songo.gather.pattern.templatemethod;

/**
 * <p>decription:</p>
 * <p>date:2015年6月12日 上午10:23:36</p>
 * @author gsu·napoleon
 */
public class Client {

	public static void main(String[] args) {
		Game chess = new Chess();
		chess.initialize();
		chess.display(10000);
	}
	
}
