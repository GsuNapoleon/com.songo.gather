/**
 * 
 */
package com.songo.gather.bbs.oschina;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.security.SecureRandom;

/**
 * <p>decription:安全删除文件</p>
 * <p>date:2014年6月17日 下午2:43:55</p>
 * @author gsu·napoleon
 */
public class SecureDeleteFile {

	public void destroyFileContent(String pathname) throws IOException {
		File file = new File(pathname);
		if (file.exists()) {
			SecureRandom secureRandom = new SecureRandom();
			RandomAccessFile raf = new RandomAccessFile(file, "rw");
			FileChannel channel = raf.getChannel();
			MappedByteBuffer buffer = channel.map(MapMode.READ_WRITE, 0, raf.length());
			while (buffer.hasRemaining()) {
				buffer.put((byte) 0);
			}
			buffer.force();
			buffer.rewind();
			while (buffer.hasRemaining()) {
				buffer.put((byte) 0xFF);
			}
			buffer.force();
			buffer.rewind();
			byte[] datas = new byte[1];
			while (buffer.hasRemaining()) {
				secureRandom.nextBytes(datas);
				buffer.put(datas[0]);
			}
			buffer.force();
			raf.close();
		}
	}
	
	public boolean deleteFile(String pathname) {
		File file = new File(pathname);
		return file.delete();
	}
	
}
