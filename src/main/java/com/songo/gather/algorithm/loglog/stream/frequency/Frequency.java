package com.songo.gather.algorithm.loglog.stream.frequency;

public interface Frequency {

    void add(long item, long count);

    void add(String item, long count);

    long estimateCount(long item);

    long estimateCount(String item);

    long size();
}
