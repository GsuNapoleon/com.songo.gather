/**
 * 
 */
package com.songo.gather.pattern.absfactorymethod;

/**
 * <p>decription:</p>
 * <p>date:2015年10月15日 上午10:52:39</p>
 * @author gsu·napoleon
 */
public class Red implements Color {

	/* (non-Javadoc)
	 * @see com.songo.gather.pattern.absfactorymethod.Color#fill()
	 */
	@Override
	public void fill() {
		System.err.println("Color : fill is red, to do!");
	}

}
