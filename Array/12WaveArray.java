public class 12WaveArray {

    //time : O(n)  space : O(1) ;
    // element given sorted array 
   //  func(arr,n) 

    for(int i=0;i<n-1;i+=2){
            
        int temp = arr[i];
        arr[i] = arr[i+1];
        arr[i+1] = temp;
        
    }
    
    // if element given is not sorted 
    // time : O(n) space : O(1) ;


    static void swap(int a,int b,int arr[]){
        
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        
    }
    public static void convertToWave(int arr[], int n){
        
        // Your code here
        //loop in the even element 

        // 1 . we check the curr element if less then its next element then swap them swap(curr,next); 
        // 2. and then if the i>0 mean i is not at index 0 then it check that its prev element is less then it 
        // if prev element if greater then curr then it will swap(prev,curr)
        for(int i=0;i<n;i+=2){
            
            
            if(i<n-1 && arr[i+1]>arr[i]){
                swap(i+1,i,arr);
            }    
        
            if(i>0 && arr[i-1]>arr[i]){
                swap(i-1,i,arr);
            }
        
        }
        
    }

}
