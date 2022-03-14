class Solution:
    # @return a string
    def convertToTitle(self, num):
        s = ""
        while (num != 0):
            s = chr((num - 1) % 26 + ord('A')) + s
            num = (num - 1) / 26;
        return s