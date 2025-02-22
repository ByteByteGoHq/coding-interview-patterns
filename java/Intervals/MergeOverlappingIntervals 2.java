import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import DS.Interval;

/*
    // Definition of Interval:
    class Interval {
        public int start;
        public int end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
 */

public class MergeOverlappingIntervals {
    public List<Interval> mergeOverlappingIntervals(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        List<Interval> merged = new ArrayList<>();
        merged.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval B = intervals.get(i);
            Interval A = merged.get(merged.size() - 1);
            // If A and B don't overlap, add B to the merged list.
            if (A.end < B.start) {
                merged.add(B);
            }
            // If they do overlap, merge A with B.
            else {
                A.end =  Math.max(A.end, B.end);
            }
        }
        return merged;
    }   
}
