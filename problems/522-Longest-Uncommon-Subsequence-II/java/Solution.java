public class Solution {
  private boolean isSubsequence(String a, String b) {
    if (a.length() > b.length())
      return false;
    int i = 0, j = 0;
    while (i < a.length() && j < b.length()) {
      if (a.charAt(i) == b.charAt(j)) {
        i++;
        j++;
      } else {
        j++;
      }
    }
    return i == a.length();
  }

  public int findLUSlength(String[] strs) {
    int longest = -1;
    for (int i = 0; i < strs.length; i++) {
      boolean found = true;
      for (int j = 0; j < strs.length; j++) {
        if (j == i)
          continue;
        if (isSubsequence(strs[i], strs[j])) {
          found = false;
          break;
        }
      }
      if (found && longest < strs[i].length()) {
        longest = strs[i].length();
      }
    }
    return longest;
  }
}
