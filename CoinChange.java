// d[x + c] = min(d[x + c], d[x] + 1)

public class Solution {
    public int coinChange(int[] coins, int amount) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 0);
        for (int i = 0; i < amount; ++ i) {
            if (map.containsKey(i)) {
                int min = map.get(i);
                for (int j = 0; j < coins.length; ++ j) {
                    if (map.containsKey(i + coins[j])) {
                        map.put(i + coins[j], Math.min(map.get(i + coins[j]), min + 1));
                    } else {
                        map.put(i + coins[j], min + 1);
                    }
                }
            }
        }
        return map.containsKey(amount) ? map.get(amount) : -1;
    }
}
