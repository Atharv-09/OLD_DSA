public class 13UnionOf2sortedArr {


    // time : O() space : O()
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        int i=0,j=0;
        int lastRep = -1;
        ArrayList<Integer> ans = new ArrayList<>();
        
        while(i<n && j<m){
            
            if(arr1[i]==arr2[j]){
                lastRep = arr1[i];
                ans.add(arr1[i]);
                i++;
                j++;
            }else if(arr1[i]>arr2[j] && lastRep!=arr2[j]){
                
                lastRep = arr2[j];
                ans.add(arr2[j]);
                j++;
            }else if(arr1[i]>arr2[j] && lastRep!=arr1[i]){
                
                lastRep = arr1[i];
                ans.add(arr1[i]);
                i++;
            }
        }
        
        
        while(i<n){
            ans.add(arr1[i++]);
        }
        
        while(j<m){
            ans.add(arr2[j++]);
        }
        
        return ans;
    }
    
}
