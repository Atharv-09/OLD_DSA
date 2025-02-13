class Main{


    //time : O(nlogn) space : O(1) space : O()

    void swap(int ind,int arr[]){
        
        for(int i=ind;i<arr.length-1;i++){
            arr[i] = arr[i+1];
        }
    }
    int remove_duplicate(int A[],int N){
        // code here
        
        int ele = A[0];
        int size = N;
        
        for(int i=1;i<N;i++){
            if(A[i]==ele){
                swap(i,A);
                i--;
                N--;
                size--;
            }else{
                ele = A[i];
            }
        }
        return size;
    }

    // time : O(N) space : O(n) 
    /*
    1.take dum array 
    2.from o to n in array 
        check if curr ele is not eql next ele 
                    put that ele in dum array 
                    increment dum array counter;

        copy th dum array into org array 
    */

    int remove_duplicate(int a[],int n){
       
       
        int temp[]=new int[n];
         int j=0;
         
        for(int i=0;i<n-1;i++){
            if(a[i]!=a[i+1]){
                temp[j] = a[i];
                j++;
            }
        }
        temp[j++] = a[n-1];
        for(int i=0;i<n;i++){
            a[i]=temp[i];
        }
        return j;
    
        
     }


     //time : O(n) space : O(1) space : O()

     int remove_duplicate(int a[],int n){
        // code here
        
       
       int j = 0;
       
        for(int i=0;i<n-1;i++){
            
            if(a[i]!=a[i+1]){
                a[j] = a[i];
                j++;
            }
        }
        
        a[j++] = a[n-1];
        return j;
    
    }
}