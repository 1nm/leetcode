public class QuickSort {
    public void sort(int[] array) {
        quicksort(array, 0, array.length - 1);
    }

    private void quicksort(int[] array, int lo, int hi) {
        if (lo < hi) {
            int p = partition(array, lo, hi);
            quicksort(array, lo, p - 1);
            quicksort(array, p + 1, hi);
        }
    }

    private int partition(int[] array, int lo, int hi) {
        int pivot = array[hi];
        int p = lo;
        for (int i = lo; i < hi; ++ i) {
            if (array[i] < pivot) {
                int temp = array[p];
                array[p++] = array[i];
                array[i] = temp;
            }
        }
        array[hi] = array[p];
        array[p] = pivot;
        return p;
    }

    public static void main(String[] args) {
        int[] array = new int[] {4,5,6,7,8,4,3,2,234,5,1};
        new QuickSort().sort(array);
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
