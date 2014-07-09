/**
 * 
 */
package com.songo.gather.lang;

import org.apache.commons.lang3.BooleanUtils;

/**
 * <p>decription:</p>
 * <p>date:2014年7月7日 上午11:28:18</p>
 * @author gsu·napoleon
 */
public abstract class EclipseToolsSelf {
	
	public static final class HashCodeBuilder {

        private static final int PRIME = 31;

        private int hashCode = 1;

        public void append(Object value) {
            if ( value != null ) {
                hashCode = hashCode * PRIME + value.hashCode();
            }
        }

        public void append(boolean value) {
        	append(BooleanUtils.toInteger(value));
        }
        
        public void append(byte value) {
            hashCode = hashCode * PRIME + value;
        }

        public void append(short value) {
            hashCode = hashCode * PRIME + value;
        }

        public void append(char value) {
            hashCode = hashCode * PRIME + value;
        }

        public void append(int value) {
            hashCode = hashCode * PRIME + value;
        }

        public void append(long value) {
            hashCode = hashCode * PRIME + (int) (value ^ (value >>> (Long.SIZE >> 1)));
        }

        public void append(float value) {
            append( Float.floatToIntBits(value) );
        }

        public void append(double value) {
            append( Double.doubleToLongBits(value) );
        }

        public int toHashCode() {
            return hashCode;
        }
    }
}
