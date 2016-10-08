public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> path = new ArrayList<String>();
        backtrack(s, 0, path, result);
        return result;
    }
    
    private boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start ++;
            end --;
        }
        return true;
    }
    
    private void backtrack(String s, int pos, List<String> path, List<List<String>> result) {
        if (pos == s.length()) { // new path found
            result.add(new ArrayList<String>(path)); // copy construction
            return;
        }
        for (int i = pos + 1; i <= s.length(); i ++) {
            String prefix = s.substring(pos, i);
            if (!isPalindrome(prefix)) {
                continue;
            }
            path.add(prefix);
            backtrack(s, i, path, result);
            path.remove(path.size() - 1);
        }
    }
}
