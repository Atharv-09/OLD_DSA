public class 8SortArrof012s {
    

    // time : O(nlogn) space : O(!) 

    // simple sort function


    // time : o(N) space : O(1) 

        int cnt0=0,cnt1=0,cnt2=0;
        
        for(int i=0;i<n;i++){
            
            if(a[i]==0){
                cnt0++;
            }else if(a[i]==1){
                cnt1++;
            }else{
                cnt2++;
            }
        }
        
        int i=0;
            
            while(cnt0!=0){
                a[i++] = 0;
                cnt0--;
            }
            
            while(cnt1!=0){
                a[i++] = 1;
                cnt1--;
            }
            while(cnt2!=0){
                a[i++] = 2;
                cnt2--;
            }

    //time : O(n) space: O(1) 


    static void swap(int a,int b,int arr[]){
        
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        
    }
    public static void sort012(int a[], int n)
    {
        // code here 
        
        int l=0,mid=0;
        int h=n-1;
        
        while(mid<=h){
            
            if(a[mid]==0){
                swap(l,mid,a);
                mid++;
                l++;
            }else if(a[mid]==1){
                mid++;
            }else{
                swap(h,mid,a);
                h--;
            }
        }
    
    }
}
