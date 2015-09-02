/**
 * 
 */
package com.songo.gather.io.console.table;

/**
 * <p>decription:</p>
 * <p>date:2015年8月31日 上午11:33:47</p>
 * @author gsu·napoleon
 */
public class TableCell {

	private int width;
	private int height;
	private boolean isHeader;
	private String content;
	private TableBorder tb;
	
	public TableCell(String content) {
		this(0, 0, false, content, new TableBorder());
	}
	
	public TableCell(int width, int height, boolean isHeader, 
			String content, TableBorder tb) {
		this.width = width;
		this.height = height;
		this.isHeader = isHeader;
		this.content = content;
		this.tb = tb;
	}
	
	public static Builder create(String content) {
		return new Builder(new TableCell(content));		
	}
	
	public String build() {
		StringBuilder builder = new StringBuilder();
		return builder.toString();
	}
	
	public static class Builder implements TableBuilder<TableCell> {

		private TableCell tableCell;
		
		public Builder(TableCell tableCell) {
			this.tableCell = tableCell;
		}
		
		/* (non-Javadoc)
		 * @see com.songo.gather.io.console.table.TableBuilder#build()
		 */
		@Override
		public TableCell build() {
			this.tableCell.setWidth(this.tableCell.getContent().length());
			return this.tableCell;
		}
		
		public Builder isHeader() {
			this.tableCell.setHeader(true);
			return this;
		}
		
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the tb
	 */
	public TableBorder getTb() {
		return tb;
	}

	/**
	 * @param tb the tb to set
	 */
	public void setTb(TableBorder tb) {
		this.tb = tb;
	}

	/**
	 * @param isHeader the isHeader to set
	 */
	public void setHeader(boolean isHeader) {
		this.isHeader = isHeader;
	}

	/**
	 * @return the isHeader
	 */
	public boolean isHeader() {
		return isHeader;
	}

}
