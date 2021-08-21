import java.util.Scanner;

public class lastIndex {
    static int lastidx(int[]arr,int index,int ele){
        if(index==arr.length){
            return -1;
        }
        int lisa=lastidx(arr, index+1, ele);
        if(lisa==-1){
            if(arr[index]==ele){
                return index;
            }
            else{
                return -1;
            }
        }
        return lisa;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of elements");
        int n=sc.nextInt();
        int [] arr=new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter element to search");
        int ele=sc.nextInt();
        System.out.println(lastidx(arr, 0, ele));
        
        sc.close();
    }
}
