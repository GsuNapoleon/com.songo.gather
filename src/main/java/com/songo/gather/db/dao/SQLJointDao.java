/**
 * 
 */
package com.songo.gather.db.dao;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.org.apache.bcel.internal.generic.GETSTATIC;

/**
 * <p>decription:</p>
 * <p>date:2015年3月27日 上午9:38:30</p>
 * @author gsu·napoleon
 */
public class SQLJointDao {

	/**
	 * <p>decription:</p>
	 * <p>date:2015年3月27日 上午9:38:30</p>
	 * @author gsu·napoleon
	 * @param args
	 */
	public static void main(String[] args) {
		SQLJointDao dao = new SQLJointDao();
		try {
			String pvDurationDaily = getTablePrefix(false) + "pv_duration_daily";
			String pvDurationTimesDaily = getTablePrefix(false) + "pv_duration_times_daily";
			System.out.println("pvDurationDaily = " + pvDurationDaily 
					+ "; pvDurationTimesDaily = " + pvDurationTimesDaily);
			List<Map<String, String>> durationSQLs = dao.getDurationSQL(4, 11, 20150327, 20150329);
			for (Map<String, String> sql : durationSQLs) {
				String dur = sql.get("dur");
				String durTimes = sql.get("dur_times");
				System.err.println("dur = " + dur + "; dur_times = " + durTimes);
			}
//			dao.getMonthlyList();
//			dao.getDataArray(durationSQLs);
//			dao.getMonthly(201503, 201506);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
//			dao.close(conn);
		}
	}

	/**
	 * <p>decription:</p>
	 * <p>date:2015年3月27日 下午2:04:09</p>
	 * @author gsu·napoleon
	 */
	private void getMonthlyList() {
		List<Integer> monthList = DateUtil.getMonthList(201503, 201506);
		for (Integer i : monthList) {
			int startYmd = DateUtil.getMonthDayOfFirstOrLast(i, 1, "yyyyMM");
			int endYmd = DateUtil.getMonthDayOfFirstOrLast(i, 2, "yyyyMM");
			System.err.println("startYmd = " + startYmd + " & endYmd = " + endYmd);
			List<Map<String, String>> monthSQL = getDurationSQL(4, 11, startYmd, endYmd);
			BigDecimal duration = getDataArray(monthSQL);
			System.err.println(i + "月 " + duration);
		}
	}
	
	private BigDecimal getDataArray(List<Map<String, String>> sqlList) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        PreparedStatement dps = null;
        ResultSet drs = null;
        try {
            conn = getConnection();
            long total = 0;
            long timesTotal = 0;
            for (Map<String, String> sql : sqlList) {
                String durSQL = sql.get("dur");
                String durTimesSQL = sql.get("dur_times");
                try {
                	ps = conn.prepareStatement(durSQL.split(";")[0]);
                    rs = ps.executeQuery();
                    int durColumnCount = rs.getMetaData().getColumnCount();
                    if (rs.next()) {
                        for (int i = 1; i <= durColumnCount; i++) {
                            total += rs.getLong(i);
                        }
                    }
                    dps = conn.prepareStatement(durTimesSQL.split(";")[0]);
                    drs = dps.executeQuery();
                    int durTimesColumnCount = drs.getMetaData().getColumnCount();
                    if (drs.next()) {
                    	for (int i = 1; i <= durTimesColumnCount; i++) {
                    		timesTotal += drs.getLong(i);
                    	}
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println("total = " + total + "&dtotal = " + timesTotal);
            BigDecimal totalBD = new BigDecimal(total);
            BigDecimal timesTotalBD = new BigDecimal(timesTotal);
            
            return timesTotal != 0 ? totalBD.divide(timesTotalBD, RoundingMode.HALF_UP) 
            		: timesTotalBD;
        } catch (Exception sqlEx) {
            throw new RuntimeException(sqlEx);
        } finally {
            close(rs, ps, drs, dps, conn);
        }
    }

	private List<Map<String, String>> getDurationSQL(int sid, int cid, int startYmd, int endYmd) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sid", sid);
		params.put("cid", cid);
		
		int startYm = startYmd / 100;
		int endYm = endYmd / 100;
		int startDay = startYmd % 100;
		int endDay = endYmd % 100;
		
		List<Map<String, String>> sqlList = new ArrayList<Map<String, String>>();
		for (int ym = startYm; ym <= endYm; ym++) {
			int year = ym / 100;
			int month = ym % 100;
			if (month > 12) {
				year++;
				month = 1;
				ym = year * 100 + month;
				if (ym > endYm) {
					break;
				}
			}
			int maxDay = getDays(ym);
			int from = 1;
			int to = maxDay;
			if (ym == startYm) {
				from = startDay;
			}
			if (ym == endYm) {
				to = endDay;
			}
			for (int day = from; day <= to; day++) {
				StringBuilder builderDuration = new StringBuilder();
				builderDuration.append("select ").append("v").append(day);
				builderDuration.append(" from ").append(getTablePrefix(false) + "pv_duration_daily");
				params.put("ym", ym);
				builderDuration.append(getClause(params)).append(";").append(to - from + 1);
				StringBuilder builderDurationTimes = new StringBuilder();
				builderDurationTimes.append("select ").append("v").append(day);
				builderDurationTimes.append(" from ").append(getTablePrefix(false) + "pv_duration_times_daily");
				builderDurationTimes.append(getClause(params)).append(";").append(to - from + 1);
				
				Map<String, String> durationMap = new HashMap<String, String>();
				durationMap.put("dur", builderDuration.toString());
				durationMap.put("dur_times", builderDurationTimes.toString());
				
				sqlList.add(durationMap);
			}
		}
		
		return sqlList;
	}
	
	private String getClause(Map<String, Object> params) {
		StringBuilder builder = new StringBuilder();
		builder.append(" where ");

		boolean isFirstAppend = true;
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				if (isFirstAppend) {
					isFirstAppend = false;
				} else {
					builder.append(" and ");
				}
				builder.append(key).append(" = ")
						.append(v2sql(params.get(key)));
			}
		}
		return builder.toString();
	}
	
	private String v2sql(Object v) {
		if (v instanceof String) {
			String s = (String) v;
			StringBuilder buf = new StringBuilder(s.length() + 2);
			buf.append('\'');

			for (int i = 0, c = s.length(); i < c; ++i) {
				char ch = s.charAt(i);
				switch (ch) {
				case '\'':
					buf.append(ch).append(ch);
					break;
				case '\n':
					buf.append('\\').append('n');
					break;
				case '\r':
					buf.append('\\').append('r');
					break;
				case '\t':
					buf.append('\\').append('t');
					break;
				default:
					// 忽略Java 1.5新增的 UTF16 扩展编码字符，因为MySQL驱动不支持
					if (ch < Character.MIN_SURROGATE
							|| ch > Character.MAX_SURROGATE) {
						buf.append(ch);
					}
					break;
				}
			}

			buf.append('\'');
			return buf.toString();
		}
		return v.toString();
	}

	/**
	 * <p>decription:</p>
	 * <p>date:2015年3月27日 上午10:03:23</p>
	 * @author gsu·napoleon
	 * @param isMobile
	 * @return
	 */
	private static String getTablePrefix(boolean isMobile) {
		return "cnt_" + (isMobile ? "mobile_" : "");
	}
	
	private int getDays(int ym) {
		int year = ym / 100;
		int mm = ym % 100;
		if (mm == 13) {
			mm = 1;
		}
		int maxDay = 30;
		switch (mm) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			maxDay = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			maxDay = 30;
			break;
		case 2:
			if (year % 400 == 0 || (year % 100 != 0 && year % 4 == 0)) {
				maxDay = 29;
			} else {
				maxDay = 28;
			}
			break;
		}
		return maxDay;
	}
	
	private Connection getConnection() throws Exception {
		String dbUrl = "jdbc:mysql://192.168.75.99:3306/counter6?rewriteBatchedStatements=true&useUnicode=true&characterEncoding=utf8";
		String dbDriver = "com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource";
		String dbUser = "cnt_it";
		String dbPassword = "cnt_it";
		Class.forName(dbDriver);
		return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
	}
	
	private void close(Object... dbRes) {
		for (Object obj : dbRes) {
			if (obj == null) {
				continue;
			}
			try {
				if (obj instanceof ResultSet) {
					((ResultSet) obj).close();
				} else if (obj instanceof PreparedStatement) {
					((PreparedStatement) obj).close();
				} else if (obj instanceof Connection) {
					((Connection) obj).close();
				}
			} catch (Exception ex) {
			}
		}
	}
	
}
