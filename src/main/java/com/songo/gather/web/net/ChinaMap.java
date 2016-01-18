/**
 * 
 */
package com.songo.gather.web.net;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.alibaba.fastjson.JSONObject;

/**
 * <p>decription:</p>
 * <p>date:2015年11月5日 下午3:11:08</p>
 * @author gsu·napoleon
 */
public class ChinaMap {

	private List<Mapper> mappers;
	
	public void init() {
		this.mappers = Parse.getProvinceLevels(null);
	}
	
	public void run() {
		
		if (mappers == null || mappers.isEmpty()) {
			return;
		}
		
		ExecutorService service = Executors.newFixedThreadPool(32);
		for (int i = 0; i < mappers.size(); i ++) {
			final Mapper mapper = mappers.get(i);
			final String fileName = mapper.getName();
			service.submit(new Callable<Integer>() {

				@Override
				public Integer call() throws Exception {
					return process(fileName, mapper);
				}
			});
		}
		service.shutdown();
	}
	
	public Integer process(String fileName, Mapper mapper) {
		int level = CssLevel.CITY.getLevel();
		try {
			Document doc = Parse.connect(mapper.getHref());
			StringBuilder sb = new StringBuilder();
			Parse.next(sb, doc, level);
			Parse.writer(sb, fileName);
		} catch (IOException e) {
//			e.printStackTrace();
		}
		return 0;
	}
	
	public static void main(String[] args) {
		ChinaMap map = new ChinaMap();
		map.init();
		map.run();
	}
	
	private static class Parse {
		
		private static final String BASE_URI = "http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2013/";
		private static final ChinaMap ChinaMap = new ChinaMap();
		
		private static List<Mapper> getProvinceLevels(String baseUri) {

			Elements eles = null;
			try {
				String localBaseUri = StringUtils.isNotBlank(baseUri) ? baseUri : BASE_URI;
				Document doc = connect(localBaseUri);
				eles = doc.select("tr." + CssLevel.PROVINCE.getCss());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			if (isEmptyElements(eles)) {
				return new ArrayList<Mapper>(0);
			}
			
			List<Mapper> provinces = new ArrayList<Mapper>();
			for (Element ele : eles) {
				Elements aeles = ele.select("a");
				if (isEmptyElements(aeles)) {
					continue;
				}
				for (Element aele : aeles) {
					Mapper mapper = ChinaMap.new Mapper(Integer.valueOf(aele.attr("href").substring(0, 2)), 
							aele.text(), aele.absUrl("href"));
					provinces.add(mapper);
				}
			}
			
			return provinces;
		}
		
		private static boolean isEmptyElements(Elements eles) {
			return eles == null || eles.isEmpty();
		}
		
		private static void next(StringBuilder sb, Document doc, int level) {
			sleep();
			
			try {
//				Document doc = connect(ele.absUrl("href"));
//				StringBuilder sb = new StringBuilder();
				if (doc != null) {
					Elements celes = doc.select("tr." + getCssLevel().get(level));
					for (Element cele : celes) {
						print(sb, level, cele);
						Elements seles = cele.select("a");
						if (seles.size() != 0) {
							next(sb, connect(seles.last().absUrl("href")), level + 1);
						}
					}
				}
			} catch (IOException e) {
//				e.printStackTrace();
			}
			
		}

		/**
		 * <p>decription:</p>
		 * <p>date:2015年11月5日 下午4:36:37</p>
		 * @author gsu·napoleon
		 * @param ele
		 * @return
		 * @throws IOException
		 */
		private static Document connect(String baseUri) throws IOException {
			Connection connection = Jsoup.connect(baseUri)
					.userAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.21 (KHTML, like Gecko) Chrome/19.0.1042.0 Safari/535.21")
					.timeout(100 * 1000);
			Connection.Response resp = connection.execute();
			int sum = 0;
			if (resp.statusCode() != 200) {
				sleep();
				while (sum < 10) {
					Connection.Response resp1 = connection.execute();
					if (resp1.statusCode() == 200) {
						resp = resp1;
						break;
					}
					sum ++;
				}
			}
			if (resp.statusCode() == 200) {
				return connection.get();
			}
			return null;
		}

		/**
		 * <p>decription:</p>
		 * <p>date:2015年11月5日 下午4:36:03</p>
		 * @author gsu·napoleon
		 */
		private static void sleep() {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		/**
		 * <p>decription:</p>
		 * <p>date:2015年11月5日 下午4:03:43</p>
		 * @author gsu·napoleon
		 * @param level
		 * @param cele
		 */
		private static void print(StringBuilder sb, int level, Element cele) {
			
			if (cele == null) {
				return ;
			}
			
			if (level == 1) {
				sb.append(cele.select("td").first().text()).append("\t");
				sb.append(level).append("\t").append("999999000000");
			} else {
				sb.append(cele.select("td").last().text()).append("\t");
				sb.append(level).append("\t").append(cele.select("td").first().text());
			}
			sb.append("\n");
		}

		/**
		 * <p>decription:</p>
		 * <p>date:2015年11月5日 下午5:08:02</p>
		 * @author gsu·napoleon
		 * @param sb
		 */
		private static void writer(StringBuilder sb, String fileName) {
			BufferedWriter writer = null;
			try {
				writer = new BufferedWriter(new FileWriter("E:\\counterworkspace\\data\\china-map\\" + fileName + ".txt", true));
				writer.write(sb.toString());
				writer.newLine();
				writer.flush();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (writer != null) {
						writer.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		private static Map<Integer, String> getCssLevel() {
			Map<Integer, String> result = new HashMap<Integer, String>();
			result.put(CssLevel.PROVINCE.getLevel(), CssLevel.PROVINCE.getCss());
			result.put(CssLevel.CITY.getLevel(), CssLevel.CITY.getCss());
			result.put(CssLevel.COUNTY.getLevel(), CssLevel.COUNTY.getCss());
			result.put(CssLevel.TOWN.getLevel(), CssLevel.TOWN.getCss());
			result.put(CssLevel.VILLAGE.getLevel(), CssLevel.VILLAGE.getCss());
			return result;
		}
		
	}
	
	private enum CssLevel {
		
		PROVINCE("provincetr", 1, "直辖市|省"),
		CITY("citytr", 2, "市"),
		COUNTY("countytr", 3, "县"),
		TOWN("towntr", 4, "镇"),
		VILLAGE("villagetr", 5, "村");
		
		private String css;
		private int level;
		private String desc;
		
		private CssLevel(String css, int level, String desc) {
			this.css = css;
			this.level = level;
			this.desc = desc;
		}

		/**
		 * @return the css
		 */
		private String getCss() {
			return css;
		}

		/**
		 * @return the level
		 */
		private int getLevel() {
			return level;
		}

		/**
		 * @return the desc
		 */
		private String getDesc() {
			return desc;
		}
		
	}
	
	private class Mapper {
		private int key;
		private String name;
		private String href;
		
		public Mapper(int key, String name, String href) {
			this.key = key;
			this.name = name;
			this.href = href;
		}

		/**
		 * @return the key
		 */
		private int getKey() {
			return key;
		}

		/**
		 * @return the name
		 */
		private String getName() {
			return name;
		}

		/**
		 * @return the href
		 */
		private String getHref() {
			return href;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			JSONObject toString = new JSONObject();
			toString.put("key", key);
			toString.put("name", name);
			toString.put("href", href);
			return toString.toJSONString();
		}
	}
	
}
