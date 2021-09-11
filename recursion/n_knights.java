import java.util.Scanner;

public class n_knights {
 static void n_knights_tour(int [][]chess,int row,int col,int move){
    
     if (row<0 ||col<0||row>=chess.length ||col>=chess.length|| chess[row][col]>0) {
         return;
     }
     else if(move==chess.length*chess.length){
         //Assigning move here as through traversal, the knight reached only to the 15th move in a 4*4 matrix and to fill the last 16*16 block we need it to initialize it here.
        chess[row][col]=move;
        displaychessboard(chess);
        chess[row][col]=0;
        return;
     }
//Possible 8 moves of a knight
    chess[row][col]=move;
     n_knights_tour(chess, row-2, col+1, move+1);
     n_knights_tour(chess, row-1, col+2, move+1);
     n_knights_tour(chess, row+1, col+2, move+1);
     n_knights_tour(chess, row+2, col-1, move+1);

     n_knights_tour(chess, row+1 ,col-2, move+1);
     n_knights_tour(chess, row+2, col+2, move+1);
     n_knights_tour(chess, row-1, col-2, move+1);
     n_knights_tour(chess, row-2, col-1, move+1);
     chess[row][col]=0;
 }
 static void displaychessboard(int [][]chess){
     for (int i = 0; i < chess.length; i++) {
         for (int j = 0; j < chess.length; j++) {
             System.out.print(chess[i][j]+" ");
         }
         System.out.println("");
     }
 }
 public static void main(String[] args) {
     Scanner sc=new Scanner(System.in);
     int n=sc.nextInt();
     int row=sc.nextInt();
     int col=sc.nextInt();
     int [][] chess=new int[n][n];
     n_knights_tour(chess, row, col,1);
     sc.close();
 }  
}
