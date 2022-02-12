import java.util.Scanner;
// This gives subsequences of that add up to target


public class targetsumsubset {
    //Time Complexity : exponential
    static void subsetsumtarget(int[] arr,int index,String set, int sum,int target){
        if(index==arr.length){
            if(target==sum){
                System.out.println(set+".");
            }
            return;
        }
       //When the number is added in subset
       subsetsumtarget(arr, index+1, set+arr[index]+",", sum+arr[index], target);
       //When the number is not added in the subset
       subsetsumtarget(arr, index+1, set, sum, target);
    }
    //DP method
    static void targetSumDp(int [][]set){

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int [] arr=new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter target");
        int target=sc.nextInt();
        subsetsumtarget(arr,0,"",0,target);
        sc.close();
    }
}
