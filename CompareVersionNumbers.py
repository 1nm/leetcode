class Solution:
    # @param version1, a string
    # @param version2, a string
    # @return an integer
    def compareVersion(self, version1, version2):
        arr1 = map(int, re.sub("(\.0+)*$", "", version1).split("."))
        arr2 = map(int, re.sub("(\.0+)*$", "", version2).split("."))
        len1 = len(arr1)
        len2 = len(arr2)
        i = 0
        while True:
            if (i == len1 and i < len2):
                return -1
            elif (i < len1 and i == len2):
                return 1
            elif (i == len1 and i == len2):
                return 0
            elif (i < len1 and i < len2):
                if (arr1[i] > arr2[i]):
                    return 1
                elif (arr1[i] < arr2[i]):
                    return -1
                else:
                    i += 1