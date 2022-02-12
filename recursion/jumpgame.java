import java.util.Scanner;

public class jumpgame {
    static boolean jumps(int []arr,int source,int end,int jump,int mins){
        if(source==end){
            // System.out.println("C "+jump);
            // System.out.println("MINS "+mins);
            return true;
        }
         if(arr[source]==0){
             return false;
         }
         //we are trying all iterations for reaching the end
         for(int i=1;i<=arr[source];i++){
             if(jumps(arr, source+i, end,jump,mins)){
                 return true;
             }
         }
         return false;
    }
    static boolean jumpswithoutrecursion(int []arr){
        int end=arr.length-1;
        for(int i=arr.length-2;i>=0;i--){
            if(arr[i]+i>=end){
                end=i;
            }
        }
        return end==0;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int [] arr=new int [n];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=sc.nextInt();
        }
        boolean ans=jumps(arr, 0,arr.length-1,0,Integer.MAX_VALUE);
        System.out.println(ans);

        boolean ans2=jumpswithoutrecursion(arr);
        System.out.println(ans2);
        sc.close();
    }
}
