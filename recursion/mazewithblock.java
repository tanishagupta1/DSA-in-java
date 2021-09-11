import java.util.Scanner;

public class mazewithblock {
    // possible moves top left down right
    // Cannot pass from the same block twice
    // cannot go on the blocked squares denoted by 1
    static void mazewithhindrance(int[][] maze, int col, int row,String psf,boolean[][] visited) {
        if((row<0) || (col<0) || (col==maze[0].length) || (row==maze.length) || maze[row][col]==1||visited[row][col]==true){
            return;
        }
        if (row==maze.length-1 && col==maze[0].length-1) {
            System.err.println(psf);
            return;
        }
        //Check the block once visited
        visited[row][col]=true;
        //top                      
         mazewithhindrance(maze, col, row-1,psf+"t",visited);
         //left
         mazewithhindrance(maze, col-1, row,psf+"l",visited);
         //down
         mazewithhindrance(maze, col, row+1,psf+"d",visited);
         //right
         mazewithhindrance(maze, col+1, row,psf+"r",visited);
         //Uncheck the block after all the calls for making room for other paths
         visited[row][col]=false;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter rows and columns");
        int r=sc.nextInt();
        int c=sc.nextInt();
      int [][] arr=new int[r][c];
      boolean [][] visited=new boolean[r][c];

      for(int i=0;i<arr.length;i++){
          for (int j = 0; j < arr[0].length; j++) {
              arr[i][j]=sc.nextInt();
          }
      }
    mazewithhindrance(arr, 0, 0, "",visited);
    sc.close();
    }
}
