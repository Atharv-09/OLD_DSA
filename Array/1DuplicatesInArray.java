

// time - > nlogn space - > O(1) but to store ans space : O(n);

public static ArrayList<Integer> duplicates(int arr[], int n) {
    // code here
    
    ArrayList<Integer> ans= new ArrayList<Integer>();
    
    Arrays.sort(arr);
    int currRep = -1;
    
    for(int i=1;i<n;i++){
        
        if(arr[i]==arr[i-1] && currRep!=arr[i]){
            currRep = arr[i];
            ans.add(currRep);
        }
        
    }
    
    if(ans.isEmpty()){
        ans.add(-1);
        return ans;
    }else
    return ans;
}

// time - > O(n) space - > O(n);

public static ArrayList<Integer> duplicates(int arr[], int n) {
    // code here
    // here instead of array we can use hashmap also 

    ArrayList<Integer> ans= new ArrayList<Integer>();
    
    int dup[] = new int[n];
    
    Arrays.fill(dup,0);
    
    
    for(int i=0;i<n;i++){
        
        dup[arr[i]]++;    
       
    }
    
    for(int i=0;i<n;i++){
        
        if(dup[i]>=2){
            ans.add(i);
        }
    }
    
    if(ans.isEmpty()){
        ans.add(-1);
        return ans;
    }else
    return ans;
}


// time : O(n) space :O(1) only O(n) to store ans 

public static ArrayList<Integer> duplicates(int arr[], int n) {
    // code here
    
    ArrayList<Integer> ans= new ArrayList<Integer>();
    
    
    for(int i=0;i<n;i++){
        
        int eleNo = arr[i]%n;
        arr[eleNo] = arr[eleNo] + n;
        
    }
    
    for(int i=0;i<n;i++){
        
        int currRem = arr[i]/n;
        
        if(currRem>1){
            ans.add(i);
        }
    }
  
    if(ans.isEmpty()){
        ans.add(-1);
        return ans;
    }else
    return ans;
}