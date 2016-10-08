class Solution:
    # @return an integer
    def trailingZeroes(self, n):
        zeros = fives = n / 5
        while fives != 0:
            fives /= 5
            zeros += fives
        return zeros
        