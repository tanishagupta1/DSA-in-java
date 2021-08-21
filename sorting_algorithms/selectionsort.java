public class selectionsort {
    // selection sort is an in-place comparison sorting algorithm. It has an O(n²)
    // time complexity, which makes it inefficient on large lists, and generally
    // performs worse than the similar insertion sort.

    void printarray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");

    }

    void selection_sort(int[] arr, int n) {
        int indexofmin, temp;
        // Loop for the number of passes
        for (int i = 0; i < n - 1; i++) {
            indexofmin = i;

            for (int j = i + 1; j <=n-1; j++) {

                if (arr[j] < arr[indexofmin]) {
                    indexofmin = j;
                }
                System.out.println("index of min is" + indexofmin);

            }
                // swapping is done 
                // in the outer loop as we need
                //  the minimum number of the array
                System.out.println("The pass no " + i);
                temp = arr[i];
                arr[i] = arr[indexofmin];
                arr[indexofmin] = temp;
                printarray(arr);
        }

    }

    // Driver code
    public static void main(String[] args) {
        int[] array = { 8, 0, 7, 1, 3 };
        selectionsort obj = new selectionsort();
        obj.printarray(array);
        obj.selection_sort(array, array.length);
        obj.printarray(array);
    }

}
