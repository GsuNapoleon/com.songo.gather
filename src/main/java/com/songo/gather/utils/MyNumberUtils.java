/**
 * 
 */
package com.songo.gather.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.MessageFormat;
import java.text.NumberFormat;

import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>decription:</p>
 * <p>date:2015年7月2日 下午5:34:17</p>
 * @author gsu·napoleon
 */
public final class MyNumberUtils extends NumberUtils {

	private static final Logger logger = LoggerFactory.getLogger(MyNumberUtils.class);
	
	public static String getDefaultDivisionPercentValue(long dividend, long divisor) {
		return getDivisionPercentValue(dividend, divisor, 2);
	}
	
	public static String getDivisionPercentValue(long dividend, long divisor, int scale) {
		return getDivisionValue(dividend, divisor, scale, true);
	}
	
	public static String getDefaultDivisionNumberValue(long dividend, long divisor) {
		return getDivisionNumberValue(dividend, divisor, 2);
	}
	
	public static String getDivisionNumberValue(long dividend, long divisor, int scale) {
		return getDivisionValue(dividend, divisor, scale, false);
	}
	
	/**
	 * 百分比的格式化法：
	 * <p>第一种格式化方法：String.format("%.2f%%", result.doubleValue() * 100)</p>
	 * <p>第二种格式化方法：MessageFormat.format("{0,number,0.00%}", result)</p>
	 * <p>date:2015年7月3日 上午10:34:09</p>
	 * @author gsu·napoleon
	 * @param dividend	被除数
	 * @param divisor	除数
	 * @param scale		精度
	 * @param isPercent	是否是百分比
	 * @return
	 */
	public static String getDivisionValue(long dividend, long divisor, int scale, boolean isPercent) {
        if (dividend == 0 || divisor == 0) {
            return MessageFormat.format("{0,number,"
            		+ String.format("%." + scale + "f" + (isPercent ? "%%" : ""), 0.0)
            		+ "}", 0);
        }
        BigDecimal bdValue = new BigDecimal(dividend);
        BigDecimal bdDivisor = new BigDecimal(divisor);
        BigDecimal result = bdValue.divide(bdDivisor, scale, RoundingMode.HALF_UP);
        Object [] args = new Object[]{dividend, divisor, scale, isPercent, result};
        logger.debug("接收参数：{value:{}, divisor:{}, scale:{}, isPercent:{}}, 结果：{{}}", args);
        return isPercent 
        		? getNumberFormatPercentInstance(scale, RoundingMode.HALF_UP).format(result.doubleValue())
        		: result.toString();
    }

	/**
	 * 
	 * <p>decription:</p>
	 * <p>date:2015年7月3日 下午2:00:09</p>
	 * @author gsu·napoleon
	 * @param digits	小数位数
	 * @param mode		舍入模式
	 * @return			NumberFormat.getPercentInstance()
	 */
	public static NumberFormat getNumberFormatPercentInstance(int digits, RoundingMode mode) {
		NumberFormat formatter = NumberFormat.getPercentInstance();
		formatter.setRoundingMode(mode);
		formatter.setMaximumFractionDigits(digits);
		formatter.setGroupingUsed(false);
		return formatter;
	}
	
}
