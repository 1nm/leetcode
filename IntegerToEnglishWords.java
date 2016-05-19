public class Solution {

    String[] phonetic = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};

    String[] phoneticTy = new String[] {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    String[] phoneticTeen = new String[] {"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    String[] phoneticSegment = new String[] {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        return read(num, 0);
    }

    String read(int num, int segment) { // assume num is less than 1000
        StringBuilder sb = new StringBuilder();
        if (num >= 1000) {
            sb.append(read(num / 1000, segment + 1));
        }
        int a = num / 100;
        if (a != 0) {
            sb.append(phonetic[a]).append("Hundred");
        }
        int b = num % 100;
        if (b > 10 && b < 20) {
            sb.append(phoneticTeen[b - 11]);
        } else {
            sb.append(phoneticTy[b / 10]).append(phonetic[b % 10]);
        }
        if (sb.length() > 0) {
            sb.append(phoneticSegment[segment]);
        }
        return sb.toString();
    }
}
