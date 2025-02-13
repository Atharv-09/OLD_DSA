import java.util.*;

//NOT DONE 
class Main{

    static mergerKSortedArrays(int arr[][],int n){

        MinHeap[] mh = new MinHeap[n];

        int res = 0;
        for(int i=0;i<arr.length;i++){

            MinHeap node = new MinHeap(a)

        }
    }
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter row : ");
        int n = sc.nextInt();
        System.out.println("Enter col : ");
        int k = sc.nextInt();

        int arr[][] = new int[n][k];

        for(int i=0;i<n;i++){
            for(int j=0;j<k;j++){
                arr[i][j] = sc.nextInt();
            }
        }

        mergerKSortedArrays(arr,arr.length);

    }
}