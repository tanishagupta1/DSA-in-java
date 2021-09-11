import java.util.Scanner;

//Here the levels in the recursion tree are rows and the columns are the options
public class n_queens {
    static boolean isqueenSafe(int[][] chess,int row,int col){
        // check vertically upwards
        for (int i = row-1,j=col; i>=0; i--) {
            if(chess[i][j]==1){
                return false;
            }
        }
        //left diagonal
        for (int i = row-1,j=col-1; i>=0 && j>=0; i--,j--) {
            if(chess[i][j]==1){
                return false;
            }
        }
        //right diagonal
        for (int i = row-1,j=col+1; (i>=0 && j<chess.length); i--,j++) {
            if(chess[i][j]==1){
                return false;
            }
        }
        return true;
    }
    static void n_queens_print(int [][]chess,int row,String qsf){
        if(row==chess.length){
            System.out.println(qsf);
            return;
        }
      for(int col=0;col<chess.length;col++){
          if(isqueenSafe(chess,row,col)==true){
              chess[row][col]=1;
              n_queens_print(chess, row+1, qsf+ row+ "-"+col+",");
              //After the call gets executed we are using backtracking to remove the filled choices
              chess[row][col]=0;
            }
      }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int [][]chess =new int [n][n];
        n_queens_print(chess,0,"");
        sc.close();

    }
}
