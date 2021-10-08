import java.util.Scanner;
import java.util.Stack;

public class infixevaluation {
    // utility functions
    static int operation(int val_1, int val_2, char operator) {
        if (operator == '+') {
            return val_1 + val_2;
        } else if (operator == '-') {
            return val_1 - val_2;
        } else if (operator == '*') {
            return val_1 * val_2;
        } else {
            return val_1 / val_2;
        }
    }

    // Precedence
    static int precendence(char operator) {
        if (operator == '+') {
            return 1;
        } else if (operator == '-') {
            return 1;
        } else if (operator == '*') {
            return 2;
        } else {
            return 2;
        }
    }

    // Infix evaluation
    static int infixeval(String expression) {
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (Character.isDigit(ch)) {
                int num = ch - '0';
                operands.push(num);
            } else if (ch == '(') {
                operators.push(ch);
            } else if (ch == ')') {
                while (operators.peek() != '(') {
                    char op = operators.pop();
                    //val2 is popped first thoughtfully as it won't affect the division and subtraction operation
                    int val2 = operands.pop();
                    int val1 = operands.pop();

                    int ans = operation(val1, val2, op);
                    operands.push(ans);
                }
                operators.pop();
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                // ch is waiting for higher priority operators to solve first
                while (operators.size() > 0 && operators.peek() != '('
                        && precendence(ch) <= precendence(operators.peek())) {
                    char op = operators.pop();
                    int val2 = operands.pop();
                    int val1 = operands.pop();

                    int ans = operation(val1, val2, op);
                    operands.push(ans);
                }
                operators.push(ch);
            }
            
        }
        if(operators.size()==0 && operands.size()>0){
            StringBuilder number=new StringBuilder("");
            while (operands.size()>0) {
                number.append(operands.pop());
            }
            
           String nsb=(number.reverse()).toString();
           return Integer.parseInt(nsb);
        }
        while (operators.size() != 0) {
            char op = operators.pop();
            int val2 = operands.pop();
            int val1 = operands.pop();
            int ans = operation(val1, val2, op);
            operands.push(ans);
        }
        return operands.peek();

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(infixeval(str));
        sc.close();
    }
}
