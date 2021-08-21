public class bubblesort {
    void printarray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");

    }

    void swap(int a, int b) {
        int temp = 0;
        temp = a;
        a = b;
        b = temp;
    }

    void bubble_sort(int[] arr) {

        int n = arr.length;
        boolean isSorted = true;
        // the i is for number of passes
        for (int i = 0; i < n - 1; i++) {
            System.out.println("This is " + (i + 1) + " number of pass");
            // j is for number of comparisons
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr[j], arr[j+1]);
                    isSorted = false;
                }
            }
            if (isSorted) {
                return;
            }
        }

    }

    public static void main(String[] args) {
        bubblesort obj = new bubblesort();
        int[] array = { 1, 2, 33, 45, 57, 6 };
        obj.printarray(array);
        obj.bubble_sort(array);
        obj.printarray(array);

    }
}
