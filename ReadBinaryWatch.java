public class Solution {
    public List<String> readBinaryWatch(int num) {
        Set<String> ret = new HashSet<>();
        backtrack(ret, 0, 0, num);
        return new ArrayList<String>(ret);
    }

    private int countDigits(int n) {
        int count = 0;
        for (int i = 0; i < 10; ++ i)
            if ((n & (1 << i)) != 0) count++;
        return count;
    }

    private void backtrack(Set<String> ret, int time, int pos, int num) {
        int min = 0x3F & time;
        int hour = (time >> 6) & 0x0F;
        if (countDigits(time) == num && min >= 0 && min < 60 && hour >= 0 && hour < 12)
            ret.add(String.format("%d:%02d", hour, min));
        if (pos == 10) return;
        backtrack(ret, time, pos + 1, num);
        backtrack(ret, time | (1 << pos), pos + 1, num);
    }
}
