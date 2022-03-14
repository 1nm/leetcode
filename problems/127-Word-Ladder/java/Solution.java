public class Solution {

    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        // one-way bfs
        wordList.add(endWord);
        Queue<String> queue = new LinkedList<String>();
        Set<String> visited = new HashSet<String>();
        queue.offer(beginWord);
        int length = 1;

        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int k = 0; k < count; ++ k) {
                String word = queue.poll();
                char[] chars = word.toCharArray();
                for (int i = 0; i < word.length(); ++ i) {
                    char old = word.charAt(i);
                    for (char c = 'a'; c <= 'z'; ++ c) {
                        if (old == c) {
                            continue;
                        }
                        chars[i] = c;
                        String newWord = new String(chars);
                        if (!visited.contains(newWord) && wordList.contains(newWord)) {
                            // found a neighbor
                            visited.add(newWord);
                            if (newWord.equals(endWord)) {
                                return length + 1;
                            } else {
                                queue.offer(newWord);
                            }
                        }
                    }
                    chars[i] = old;
                }
            }
            length ++;
        }
        return 0;
    }

    // private List<String> getNeighbors(Set<String> wordList, String word) {
    //     List<String> neighbors = new ArrayList<String>();
    //     StringBuffer sb = new StringBuffer(word);
    //     for (int i = 0; i < word.length(); ++ i) {
    //         for (int j = 0; j < 26; ++ j) {
    //             char c = (char) ('a' + j);
    //             if (word.charAt(i) == c) {
    //                 continue;
    //             }
    //             sb.setCharAt(i, c);
    //             String newWord = sb.toString();
    //             if (wordList.contains(newWord)) {
    //                 neighbors.add(newWord);
    //             }
    //         }
    //         sb.setCharAt(i, word.charAt(i));
    //     }
    //     return neighbors;
    // }

    // public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
    //     // dijkstra
    //     Map<String, Integer> distance = new HashMap<String, Integer>(); // distance from beginWord to key
    //     Set<String> visited = new HashSet<String>();
    //     Set<String> vertices = new HashSet<String>();
    //     vertices.addAll(wordList);
    //     vertices.add(endWord);

    //     distance.put(endWord, isTransformable(beginWord, endWord) ? 1 : Integer.MAX_VALUE);
    //     for (String word : wordList) {
    //         distance.put(word, isTransformable(beginWord, word) ? 1 : Integer.MAX_VALUE);
    //     }

    //     for (int i = 0; i < wordList.length() + 1; ++ i) {
            
    //     }
    //     return distance.get(endWord) + 1;
    // }

    // private boolean isTransformable(String a, String b) {
    //     if (a.length() != b.length()) {
    //         return false;
    //     }
    //     int diff = 0;
    //     for (int i = 0; i < a.length(); ++ i) {
    //         if (a.charAt(i) != b.charAt(i)) {
    //             diff++;
    //             if (diff > 1) {
    //                 break;
    //             }
    //         }
    //     }
    //     return diff == 1;
    // }
}
