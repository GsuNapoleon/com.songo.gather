/**
 * 
 */
package com.songo.gather.utils;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.time.FastDateFormat;

public enum MyDateFormatter {
	YYYY(101, "yyyy"), 
	YYYY_MM(102, "yyyy-MM"), 
	YYYY_MM_DD(103, "yyyy-MM-dd"), 
	YYYY_MM_DD_HH(104, "yyyy-MM-dd HH"), 
	YYYY_MM_DD_HH_MM(105, "yyyy-MM-dd HH:mm"), 
	YYYY_MM_DD_HH_MM_SS(106, "yyyy-MM-dd HH:mm:ss"), 
	YYYYMM(201, "yyyyMM"), 
	YYYYMMDD(202, "yyyyMMdd"), 
	YYYYMMDDHH(203, "yyyyMMddHH"), 
	YYYYMMDDHHMM(204, "yyyyMMddHHmm"), 
	YYYYMMDDHHMMSS(205, "yyyyMMddHHmmss"), 
	YYYYMMDDHHMMSSSSS(206, "yyyyMMddHHmmssSSS"), 
	ZH_YYYY(301, "yyyy年"), 
	ZH_YYYY_MM(302, "yyyy年MM月"), 
	ZH_YYYY_MM_DD(303, "yyyy年MM月dd日"), 
	ZH_YYYY_MM_DD_HH(304, "yyyy年MM月dd日 HH时"), 
	ZH_YYYY_MM_DD_HH_MM(305, "yyyy年MM月dd日 HH时mm分"), 
	ZH_YYYY_MM_DD_HH_MM_SS(306, "yyyy年MM月dd日 HH时mm分ss秒"),
	HHMM(401, "HHmm"),
	HHMMSS(402, "HHmmss");
	
	private final int type;
	private final String pattern;
	
	private MyDateFormatter(int type, String pattern) {
		this.type = type;
		this.pattern = pattern;
	}
	
	public String formatter(Date date) {
		return FastDateFormat.getInstance(pattern).format(date);
	}
	
	public Date parser(String date) throws ParseException {
		return FastDateFormat.getInstance(pattern).parse(date);
	}

	/**
	 * @return the type
	 */
	public int getType() {
		return this.type;
	}
}