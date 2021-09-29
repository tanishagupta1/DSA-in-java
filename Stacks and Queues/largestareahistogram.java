import java.util.Scanner;
import java.util.Stack;

public class largestareahistogram {
    static int largest_histogram_area(int[] arr) {
        // Right Boundary
        int[] right_boundary = new int[arr.length]; // gives next smallest element on the left
        Stack<Integer> st = new Stack<>();
        st.push(arr.length - 1);
        // If there is no smaller element for the arr[i] then consider the right
        // boundary to be the last element
        right_boundary[arr.length - 1] = arr.length;

        for (int i = arr.length - 2; i >= 0; i--) {
            while (st.size() > 0 && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                right_boundary[i] = arr.length;
            } else {
                right_boundary[i] = st.peek();
            }
            st.push(i);
        }
        // Left Boundary
        int[] left_boundary = new int[arr.length]; // gives next smallest element on the right
        st = new Stack<>();
        left_boundary[0] = -1;
        st.push(0);
        // If there is no smaller element for the arr[i] then consider the right
        // boundary to be the last element
        left_boundary[0] = -1;

        for (int i = 1; i < arr.length; i++) {
            while (st.size() > 0 && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                left_boundary[i] = -1;
            } else {
                left_boundary[i] = st.peek();
            }
            st.push(i);
        }
        // Area
        int maxArea = 0;
        for (int i = 0; i < arr.length; i++) {
            int width = (right_boundary[i] - left_boundary[i]) - 1;
            int area = width * arr[i];
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(largest_histogram_area(arr));
        sc.close();
    }
}
