package com.songo.gather.algorithm.loglog.stream.quantile;

public interface QuantileEstimator {

    void offer(long value);

    long getQuantile(double q);
}
