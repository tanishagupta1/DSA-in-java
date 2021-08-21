//Array must be sorted
public class binarySearch {
    static int binary_Search(int[] arr, int ele) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            // System.out.println("Mid "+mid);
            if (arr[mid] == ele) {
                return mid;
            }

            else if (arr[mid] < ele) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] A = {1,3};
        int search = binary_Search(A, 1);
        System.out.println("The searchIndex is " + search);

    }

}
