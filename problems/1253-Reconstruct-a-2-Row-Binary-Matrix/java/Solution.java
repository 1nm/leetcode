public class Solution {
  public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
      List<Integer> upperList = new ArrayList<>();
      List<Integer> lowerList = new ArrayList<>();
      int i = 0;
      while (i < colsum.length) {
          if (colsum[i] == 0) {
              upperList.add(0);
              lowerList.add(0);
          } else if (colsum[i] == 1) {
              if (upper == 0 && lower == 0) return new ArrayList<>();
              if (upper < lower) {
                  lower --;
                  lowerList.add(1);
                  upperList.add(0);
              } else {
                  upper --;
                  upperList.add(1);
                  lowerList.add(0);
              }
          } else { // colsum[i] == 2
              if (upper == 0 || lower == 0) return new ArrayList<>();
              upper --;
              lower --;
              upperList.add(1);
              lowerList.add(1);
          }
          i ++;
      }
      if (upper == 0 && lower == 0)
          return Arrays.asList(upperList, lowerList);
      else
          return new ArrayList<>();
  }
}