class Solution {
public:
    int reverse(int x) {
        int result = 0;
        while (x != 0) {
            if (result > 214748364 || result < -214748364) {
                return 0;
            } else {
                result = result * 10 + x % 10;
            }
            x /= 10;
        }
        return result;
    }
};