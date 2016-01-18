public class 4Sum {
    public static void main(String[] args) {
        new 4Sum().fourSum(new int[] {1 0 -1 0 -2 2}, 0);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<Pair> pairset = new HashSet<Pair>();
        for (int i = 0; i < nums.length; ++ i) {
            for (int j = i + 1; j < nums.length; ++ j) {
                pairset.put(new Pair(nums[i], nums[j]));
            }
        }
        List<Pair> pairs = new ArrayList<Pair>();
        pairs.addAll(pairset);
        Collections.sort(pairs);
        for (int i = 0; i < pairs.size(); ++ i) {
            Pair pair = pairs.get(i);
            System.out.println("("+ pair.a + "," + pair.b + ")");
        }
    }

    private Pair search(List<Pairs> pairs, int start, int end, Pair target) {
        while (start <= end) {
            int mid = (start + end) / 2;
            int compare = pairs.get(mid).compareTo(target);
            if (compare == 0) {
                return pairs.get(mid);
            } else if (compare < 0) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return null;
    }

    private static class Pair implements Comparable<Pair> {
        int a, b;
        Pair(int x, int y) {
            if (x < y) {
                a = x;
                b = y;
            } else {
                a = y;
                b = x;
            }
        }

        @Override
        int compareTo(Pair o) {
            if (a + b == o.a + o.b) {
                if (a == o.a) {
                    return 0;
                } else {
                    return a - o.a;
                }
            } else {
                return a + b - o.a - o.b;
            }
        }
    }
}
