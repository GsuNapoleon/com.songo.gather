/**
 * 
 */
package com.songo.gather.web.springmvctestframe;

import org.junit.Test;

/**
 * <p>decription:</p>
 * <p>date:2014年7月3日 下午3:29:37</p>
 * @author gsu·napoleon
 */
public class BusinessControllerTest extends BaseControllerTest {
	
	@Test
	public void testAdd() {
		
		try {
			mockMvc.perform(get("/consumer/add").param("name", "Test")).andExpect(status().isOk());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
