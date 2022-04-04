package java;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
  public int minStoneSum(int[] piles, int k) {
    PriorityQueue<Integer> q = new PriorityQueue<>(10, Collections.reverseOrder());
    int sum = 0;
    for (int numStones : piles) {
      sum += numStones;
      q.add(numStones);
    }
    for (int i = 0; i < k; i++) {
      int max = q.poll();
      int removal = max / 2;
      sum -= removal;
      q.add(max - removal);
    }
    return sum;
  }
}
