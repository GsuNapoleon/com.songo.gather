/**
 * 
 */
package com.songo.gather.pattern.templatemethod;

/**
 * <p>decription:</p>
 * <p>date:2015年6月12日 上午10:16:15</p>
 * @author gsu·napoleon
 */
public abstract class Game {

	private int playerCounts;
	
	public abstract void initialize();
	
	public abstract void makePlay(int player);
	
	public abstract boolean endOfGame();
	
	public abstract void printWinner();
	
	public final void display(int playerCounts) {
		this.playerCounts = playerCounts;
		initialize();
		int i = 0;
		while (!endOfGame()) {
			makePlay(i);
			i = (i + 1) % this.playerCounts;
		} 
		printWinner();
	}
	
}
