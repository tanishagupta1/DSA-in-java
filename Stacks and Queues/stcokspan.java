import java.util.Stack;

public class stcokspan {

    static int[] getstockspan(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        ans[0] = 1;
        // We are pushing index here-
        for (int i = 1; i < ans.length; i++) {
            while (arr[i]>arr[st.peek()]&& st.size() > 0) {
                st.pop();
            }
            if (st.isEmpty()) {
                ans[i] = i + 1;
            }
            else{
                ans[i]=i-st.peek();
            }
            st.push(i);
        }

        return ans;
    }

    public static void main(String[] args) {
      int [] stock={100,80,60,70,60,75,85};
      int []answer=getstockspan(stock);
      for (int i = 0; i < answer.length; i++) {
          System.out.print(answer[i]+" ");
      }
    }
}
