public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 0)
            return "";
        if (numRows == 1)
            return s;
        StringBuilder[] sb = new StringBuilder[numRows];
        int row = 0, dir = 1;
        for (int i = 0; i < s.length(); ++ i) {
            if (sb[row] == null)
                sb[row] = new StringBuilder();
            sb[row].append(s.charAt(i));
            row += dir;
            if (row < 0) {
                row = 1;
                dir = 1;
            } else if (row == numRows) {
                row = numRows - 2;
                dir = -1;
            }
        }
        StringBuilder all  = new StringBuilder();
        for (int i = 0; i < sb.length; ++ i) {
            if (sb[i] != null)
                all.append(sb[i]);
        }
        return all.toString();
    }
}