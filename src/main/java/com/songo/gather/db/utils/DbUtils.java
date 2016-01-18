/**
 * 
 */
package com.songo.gather.db.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * <p>decription:</p>
 * <p>date:2015年9月24日 下午5:47:29</p>
 * @author gsu·napoleon
 */
public class DbUtils {

	private DbUtils() {}
	
	public static void close(Object... dbRes) {
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
	
	public static void close(Connection conn, Statement stmt) {
        close( stmt );
        close( conn );
    }

    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        close( rs );
        close( conn , stmt );
    }

    public static void close(Connection conn) {
        if ( conn != null ) {
            try {
                conn.close( );
            }
            catch (SQLException e) {
                // ignore
            }
        }
    }

    private static void close(Statement stmt) {
        if ( stmt != null ) {
            try {
                stmt.close( );
            }
            catch (SQLException e) {
                // ignore
            }
        }
    }

    private static void close(ResultSet rs) {
        if ( rs != null ) {
            try {
                rs.close( );
            }
            catch (SQLException e) {
                // ignore
            }
        }
    }

	
}
