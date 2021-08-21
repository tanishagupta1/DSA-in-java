import java.util.Scanner;
public class firstIndex {
    static int firstoccurance(int[]arr,int index,int data){
        if (arr.length==index) {
            return -1;
        }
       if(arr[index]==data){
           return index;
       }
       int fisa=firstoccurance(arr, index+1, data);
       return fisa;
    
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
            int n=sc.nextInt();
            int arr[]=new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i]=sc.nextInt();
            }
            System.out.println(firstoccurance(arr, 0, 8));
            sc.close();
    }
}
