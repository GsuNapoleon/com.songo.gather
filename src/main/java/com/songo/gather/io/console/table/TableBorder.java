/**
 * 
 */
package com.songo.gather.io.console.table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>decription:</p>
 * <p>date:2015年8月31日 上午11:33:03</p>
 * @author gsu·napoleon
 */
public class TableBorder {

	private static final Logger logger = LoggerFactory.getLogger(TableBorder.class);
	private final Border border = new Border();
	private boolean isHeader;
	private int width;
	
	public TableBorder() {
		this(8);
	}
	
	public TableBorder(int width) {
		this.width = width;
		this.isHeader = true;
	}
	
	public String buildHorizontal(int width) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < width; i ++) {
			builder.append(border.getHorizontal());
		}
		return builder.toString();
	}

	public String buildCorner() {
		return String.format("%" + width + "s", border.getCorner());
	}
	
	public String buildVertical(int width) {
		return String.format("%" + width + "s", border.getVertical());
	}

	/**
	 * @param isHeader the isHeader to set
	 */
	public void setHeader(boolean isHeader) {
		this.isHeader = isHeader;
	}

	/**
	 * @return the border
	 */
	public Border getBorder() {
		return border;
	}
	
}
