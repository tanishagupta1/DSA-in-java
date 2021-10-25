package backtracking;

import java.util.Scanner;

public class sudokusolverclass {

    static boolean isValid(int [][]board,int nrow,int ncol,int possible_outcome){
       //Checking the column (column is fixed the row is increasing) 
        for(int i=0;i<board.length;i++){
            if (board[i][ncol]==possible_outcome) {
                return false;
            }
        }
        // checking the row(row is fixed and the column is increasing)
        for(int i=0;i<board[0].length;i++){
            if (board[nrow][i]==possible_outcome) {
                return false;
            }
        }
        //grid check
        int smr= 3*nrow/3;
        int smc= 3*ncol/3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(board[smr+i][smc+j]==possible_outcome){
                    return false;
                }
            }
        }
        return true;
    }

    static void solvesudoku(int[][] board, int row, int col) {
        int ni = 0;
        int nj = 0;
        if (col == board.length - 1) {
            ni = row + 1;
            nj = 0;
        } else {
            ni = row;
            nj = col + 1;
        }
        if (board[ni][nj] != 0) {
            solvesudoku(board, ni, nj + 1);
        } else {
            for (int po = 1; po <= 9; po++) {
                if (isValid(board, ni, nj, po) == true) {
                    board[row][col] = po;
                    solvesudoku(board, ni, nj);
                    board[row][col] = 0;
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] board = new int[r][c];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < c; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        solvesudoku(board, 0, 0);
        sc.close();
    }
}
