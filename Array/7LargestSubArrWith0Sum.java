public class 7LargestSubArrWith0Sum {
    
    // time : O(n^2) space : O(1) 

    int maxLen(int arr[], int n)
    {
        // Your code here
        
        int currHighRank =0;
        
        for(int i=0;i<n;i++){
            
            int totalSum = 0;
            
            for(int j=i;j<n;j++){
                
                totalSum += arr[j];
                if(totalSum == 0){
                    int len = j-i+1;
                    currHighRank = Math.max(len,currHighRank);
                }
            }
        }
        
        return currHighRank;
    }


    // time : O(n) space : O(n) 

    int maxLen(int arr[], int n)
    {
        // Your code here
        
        
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        
        int sum=0 ,maxLen = 0;
        
        for(int i=0;i<n;i++){
            
            
            sum += arr[i] ;
            
            if(arr[i]==0 && maxLen==0){
                maxLen = 1;
            }
            
            if(sum==0)
                maxLen = i+1;
                
            
            Integer prevI = map.get(sum);
            
            if(prevI==null){
                map.put(sum,i);
            }else{
                int currmaxL = i-prevI;
                maxLen = Math.max(maxLen,currmaxL);
            }
        }
        return maxLen;
    }
}
