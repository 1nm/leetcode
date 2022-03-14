public class Solution {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        reverse(chars, 0, chars.length - 1);
        int start = 0, end = 0;
        while (end < chars.length) {
            while (end < chars.length && chars[end] != ' ') {
                end ++;
            }
            reverse(chars, start, end - 1);
            while (end < chars.length && chars[end] == ' ') {
                end ++;
            }
            start = end;
        }
        return removeSpaces(chars);
    }
    
    void reverse(char[] array, int start, int end) {
        while (start < end) {
            char temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
    
    String removeSpaces(char[] array) {
        int pos = 0;
        boolean skip = true;
        for (int i = 0; i < array.length; ++ i) {
            if (array[i] == ' ') {
                if (skip) {
                    continue;
                } else {
                    array[pos++] = ' ';
                    skip = true;
                }
            } else {
                array[pos++] = array[i];
                skip = false;
            }
        }
        while (pos > 0 && array[pos - 1] == ' ') {
            pos --;
        }
        return new String(array, 0, pos);
    }
}