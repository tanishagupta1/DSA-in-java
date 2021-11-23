import java.util.Scanner;

public class min_costpath {
//in a grid we need to reach a point b from point a adding all the numbers in the way and reukt the minimum cost
    static int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];

        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[0].length - 1; j >= 0; j--) {

                // last cell
                if (i == dp.length - 1 && j == dp[0].length - 1) {
                    dp[i][j] = grid[i][j];
                }
                // last row
                else if (i == dp.length - 1) {
                    dp[i][j] = dp[i][j + 1] + grid[i][j];
                }
                // last column
                else if (j == dp[0].length - 1) {
                    dp[i][j] = dp[i + 1][j] + grid[i][j];
                } else {
                    //minimum from succeeding row or column 
                    dp[i][j] = (Math.min(dp[i + 1][j], dp[i][j + 1]) + grid[i][j]);
                }

            }
        }
        return dp[0][0];
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        int m=sc.nextInt();
        int n=sc.nextInt();

        int [][] grid =new int [m][n];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j]=sc.nextInt();
            }
        }
        int ans=minPathSum(grid);
        System.out.println(ans);
        sc.close();
    }

}
