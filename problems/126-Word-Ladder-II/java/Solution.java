public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        // two-way BFS
        Set<String> beginSet = new HashSet<String>();
        Set<String> endSet = new HashSet<String>();
        List<List<String>> ladders = new ArrayList<List<String>>();
        Map<String, List<String>> parents = new HashMap<String, List<String>>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        wordList.remove(beginWord);
        wordList.remove(endWord);
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
                            findPath(beginWord, newWord, word, parents, ladders);
                        } else if (nextLevel.contains(newWord)) {
                            parents.get(newWord).add(word);
                        } else if (wordList.contains(newWord)) { // found
                            wordList.remove(newWord);
                            nextLevel.add(newWord);
                            List<String> words = parents.get(newWord);
                            if (words == null) {
                                words = new ArrayList<String>();
                            }
                            words.add(word);
                            parents.put(newWord, words);
                        }
                    }
                    chars[i] = old;
                }
            }
            if (found) {
                break;
            }
            beginSet = nextLevel;
        }
        return ladders;
    }

    private void build(List<List<String>> path, List<String> curr, String word, Map<String, List<String>> parents) {
        if (word == null) {
            return;
        }
        curr.add(word);
        List<String> list = parents.get(word);
        if (list != null) {
            for (int i = 0; i < list.size(); ++ i) {
                build(path, new ArrayList<String>(curr), list.get(i), parents);
            }
        } else {
            path.add(curr);
        }
    }

    private void findPath(String beginWord, String word1, String word2, Map<String, List<String>> parents, List<List<String>> path) {
        List<List<String>> path1 = new ArrayList<List<String>>();
        List<List<String>> path2 = new ArrayList<List<String>>();

        build(path1, new ArrayList<String>(), word1, parents);
        build(path2, new ArrayList<String>(), word2, parents);

        for (int i = 0; i < path1.size(); ++ i) {
            List<String> p1 = path1.get(i);
            Collections.reverse(p1);
            for (int j = 0; j < path2.size(); ++ j) {
                List<String> p2 = path2.get(j);
                List<String> fullpath = new ArrayList<String>();
                fullpath.addAll(p1);
                fullpath.addAll(p2);
                if (!fullpath.get(0).equals(beginWord)) {
                    Collections.reverse(fullpath);
                }
                path.add(fullpath);
            }
        }
    }

}
