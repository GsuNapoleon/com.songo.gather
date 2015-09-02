/**
 * 
 */
package com.songo.gather.io.console.table;

/**
 * <p>decription:</p>
 * <p>date:2015年8月31日 上午11:33:13</p>
 * @author gsu·napoleon
 */
public class TableColumn {

	private int width;
	private Align align;
	
	private TableColumn() {
		this(4);
	}
	
	private TableColumn(int width) {
		this.width = width;
	}
	
	public static Builder create() {
		return create(4);
	}
	
	public static Builder create(int width) {
		return new Builder(new TableColumn(width));
	}
	
	public static class Builder implements TableBuilder<TableColumn> {

		private TableColumn tableColumn;
		
		public Builder(TableColumn tableColumn) {
			this.tableColumn = tableColumn;
		}
		
		/* (non-Javadoc)
		 * @see com.songo.gather.io.console.table.TableBuilder#build()
		 */
		@Override
		public TableColumn build() {
			return this.tableColumn;
		}
		
		public Builder alignRight() {
			return this;
		}
		
		public Builder alignLeft() {
			return this;
		}
		
		public Builder alignCenter() {
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
	 * @return the align
	 */
	public Align getAlign() {
		return align;
	}
	
}
