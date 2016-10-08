class Solution:
    # @param s, a string
    # @return an integer
    def titleToNumber(self, s):
        num = exp = 0
        for ch in reversed(s):
            num += (ord(ch) - ord("A") + 1) * (26 ** exp)
            exp += 1
        return num