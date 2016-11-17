public class Solution {
    public int compareVersion(String version1, String version2) {
        // pay special attention to java string split, which accept regex!
        int[] v1 = parse(version1);
        int[] v2 = parse(version2);
        int result = -1;
        if (v1.length > v2.length) {
            result = 1;
            int[] temp = v1;
            v1 = v2;
            v2 = temp;
        }
        for (int i = 0; i < v2.length; ++ i) {
            if (i < v1.length)
                v2[i] -= v1[i];
        }

        for (int i = 0; i < v2.length; ++ i) {
            if (v2[i] != 0)
                return v2[i] > 0 ? result : -result;
        }
        return 0;
    }

    private int[] parse(String version) {
        String[] s = version.split("\\.");
        int[] parsed = new int[s.length];
        for (int i = 0; i < s.length; ++ i) {
            parsed[i] = Integer.parseInt(s[i]);
        }
        return parsed;
    }
}
