/**
 * 
 */
package com.songo.gather.io.console.table;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>decription:</p>
 * <p>date:2015年8月31日 下午12:12:19</p>
 * @author gsu·napoleon
 */
public class TableTest {

	private static final Logger logger = LoggerFactory.getLogger(TableTest.class);
	
	/**
	 * <p>decription:</p>
	 * <p>date:2015年8月31日 下午12:12:19</p>
	 * @author gsu·napoleon
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Table table = Table.create()
				.addColumn(TableColumn.create().build())
				.addColumn(TableColumn.create().build())
				.addColumn(TableColumn.create().build())
				.addColumn(TableColumn.create().build())
				.addColumn(TableColumn.create().build())
				.build();
		table.newTableRow().appendCell(TableCell.create("id").isHeader().build())
			.appendCell(TableCell.create("name").isHeader().build())
			.appendCell(TableCell.create("age").isHeader().build())
			.appendCell(TableCell.create("sex").isHeader().build())
			.appendCell(TableCell.create("company").isHeader().build()).create();;
//		logger.debug("Table columns : {}", table.getColumns().size());
//		table.buildColumn();
//		TableCell tc = TableCell.create("A").alignCenter().build();
//		logger.debug("content:{}, align:{}", tc.getContent(), tc.getAlign().isCenter());
//		logger.debug("{}", tc.build());
	}

	@Test
	public void testLength() {
		System.out.println("id".length());
		System.out.println("+-".length());
		System.out.println("--".length());
	}
	
}
