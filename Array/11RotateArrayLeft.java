public class 11RotateArrayLeft {

    //time : O(n) space : O(d) 

    static void rotateArr(int arr[], int d, int n)
    {
        // add your code here
        
        int temp[] = new int[d];
        
        for(int i=0;i<d;i++){
            temp[i] = arr[i];
        }
        
        int ind = 0;
        
        for(int i=d;i<n;i++){
            arr[ind++] = arr[i];
        }
        
        for(int i=0;i<d;i++){
            arr[ind++] = temp[i];
        }
        
        
    }
    
    // ROTATE ARRAY ONE BY ONE 
    // time :O(n*d) space : O(1) 

    void rotateArr(int arr[], int d, int n)
    {
        for (int i = 0; i < d; i++)
            leftRotatebyOne(arr, n);
    }

    void leftRotatebyOne(int arr[], int n)
    {
        int i, temp;
        temp = arr[0];
        for (i = 0; i < n - 1; i++)
            arr[i] = arr[i + 1];
        arr[n-1] = temp;
    }
}
