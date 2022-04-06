class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        if (s.length() == 0) {
            return 0;
        }
        int map[256];
        int p = 0;
        int q = 1;
        int max = 0;
        memset(map, -1, sizeof(map));
        map[s[0]] = 0;
        while (q < s.length()) {
            if (map[s[q]] == -1) {
                map[s[q]] = q;
                q ++;
            } else {
                if (max < q - p) {
                    max = q - p;
                }
                p = map[s[q]] + 1;
                memset(map, -1, sizeof(map));
                map[s[p]] = p;
                q = p + 1;
            }
        }
        if (max < q - p) {
            max = q - p;
        }
        return max;
    }
};