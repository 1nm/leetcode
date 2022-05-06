class Solution {
  private int[] count(String word) {
    int[] res = new int[26];
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (Character.isLetter(c)) {
        res[Character.toLowerCase(c) - 'a']++;
      }
    }
    return res;
  }

  public String shortestCompletingWord(String licensePlate, String[] words) {
    String res = null;
    int[] letterCountLicensePlate = count(licensePlate);
    for (String word : words) {
      int[] letterCountWord = count(word);
      boolean completing = true;
      for (int i = 0; i < 26; i++) {
        if (letterCountWord[i] < letterCountLicensePlate[i]) {
          completing = false;
          break;
        }
      }
      if (completing) {
        if (res == null || res.length() > word.length()) {
          res = word;
        }
      }
    }
    return res;
  }
}
