public class 5EquilibriumPoint {


//-------------------------------- TIME : O(n^2) space : O(1) ---------------------
        int j,leftSum,rightSum;
        
        for(int i=0;i<n;i++){
            
            //left side sum 
            
            leftSum = 0;
            for(j=0;j<i;j++){
                leftSum += arr[j];
            }
            
            //right side sum 
            rightSum = 0;
            for(j=i+1;j<n;j++){
                rightSum += arr[j];
            }
            
            // check if right and lefr sum are equl 
            
            if(leftSum==rightSum){
                return i+1;
            }
        }
        return -1;

        // ----------------------------TIME : O(n) space : O(1) 
        // take the total sum of array 
        // here basically we will go through the array from 0 and as assuse the curr ele is mid so 
        // we will store totalrightsum - currele so it willl give the right elements sum 
        // check if right sum is eqaul to left sum 
        // left sum will be added with the currele value 
        int totalSum = 0;
        for(int i=0;i<n;i++)
            totalSum += arr[i];
        
        int leftSum = 0;
        
        for(int i=0;i<n;i++){
            
            // to get right sum of the curr index 
            
            totalSum -= arr[i];
            
            if(totalSum == leftSum){
                return i+1;
            }
            
            leftSum += arr[i];    
        }
        return -1;
        

        // ------------------tIme: O(n) space : O(n) space : O()


        long lef[] = new long[n];
        long rig[] = new long[n];
        
        lef[0] = arr[0];
        rig[n-1] = arr[n-1];
        
        for(int i=1;i<n;i++){
            
            lef[i] = lef[i-1]+arr[i];    
        }
        
        for(int j=n-2;j>=0;j--){
            
            rig[j] = rig[j+1]+arr[j];
        }
        
        for(int i=0;i<n;i++){
            
            if(lef[i]==rig[i]){
                return i+1;
            }
        }
        return -1;


        //----------------------------- time : O(logn) spcae : O(!) 
        static int binSearch(long[] arr,int n){
        
            int mid = n/2;
            
            long ls=0,rs=0;
            
            for(int i=0;i<mid;i++){
                ls += arr[i];
            }
            
            for(int j=mid+1;j<n;j++){
                rs += arr[j];
            }
            
            if(rs>ls){
                
                while(rs>ls && mid<n-1){
                    rs = rs-arr[mid+1];
                    ls = ls+arr[mid];
                    mid++;
                }
                
            }else{
                
                while(ls>rs && mid>0){
                    
                    rs = rs + arr[mid];
                    ls = ls - arr[mid-1];
                    mid--;
                }
                
            }
            
            if(ls==rs) return mid+1;
            else return -1;
            
        }
        public static int equilibriumPoint(long arr[], int n) {
            
           return binSearch(arr,n);
        
        }
}
