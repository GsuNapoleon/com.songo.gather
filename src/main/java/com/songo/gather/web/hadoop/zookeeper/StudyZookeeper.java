/**
 * 
 */
package com.songo.gather.web.hadoop.zookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

import com.songo.gather.utils.MySpecialUtils;

/**
 * <p>decription:</p>
 * <p>date:2015年6月3日 下午4:11:59</p>
 * @author gsu·napoleon
 */
public class StudyZookeeper {

	public void study() throws Exception {
		ZooKeeper zookeeper = new ZooKeeper("127.0.0.1:7701", 
				(int) MySpecialUtils.MILLIS_PER_MINUTE.getValue(), 
				new StudyWatcher(), true);
		zookeeper.create("/a", "1".getBytes(), Ids.CREATOR_ALL_ACL, CreateMode.PERSISTENT_SEQUENTIAL);
		zookeeper.getData("/a", true, null);
	}
	
	private class StudyWatcher implements Watcher {

		/* (non-Javadoc)
		 * @see org.apache.zookeeper.Watcher#process(org.apache.zookeeper.WatchedEvent)
		 */
		@Override
		public void process(WatchedEvent event) {
			switch (event.getState()) {
			case SyncConnected:
				
				break;
			case Expired:
				
				break;
			default:
				break;
			}
		}
		
	}
	
}
