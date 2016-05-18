public class Solution {
    private static Character[][] map = new Character[][]{ {' ', null, null, null},  // 0
                                                          {null, null, null, null}, // 1
                                                          {'a', 'b', 'c', null}, // 2
                                                          {'d', 'e', 'f', null}, // 3
                                                          {'g', 'h', 'i', null}, // 4
                                                          {'j', 'k', 'l', null}, // 5
                                                          {'m', 'n', 'o', null},// 6
                                                          {'p', 'q', 'r', 's'}, // 7
                                                          {'t', 'u', 'v', null}, // 8
                                                          {'w', 'x', 'y', 'z'}}; // 9
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if (digits.length() > 0) {
            backtracking(digits, 0, result, "");
        }
        return result;
    }

    private void backtracking(String digits, int i, List<String> result, String curr) {
        if (i != curr.length()) {
            return;
        }
        if (i == digits.length()) {
            result.add(curr);
            return;
        }
        for (; i < digits.length(); ++ i) {
            int d = digits.charAt(i) - '0';
            for (int j = 0; j < 4; ++ j) {
                if (map[d][j] != null) {
                    backtracking(digits, i + 1, result, curr + map[d][j]);
                }
            }
        }
    }
}
