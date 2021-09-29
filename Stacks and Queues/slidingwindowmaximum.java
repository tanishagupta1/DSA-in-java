import java.util.Scanner;
import java.util.Stack;

public class slidingwindowmaximum {

    //Next Greater element
    static int[] ngelement (int [] arr){
    Stack <Integer> st=new Stack<>();
    
    int [] nge=new int [arr.length];
    //We had the option to set the maximum of the element as -1 as well but setting it to arr.length help us in comparing it to the elments as the window shifts 
    nge[arr.length-1]=arr.length;
    st.push(arr.length-1);
    for (int i = arr.length-2; i >=0; i--) {
        while (st.size()>0 && arr[i]>arr[st.peek()]) {
            st.pop();
        }
        if (st.size()==0) {
            nge[i]=arr.length;
        }
        else{
            nge[i]=st.peek();
        }
        st.push(i);
    }
    return nge;
    }
    //Sliding window
    static int [] sliding_maximum(int []arr,int k){
        //k is the window size
        int [] ans=new int[arr.length-k+1];
        int []nge=ngelement(arr);
        int j=0;
        for (int i = 0; i <= arr.length-k; i++) {
            if (j<i) {
                j=i;
            }
            while(nge[j]<i+k){
                j=nge[j];
            }
            ans[i]=arr[j];
        }
        return ans;
    }
    
    
public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int [] arr=new int [n];
   
    for (int i = 0; i < arr.length; i++) {
        arr[i]=sc.nextInt();
    }
    System.out.println("Enter the window size");
    int k=sc.nextInt();
   int [] answer=sliding_maximum(arr, k);
   for (int i = 0; i < answer.length; i++) {
       System.out.print(answer[i]+" ");
   }
   sc.close();
}
}