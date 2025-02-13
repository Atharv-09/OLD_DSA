public class 9IndexOfExtraElement {
    

    // time : O(n) space : O(1) 

    public int findExtra(int a[], int b[], int n) {
        // add code here.
        
        for(int i=0;i<n;i++){
            
            if(b.length==i){
                return b.length;
            }
            if(a[i]!=b[i]){
                return i;
            }
            
            
        }
        
        return -1;
    }

    // time : O(logn) space : O(1) 
    // FIRST CODE BY SELF :) 
    int bin(int[] a,int[] b,int n,int l,int h){
        
        int mid = l+(h-l)/2;
        
        if(a[mid]==b[mid] && mid<=n){
        //right 
            return bin(a,b,n,mid+1,h);
        
        }else if(a[mid]!=b[mid] && a[mid-1]==b[mid-1] && a[mid+1]==b[mid]){
        
            return mid;
       
        }else if(a[mid]!=b[mid] && mid>=l){
        
            return bin(a,b,n,l,mid-1);
        
        }
    
        return -1;
    }
    
    
    public int findExtra(int a[], int b[], int n) {
        // add code here.
        if(a[0]!=b[0]){
            return 0;
        }
        if(a[n-1]!=b[n-2]){
            return n-1;
        }
     
        return bin(a,b,n,0,n-1);   
    }



    //time : O(logn) space  :O(1) 
    public int findExtra(int a[], int b[], int n) {
        
        int l = 0;
        int r =  n-1;
        int index = n;
        //if both last element is different 
        if(a[n-1]!=b[n-2]){
            return n-1;
        }
        while(l<=r){
            
            int mid = (l+r)/2;
         
             if(a[mid] == b[mid] ){
                 // id both mid are same so th extra element is on right half
                 l = mid+1;
             }else{
                 // id mid is diff then 
                 //1 extra element is that mid element or 
                 //2 extra elemtn id on the left half 
                 index = mid;
                 r = mid-1;
                 
             }
            
        }
        return index;
     }
}
