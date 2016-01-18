/**
 * 
 */
package com.songo.gather.pattern.absfactorymethod;

/**
 * <p>decription:</p>
 * <p>date:2015年10月15日 上午10:52:52</p>
 * @author gsu·napoleon
 */
public class Green implements Color {

	/* (non-Javadoc)
	 * @see com.songo.gather.pattern.absfactorymethod.Color#fill()
	 */
	@Override
	public void fill() {
		System.err.println("Color : fill is green, to do!");
	}

}
