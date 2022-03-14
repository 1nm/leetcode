class Solution:
    # @param n, an integer
    # @return an integer
    def climbStairs(self, n):
        a = 1
        b = 2
        if n == 1:
            return 1
        elif n == 2:
            return 2
        c = 0
        for i in xrange(2, n):
            c = a + b
            a = b
            b = c
        return c