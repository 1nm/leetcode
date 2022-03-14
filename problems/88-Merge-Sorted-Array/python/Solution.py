class Solution:
    # @param A  a list of integers
    # @param m  an integer, length of A
    # @param B  a list of integers
    # @param n  an integer, length of B
    # @return nothing
    def merge(self, A, m, B, n):
        pa = pb = 0;
        C = []
        while True:
            if (pa == m and pb == n):
                break;
            if (pa == m):
                num = B[pb]
                pb += 1
            elif (pb == n):
                num = A[pa]
                pa += 1
            elif (A[pa] < B[pb]):
                num = A[pa]
                pa += 1
            else:
                num = B[pb]
                pb += 1
            C.append(num)
        del A[:]
        A.extend(C)
