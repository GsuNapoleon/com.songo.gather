/**
 * 
 */
package com.songo.gather.web.collector;

import java.util.Date;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.songo.gather.utils.MyDateFormatter;

/**
 * <p>
 * decription:
 * </p>
 * <p>
 * date:2015年6月19日 上午9:30:57
 * </p>
 * 
 * @author gsu·napoleon
 */
public class FileOutputManager {
	private static String [][] NAMES_TABLE = null;
	static {
		NAMES_TABLE = FileNameManager.FILE_TIMES.getFileNames();
	}

	private static final Logger logger = LoggerFactory
			.getLogger(FileOutputManager.class);

	private static final String LOCAL_MANAGER = "com.songo.gather.counter.LocalManager";
	private static final ResourceBundle localManager = ResourceBundle
			.getBundle(LOCAL_MANAGER);

	public static final int STATUS_NEW = 0;
	public static final int STATUS_INITED = 1;
	private int status = STATUS_NEW;

	private String path_0_30;
	private String path_15_45;
	private String path_exception;

	private static volatile FileOutputManager INSTANCE = null;

	private CollectorWriter writer;

	private FileOutputManager() {
	}

	/**
	 * <p>
	 * decription:懒汉模式
	 * </p>
	 * <p>
	 * date:2015年6月19日 上午9:49:24
	 * </p>
	 * 
	 * @author gsu·napoleon
	 * @return
	 */
	public static FileOutputManager getInstance() {
		if (INSTANCE == null) {
			synchronized (FileOutputManager.class) {
				if (INSTANCE == null) {
					INSTANCE = new FileOutputManager();
				}
			}
		}
		return INSTANCE;
	}

	public synchronized void init() {
		if (getStatus() != STATUS_NEW) {
			logger.warn("类已初始化!未初始化状态是：{{}},当前状态是：{{}}.", STATUS_NEW,
					getStatus());
			return;
		}

		setStatus(STATUS_INITED);

		this.path_0_30 = localManager.getString("PATH_0_30");
		this.path_15_45 = localManager.getString("PATH_15_45");
		this.path_exception = localManager.getString("PATH_EXCEPTION");

		CollectorWriter localWriter = new CollectorWriter();
		localWriter.setFileName(getFileName());

		this.writer = localWriter;
	}

	private synchronized String getFileName() {
		String fileName = MyDateFormatter.YYYYMMDD.formatter(new Date()) + getStartTime();
		String filePath = "";
		if (fileName.lastIndexOf("0") != -1) {
			filePath = this.path_0_30 + fileName;
		} else if (fileName.lastIndexOf("5") != -1) {
			filePath = this.path_15_45 + fileName;
		} else {
			filePath = this.path_exception + fileName;
		}
		logger.debug("最终生成的file path是：{{}}.", filePath);
		return filePath;
	}

	public void writer(String type, String ipAddr, String xForward,
			String resolution, String currentUrl, String referer,
			String channel, String adId, String oldChannel, String suv,
			String uvdata, String uuid, String pcgroupCID, String ldjc,
			String pcxuv, String from, String iframeCode) {
		writer.writer(MyDateFormatter.YYYYMMDDHHMMSS.formatter(new Date()), 
				type, ipAddr, xForward, resolution, currentUrl, referer, channel, adId,
				oldChannel, suv, uvdata, uuid, pcgroupCID, ldjc, pcxuv, from, iframeCode);
	}

	public static void main(String[] args) {
		FileOutputManager fopManager = FileOutputManager.getInstance();
		fopManager.init();
	}

	public static String getStartTime() {
		int currentIntTime = Integer.valueOf(MyDateFormatter.HHMM.formatter(new Date()));

		int hh = currentIntTime / 100;
		int mm = currentIntTime % 100;
		return hh + NAMES_TABLE[hh][getHourMmIndex(mm)];
	}

	/**
	 * <p>
	 * decription:
	 * </p>
	 * <p>
	 * date:2015年6月19日 下午12:24:29
	 * </p>
	 * 
	 * @author gsu·napoleon
	 * @param mm
	 * @return 异常时,返回-1;
	 */
	private static int getHourMmIndex(int mm) {
		return mm < 15 ? 0 : mm < 30 ? 1 : mm < 45 ? 2 : mm <= 59 ? 3 : -1;
	}

	private enum FileNameManager {
		FILE_TIMES {
			public String[][] getFileNames() {
				String[][] times = new String[24][4];
				for (int i = 0; i < 24; i++) {
					for (int j = 0; j < 4; j++) {
						int t = j * 15;
						times[i][j] = t == 0 ? ("0" + t) : String.valueOf(t);
					}
				}
				return times;
			}
		};
		public String[][] getFileNames() {
			return null;
		}
	}

	/**
	 * @return the status
	 */
	public synchronized int getStatus() {
		return this.status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public synchronized void setStatus(int status) {
		this.status = status;
	}
}
