public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        long I = A > E ? A : E;
        long J = B > F ? B : F;
        long K = C < G ? C : G;
        long L = D < H ? D : H;
        long overlapped = (K - I <= 0 || L - J <= 0) ? 0 : (K - I) * (L - J);
        long area = (C - A) * (D - B) + (G - E) * (H - F) - overlapped;
        return (int) area;
    }
}