public class Solution {
  public boolean detectCapitalUse(String word) {
    int len = word.length();
    if (len == 0 || len == 1)
      return true;
    boolean isCapitalized = Character.isUpperCase(word.charAt(0));
    boolean isSecondCharacterUpperCase = Character.isUpperCase(word.charAt(1));
    if (!isCapitalized && isSecondCharacterUpperCase)
      return false; // e.g. aA
    for (int i = 2; i < len; i++) {
      // We have ruled out the words starting with a lowercase char followed by an uppercase char
      // Now we have aa or AA or Aa, and following cases must be same with the second one
      if (isSecondCharacterUpperCase != Character.isUpperCase(word.charAt(i))) {
        return false;
      }
    }
    return true;
  }
}
