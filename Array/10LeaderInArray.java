public class 10LeaderInArray {


    // time : O(n^2) space : O(1) 

    ArrayList<Integer> ans = new ArrayList<Integer>();
        
    for(int i=0;i<n;i++){
        
        int curr = arr[i];
        boolean leader = false;
        for(int j=i+1;j<n;j++){
            
            if(curr>=arr[j]){
                leader = true;
            }else{
                leader=false;
                break;
            }   
        }
    
        if(leader) ans.add(curr);
        
    }
    ans.add(arr[n-1]);
    return ans;

    // time : O(n) space : O(n) [[SELF]]

        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        int temp[] = new int[n];
        
        int currMax = Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--){
            
            temp[i] = Math.max(currMax,arr[i]);
            currMax = temp[i];
            
        }
        
        for(int i=0;i<n;i++){
            
            if(arr[i]==temp[i]){
                ans.add(arr[i]);
            }
        }
        // ans.add(arr[n-1]);
        return ans;
    

    //time : O(n) space : O(1) 

    static ArrayList<Integer> leaders(int arr[], int n){
        // Your code here
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        int maxFromRig = arr[n-1];
        
        for(int i=n-2;i>=0;i--){
            
            if(arr[i]>maxFromRig){
                maxFromRig = arr[i];
                ans.add(maxFromRig);
            }
        }
        ans.add(arr[n-1]);
        return ans;
    }
}
