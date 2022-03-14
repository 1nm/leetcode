class Solution:
    # @param num, a list of integers
    # @return an integer
    def majorityElement(self, num):
        counter = {}
        for i in num:
            if (not i in counter):
                counter[i] = 1
            else:
                counter[i] += 1
            if (counter[i] > len(num) / 2):
                return i