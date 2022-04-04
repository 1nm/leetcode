class Solution {
  public boolean canReach(String s, int minJump, int maxJump) {
    int len = s.length();
    boolean[] canReach = new boolean[len];
    canReach[0] = true;
    for (int i = 0, j = 0; i < len; i++) {
      if (!canReach[i])
        continue;
      for (j = Math.max(j, i + minJump); j <= Math.min(len - 1, i + maxJump); j++) {
        if (s.charAt(j) == '0') {
          canReach[j] = true;
        }
      }
    }
    return canReach[len - 1];
  }
}
