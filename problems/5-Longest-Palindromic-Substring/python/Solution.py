class Solution:
    # @return a string
    def longestPalindrome(self, s):
        length = len(s)
        if length == 0:
            return ""
        else:
            max_length = 0
            l = r = 0
            for pivot in xrange(0, length):
                halfspan = 1
                p = pivot - 1
                q = pivot + 1
                while p >= 0 and q < length and s[p] == s[q]:
                    p = p - 1
                    q = q + 1
                if max_length < q - p - 1:
                    max_length = q - p - 1
                    l = p + 1
                    r = q
                p = pivot - 1
                q = pivot
                while p >= 0 and q < length and s[p] == s[q]:
                    p = p - 1
                    q = q + 1
                if max_length < q - p - 1:
                    max_length = q - p - 1
                    l = p + 1
                    r = q
        return s[l:r]