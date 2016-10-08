public class Solution {
    public int maxProduct(String[] words) {
        qsort(words, 0, words.length - 1);
        int[] bits = new int[words.length];
        for (int i = 0; i < words.length; ++ i) {
            for (int j = 0; j < words[i].length(); ++ j) {
                char c = words[i].charAt(j);
                bits[i] |= ( 1 << (c - 'a'));
            }
        }
        int max = 0;
        for (int i = 0; i < bits.length; ++ i) {
            for (int j = i + 1; j < bits.length; ++ j) {
                if ((bits[i] & bits[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }


    private void swap (String[] words, int i, int j) {
        String temp = words[i];
        words[i] = words[j];
        words[j] = temp;
    }

    private void qsort(String[] words, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = words[end].length();
        int s = start;
        for (int i = start; i < end; ++ i) {
            if (words[i].length() > pivot) {
                swap(words, s++, i);
            }
        }
        swap(words, s, end);
        qsort(words, start, s - 1);
        qsort(words, s + 1, end);
    }
}
