class Solution {
  public int arrangeCoins(int n) {
    // for a full k row count sum(k) = 1 + 2 + ... + k = k * (1 + k) / 2
    // So we need to find k that satisfies k * (1 + k) / 2 <= n
    // We have the equation (1/2) * k^2 + (1/2) * k - n <= 0
    // Since k and n are both positive integers
    // k = floor((-b + sqrt(b^2 - 4ac)) / 2a)
    double a = 0.5;
    double b = 0.5;
    int c = -n;
    return (int) ((-b + Math.sqrt(b * b - 4 * a * c)) / 2 / a);
  }
}
