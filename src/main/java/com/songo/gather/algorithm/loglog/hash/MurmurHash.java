package com.songo.gather.algorithm.loglog.hash;

import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with this
 * work for additional information regarding copyright ownership. The ASF
 * licenses this file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

/**
 * This is a very fast, non-cryptographic hash suitable for general hash-based
 * lookup. See http://murmurhash.googlepages.com/ for more details.
 * <p/>
 * <p>
 * The C version of MurmurHash 2.0 found at that site was ported to Java by
 * Andrzej Bialecki (ab at getopt org).
 * </p>
 */
public class MurmurHash {

	private static final HashFunction hashFunction = Hashing.murmur3_128();
    public static int hash(Object o) {
        if (o == null) {
            return 0;
        }
        if (o instanceof Long) {
        	return hashFunction.hashLong((Long) o).asInt();
        }
        if (o instanceof Integer) {
        	return hashFunction.hashInt((Integer) 0).asInt();
        }
        if (o instanceof Double) {
        	return hashFunction.hashLong(Double.doubleToRawLongBits((Double) o)).asInt();
        }
        if (o instanceof Float) {
        	return hashFunction.hashLong(Float.floatToRawIntBits((Float) o)).asInt();
        }
        if (o instanceof String) {
        	return hashFunction.hashBytes(((String) o).getBytes()).asInt();
        }
        if (o instanceof byte[]) {
        	return hashFunction.hashBytes((byte[]) o).asInt();
        }
        return hashFunction.hashString(o.toString(), null).asInt();
    }

    public static int hash(byte[] data) {
        return hash(data, data.length, -1);
    }

    public static int hash(byte[] data, int seed) {
        return hash(data, data.length, seed);
    }

    public static int hash(byte[] data, int length, int seed) {
    	HashFunction hashFunc = Hashing.murmur3_128(seed);
    	return hashFunc.hashBytes(data, 0, length).asInt();
    }

    public static long hash64(Object o) {
        if (o == null) {
            return 0l;
        } else if (o instanceof String) {
            final byte[] bytes = ((String) o).getBytes();
            return hashFunction.hashBytes(bytes, 0, bytes.length).asLong();
        } else if (o instanceof byte[]) {
            final byte[] bytes = (byte[]) o;
            return hashFunction.hashBytes(bytes, 0, bytes.length).asLong();
        }
        return hash64(o.toString());
    }
}