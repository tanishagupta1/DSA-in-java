
class quickSort {

    static void printarray(int[] arr, int n) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println(" ");
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static int partition(int[] arr, int low, int high) {
        // It is set to -1 initially so that it starts comparison from 0
        int i = (low - 1);
        int pivot = arr[high];
        // it runs till high -1 cause arr[high] is pivot
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        // i+1 is used to point on the index
        swap(arr, i + 1, high);
        return (i + 1);

    }

    static void quick_sort(int[] arr, int low, int high) {
        if (low < high) {
            int partition_index = partition(arr, low, high);
            quick_sort(arr, low, partition_index - 1);
            // printarray( arr,arr.length);
            quick_sort(arr, partition_index + 1, high);
        }
    }

    public static void main(String[] args) {

        int[] b = { 2,4,8,7,6,3};
        printarray(b, b.length);
        quick_sort(b, 0, 5);
        printarray(b, b.length);

    }
}
