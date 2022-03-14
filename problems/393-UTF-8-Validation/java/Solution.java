public class Solution {

    public boolean validUtf8(int[] data) {
        if (data.length == 0)
            return true;
        int i = 0;
        while (i < data.length) {
            int length = bits(data[i]);
            if (!isValid(data, i, length))
                return false;
            i += length;
        }
        return true;
    }

    private int bits(int n) {
        n &= 0xFF;
        int mask = 0x80; // 10000000
        int count = 0;
        while (mask > 0 && (n & mask) > 0) {
            count ++;
            mask = mask >> 1;
        }
        return count == 0 ? 1 : count;
    }

    private boolean isValid(int[] data, int i, int length) {
        if (i + length > data.length)
            return false;

        int n = data[i] & 0xFF;

        if (length == 1) {
            return ((n & 0x80) == 0);
        } else {
            for (int j = i + 1; j < i + length; ++ j) {
                if (j >= data.length)
                    return false;
                int m = data[j] & 0xFF;
                if ((m & 0xC0) != 0x80)
                    return false;
            }
            return true;
        }
    }
}