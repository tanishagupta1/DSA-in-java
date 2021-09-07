public class bubblesort {
    void printarray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");

    }
    
    void bubble_sort(int[] arr) {

        int n = arr.length;
        boolean isSorted = true;
        // the i is for number of passes
        for (int i = 0; i < n - 1; i++) {
            // System.out.println("This is " + (i + 1) + " number of pass");
            // j is for number of comparisons
            // this creates a bubbling effect in which after every pass the largest number
            // pops up.
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
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
        int[] array = { 1, 4, 2, 6, 2, 5 };
        obj.printarray(array);
        obj.bubble_sort(array);
        System.out.println("After sorting");
        obj.printarray(array);

    }
}
