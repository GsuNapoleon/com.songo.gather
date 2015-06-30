/**
 * 
 */
package com.songo.gather.io.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * <p>decription:</p>
 * <p>date:2014年6月18日 下午3:31:15</p>
 * @author gsu·napoleon
 */
public class MyFileOutInputStream {
	
	public void output(String pathname) {
		File file = new File(pathname);
		OutputStream os = null;
		try {
			os = new FileOutputStream(file);
			String src = "123456789";
			byte [] bufferBytes = src.getBytes();
			os.write(bufferBytes);
			os.flush();
			System.out.println(new String(bufferBytes));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (os != null) {
					os.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void input(String pathname) {
		InputStream is = null;
		try {
			File file = new File(pathname);
			is = new FileInputStream(file);
			byte[] bufferBytes = new byte[1024];
			is.read(bufferBytes);
			is.available();
			System.out.println(new String(bufferBytes));
		} catch (Exception e) {
			
		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void writeChannel(String pathname) {
		File file = new File(pathname);
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(file, "rw");
			FileChannel channel = raf.getChannel();
			String src = "123456789987654321";
			ByteBuffer srcBuffer = ByteBuffer.allocate(src.length());
			byte [] bufferBytes = src.getBytes();
			srcBuffer.put(bufferBytes);
			srcBuffer.flip();
			channel.write(srcBuffer);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (raf != null) {
					raf.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
