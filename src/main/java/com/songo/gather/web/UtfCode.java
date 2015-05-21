/**
 * 
 */
package com.songo.gather.web;

import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.commons.io.HexDump;

/**
 * <p>decription:</p>
 * <p>date:2014年10月16日 下午3:43:41</p>
 * @author gsu·napoleon
 */
public class UtfCode {

	/**
	 * <p>decription:</p>
	 * <p>date:2014年10月16日 下午3:43:41</p>
	 * @author gsu·napoleon
	 * @param args
	 */
	public static void main(String[] args) {
		OutputStream stream = null;
		try {
			stream = new FileOutputStream("D:\\DevelopmentEnvironment\\workspace\\SelfWorkspace\\test\\code.txt");
			byte [] datas = "陈".getBytes("UTF-8");
			HexDump.dump(datas, datas.length, stream, 0);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stream != null) {
					stream.close();
				}
			} catch (Exception e) {
				
			}
		}
		
	}

}
