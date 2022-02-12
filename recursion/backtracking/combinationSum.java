package backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class combinationSum {
    static void combinationSumsubset(int []arr,int index,int target,List<Integer> temp,List<List<Integer>> ans){
        if(index==arr.length){
            if (target==0) {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
    if(arr[index]<=target){
        temp.add(arr[index]);
        //when we selected the number
        combinationSumsubset(arr, index, target-arr[index], temp, ans);
        temp.remove(temp.size()-1);
    }
    //when number is not selected
    combinationSumsubset(arr, index+1, target, temp, ans);
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
        List<List<Integer>> ans=new ArrayList<>();
        combinationSumsubset(arr,0,target,new ArrayList<>(),ans);
        System.out.println(ans);
        sc.close();
    }
}
