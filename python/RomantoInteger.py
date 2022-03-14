class Solution:
    # @return an integer
    def romanToInt(self, s):
        r = {"I": 1, "V": 5, "X": 10, "L": 50, "C": 100, "D": 500, "M": 1000}
        result = r[s[0]]
        length = len(s)
        i = 1
        while i < length:
            curr = r[s[i]]
            pre = r[s[i - 1]]
            if curr <= pre:
                result = result + curr
            else:
                result = result - pre - pre + curr
            i += 1
        return result