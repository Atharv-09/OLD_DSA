#include<bits/stdc++.h>
using namespace std;
void threeSumClosest(vector<int> nums, int target) {
        
        int n = nums.size();
        int arr[n];

        copy(nums.begin(),nums.end(),arr);

        int l=0;
        int sumV[n];

        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                for(int k=j+1;k<n;k++){
                    
                    sumV[l] = arr[i]+arr[j]+arr[k];            
                    l++;
                }
            }
        }
        // for(int i=0;i<n;i++){
        //     cout<<sumV[i]<<" ";
        // }
        int diff[n];
        
        for(int i=0;i<n;i++){
            if((sumV[i]-target) > 0){
                diff[i] = sumV[i]-target;
            }else{
                diff[i] = -(sumV[i]-target);
            }
        }
        
        int ans = INT_MAX,indexM=0;
        for(int i=0;i<n;i++){
            if(diff[i]<ans){
                ans = diff[i];
                indexM = i;
            }
        }
        // ans = *min_element(diff.begin(),diff.end());
        
        cout<<sumV[indexM]<<" ";
}
int main(){

    vector<int> v1 = {1,1,-1,-1,3};
    
    threeSumClosest(v1,1);

    // cout<<ans<<"\n";
    return 0;
}