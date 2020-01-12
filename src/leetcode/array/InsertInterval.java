package leetcode.array;

// Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
// You may assume that the intervals were initially sorted according to their start times.

// Example 1:
// Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

// Example 2:
// Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

// This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

import java.util.List;

public class InsertInterval {
    public List<Interval> insert(List<Interval> intervalList, Interval newInterval) {
        int i = 0;
        while (i < intervalList.size() && intervalList.get(i).end < newInterval.start) {
            i++;
        }

        while (i < intervalList.size() && intervalList.get(i).start <= newInterval.end) {
            newInterval = new Interval(Math.min(intervalList.get(i).start, newInterval.start),
                    Math.max(intervalList.get(i).end, newInterval.end));
            intervalList.remove(i);
        }
        intervalList.add(i, newInterval);
        return intervalList;
    }

    class Interval {
        int start;
        int end;
        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
