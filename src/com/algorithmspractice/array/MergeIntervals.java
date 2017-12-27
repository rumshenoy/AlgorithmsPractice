package com.algorithmspractice.array;

//Given a collection of intervals, merge all overlapping intervals.
//
//For example,
//Given [1,3],[2,6],[8,10],[15,18],
//return [1,6],[8,10],[15,18].

import java.util.*;

public class MergeIntervals {
    public static void main(String[] args) {
        Interval i1 = new Interval(9, 10);
        Interval i2 = new Interval(3, 4);
        Interval i3 = new Interval(2, 4);
        Interval i4 = new Interval(1, 2);
        Interval i5 = new Interval(0, 2);
        MergeIntervals mergeIntervals = new MergeIntervals();
        System.out.println(mergeIntervals.merge(new ArrayList<>(Arrays.asList(i1, i2, i3, i4, i5))));
    }

    public class IntervalComparator implements Comparator<Interval>{

        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start < o2.start ? -1: o1.start == o2.start? 0: 1;
        }
    }
    
    public List<Interval> merge(List<Interval> intervals) {
        LinkedList<Interval> merged = new LinkedList<>();
        Collections.sort(intervals, new IntervalComparator());

        for(Interval interval : intervals){
            if(merged.isEmpty() || interval.start > merged.getLast().end){
                merged.add(interval);
            }else{
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
        }
        return merged;
    }
}
