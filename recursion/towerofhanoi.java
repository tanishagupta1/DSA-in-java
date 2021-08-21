import java.util.Scanner;
public class towerofhanoi {
    //t1 is the start , t2 is the destination and t3 is the helper
  static void toh(int n,int t1,int t2,int t3){
      if(n==0){
          return;
      }
      toh(n-1,t1,t3,t2);
      System.out.println(n+" [ "+t1+" -> "+t2+" ]");
      toh(n-1, t3, t2, t1);
  }
  public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
      System.out.println("Enter number of towers ");
       int n=sc.nextInt();
       System.out.println("Enter numbering to towers ");
       int t1=sc.nextInt();
       int t2=sc.nextInt();
       int t3=sc.nextInt();
       toh(n, t1, t2, t3);
       sc.close();
  }
   
}