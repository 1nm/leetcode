public class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) return s;
        char[] array = s.toCharArray();
        int i = 0, j = array.length - 1;
        while (i < j) {
            while (i < j && !isVowel(array[i])) i++;
            while (i < j && !isVowel(array[j])) j--;
            char t = array[i];
            array[i] = array[j];
            array[j] = t;
            i ++;
            j --;
        }
        return new String(array);
    }
    
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}