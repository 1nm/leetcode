class Solution:
    # @param a, a string
    # @param b, a string
    # @return a string
    def addBinary(self, a, b):
        carry = 0
        i = len(a) - 1
        j = len(b) - 1
        result = ""
        while i >= 0 or j >= 0:
            x = int(a[i]) if i >= 0 else 0
            y = int(b[j]) if j >= 0 else 0
            sum = x ^ y ^ carry
            carry = x & y | x & carry | y & carry
            result = str(sum) + result
            i -= 1
            j -= 1
        if carry == 1:
            result = str(1) + result
        return result