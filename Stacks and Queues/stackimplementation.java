public class stackimplementation {

    // Stack is a linear data structure 
    //it works on LIFO principle (last in first out)
    // push(), pop(), isEmpty() and peek() all take O(1) time
    static final int CAPACITY=5;
    static int stack[]=new int[CAPACITY];
    static int top=-1;
    //isEmpty Function
    static boolean isEmpty(){
        if(top==-1)
        return true;

        return false;
    }
    //isFull() function
    static boolean isFull(){
       if(top==stack.length-1){
           return true;
        }
        return false;
    }
    //push function
    static void push(int ele){
        if(isFull()){
            System.out.println("Cannot push, The stack is Full");
            return;
        }
        else{
            stack[++top]=ele;
        }
    } 
    //pop function
    static void pop(){
        if (isEmpty()) {
            System.out.println("The Stack is Empty");
        }
        else{
            stack[top]=0;
            top--;
        }
    }
    //peek function
    static int peek(){
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return stack[top];
    }



   public static void main(String[] args) {
       System.out.println(isEmpty());
        push(1);
        push(2);
        push(3);
        pop();
        System.out.println("The topmost element is "+peek());
    
        for (int i : stack) {
            System.out.println(i);
        }
    }
}
