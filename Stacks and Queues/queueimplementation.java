public class queueimplementation {
    //insertion from rear
    //deletion from front
    //it works on FIFO principle (first in first out)

    static final int CAPACITY=5;
    static int queue[]=new int[CAPACITY];
    static int front=0;
    static int rear=0;
    //isFull()
    static boolean isFull(){
        if(rear==CAPACITY){
         
            return true;
        }
        return false;
    }
    //isEmpty()
    static boolean isEmpty(){
        if (rear==front) {
            return true;
        }
        return false;
    }
    //insert
    static void insert(int ele){
        if (isFull()) {
            System.out.println("Queue is Full");
            return;
        }
        else{
           
           queue[rear]=ele;
           rear++;
        }
    }
    //delete
    static void delete(){
        if (isEmpty()) {
            System.out.println("Queue is Empty");
        }
        else{
            
            for (int i = 0; i < rear-1; i++) {
                queue[i]=queue[i+1];
            }
            queue[rear-1]=-1;
            front++;
            rear--;
        }
    }
    



   public static void main(String[] args) {
       insert(1);
       insert(2);
       insert(3);
       insert(4);
       insert(5);
       delete();
       delete();
       for (int i = 0; i < CAPACITY; i++) {
           System.out.println(queue[i]);
       }
   } 
}
