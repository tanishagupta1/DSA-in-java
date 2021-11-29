import java.util.Scanner;

public class jumpgame {
    static boolean jumps(int []arr,int source,int nextjump,int end){
        if(source==end){
            return true;
        }
         if(arr[source]==0){
             return false;
         }
         //we are trying all iterations for reaching the end
         for(int i=1;i<=arr[source];i++){
             if(jumps(arr, source+i, nextjump, end)){
                 return true;
             }
         }
         return false;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int [] arr=new int [n];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=sc.nextInt();
        }
        boolean ans=jumps(arr, 0,1, arr.length-1);
        System.out.println(ans);
        sc.close();
    }
}
