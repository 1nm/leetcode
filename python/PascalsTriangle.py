class Solution:
    # @return a list of lists of integers
    def generate(self, numRows):
        s = []
        for i in xrange(0, numRows):
            s.append([1])
            if i == 0:
                continue
            elif i == 1:
                s[i].append(1)
                continue
            for j in xrange(0, len(s[i - 1]) - 1):
                s[i].append(s[i - 1][j] + s[i - 1][j + 1])
            s[i].append(1)
        return s