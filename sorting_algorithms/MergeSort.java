class MergeSort {

    void merge(int[] arr, int l, int mid, int h) 
    {
        int n1 = mid - l + 1;
        int n2 = h - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        // Copying the elements of arr to the two arrays which are left and right from
        // mid
        for (int i = 0; i < n1; i++) {
            L[i] = arr[i+l];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid+1+j];
        }
        int i = 0;// for iterating L
        int j = 0;// for iterating R
        int k = l;// for iterating through arr to insert sorted elements

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // MergeSort recursive function
    void Sort(int[] arr, int l, int h) {
        
        if (l < h) {
           int mid = (l + h) / 2;
            // sort the two halves
            Sort(arr, l, mid);
            Sort(arr, mid + 1, h);
            // merge the sorted halves
            merge(arr, l, mid, h);
        }
    }

    // utility function
    static void printarray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.err.println("");
    }

    public static void main(String[] args) {
        int []A = { 12, 11, 13, 5, 6, 7 };
        printarray(A);
       
        MergeSort obj=new MergeSort();
        obj.Sort(A, 0, A.length - 1);
        printarray(A);
    }
}

// Time Complexity: θ(nLogn) in all 3 cases (worst, average and best).
// Auxiliary Space: O(n)
// Algorithmic Paradigm: Divide and Conquer
// Sorting In Place: No in a typical implementation
// Stable: Yes