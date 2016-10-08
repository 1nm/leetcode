class Solution:
    # @return a list of integers
    def getRow(self, rowIndex):
        if rowIndex == 0:
            return [1]
        s = [1, 1]
        for i in xrange(2, rowIndex + 1):
            a = b = 1
            for j in xrange(0, i - 1):
                a = b
                b = s[j + 1]
                s[j + 1] = a + b
            s.append(1)
        return s