/**
 * 
 */
package com.songo.gather.io.console.table;

import org.fusesource.jansi.Ansi;

/**
 * <p>decription:</p>
 * <p>date:2015年9月2日 上午9:37:48</p>
 * @author gsu·napoleon
 */
public enum Align {
	
	CENTER {
		
	},
	LEFT {
		
	},
	RIGHT {
		
	};
	
	public StringBuilder format(String text, int width, StringBuilder builder) {
		return null;
	}
	
	public StringBuilder format(String text, int width, StringBuilder builder, Ansi ansi) {
		return null;
	}
	

}
