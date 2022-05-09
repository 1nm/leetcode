class Solution {
  public boolean backspaceCompare(String s, String t) {
    // scan from right to left, if we met #, skip the next letter
    int i = s.length() - 1, j = t.length() - 1;
    int sBackspaceCount = 0, tBackspaceCount = 0;
    while (i >= 0 && j >= 0) {
      while (i >= 0 && (s.charAt(i) == '#' || sBackspaceCount > 0)) {
        if (s.charAt(i) == '#') {
          sBackspaceCount++;
        } else {
          sBackspaceCount--;
        }
        i--;
      }
      while (j >= 0 && (t.charAt(j) == '#' || tBackspaceCount > 0)) {
        if (t.charAt(j) == '#') {
          tBackspaceCount++;
        } else {
          tBackspaceCount--;
        }
        j--;
      }
      if (i >= 0 && j >= 0) {
        if (s.charAt(i) == t.charAt(j)) {
          i--;
          j--;
        } else {
          return false;
        }
      }
    }
    while (i >= 0 && (s.charAt(i) == '#' || sBackspaceCount > 0)) {
      if (s.charAt(i) == '#') {
        sBackspaceCount++;
      } else {
        sBackspaceCount--;
      }
      i--;
    }
    while (j >= 0 && (t.charAt(j) == '#' || tBackspaceCount > 0)) {
      if (t.charAt(j) == '#') {
        tBackspaceCount++;
      } else {
        tBackspaceCount--;
      }
      j--;
    }
    return i == -1 && j == -1;
  }
}
