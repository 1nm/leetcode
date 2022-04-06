public class Solution {
  public String reverseWords(String s) {
    char[] chars = s.toCharArray();
    int len = chars.length;
    int i = 0, j = 0;
    while (i < len) {
      // find next white space
      // no leading and trailing whitespaces
      while (j < len && chars[j] != ' ') {
        j++;
      }
      // reverse [i, j]
      int p = i, q = j - 1;
      while (p < q) {
        char temp = chars[p];
        chars[p] = chars[q];
        chars[q] = temp;
        p++;
        q--;
      }
      i = j;
      // there may be multiple spaces between words, skip the whitespaces
      while (j < len && chars[j] == ' ') {
        j++;
      }
      i = j;
    }
    return new String(chars);
  }
}
