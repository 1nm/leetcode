public class HeapSort {
    public void sort(int[] array) {
        heapify(array);
        int end = array.length - 1;
        while (end > 0) {
            int temp = array[0];
            array[0] = array[end];
            array[end] = temp;
            end --;
            siftDown(array, 0, end);
        }
    }

    private void heapify(int[] array) {
        if (array.length == 0) return;
        int start = (array.length - 1) / 2;
        while (start >= 0) {
            siftDown(array, start, array.length - 1);
            start --;
        }
    }

    private void siftDown(int[] array, int start, int end) {
        int root = start, left = (root << 1) + 1, right = left + 1;
        while (left <= end) {
            int swap = root;
            if (left <= end && array[swap] < array[left]) swap = left;
            if (right <= end && array[swap] < array[right]) swap = right;
            if (swap == root)
                return;
            else {
                int temp = array[swap];
                array[swap] = array[root];
                array[root] = temp;
                root = swap;
                left = (root << 1) + 1;
                right = left + 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] {4,5,6,7,8,4,3,2,234,5,1};
        new HeapSort().sort(array);
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
