/**
 * 
 */
package com.songo.gather.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.songo.gather.db.entity.Channel;
import com.songo.gather.db.utils.DbUtils;

/**
 * <p>decription:</p>
 * <p>date:2015年9月24日 下午5:45:55</p>
 * @author gsu·napoleon
 */
public class ChannelDao {
private Connection conn;
	
	public ChannelDao(Properties properties) {
		initConnection(properties);
	}
	
	private void initConnection(Properties properties) {
		try {
			Class.forName(properties.getProperty("database.count5.driver"));
			conn = DriverManager.getConnection(properties.getProperty("database.count5.url"), 
					properties.getProperty("database.count5.user"), 
					properties.getProperty("database.count5.password"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Channel getChannel(long id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Channel tree = null;
		try {
			ps = conn.prepareStatement("select id,parent_id,name,rank "
					+ "from cnt_channel where id=" + id 
					+ " and status = 0 order by rank, id");
			rs = ps.executeQuery();
			while (rs.next()) {
				tree = new Channel(rs.getLong(1), rs.getLong(2), rs.getString(3), rs.getInt(4));
			}
			if (tree != null) {
				List<Channel> childrens = getChildrens(id);
				tree.setChildrens(childrens);
				add(childrens);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(ps, rs, conn);
		}
		return tree;
	}
	
	private void add(List<Channel> childrens) {
		if (childrens != null && !childrens.isEmpty()) {
			for (Channel children : childrens) {
				List<Channel> tchildrens = getChildrens(children.getId());
				children.setChildrens(tchildrens);
				add(tchildrens);
			}
		}
	}
	
	public List<Channel> getChildrens(long parentId) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Channel> childrens = new ArrayList<Channel>();
		try {
			ps = conn.prepareStatement("select id,parent_id,name,rank "
					+ "from cnt_channel where parent_id=" + parentId 
					+ " and status = 0 order by rank, id");
			rs = ps.executeQuery();
			while (rs.next()) {
				childrens.add(new Channel(rs.getLong(1), rs.getLong(2), rs.getString(3), rs.getInt(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(ps, rs);
		}
		return childrens;
	}
}
