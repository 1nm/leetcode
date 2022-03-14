public class Solution {

    String[] phonetic = new String[] {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};

    String[] phoneticTy = new String[] {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    String[] phoneticTeen = new String[] {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    String[] phoneticSegment = new String[] {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        List<String> result = read(num, 0);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.size(); ++ i) {
            if (i > 0) {
                sb.append(" ");
            }
            sb.append(result.get(i));
        }
        return sb.toString();
    }

    List<String> read(int num, int segment) { // assume num is less than 1000
        List<String> result = new ArrayList<String>();
        List<String> higher = null;
        if (num >= 1000) {
            higher = read(num / 1000, segment + 1);
        }
        if (segment == 0 && num == 0) {
            result.add(phonetic[0]);
            return result;
        }
        int a = (num % 1000) / 100;
        if (a != 0) {
            result.add(phonetic[a]);
            result.add("Hundred");
        }
        int b = num % 100;
        if (b >= 10 && b < 20) {
            result.add(phoneticTeen[b - 10]);
        } else if (b >= 20) {
            result.add(phoneticTy[b / 10]);
            if (b % 10 != 0) {
                result.add(phonetic[b % 10]);
            }
        } else if (b != 0) { // b < 10
            result.add(phonetic[b]);
        }
        if (segment > 0 && result.size() > 0) {
            result.add(phoneticSegment[segment]);
        }
        if (higher != null) {
            higher.addAll(result);
            result = higher;
        }
        return result;
    }
}
