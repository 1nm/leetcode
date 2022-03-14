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
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<Interval>();
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                if (o1.start == o2.start) {
                    return o1.end - o2.end;
                } else {
                    return o1.start - o2.start;
                }
            }
        });
        int i = 0;
        while (i < intervals.size()) {
            Interval curr = new Interval(intervals.get(i).start, intervals.get(i).end);
            i++;
            while (i < intervals.size()) {
                Interval next = intervals.get(i);
                if (curr.end >= next.start) {
                    curr.end = curr.end > next.end ? curr.end : next.end;
                    i ++;
                } else {
                    break;
                }
            }
            result.add(curr);
        }
        return result;
    }
}