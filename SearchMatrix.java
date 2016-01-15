public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // search row
        int start = 0, end = matrix.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid][0] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        int row = start;
        start = 0;
        end = matrix[row].length - 1;

        // search column
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return false;
    }
}
