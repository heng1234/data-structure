package com.company.SegmentTree;

/**
 * Merger
 *
 * @author heng
 * @date 2019/11/4
 **/
public interface Merger<E> {
    E merge(E a,E b);
}
