import java.util.Scanner;
import java.util.Stack;

public class nextgreaterelement {
    // print the nearest greater element than the element when seen rightwards
     static int[] nearestgreaterelement(int [] arr){
         int [] ans=new int[arr.length];
         Stack<Integer> st=new Stack<>();
         st.push(arr[arr.length-1]);
         ans[ans.length-1]=-1;

         for (int i = arr.length-2 ; i>=0 ; i--) {
               
                while (!st.isEmpty() && arr[i]>=st.peek()) {
                    st.pop();
                }
                //Everything is popped out
                if (st.isEmpty()) {
                    ans[i]=-1;
                }
                else{
                    //when element on the stack is greater than element in the array
                    ans[i]=st.peek();
                }
                st.push(arr[i]);
            
         }
         return ans;
     } 
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
     int [] nums=new int [n]; 
     for (int i = 0; i < nums.length; i++) {
         nums[i]=sc.nextInt();
     }
     int[] answer=nearestgreaterelement(nums);
     for (int i : answer) {
         System.out.println(i);
     }  
     sc.close();
    }
}
