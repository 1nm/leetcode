public class WordDictionary {
    TrieNode root;
    
    WordDictionary() {
        root = new TrieNode();
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); ++ i) {
            char c = word.charAt(i);
            if (p.children.containsKey(c)) {
                p = p.children.get(c);
            } else {
                TrieNode node = new TrieNode();
                node.character = c;
                p.children.put(c, node);
                p = node;
            }
        }
        p.isLeaf = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(this.root, word);
    }
    
    private boolean search(TrieNode head, String word) {
        TrieNode p = head;
        int i = 0;
        while (p != null && i < word.length()) {
            char c = word.charAt(i++);
            if (c == '.') {
                for (TrieNode child : p.children.values()) {
                    if (search(child, word.substring(i))) {
                        return true;
                    }
                }
                return false;
            } else {
                p = p.children.get(c);
            }
        }
        
        if (p != null && p.isLeaf && i == word.length()) {
            return true;
        } else {
            return false;
        }
    }
    
    class TrieNode {
        Character character;
        Map<Character, TrieNode> children;
        boolean isLeaf;
        
        TrieNode() {
            this.children = new HashMap<Character, TrieNode>();
            this.isLeaf = false;
        }
        
        
    }
}
// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");