public class Solution {
    public int hIndex(int[] citations) {
        qsort(citations, 0, citations.length - 1);
        int h = 0;
        for (int i = 0; i < citations.length; ++ i) {
            if (citations[i] >= i + 1) {
                h = i + 1;
            } else {
                break;
            }
        }
        return h;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void qsort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = array[end];
        int p = start;
        for (int i = start; i < end; ++ i) {
            if (array[i] > pivot) {
                swap(array, p ++, i);
            }
        }
        swap(array, p, end);
        qsort(array, start, p - 1);
        qsort(array, p + 1, end);
    }
}
