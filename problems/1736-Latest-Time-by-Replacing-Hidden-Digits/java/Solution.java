public class Solution {
  public String maximumTime(String time) {
    char h1 = time.charAt(0);
    char h2 = time.charAt(1);
    char m1 = time.charAt(3);
    char m2 = time.charAt(4);

    // Set the max for hours
    if (h1 == '?' && h2 == '?') {
      h1 = '2';
      h2 = '3';
    } else if (h1 == '?') {
      if (h2 - '0' <= 3) {
        h1 = '2';
      } else {
        h1 = '1';
      }
    } else if (h2 == '?') {
      if (h1 - '0' <= 1) {
        h2 = '9';
      } else {
        h2 = '3';
      }
    }

    // Set the max for minutes
    if (m1 == '?' && m2 == '?') {
      m1 = '5';
      m2 = '9';
    } else if (m1 == '?') {
      m1 = '5';
    } else if (m2 == '?') {
      m2 = '9';
    }

    return String.format("%c%c:%c%c", h1, h2, m1, m2);
  }
}
