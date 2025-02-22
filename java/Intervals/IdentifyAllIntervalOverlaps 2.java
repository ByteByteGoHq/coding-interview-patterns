import java.util.ArrayList;
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

public class IdentifyAllIntervalOverlaps {
    public List<Interval> identifyAllIntervalOverlaps(List<Interval> intervals1, List<Interval> intervals2) {
        List<Interval> overlaps = new ArrayList<>();
        int i, j;
        i = j = 0;
        while (i < intervals1.size() && j < intervals2.size()) {
            // Set A to the interval that starts first and B to the other 
            // interval.
            Interval A, B;
            if (intervals1.get(i).start <= intervals2.get(j).start) {
                A = intervals1.get(i);
                B = intervals2.get(j);
            } else {
                A = intervals2.get(j);
                B = intervals1.get(i);
            }
            // If there's an overlap, add the overlap.
            if (A.end >= B.start) {
                overlaps.add(new Interval(B.start, Math.min(A.end, B.end)));
            }
            // Advance the pointer associated with the interval that ends 
            // first.
            if (intervals1.get(i).end < intervals2.get(j).end) {
                i++;
            } else {
                j++;
            }
        }
        return overlaps;
    }
}
