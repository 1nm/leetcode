public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        Set<List<Integer>> result = new HashSet<>();
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; ++ i) {
            addWord(root, words[i], i);
        }
        for (int i = 0; i < words.length; ++ i) {
            for (int j = words[i].length(); j >= 0; -- j) {
                String lsubstr = new StringBuilder(words[i].substring(0, j)).reverse().toString();
                String rsubstr = new StringBuilder(words[i].substring(j)).reverse().toString();
                int lindex = findWord(root, lsubstr);
                int rindex = findWord(root, rsubstr);
                if (lindex != -1 && lindex != i && isPalindrome(words[i], j, words[i].length() - 1))
                    result.add(Arrays.asList(i, lindex));
                if (rindex != -1 && rindex != i && isPalindrome(words[i], 0, j - 1))
                    result.add(Arrays.asList(rindex, i));
            }
        }
        return new ArrayList<List<Integer>>(result);
    }
    
    private boolean isPalindrome(String word, int i, int j) {
        while (i < j) {
            if (word.charAt(i++) != word.charAt(j--)) return false;
        }
        return true;
    }
    
    private void addWord(TrieNode node, String word, int index) {
        for (int i = 0; i < word.length(); ++ i) {
            char c = word.charAt(i);
            if (node.next[c - 'a'] == null) {
                node.next[c - 'a'] = new TrieNode();
            }
            node = node.next[c - 'a'];
        }
        node.index = index;
    }
    
    private int findWord(TrieNode node, String word) {
        for (int i = 0; i < word.length(); ++ i) {
            char c = word.charAt(i);
            if (node.next[c - 'a'] == null) return -1;
            node = node.next[c - 'a'];
        }
        return node.index;
    }
    
    class TrieNode {
        int index;
        TrieNode[] next;
        public TrieNode() {
            index = -1;
            next = new TrieNode[26];
        }
    }
}