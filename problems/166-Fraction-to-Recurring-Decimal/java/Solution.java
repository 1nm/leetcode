public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        String result = "";
        if (numerator > 0 && denominator < 0 || numerator < 0 && denominator > 0) {
            result += "-";
        }
        long n = Math.abs((long) numerator);
        long d = Math.abs((long) denominator);
        Map<Long, Integer> remainders = new HashMap<Long, Integer>();
        result += String.valueOf(n / d);
        n %= d;
        if (n == 0) {
            return result;
        } else {
            String frac = "";
            while (n != 0 && !remainders.containsKey(n)) {
                remainders.put(n, frac.length());
                n *= 10;
                frac += n / d;
                n %= d;
            }
            if (n == 0) {
                result += "." + frac;
            } else {
                result += "." + frac.substring(0, remainders.get(n)) + "(" + frac.substring(remainders.get(n), frac.length()) + ")";
            }
        }
        return result;
    }
}