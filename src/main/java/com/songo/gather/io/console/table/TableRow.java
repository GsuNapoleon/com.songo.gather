/**
 * 
 */
package com.songo.gather.io.console.table;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;

/**
 * <p>decription:</p>
 * <p>date:2015年8月31日 上午11:34:20</p>
 * @author gsu·napoleon
 */
public class TableRow {

	private List<TableColumn> columns;
	private List<TableCell> cells;
	private TableBorder tableBorder;
	
	public TableRow(Set<TableColumn> columns, TableBorder tableBorder) {
		this(columns, new ArrayList<TableCell>(), tableBorder);
	}
	
	public TableRow(Set<TableColumn> columns, List<TableCell> cells, TableBorder tableBorder) {
		this.columns = new ArrayList<TableColumn>(columns);
		this.cells = cells;
		this.tableBorder = tableBorder;
	}
	
	public TableRow appendCell(TableCell cell) {
		this.cells.add(cell);
		return this;
	}
	
	public void create() {
		
		if (CollectionUtils.isEmpty(columns) || CollectionUtils.isEmpty(cells) || columns.size() != cells.size()) {
			return;
		}
		StringBuilder columnBuilder = new StringBuilder();
		StringBuilder rowBuilder = new StringBuilder();
		columnBuilder.append(tableBorder.getBorder().getVertical());
		for (int i = 0; i < columns.size(); i ++) {
			TableColumn column = columns.get(i);
			TableCell cell = cells.get(i);
			if (cell.isHeader()) {
				createRow(rowBuilder, cell, i);
			}
			columnBuilder.append(cell.getContent()).append(tableBorder.getBorder().getVertical());
		}
		System.err.println(rowBuilder.toString());
		System.err.println(columnBuilder.toString());
		System.err.println(rowBuilder.toString());
	}

	/**
	 * <p>decription:</p>
	 * <p>date:2015年9月1日 下午3:11:21</p>
	 * @author gsu·napoleon
	 * @param i
	 * @return
	 */
	private boolean isLine(int i) {
		return i == columns.size() - 1;
	}

	/**
	 * <p>decription:</p>
	 * <p>date:2015年9月1日 下午2:56:25</p>
	 * @author gsu·napoleon
	 * @param rowBuilder
	 * @param cell
	 */
	private void createRow(StringBuilder rowBuilder, TableCell cell, int i) {
		rowBuilder.append(i == 0 ? tableBorder.getBorder().getCorner() : "");
		rowBuilder.append(tableBorder.buildHorizontal(cell.getWidth()));
		rowBuilder.append(tableBorder.getBorder().getCorner()).append(false ? "\n" : "");
	}
	
}
