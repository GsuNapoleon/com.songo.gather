/**
 * 
 */
package com.songo.gather.web.authentication;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * <p>decription:</p>
 * <p>date:2015年5月20日 下午4:28:39</p>
 * @author gsu·napoleon
 */
public class UserParser {
	public static String encode(UserInfo user) {
        if (user == null) return "NULL";

        StringBuffer buf = new StringBuffer();
        buf.append("user").append('\n');
        buf.append("    id=").append(user.getId()).append('\n');
        buf.append("    account=").append(user.getAccount()).append('\n');
        buf.append("    name=").append(user.getName()).append('\n');
        buf.append("    department=").append(user.getDepartment()).append('\n');
        buf.append("    parttime=").append(user.getParttime()).append('\n');
        buf.append("    isSafe=").append(user.isSafe());

        return buf.toString();
    }


    public static UserInfo decode(String text) {
        StringTokenizer st = new StringTokenizer(text, "\n", false);
        String token = null;
        UserInfo user = null;
        while (st.hasMoreTokens()) {
            token = st.nextToken();
            if (token.startsWith("user")) {
                // 只处理第一个用户
                if (user != null) {
                    break;
                }
                user = new UserInfo();
            } else if (token.startsWith("    id=")) {
                user.setId(Long.parseLong(token.substring(token.indexOf('=') + 1)));
            } else if (token.startsWith("    account=")) {
                user.setAccount(token.substring(token.indexOf('=') + 1));
            } else if (token.startsWith("    name=")) {
                user.setName(token.substring(token.indexOf('=') + 1));
            } else if (token.startsWith("    department=")) {
                user.setDepartment(token.substring(token.indexOf('=') + 1));
            } else if (token.startsWith("    parttime=")) {
                user.setParttime(Boolean.valueOf(token.substring(token.indexOf('=') + 1)).booleanValue());
            } else if (token.startsWith("    isSafe=")) {
            	user.setSafe(Boolean.valueOf(token.substring(token.indexOf('=') + 1)).booleanValue());
            }
        }
        return user;
    }

    public static List<UserInfo> decodeList(String text) {
        List<UserInfo> result = new ArrayList<UserInfo>();
        StringTokenizer st = new StringTokenizer(text, "\n", false);
        String token = null;
        UserInfo user = null;
        while (st.hasMoreTokens()) {
            token = st.nextToken();
            if (token.startsWith("user")) {
                // 只处理第一个用户
                if (user != null) {
                    result.add(user);
                }
                user = new UserInfo();
            } else if (token.startsWith("    id=")) {
                user.setId(Long.parseLong(token.substring(token.indexOf('=') + 1)));
            } else if (token.startsWith("    account=")) {
                user.setAccount(token.substring(token.indexOf('=') + 1));
            } else if (token.startsWith("    name=")) {
                user.setName(token.substring(token.indexOf('=') + 1));
            } else if (token.startsWith("    department=")) {
                user.setDepartment(token.substring(token.indexOf('=') + 1));
            } else if (token.startsWith("    parttime=")) {
                user.setParttime(Boolean.valueOf(token.substring(token.indexOf('=') + 1)).booleanValue());
            } else if (token.startsWith("    isSafe=")) {
            	user.setSafe(Boolean.valueOf(token.substring(token.indexOf('=') + 1)).booleanValue());
            }
        }

        if (result.size() == 0 && user != null) {
            result.add(user);
        } else if (user != null) {
            if (user != result.get(result.size() - 1)) {
                result.add(user);
            }
        }

        return result;
    }
}
