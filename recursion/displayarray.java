import java.util.Scanner;

public class displayarray {
static void dar(int [] arr,int index){
if(index==arr.length){
    return;
}
System.out.println(arr[index]);
dar(arr, index+1);
}
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=sc.nextInt();
        }
        dar(arr, 2);
        sc.close();
    }
}
