public class array2d_print {
public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter rows and columns");
    int r=sc.nextInt();
    int c=sc.nextInt();
  int [][] arr=new int[r][c];
  for(int i=0;i<r;i++){
      for (int j = 0; j < c; j++) {
          arr[i][j]=sc.nextInt();
      }
  }
  for(int i=0;i<r;i++){
    for (int j = 0; j < c; j++) {
       System.out.print(arr[i][j]+" ");
    }
    System.out.println("");
}
}
    
}