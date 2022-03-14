public class Solution {
    Trie trie;
    int[] di = {-1, 0, 1, 0};
    int[] dj = {0, 1, 0, -1};
    Set<String> result = new HashSet<>();
    public List<String> findWords(char[][] board, String[] words) {
        trie = new Trie();
        for (String word: words) {
            trie.insert(word);
        }
        for (int i = 0; i < board.length; ++ i)
            for (int j = 0; j < board[0].length; ++ j)
                if (trie.startsWith(String.valueOf(board[i][j])))
                    dfs(board, new StringBuilder(), i, j);
        return new ArrayList<String>(result);
    }

    private void dfs(char[][] board, StringBuilder word, int i, int j) {
        char c = board[i][j];
        board[i][j] = '.'; // visited
        word.append(c);
        if (!trie.startsWith(word.toString())) {
            word.setLength(word.length() - 1);
            board[i][j] = c;
            return;
        }
        if (trie.search(word.toString()))
            result.add(word.toString());
        for (int dir = 0; dir < 4; ++ dir) {
            int newi = i + di[dir];
            int newj = j + dj[dir];
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length && board[newi][newj] != '.')
                dfs(board, word, newi, newj);
        }
        word.setLength(word.length() - 1);
        board[i][j] = c;
    }

    class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); ++ i) {
                char c = word.charAt(i);
                if (node.next[c - 'a'] == null)
                    node.next[c - 'a'] = new TrieNode();
                node = node.next[c - 'a'];
            }
            node.word = true;
        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
            return search(word, false);
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            return search(prefix, true);
        }

        private boolean search(String word, boolean prefix) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); ++ i) {
                char c = word.charAt(i);
                if (node.next[c - 'a'] == null)
                    return false;
                node = node.next[c - 'a'];
            }
            return prefix || node.word;
        }

        class TrieNode {
            // Initialize your data structure here.
            TrieNode[] next;
            boolean word;
            public TrieNode() {
                next = new TrieNode[26];
                word = false;
            }
            @Override
            public String toString() {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 26; ++ i)
                    if (next[i] != null)
                        sb.append((char) ('a' + i));
                    else
                        sb.append('.');
                return sb.toString();
            }
        }

    }
}
