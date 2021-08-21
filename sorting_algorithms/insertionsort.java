public class insertionsort {
    void printarray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");

    }
    void insertion_sort(int []arr,int n){
        int key,j;
        //Loop for passes( i is denoting no of passes)
        for (int i = 1; i <=n-1; i++) {
            key=arr[i];
            //Loop for each pass
            j=i-1;
            //For ascending order
            while (j>=0 && arr[j]>key)
            //descending order 
            // while (j>=0 && arr[j]<key) 
            //j is used for number of comparisons
            {
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
    }

//Driver code
    public static void main(String[] args) {
        int []array={12,54,3,7,21,67,23};
        int n=array.length;
        insertionsort obj=new insertionsort();
        obj.printarray(array);
        obj.insertion_sort(array, n);
        obj.printarray(array);
    }
    
}
