import java.util.Scanner;
import java.util.Stack;

public class infix_to_postfix_prefix {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Stack<String> pre = new Stack<>();
        Stack<String> post = new Stack<>();
        Stack<Character> optors = new Stack<>();
        for(int i =0;i<str.length();i++){
            char ch = str.charAt(i);
            //if the ch is opening bracket
            if(ch=='('){
              optors.push(ch);
            }
            // )
            else if(ch==')'){
               while (optors.size()>0 && optors.peek()!='('){
                   char op = optors.pop();
                   String v2pre = pre.pop();
                   String v1pre = pre.pop();
                   String valpre = value(v1pre,v2pre,String.valueOf(op),"pre");
                   pre.push(valpre);
                   String v2post = post.pop();
                   String v1post = post.pop();
                   String valpost = value(v1post,v2post,String.valueOf(op),"post");
                   post.push(valpost);
               }
               optors.pop();
            }
            
            else if(Character.isLetterOrDigit(ch)){
                pre.push(String.valueOf(ch));
                post.push(String.valueOf(ch));
                
            }
            
            else if(ch=='*'||ch=='+'||ch=='-'||ch=='/'){
                while (optors.size()>0 && optors.peek()!='(' && precedence(ch)<=precedence(optors.peek())){
                    char op = optors.pop();
                    String v2pre = pre.pop();
                    String v1pre = pre.pop();
                    String valpre = value(v1pre,v2pre,String.valueOf(op),"pre");
                    pre.push(valpre);
                    String v2post = post.pop();
                    String v1post = post.pop();
                    String valpost = value(v1post,v2post,String.valueOf(op),"post");
                    post.push(valpost);
                }
                optors.push(ch);
            }
        }

        while (optors.size()>0){
            char op = optors.pop();
            String v2pre = pre.pop();
            String v1pre = pre.pop();
            String valpre = value(v1pre,v2pre,String.valueOf(op),"pre");
            pre.push(valpre);
            String v2post = post.pop();
            String v1post = post.pop();
            String valpost = value(v1post,v2post,String.valueOf(op),"post");
            post.push(valpost);
        }
        System.out.println(pre.peek());
        System.out.println(post.peek());


        sc.close();

    }
    public static int precedence(char optors){
        if(optors=='+'){
          return 1;
        }else if(optors=='-'){
           return 1;
        }else if(optors=='*'){
          return 2;
        }else {
           return 2;
        }
    }
    public static String value(String v1,String v2,String optor,String fun){
        if(fun=="pre"){
            return optor+v1+v2;
        }else {
            return v1+v2+optor;
        }
    }
}
