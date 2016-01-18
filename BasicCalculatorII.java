public class Solution {
    private static final String patternRegex = "(?<num>\\d+)|(?<op>[+-*/])";

    public int calculate(String s) {
        Stack<Character> operands = new Stack<Character>();
        Stack<Integer> operators = new Stack<Integer>();
        Pattern patterns = Pattern.compile(patternRegex);
        Matcher matcher = patterns.matcher(s);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    private String nextToken() {
        if (matcher.find()) {
            return matcher.group();
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        new Solution().calculate(" 34 - 2*4");
    }
}
