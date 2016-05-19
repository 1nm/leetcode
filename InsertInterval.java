/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        Comparator<Interval> comparator = new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                if (i1.start != i2.start)
                    return i1.start - i2.start;
                else
                    return i1.end - i2.end;
            }
        };
        Collections.sort(intervals, comparator);
        Set<Interval> removal = new HashSet<>();
        for (Interval interval : intervals) {
            if (newInterval.start <= interval.start && newInterval.end >= interval.end) // newInterval contains interval
                removal.add(interval);
            else if (interval.start <= newInterval.start && newInterval.start <= interval.end) {
                newInterval.start = Math.min(interval.start, newInterval.start);
                newInterval.end = Math.max(interval.end, newInterval.end);
                removal.add(interval);
            } else if (interval.start <= newInterval.end && newInterval.end <= interval.end) {
                newInterval.start = Math.min(interval.start, newInterval.start);
                newInterval.end = Math.max(interval.end, newInterval.end);
                removal.add(interval);
            }
        }
        if (removal.size() > 0)
            intervals.removeAll(removal);
        intervals.add(newInterval);
        Collections.sort(intervals, comparator);
        return intervals;
    }
}
