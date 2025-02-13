class Main{

    // time : O(n^2) space : O(1)


    ArrayList<Integer> ans = new ArrayList<>();
        
        
    int s = -1;
        int e = -1;
        int curr = -1;
        
        for(int i=0;i<n;i++){
            curr=arr[i];
            s = i;
            for(int j=i+1;j<=n;j++){
              
                    
                    if(curr==sum){
                        ans.add(s+1);
                        ans.add(e);
                        return ans;
                    }
                    if(curr>sum){
                        break;
                    }

                    curr = curr + arr[j];
            }
            
        }

        ans.add(-1);
        return ans;

    /////////////////////////
        // time : O(n) space : O(1) 

        static ArrayList<Integer> subarraySum(int[] arr, int n, int sum) 
    {
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        
        int total = arr[0];
    
        int sIndex=0,eIndex=-1;
        
        for(int i=1;i<=n;i++){
            
            
            while(total>sum && sIndex<i-1){
                
                total = total-arr[sIndex];
                sIndex++;
            
            }
            
            if(total == sum){
                eIndex = i-1;
                ans.add(sIndex+1);
                ans.add(eIndex+1);
                break;
            }
            
           
            if(i<n){
                
                total = total+arr[i];
            }
        }
        
        if(ans.isEmpty())
            ans.add(-1);
        
        return ans;
    }

}