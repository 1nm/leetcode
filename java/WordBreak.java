/*
 * boolean[][] breakable
 * breakable[i][j] = true if wordDict contains s.substring(i, j)
 *                   true if breakable[i][k] is true and wordDict contains s.substring(k, j)
 *                   false if else
 */
public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        int len = s.length();
        boolean[][] breakable = new boolean[len + 1][len + 1];
        for (int i = 0; i < len; ++ i) {
            for (int j = i + 1; j <= len; ++ j) {
                String substr = s.substring(i, j);
                if (wordDict.contains(substr)) {
                    breakable[i][j] = true;
                } else {
                    for (int k = i + 1; k < j; ++ k) {
                        String substr1 = s.substring(k, j);
                        if (breakable[i][k] && wordDict.contains(substr1)) {
                            breakable[i][j] = true;
                            break;
                        }
                    }
                }
            }
        }
        return breakable[0][len];
    }
}
