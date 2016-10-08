class Solution:
    # @return a string
    def longestCommonPrefix(self, strs):
        result = ""
        i = 0
        while True:
            same = True
            curr = ""
            for string in strs:
                if i < len(string):
                    if curr == "":
                        curr = string[i]
                    elif curr != string[i]:
                        same = False
                        break
                else:
                    same = False
                    break;
            if same and curr != "":
                result += curr
                i += 1
            else:
                break
        return result