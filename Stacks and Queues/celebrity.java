import java.util.Scanner;
import java.util.Stack;

public class celebrity {
static void findCelebrity(int [][]arr){
    int n=arr.length;
    Stack<Integer> st=new Stack<>();
    	for(int i=0;i<n;i++){
    	    st.push(i);
    	}
    	while(st.size()>=2){
    	    int i=st.pop();
    	    int j=st.pop();
    	    //if i knows j that means i cannot be celebrity
    	    if(arr[i][j]==1){
    	        st.push(j);
    	    }
    	    else{
    	        st.push(i);
    	    }
    	}
    	int pot=st.pop();
    	for(int i=0;i<n;i++){
    	    if(pot!=i){
    	        if(arr[pot][i]==1 || arr[i][pot]==0){
    	            return;
    	        }
    	    }
    	}
    	
    System.out.println("Celebrity is "+pot);
}

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[][]=new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j]=sc.nextInt();
            }
        }
        findCelebrity(arr);
        sc.close();
    }
}
