public class Solution {
  public boolean canFormArray(int[] arr, int[][] pieces) {
    Map<Integer, Integer> indices = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      indices.put(arr[i], i);
    }
    for (int[] piece : pieces) {
      if (!indices.containsKey(piece[0]))
        return false;
      int prevIndex = indices.remove(piece[0]);
      for (int i = 1; i < piece.length; i++) {
        if (!indices.containsKey(piece[i]) || indices.get(piece[i]) != prevIndex + 1)
          return false;
        indices.remove(piece[i]);
        prevIndex++;
      }
    }
    return indices.isEmpty();
  }
}
