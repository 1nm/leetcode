class Solution:
    # @return a string
    def intToRoman(self, num):
        i2r = {1: "I", 5: "V", 10: "X", 50: "L", 100:"C", 500: "D", 1000: "M"}
        # 10 = 10, 9 = 10 - 1, 5 = 5, 4 = 5 - 1, 1 = 1
        baserule = [10, 9, 5, 4, 1]
        roman = ""
        for i in [100, 10, 1]:
            rule = [x * i for x in baserule]
            while num >= rule[0]:
                roman += i2r[rule[0]]
                num -= rule[0]
            if num >= rule[1]:
                roman += i2r[rule[4]] + i2r[rule[0]]
                num -= rule[1]
            elif num >= rule[2]:
                roman += i2r[rule[2]]
                num -= rule[2]
            elif num >= rule[3]:
                roman += i2r[rule[4]] + i2r[rule[2]]
                num -= rule[3]
            while num >= rule[4]:
                roman += i2r[rule[4]]
                num -= rule[4]
        return roman

            