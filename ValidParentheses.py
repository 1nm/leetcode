class Solution:
    # @return a boolean
    def isValid(self, s):
        stack = []
        for ch in s:
            if (ch in "([{"):
                stack.append(ch)
            elif (ch in ")]}"):
                if (len(stack) == 0):
                    return False
                ch1 = stack.pop()
                if (ch == ")"):
                    expect = "("
                elif (ch == "]"):
                    expect = "["
                elif (ch == "}"):
                    expect = "{"
                if (ch1 != expect):
                    return False
            else:
                return False
        if (len(stack) == 0):
            return True
        else:
            return False