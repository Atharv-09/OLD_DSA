class Main{

    // time : O(n) space : O(1);

    public int peakElement(int[] arr,int n)
    {
       //add code here.
       
       int peIndex = 0;
       int peEle = arr[0];
       
       
       for(int i=1;i<n;i++){
                
          if(arr[i]>peEle){
              peEle = arr[i];
              peIndex = i;
          } 
       }
       return peIndex;
    }

    // time  : O(n) space : O(1) space : O()

    public int peakElement(int[] arr,int n)
    {
      
       if(arr.length==2){
           if(arr[0]>=arr[1]){
               return 0;
           }else if(arr[0]<arr[1]){
               return 1;
           }
       }
       if(arr.length==1){
           return 0;
       }
       
       if (arr[n - 1] >= arr[n - 2])    
            return n - 1;
            
       for(int i=1;i<n-1;i++){
           
           if(arr[i]>arr[i-1] && arr[i]>arr[i+1]){
               return i;
           }
           
       }
       return 0;
    }


    // time : O(logn) space : O(1) 

    int binSearch(int[] arr,int l,int r,int n){
	   
        int mid = l+(r-l)/2;
        
        if((mid==0 || arr[mid-1]<=arr[mid]) && (mid==n-1 || arr[mid+1]<=arr[mid])){
            
           // System.out.println(arr[mid]);
            return mid;
           
        }
        
        //mid is not peak 
        else if(mid>0 && arr[mid-1]>arr[mid]){
            return binSearch(arr,l,mid-1,n); // got to left side 
        }else{
            //right half 
            return binSearch(arr,mid+1,r,n);
        }
   
    }
    public int peakElement(int[] arr,int n)
    {
    //add code here.
    
        return binSearch(arr,0,n-1,n);
        
    }




}