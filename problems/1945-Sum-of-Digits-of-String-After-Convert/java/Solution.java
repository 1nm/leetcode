public class Solution {
  private String transform(String num) {
    int sum = 0;
    for (int i = 0; i < num.length(); i++) {
      sum += Character.getNumericValue(num.charAt(i));
    }
    return String.valueOf(sum);
  }

  public int getLucky(String s, int k) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      sb.append(String.valueOf(s.charAt(i) - 'a' + 1));
    }
    String converted = sb.toString();
    for (int i = 0; i < k; i++) {
      converted = transform(converted);
    }
    return Integer.parseInt(converted);
  }
}
