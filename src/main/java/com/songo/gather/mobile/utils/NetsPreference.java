/**
 * 
 */
package com.songo.gather.mobile.utils;

/**
 * <p>decription:</p>
 * <p>date:2015年6月8日 上午11:25:15</p>
 * @author gsu·napoleon
 */
public enum NetsPreference {
	
    MOBILE {
    	public boolean isMobile() {
    		return true;
    	}
    },
    IPHONE {
    	public boolean isIphone() {
    		return true;
    	}
    },
    INSTANCE {
    	public Singleton getInstance() {
    		return new Singleton();
    	}
    };
    
    public Singleton getInstance() {
    	return null;
    }
    
    public boolean isMobile() {
    	return false;
    }
    
    public boolean isIphone() {
    	return false;
    }
    
}
