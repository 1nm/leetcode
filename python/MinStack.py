class MinStack:
    # @param x, an integer
    # @return an integer
    def push(self, x):
        self.stack.append(x)
        if (len(self.stack) == 1):
            self.minValue = x
        else:
            if x < self.minValue:
                self.minValue = x

    # @return nothing
    def pop(self):
        y = self.stack.pop()
        if (y == self.minValue and len(self.stack) != 0):
            self.minValue = min(self.stack)

    # @return an integer
    def top(self):
        return self.stack[-1]

    # @return an integer
    def getMin(self):
        return self.minValue

    def __init__(self):
        self.stack = []
        self.minValue = 0
