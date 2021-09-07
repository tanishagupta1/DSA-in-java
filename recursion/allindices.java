import java.util.Scanner;

public class allindices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of the array");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter element");
        int ele = sc.nextInt();
        int[] resarr = allIdx(arr, 0, ele, 0);
        if (resarr.length == 0) {
            System.out.println("Element not found");
            sc.close();
            return;
        }
        if (resarr.length > 0) {
            for (int i = 0; i < resarr.length; i++) {
                System.out.println(resarr[i]);
            }
        }
        sc.close();
    }

    // sf here is the the counter of number to be searched
    static int[] allIdx(int[] arr, int index, int ele, int sf) {
        if (arr.length == index) {
            int[] rarr = new int[sf];
            return rarr;
        }
        if (arr[index] == ele) {
            int[] rarr = allIdx(arr, index + 1, ele, sf + 1);
            rarr[sf] = index;
            return rarr;
        } else {
            int[] rarr = allIdx(arr, index + 1, ele, sf);
            return rarr;
        }
    }
}
