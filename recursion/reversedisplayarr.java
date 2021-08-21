import java.util.Scanner;
public class reversedisplayarr {
    static void darReverse(int [] arr,int index){
        if(index<0){
            return;
        }
        System.out.println(arr[index]);
        darReverse(arr, index-1);
        
        }
        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            int n=sc.nextInt();
            int arr[]=new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i]=sc.nextInt();
            }
            darReverse(arr, n-1);
            sc.close();
        }
}
