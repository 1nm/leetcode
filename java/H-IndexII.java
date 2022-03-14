public class Solution {
    public int hIndex(int[] citations) {
        if (citations.length == 0) {
            return 0;
        }
        int start = 0, end = citations.length - 1;
        while (start < end) {
            int mid = start + ((end - start) >> 1);
            if (citations[mid] >= citations.length - mid) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return citations[start] >= citations.length - start ? citations.length - start : 0;
    }
}
