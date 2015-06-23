/**
 * 
 */
package com.songo.gather.collector;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * <p>
 * decription:
 * </p>
 * <p>
 * date:2015年6月18日 下午5:36:16
 * </p>
 * 
 * @author gsu·napoleon
 */
public final class CollectorWriter {

	private static final Logger logger = LoggerFactory.getLogger(CollectorWriter.class);

	private static final char LF = '\n';
	private static final int BATCH_SIZE = 8;
	private JSONArray batches = new JSONArray(BATCH_SIZE);
	private JSONObject line = new JSONObject(32);
	
	private String fileName = "counter.txt";
	private int count = 0;

	public CollectorWriter() {
	}

	public synchronized void writer(String currentTime, String type,
			String ipAddr, String xForward, String resolution,
			String currentUrl, String referer, String channel, String adId,
			String oldChannel, String suv, String uvdata, String uuid,
			String pcgroupCID, String ldjc, String pcxuv, String from,
			String iframeCode) {
		
		if (!line.isEmpty()) {
			line.clear();
		}
		
		line.put("CURRENT_TIME", currentTime);
		line.put("TYPE", type);
		line.put("IP_ADDR", ipAddr);
		line.put("X_FORWARD", xForward);
		line.put("RESOLUTION", resolution);
		line.put("CURRENT_URL", currentUrl);
		line.put("REFERER", referer);
		line.put("CHANNEL", channel);
		line.put("AD_ID", adId);
		line.put("OLD_CHANNEL", oldChannel);
		line.put("S_UV", suv);
		line.put("UV_DATA", uvdata);
		line.put("UUID", uuid);
		line.put("PCGROUP_CID", pcgroupCID);
		line.put("LDJC", ldjc);
		line.put("PC_XUV", pcxuv);
		line.put("FROM", from);
		line.put("IFRAME_CODE", iframeCode);
		
		batches.add(line);
		
		if (count < BATCH_SIZE) {
			count ++;
			return;
		}
		
		BufferedWriter bw = null;
		OutputStreamWriter osw = null;
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(fileName, true);
			osw = new OutputStreamWriter(fos, "UTF-8");
			bw = new BufferedWriter(osw);
			bw.write(batches.toJSONString() + LF);
			batches.clear();
			count = 0;
		} catch (Exception e) {
			logger.error("unhandle exception : {}", e);
		} finally {
			try {
				if (fos != null) {
					fos.close();
					fos = null;
				}
				if (osw != null) {
					osw.close();
					osw = null;
				}
				if (bw != null) {
					bw.close();
					bw = null;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	/**
	 * @param fileName
	 *            the fileName to set
	 */
	public synchronized void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
