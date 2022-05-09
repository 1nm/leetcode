class Solution {
  public int compress(char[] chars) {
      int i = 0; // scan index 
      int j = 0; // current position for inline update
      while (i < chars.length) {
          int count = 1;
          char curr = chars[i];
          i += 1;
          // count the repeated characters
          while (i < chars.length && chars[i] == curr) {
              i += 1;
              count += 1;
          }
          chars[j] = curr;
          j += 1;
          // if repeat count is greater than 1, do the compression
          if (count > 1) {
              String countStr = String.valueOf(count);
              for (int k = 0; k < countStr.length(); k ++) {
                  chars[j + k] = countStr.charAt(k);
              }
              j += countStr.length();
          }
      }
      return j;
  }
}