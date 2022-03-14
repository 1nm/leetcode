/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if (points.length <= 2) {
            return points.length;
        }
        int max = 2;
        Map<Float, Integer> stats = new HashMap<Float, Integer>();
        for (int i = 0; i < points.length; ++ i) {
            stats.clear();
            int same = 0;
            for (int j = 0; j < points.length; ++ j) {
                if (j == i) {
                    continue;
                }
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    same ++;
                }
                else {
                    Float gradient = points[i].y == points[j].y ? Float.NaN : (points[i].x - points[j].x) / (float) (points[i].y - points[j].y);
                    if (stats.containsKey(gradient)) {
                        stats.put(gradient, stats.get(gradient) + 1);
                    } else {
                        stats.put(gradient, 2);
                    }
                }
            }
            if (stats.isEmpty()) {
                if (max < same + 1) {
                    max = same + 1;
                }
            } else {
            for (int count : stats.values()) {
                if (max < count + same) {
                    max = count + same;
                }
            }
            }
        }
        return max;
    }
}