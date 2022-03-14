import java.util.*;

public class Pasmo233 {
    public int coinChange(int[] coins, int amount) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Map<Integer, List<Integer>> combination = new HashMap<Integer, List<Integer>>();
        map.put(0, 0);
        combination.put(0, new ArrayList<Integer>());
        List<Integer> c = null;
        for (int i = 0; i < amount; ++ i) {
            if (map.containsKey(i)) {
                int min = map.get(i);
                for (int j = 0; j < coins.length; ++ j) {
                    if (map.containsKey(i + coins[j])) {
                        map.put(i + coins[j], Math.min(map.get(i + coins[j]), min + 1));
                        if (map.get(i + coins[j]) < min + 1) {
                            c = new ArrayList<Integer>(combination.get(i + coins[j]));
                        } else {
                            c = new ArrayList<Integer>(combination.get(i));
                            c.add(coins[j]);
                        }
                        combination.put(i + coins[j], c);
                    } else {
                        map.put(i + coins[j], min + 1);
                        c = combination.get(i);
                        c.add(coins[j]);
                        combination.put(i + coins[j], c);
                    }
                }
            }
        }
        if (map.containsKey(amount)) {
            c = combination.get(amount);
            for (int val : c) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
        return map.containsKey(amount) ? map.get(amount) : -1;
    }

    public static void main(String[] args) {
        Pasmo233 p = new Pasmo233();
        int[] coins = new int[] {165, 195, 237, 278, 308};
        int amount = 767;
        int ways = 0;
        while ((ways = p.coinChange(coins, amount)) < 0) {
            amount += 1000;
        }
        System.out.println(amount);
        System.out.println(ways);

    }
}
