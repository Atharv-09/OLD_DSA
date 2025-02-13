public class 14MissingNoInArray {

    // time : O(nlogn) space : O(!);

    int MissingNumber(int array[], int n) {
        // Your Code Here
        Arrays.sort(array);
        
        for(int i=0;i<n-1;i++){
            
            if(array[i]!=i+1){
                return i+1;
            }
        }
        
        return n;
    }



    // time : O(n) space : O(n);

    int MissingNumber(int array[], int n) {
        // Your Code Here
        int temp[] = new int[n];
        
        Arrays.fill(temp,0);
        
        for(int i=0;i<n-1;i++){
            
            temp[array[i]-1] = 1;
            
        }
        
        for(int i=0;i<n;i++){
            if(temp[i]==0){
                return i+1;
            }
        }
        return -1;
    }

    // time : o(N) space : O(!);
    // SELF 
    void swap(int a,int b,int arr[]){
        
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    int MissingNumber(int array[], int n) {
        // Your Code Here
        
        int i=0;
        while(i<n-1){
            
            int currVal = array[i];
            
            // if currvalue in array is 0 or arraylast value so we will skip 
            if(currVal==0 || currVal==n){
                i++;
            }
            
            else if(currVal==(i+1)){ // if we are at that place already where we swapand do it 0
            // so direct make 0 
                array[i] = 0;
                i++;
            }
            
            else{
                
                int ind = array[i]-1;
                swap(i,ind,array);
                array[ind]=0;
                
            }
            
    
        }
        
        for(i=0;i<n-1;i++){
            
            if(array[i]!=0){
                return i+1;
            }
        }
        
        return n;
    }

        // SUMMATION TECH 
        //time : O(n) space : O(!) 
        public static int
    findDisappearedNumbers(int[] nums)
    {
        int n=nums.length;
        int sum=((n+1)*(n+2))/2;
        for(int i=0;i<n;i++)
          sum-=nums[i];
        return sum;
    }
    }
}
