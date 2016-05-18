import java.util.*;

public class WordLadder2 {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        // two-way BFS
        Set<String> beginSet = new HashSet<String>();
        Set<String> endSet = new HashSet<String>();
        List<List<String>> ladders = new ArrayList<List<String>>();
        Map<String, String> parents = new HashMap<String, String>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        wordList.remove(beginWord);
        wordList.remove(endWord);
        int length = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            boolean found = false; // true if found the shortest path
            if (beginSet.size() > endSet.size()) { // swap sets
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            Set<String> nextLevel = new HashSet<String>();

            for (String word : beginSet) {
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; ++ i) {
                    char old = word.charAt(i);
                    for (char c = 'a'; c <= 'z'; ++ c) {
                        if (c == old) {
                            continue;
                        }
                        chars[i] = c;
                        String newWord = String.valueOf(chars);
                        if (endSet.contains(newWord)) { // found one path
                            found = true;
                            String parent = word;
                            LinkedList<String> path = new LinkedList<String>();
                            path.addFirst(newWord);
                            path.addFirst(parent);
                            while ((parent = parents.get(parent)) != null) {
                                path.addFirst(parent);
                            }
                            ladders.add(new ArrayList<String>(path));
                        } else if (wordList.contains(newWord)) { // found
                            wordList.remove(newWord);
                            nextLevel.add(newWord);
                            parents.put(newWord, word);
                        }
                    }
                    chars[i] = old;
                }
            }
            if (found) {
                break;
            }
            beginSet = nextLevel;
            length ++;
        }
        return ladders;
    }

    List<String> findPath(String beginWord, String endWord, Map<String, String> parents) {
    }

    public static void main(String[] args) {
        Set<String> wordList = new HashSet<String>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        List<List<String>> ladders = new WordLadder2().findLadders("hot", "dot", wordList);
        for (List<String> ladder : ladders) {
            for (String word : ladder) {
                System.out.print(word + " -> ");
            }
            System.out.println();
        }
    }
}
