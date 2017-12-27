package com.algorithmspractice.array;
//Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
// find the minimum number of conference rooms required.
//For example,
//Given [[0, 30],[5, 10],[15, 20]],
//return 2.

import java.util.Arrays;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class MeetingRoomsTwo {
    public static void main(String[] args) {
        Interval i1 = new Interval(0, 30);
        Interval i2 = new Interval(5, 10);
        Interval i3 = new Interval(15, 20);
        System.out.println(minMeetingRooms(new Interval[]{i1, i2, i3}));
    }
    public static int minMeetingRooms(Interval[] intervals) {
        int[] startTimes = new int[intervals.length];
        int[] endTimes = new int[intervals.length];

        for(int i =0; i < intervals.length; i++){
            startTimes[i] = intervals[i].start;
            endTimes[i] = intervals[i].end;
        }

        Arrays.sort(startTimes);
        Arrays.sort(endTimes);
        int j =0, count = 0;
        for(int i =0; i < startTimes.length; i++){
            if(startTimes[i] < endTimes[j]){
                count++;
            }else{
                j++;
            }
        }

        return count;
    }
}
