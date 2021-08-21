public class countSort {
    static void printarray(int[] arr, int n) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println(" ");
    }

    static int max(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    static void count_sort(int[] arr) {
        int k = max(arr);
        int[] output = new int[arr.length];
        int[] count = new int[k + 1];
        // Assigning each value of count array as 0
        // for (int i : count) {
        //     count[i] = 0;
        // }
        // Loop for assigning frequency
        for (int i = 0; i < count.length-1; ++i) {
            count[arr[i]]++;
        }
        // Loop for incrementing the cummulative index
        for (int i = 1; i <=k; ++i) {
            count[i] = count[i] + count[i - 1];
        }
        // Loop for getting the output array (decerementing -1 to get the index value in count array)
        for (int i = arr.length-1; i >=0; i--) {
            output[--count[arr[i]]] = arr[i];
        }
        //Loop to copy the output array into arr
        for (int i = 0; i < arr.length; i++) {
            arr[i]=output[i];
        }

    }

    public static void main(String[] args) {
        int[] b = { 1, 4, 1, 2, 7, 5, 2};
        printarray(b, b.length);
        count_sort(b);
        printarray(b, b.length);

    }

}
// Time Compelxity is O(1) one of the fastest sorting algo
// Best Case is O(n+k)
// Worst Case  is O(n+k) where n is the size of arr and k is the size of count array
// Auxilliary Space Compelxity is O(n+k)

// Count sort is a stable sort (as we are starting from arr[n-1] to get the output array else it won't be stable).

//                       Limitations of count sort
// 1) Counting sort can be extended to work for negative inputs also.
// 2) If the value of K is very huge and the the numbe of elements in arr 
// is very less, it will cause a lot of memory wastage
// 3) Counting sort is efficient if the range of input data is not significantly greater than the number of objects to be sorted. 
