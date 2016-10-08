public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> result = new ArrayList<>();
        boolean[] breakable = new boolean[s.length() + 1];
        Arrays.fill(breakable, true);
        backtrack(result, new StringBuilder(), 0, s, wordDict, breakable);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder sb, int pos, String s, Set<String> wordDict, boolean[] breakable) {
        if (pos == s.length()) {
            result.add(sb.toString());
            return;
        }
        if (!breakable[pos]) return;
        for (int i = pos + 1; i <= s.length(); ++ i) {
            String substr = s.substring(pos, i);
            if (wordDict.contains(substr)) {
                int len = sb.length();
                if (len > 0) sb.append(' ');
                sb.append(substr);
                int oldSize = result.size();
                backtrack(result, sb, i, s, wordDict, breakable);
                if (result.size() == oldSize) breakable[i] = false;
                sb.setLength(len);
            }
        }
    }
}
