/**
 * 
 */
package com.songo.gather.concurrent.disruptor.study;

import org.junit.Before;
import org.junit.Test;

/**
 * <p>decription:</p>
 * <p>date:2014年4月16日 下午12:00:10</p>
 * @author gsu·napoleon
 */
public class StudyEventMainTest {

	/**
	 * <p>decription:</p>
	 * <p>date:2014年4月16日 下午12:00:10</p>
	 * @author gsu·napoleon
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for {@link com.songo.cakeop.concurrent.disruptor.study.StudyEventMain#run()}.
	 */
	@Test
	public void testRun() {
		StudyEventMain main = new StudyEventMain();
		try {
			main.run();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
