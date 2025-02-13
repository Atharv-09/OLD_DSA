class Main{
    
// time : n space : O(1) 
int transitionPoint(int arr[], int n) {
    // code here
    
    int ans = -1;
    for(int i=0;i<n;i++){
        
        if(arr[i]==1){
            ans = i;
            break;
        }
    }
    
    return ans;
}

// time : O(logn) space : O(1) 

int lastMid1 = -1;
    
    void binSearch(int[] arr,int l,int r){
        
        int mid = l+((r-l)/2);
        
        if(l>r) return ;
        if(l==r && arr[l]==1){
            lastMid1 = l;
            return;
        }
        if(arr[mid]==1){
            //left jao
            lastMid1 = mid;
            binSearch(arr,l,mid);
        }else if(arr[mid]==0){
            //right jao
            binSearch(arr,mid+1,r);
        }
        
        
    }
    
    int transitionPoint(int arr[], int n) {
        // code here
        binSearch(arr,0,n-1);
        return lastMid1;
    }



}