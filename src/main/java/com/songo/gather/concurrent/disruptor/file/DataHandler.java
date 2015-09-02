/**
 * 
 */
package com.songo.gather.concurrent.disruptor.file;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lmax.disruptor.EventHandler;

/**
 * <p>decription:</p>
 * <p>date:2015年8月12日 上午10:55:58</p>
 * @author gsu·napoleon
 */
public class DataHandler implements EventHandler<Data> {

	private static final Logger logger = LoggerFactory.getLogger(DataHandler.class);
	
	private Set<String> ips = new HashSet<String>();
	private Set<String> uvs = new HashSet<String>();
	private Set<String> ups = new HashSet<String>();
	private AtomicLong pvs = new AtomicLong(0);
	private int init;
	
	public DataHandler() {
		logger.warn("初始化:【{}】", init ++);
	}
	
	/* (non-Javadoc)
	 * @see com.lmax.disruptor.EventHandler#onEvent(java.lang.Object, long, boolean)
	 */
	@Override
	public void onEvent(Data event, long sequence, boolean endOfBatch)
			throws Exception {
		pvs.incrementAndGet();
		String ip = event.getIpAddr();
		countIp(ip);
		if (!StringUtils.equals("0", event.getSuv())) {
			countUv(event.getSuv(), ip);
		} else {
			countUvIp(ip);
		}
//		Object [] objs = {sequence, uvs.size(), ups.size(), ips.size()};
//		logger.debug("sequence->[{}], uvs->[{}], ups->[{}], ips->[{}]", objs);
	}
	
	/**
	 * <p>decription:</p>
	 * <p>date:2015年8月12日 下午12:03:56</p>
	 * @author gsu·napoleon
	 * @param event
	 * @param ip
	 */
	private void countUv(String suv, String ip) {
		if (!ups.isEmpty() && StringUtils.isNotBlank(ip) && ups.contains(ip)) {
			ups.remove(ip);
		}
		if (StringUtils.isNotBlank(suv)) {
			uvs.add(suv);
		}
	}

	/**
	 * <p>decription:</p>
	 * <p>date:2015年8月12日 下午12:03:35</p>
	 * @author gsu·napoleon
	 * @param ip
	 */
	private void countUvIp(String ip) {
		if (StringUtils.isNotBlank(ip)) {
			ups.add(ip);
		}
	}

	/**
	 * <p>decription:</p>
	 * <p>date:2015年8月12日 下午12:03:11</p>
	 * @author gsu·napoleon
	 * @param ip
	 */
	private void countIp(String ip) {
		if (StringUtils.isNotBlank(ip)) {
			ips.add(ip);
		}
	}

	public long getIpNums() {
		return ips.size();
	}
	
	public long getUvNums() {
		return uvs.size() + ups.size();
	}
	
	public long getUvIpNums() {
		return ups.size();
	}

	/**
	 * @return the pvs
	 */
	public AtomicLong getPvs() {
		return pvs;
	}

	/**
	 * @param pvs the pvs to set
	 */
	public void setPvs(AtomicLong pvs) {
		this.pvs = pvs;
	}
}
