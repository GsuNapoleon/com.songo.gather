/**
 * 
 */
package com.songo.gather.algorithm.loglog;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;

import com.songo.gather.algorithm.loglog.stream.cardinality.CardinalityMergeException;
import com.songo.gather.algorithm.loglog.stream.cardinality.HyperLogLog;
import com.songo.gather.utils.MyWebUtils;

/**
 * <p>decription:</p>
 * <p>date:2015年8月27日 下午5:30:36</p>
 * @author gsu·napoleon
 */
public class TestHyperLogLog {

	/**
	 * <p>decription:</p>
	 * <p>date:2015年8月27日 下午5:30:36</p>
	 * @author gsu·napoleon
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
	}
	
	@Test
    public void testIp() {
    	try {
    		long start = System.currentTimeMillis();
    		String [] files = listTaskFile();
    		List<BufferedReader> inputs = new ArrayList<BufferedReader>();
    		for (String file : files) {
    			inputs.add(new BufferedReader(new FileReader(new File("E:\\counterworkspace\\counter\\auto\\com\\" + file))));
    		}
    		int expMegerNums = inputs.size();
    		int bits = 26;
    		HyperLogLog [] hlls = new HyperLogLog[expMegerNums];
    		BufferedReader br = null;
    		Set<Long> sets = new HashSet<Long>();
    		for (int i = 0; i < hlls.length; i ++) {
    			System.err.println(i);
    			br = inputs.get(i);
    			hlls[i] = new HyperLogLog(bits);	
    			String line;
    			while ((line = br.readLine()) != null) {
    				String ips = line.split("\t")[2];
    				if (StringUtils.isBlank(ips)) {
    					continue;
    				}
    				long ip = MyWebUtils.parseIp(ips.indexOf("/") == -1 ? ips : ips.split("/")[0]);
//    				sets.add(ip);
    				hlls[i].offer(ip);
    			}
    			br.close();
    		}
    		HyperLogLog hyperLogLog = hlls[0];
    		HyperLogLog [] ns = Arrays.asList(hlls).subList(1, hlls.length).toArray(new HyperLogLog[0]);
    		long cardinality = hyperLogLog.merge(ns).cardinality();
    		long end = System.currentTimeMillis();
    		System.err.println("用时:" + (end - start));
			System.err.println("hyperloglog-cardinality=" + cardinality);
			System.err.println("Set size = " + sets.size());
			System.err.println(hyperLogLog.sizeof());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CardinalityMergeException e) {
			e.printStackTrace();
		} 
    }
	
	private String[] sortFileName(String[] files) {
		//对文件进行排序，确保每次都是有序
        TreeSet<String> tree = new TreeSet<String>();
        for (String file : files) {
        	tree.add(file);
        }
        String[] _files = new String[files.length];
        for (int i = 0; i < files.length; i++) {
        	_files[i] = tree.pollFirst();
        }
        return _files;
	}
    
    private String[] listTaskFile() {
		File dir = new File("E:\\counterworkspace\\counter\\auto\\com\\");
		String[] files = dir.list(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				if (name.endsWith("1")) {
					return true;
				}
				return false;
			}
		});
		//对文件进行排序，确保每次都是有序
		return sortFileName(files);
	}
}
