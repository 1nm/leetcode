public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> segments = new ArrayList<>();
        List<int[]> skyline = new ArrayList<>();
        Queue<Integer> q = new PriorityQueue<>((a, b) -> (b - a));
        for (int[] b : buildings) {
            segments.add(new int[] {b[0], -b[2]}); // use minus height for left point
            segments.add(new int[] {b[1], b[2]});
        }
        Collections.sort(segments, (a, b) -> (a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]));
        q.add(0);
        int prev = 0;
        for (int[] segment : segments) {
            if (segment[1] < 0) {
                q.add(-segment[1]);
            } else {
                q.remove(segment[1]);
            }
            int curr = q.peek();
            if (prev != curr) {
                skyline.add(new int[] {segment[0], curr});
                prev = curr;
            }
        }
        return skyline;
    }
}