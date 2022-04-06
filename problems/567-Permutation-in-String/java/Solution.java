public class Solution {
  private boolean check(int[] counter1, int[] counter2) {
    for (int i = 0; i < 26; i++) {
      if (counter1[i] != counter2[i])
        return false;
    }
    return true;
  }

  public boolean checkInclusion(String s1, String s2) {
    if (s1.length() > s2.length())
      return false;

    int[] counter1 = new int[26];
    int[] counter2 = new int[26];

    for (int i = 0; i < s1.length(); i++) {
      char c1 = s1.charAt(i);
      char c2 = s2.charAt(i);
      counter1[c1 - 'a']++;
      counter2[c2 - 'a']++;
    }

    if (check(counter1, counter2))
      return true;

    for (int i = s1.length(); i < s2.length(); i++) {
      char charToAdd = s2.charAt(i);
      char charToRemove = s2.charAt(i - s1.length());
      counter2[charToAdd - 'a']++;
      counter2[charToRemove - 'a']--;
      if (check(counter1, counter2))
        return true;
    }
    return false;
  }
}
