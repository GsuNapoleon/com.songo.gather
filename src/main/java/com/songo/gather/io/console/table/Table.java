/**
 * 
 */
package com.songo.gather.io.console.table;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>decription:</p>
 * <p>date:2015年8月31日 上午11:32:56</p>
 * @author gsu·napoleon
 */
public class Table {

	private Set<TableColumn> columns = new HashSet<TableColumn>();
	private TableBorder tableBorder = new TableBorder();
	
	public static Builder create() {
		return new Builder(new Table());
	}
	
	public TableRow newTableRow() {
		return new TableRow(columns, tableBorder);
	}
	
	public static class Builder implements TableBuilder<Table> {

		private Table table;
		
		public Builder(Table table) {
			this.table = table;
		}
		
		public Builder addColumn(TableColumn column) {
			this.table.setColumn(column);
			this.table.setTableBorder(new TableBorder(column.getWidth()));
			return this;
		}
		
		/* (non-Javadoc)
		 * @see com.songo.gather.io.console.table.TableBuilder#build()
		 */
		@Override
		public Table build() {
			return this.table;
		}
		
	}

	/**
	 * @return the columns
	 */
	public Set<TableColumn> getColumns() {
		return columns;
	}

	/**
	 * @param columns the columns to set
	 */
	public void setColumns(Set<TableColumn> columns) {
		this.columns = columns;
	}
	
	public void setColumn(TableColumn column) {
		if (this.columns == null) {
			this.columns = new HashSet<TableColumn>();
		}
		this.columns.add(column);
	}
	
	/**
	 * @return the tableBorder
	 */
	public TableBorder getTableBorder() {
		return tableBorder;
	}

	/**
	 * @param tableBorder the tableBorder to set
	 */
	public void setTableBorder(TableBorder tableBorder) {
		this.tableBorder = tableBorder;
	}

	public void buildColumn() {
		if (columns == null || columns.size() == 0) {
			return;
		}
		StringBuilder builder = new StringBuilder();
		builder.append(tableBorder.getBorder().getVertical());
		for (TableColumn tc : columns) {
//			builder.append(tableBorder.buildVertical());
		}
		System.out.println(builder.toString());
	}
	
}
