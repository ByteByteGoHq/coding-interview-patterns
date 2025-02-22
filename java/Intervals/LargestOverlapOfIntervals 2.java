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

public class LargestOverlapOfIntervals {
    public int largestOverlapOfIntervals(List<Interval> intervals) {
        List<int[]> points = new ArrayList<>();
        for (Interval interval : intervals) {
            points.add(new int[]{interval.start, 'S'});
            points.add(new int[]{interval.end, 'E'});
        }
        // Sort in chronological order. If multiple points occur at the same 
        // time, ensure end points are prioritized before start points.
        Collections.sort(points, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
            else return Integer.compare(a[0], b[0]);
        });
        int activeInterval= 0;
        int maxOverlaps = 0;
        for (int[] point : points) {
            int time = point[0];
            int pointType = point[1];
            if (pointType == 'S') {
                activeInterval++;
            } else {
                activeInterval--;
            }
            maxOverlaps = Math.max(maxOverlaps, activeInterval);
        }
        return maxOverlaps;
    }
}
