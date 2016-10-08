class Solution:
    # @return a boolean
    def isPalindrome(self, x):
        if x < 0:
            return False
        if x < 10:
            return True
        l = int(math.log10(x)) + 1
        if l == 1:
            return True
        y = 0
        for i in xrange (0, l / 2):
            y = y * 10 + x % 10
            x /= 10
        if l % 2 == 1:
            x /= 10
        return True if x == y else False