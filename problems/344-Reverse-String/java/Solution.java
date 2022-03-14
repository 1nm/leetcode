public class Solution {
    public String reverseString(String s) {
        if (s == null || s.length() == 0) return s;
        char[] array = s.toCharArray();
        int i = 0, j = array.length - 1;
        while (i < j) {
            char t = array[i];
            array[i] = array[j];
            array[j] = t;
            i ++;
            j --;
        }
        return new String(array);
    }
}