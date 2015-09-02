/**
 * 
 */
package com.songo.gather.io.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * <p>decription:</p>
 * <p>date:2015年7月30日 下午2:58:19</p>
 * @author gsu·napoleon
 */
public class CombinerFile {
	
	private static String[] listTaskFile(String work, final String task, final String ends) {
		File dir = new File(work);
		String[] files = dir.list(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				if (name.startsWith(task) && name.endsWith(ends)) {
					return true;
				}
				return false;
			}
		});
		//对文件进行排序，确保每次都是有序
		return FileUtils.sortFileName(files);
	}

	/**
	 * <p>decription:</p>
	 * <p>date:2015年7月30日 下午2:58:19</p>
	 * @author gsu·napoleon
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws Exception {
		String path = "E:\\counterworkspace\\counter\\online\\sql\\";
		String prefix = "20150826";
		String cntType = prefix + ".ip-1";
		String [] files = listTaskFile(path, "20150826", "ip.sql");
		List<BufferedReader> inputs = new ArrayList<BufferedReader>();
		for (String file : files) {
			inputs.add(new BufferedReader(new FileReader(path + file)));
		}
		PrintWriter pw = new PrintWriter(path + cntType + ".total.sql");
		String line;
		boolean isFirst = true;
		int i = 0;
		for (BufferedReader br : inputs) {
			i ++;
			while ((line = br.readLine()) != null) {
				if (i > 1 && (line.startsWith("UPDATE cnt") || line.startsWith("DELETE FROM cnt"))) {
					System.err.println(line);
					isFirst = false;
					continue;
				}
				pw.println(line);
			}
		}
		pw.close();
	}

}
class FileUtils {
	public static String[] sortFileName(String[] files) {
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
	
	/**
	 * 得到某个文件目录下某个时间的全部日志，并对日志按时间进行排序
	 * @param work
	 * @param time
	 * @return
	 */
	public static String[] getFiles(String work, final String time) {
		File dir = new File(work);
        String[] files = dir.list(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                if (name.startsWith(time)){
                	return true;                        
                }
                return false;
            }
        });
        files = sortFileName(files);
        return files;
	}
	
}
