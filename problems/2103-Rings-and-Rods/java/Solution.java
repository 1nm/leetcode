class Solution {
  public int countPoints(String rings) {
      int i = 0;
      int[] rods = new int[10];
      while (i < rings.length()) {
          char c = rings.charAt(i);
          int label = rings.charAt(i + 1) - '0';
          int mask = 0x0;
          if (c == 'R') {
              mask = 0x001;
          } else if (c == 'G') {
              mask = 0x010;
          } else if (c == 'B') {
              mask = 0x100;
          }
          rods[label] |= mask;
          i += 2;
      }
      int count = 0;
      for (int j = 0; j < 10; j ++) {
          if (rods[j] == 0x111) {
              count ++;
          }
      }
      return count;
  }
}