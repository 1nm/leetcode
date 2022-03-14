class TrieNode {
    // Initialize your data structure here.
    TrieNode[] next;
    boolean word;
    public TrieNode() {
        next = new TrieNode[26];
        word = false;
    }
}

public class Trie {
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
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
