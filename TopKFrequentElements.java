public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Freq> m = new HashMap<>();
        Queue<Freq> q = new PriorityQueue<>(new Comparator<Freq>() {
            public int compare(Freq o1, Freq o2) {
                return o2.freq - o1.freq;
            }
            });
        for (int i = 0; i < nums.length; ++ i) {
            Freq f;
            if (!m.keySet().contains(nums[i])) {
                f = new Freq(nums[i], 1);
                m.put(nums[i], f);
                q.add(f);
            } else {
                f = m.get(nums[i]);
                q.remove(f);
                f.freq ++;
                q.add(f);
            }
        }
        List<Integer> result = new ArrayList<>();
        while (k > 0) {
            result.add(q.poll().num);
            k --;
        }
        return result;
    }
    
    class Freq {
        int num;
        int freq;
        public Freq(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }
    }
}