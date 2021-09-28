import java.util.Scanner;
import java.util.Stack;

public class bracketsduplicacy {

// Concept : To see if there is any duplicate pair wrapping the same sequence, we push the opening bracket and other characters and check when closing bracket appears while popping the characters if there is no need of removing any characters to find the opening bracket, there exits duplicacy else it does not


    static boolean duplicatebracket(String str){
        Stack<Character> st=new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch=str.charAt(i);
            if (ch==')') {
                if (st.peek()=='(') {
                    return true;
                }
                else{
                    while (st.peek()!='(') {
                        st.pop();
                    }
                    //last pop to remove the opening bracket
                    st.pop();
                }
            } else {
                st.push(ch);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println(duplicatebracket(s));
        sc.close();
    }
}
