class Solution {
  private boolean equals(String text, int p0, int p1, int q0, int q1) {
    String p = text.substring(p0, p1);
    String q = text.substring(q1, q0);
    // System.out.println(p0 + " " + p1 + " " + q0 + " " + q1 + " " + p + " " + q);
    return p.equals(q);
  }

  public int longestDecomposition(String text) {
    int count = 1;
    int p0 = 0, p1 = 0, q0 = text.length(), q1 = text.length();
    while (p1 <= q1) {
      p1++;
      q1--;
      if (p1 <= q1 && equals(text, p0, p1, q0, q1)) {
        count += 2;
        p0 = p1;
        q0 = q1;
        if (p1 == q1) { // the string can be decomposed into even number of palindromes
          count -= 1;
        }
      }
    }
    return count;
  }
}
