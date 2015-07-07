/**
 * 
 */
package com.songo.gather.utils;

/**
 * // %[argument_index$][flags][width][.precision][t]conversion
    private static final String formatSpecifier
        = "%(\\d+\\$)?([-#+ 0,(\\<]*)?(\\d+)?(\\.\\d+)?([tT])?([a-zA-Z%])"
 * <p>decription:</p>
 * <p>date:2015年6月3日 下午2:59:39</p>
 * @author gsu·napoleon
 */
public enum MySpecialUtils {
	
	NESTED("点号", "."), MAPPED_START("右括号", "("), MAPPED_END("左括号", ")"),
	INDEXED_START("", "["), INDEXED_END("", "]"), 
	AMPERSAND("", "&"), APOSTROPHE("", "'"), COLON("", ":"),
	COMMA("", ","), DASH("", "_"),
	MILLIS_PER_SECOND("", 1000L),
	MILLIS_PER_MINUTE("", 60 * 1000L),
	MILLIS_PER_HOUR("", 60 * 60 * 1000L),
	MILLIS_PER_DAY("", 24 * 60 * 60 * 1000L),
	PERMS_READ("", 1 << 0),
	PERMS_WRITE("", 1 << 1),
	PERMS_CREATE("", 1 << 2),
	PERMS_DELETE("", 1 << 3),
	PERMS_ADMIN("", 1 << 4),
	PERMS_ALL("", (int)PERMS_READ.getValue() | (int)PERMS_WRITE.getValue() 
			| (int)PERMS_CREATE.getValue() | (int)PERMS_DELETE.getValue() 
			| (int)PERMS_ADMIN.getValue()),
	STRING_FORMAT_SPECIFIER("String.format的正则表达式", "%(\\d+\\$)?([-#+ 0,(\\<]*)?(\\d+)?(\\.\\d+)?([tT])?([a-zA-Z%])");

	private String name;
	private Object value;
	
	private MySpecialUtils(String name, Object value) {
		this.name = name;
		this.value = value;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @return the value
	 */
	public Object getValue() {
		return this.value;
	}
	
}
