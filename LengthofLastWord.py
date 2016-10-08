class Solution:
    # @param s, a string
    # @return an integer
    def lengthOfLastWord(self, s):
        length = len(s)
        i = length - 1
        while i >= 0 and s[i] == " ": # remove trailing spaces
            i -= 1
        count = 0
        while i >= 0 and s[i] != " ":
            count += 1
            i -= 1
        return count