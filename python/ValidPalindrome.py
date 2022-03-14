class Solution:
    # @param s, a string
    # @return a boolean
    def isPalindrome(self, s):
        validChars = "abcdefghijklmnopqrstuvwxyz1234567890"
        l = len(s)
        if l == 0 or l == 1:
            return True
        i = 0
        j = l - 1
        lowered = s.lower()
        while True:
            while lowered[i] not in validChars and i < j:
                i += 1
            while lowered[j] not in validChars and j > i:
                j -= 1
            if i == j:
                return True
            if lowered[i] == lowered[j]:
                if i + 1 == j:
                    return True
                else:
                    i += 1
                    j -= 1
            else:
                return False
            