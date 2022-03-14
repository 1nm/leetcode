class Solution:
    # @return an integer
    def atoi(self, str):
        length = len(str)
        if (length == 0): # return 0 if str is empty
            return 0
        digits = "0123456789"
        i = 0
        result = 0
        while i < length and str[i] == " ": # skip leading spaces
            i += 1
        if (i == length): # return 0 if there are only spaces
            return 0
        else:
            sign = True
            if str[i] == "+": # sign
                i += 1
            elif str[i] == "-": # sign
                sign = False
                i += 1
            while (i < length and str[i] in digits): # process digits
                digit = ord(str[i]) - ord("0")
                if sign:
                    if result > 214748364 or result == 214748364 and digit >= 8: # overflow
                        return 2147483647
                else:
                    if result < -214748364 or result == -214748364 and digit == 9: # underflow
                        return -2147483648
                result = result * 10 + (digit if sign else -digit)
                i += 1

            return result