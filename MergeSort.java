public class MergeSort {
    public void sort(int[] array) {
        int[] sorted = mergesort(array);
        System.arraycopy(sorted, 0, array, 0, array.length);
    }

    private int[] mergesort(int[] array) {
        if (array.length <= 1) return array;
        int[] left = new int[array.length / 2];
        int[] right = new int[array.length - left.length];
        System.arraycopy(array, 0, left, 0, left.length);
        System.arraycopy(array, left.length, right, 0, right.length);
        return merge(mergesort(left), mergesort(right));
    }

    private int[] merge(int[] left, int[] right) {
        int[] merged = new int[left.length + right.length];
        int i = 0, j = 0;
        for (int k = 0; k < merged.length; ++ k) {
            if (i < left.length && (j < right.length && left[i] < right[j]) || j >= right.length) {
                merged[k] = left[i++];
            } else {
                merged[k] = right[j++];
            }
        }
        return merged;
    }

    public static void main(String[] args) {
        int[] array = new int[] {4,5,6,7,8,4,3,2,234,5,1};
        new MergeSort().sort(array);
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
