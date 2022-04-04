public class Solution {
  public int minPartitions(String n) {
    // The max number of required deci-binary numbers is 9
    // Because the max value of each digit is 9 and we can always have 9 deci-binary numbers of
    // length n
    int min = 0;
    for (int i = 0; i < n.length(); i++) {
      int value = Character.getNumericValue(n.charAt(i));
      if (min < value) {
        min = value;
      }
    }
    return min;
  }
}
