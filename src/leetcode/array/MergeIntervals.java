package leetcode.array;

// Given a collection of intervals, merge all overlapping intervals.
// For example,
// Given [1,3],[2,6],[8,10],[15,18],
// return [1,6],[8,10],[15,18].

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MergeIntervals {
    public List<Interval> merge(List<Interval> intervalList) {
        List<Interval> ans = new ArrayList<>();
        if (intervalList == null || intervalList.size() == 0) {
            return ans;
        }

        Interval[] intervalArr = intervalList.toArray(new Interval[intervalList.size()]);
        Arrays.sort(intervalArr, (a, b) -> {
            if (a.start == b.start) {
                return a.end - b.end;
            }
            return a.start - b.start;
        });

        for (Interval interval : intervalArr) {
            if (ans.size() == 0 || ans.get(ans.size() - 1).end < interval.start) {
                ans.add(interval);
            } else {
                ans.get(ans.size() - 1).end = Math.max(ans.get(ans.size() - 1).end, interval.end);
            }
        }
        return ans;
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
