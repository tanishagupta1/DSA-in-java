import java.util.Scanner;
public class maxofArray {
    static int maximum(int []arr,int index){
        if (index==arr.length-1) {
            return arr[index];
        }
        //max in smaller array
      int misa=maximum(arr,index+1);
       if (arr[index]>misa) {
           return arr[index];
       }
       return misa;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
            int n=sc.nextInt();
            int arr[]=new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i]=sc.nextInt();
            }
           System.out.println( maximum(arr, 0));
           sc.close();
    }
}
