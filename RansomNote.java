public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] ransomCount = count(ransomNote);
        int[] magazineCount = count(magazine);
        for (int i = 0; i < 26; ++ i)
            if (ransomCount[i] > magazineCount[i]) return false;
        return true;
    }
    
    int[] count(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); ++ i)
            count[s.charAt(i) - 'a']++;
        return count;
    }
}