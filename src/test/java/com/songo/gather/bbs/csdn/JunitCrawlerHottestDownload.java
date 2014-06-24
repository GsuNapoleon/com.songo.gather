/**
 * 
 */
package com.songo.gather.bbs.csdn;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

/**
 * <p>decription:</p>
 * <p>date:2014年6月19日 下午3:19:29</p>
 * @author gsu·napoleon
 */
public class JunitCrawlerHottestDownload {
	
	private static final String CSDN_DOWNLOAD_URL = "http://download.csdn.net";
	private CrawlerHottestDownload chd;

	/**
	 * <p>decription:</p>
	 * <p>date:2014年6月19日 下午3:19:29</p>
	 * @author gsu·napoleon
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		chd = new CrawlerHottestDownload();
	}

	/**
	 * Test method for {@link com.songo.gather.bbs.csdn.CrawlerHottestDownload#getPageContent(java.lang.String)}.
	 */
	@Test
	public void testGetPageContent() {
		String pageContent = chd.getPageContent(CSDN_DOWNLOAD_URL);
//		System.out.println(pageContent);
		Set<String> sets = chd.getDownloadHref(pageContent);
		String newPageContent = chd.getPageContent(sets.iterator().next());
//		System.out.println(newPageContent);

		String concreteUrl = chd.getConcreteDownloadHref(newPageContent);
		System.out.println(concreteUrl);
		String downloadPageContent = chd.getPageContent(concreteUrl);
		System.out.println(downloadPageContent);
		String concreteDownloadURL = chd.getConcreteDownloadURL(downloadPageContent);
		
//		chd.runDownload(downloadPageContent);
	}
	
}
