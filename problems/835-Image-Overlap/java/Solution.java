class Solution {
  private int overlap(int[][] img1, int[][] img2) {
    int count = 0;
    for (int i = 0; i < img1.length; i++) {
      for (int j = 0; j < img1[0].length; j++) {
        count += img1[i][j] & img2[i][j];
      }
    }
    return count;
  }

  private int[][] move(int[][] img, int dx, int dy) {
    int n = img.length;
    int[][] newImg = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i - dx >= 0 && i - dx < n && j - dy >= 0 && j - dy < n) {
          newImg[i][j] = img[i - dx][j - dy];
        }
      }
    }
    return newImg;
  }

  public int largestOverlap(int[][] img1, int[][] img2) {
    // brute force, time O(n^4), space O(n^2)
    // overlap calculation O(n^2)
    // transition O(n^2)
    int max = 0;
    int n = img1.length;
    for (int dx = -n; dx <= n; dx++) {
      for (int dy = -n; dy <= n; dy++) {
        // move img1 with dx, dy
        int[][] img3 = move(img1, dx, dy);
        max = Math.max(max, overlap(img3, img2));
      }
    }
    return max;
  }
}
