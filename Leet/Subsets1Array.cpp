#include<bits/stdc++.h>
using namespace std;
void subsets(vector<int> nums){
    
        vector<vector<int>> ans;
        vector<int> v1;
        
        int n = nums.size();
        
        ans.push_back({});
                
        
        int p1 = 0;
        int p2 = 1,key=0;

        for(int i=0;i<n;i++){
            v1.push_back(nums[i]);
            ans.push_back(v1);
            v1.clear();
        }
        // for(int i=0;i<n;i++){
        while(p1<p2){
                
                while(p2>p1){
                    v1.push_back(nums[p1]);
                    v1.push_back(nums[p2]);
                    ans.push_back(v1);
                    v1.clear();
                    if(p2 == n-1){
                        p1++;
                    }
                    if(p2!=n-1)
                        p2++;    
                }
                
        //     if(p1==p2 || p2>p1){
             
        //         v1.push_back(nums[p2]);
        //         ans.push_back(v1);
        //         v1.clear();
        //         if(p1==p2 && p2!=n-1){
        //             p2++;
        //             // key =1 ;
        //         }
        //         // key = 1;
        //     }
        //     if(p2>p1){
        //         v1.push_back(nums[p2]);
        //         ans.push_back(v1);
        //         v1.clear();
        //         v1.push_back(nums[p1]);
        //         v1.push_back(nums[p2]);
        //         ans.push_back(v1);
        //         if(p2!=n-1)
        //              p2++;
                    
        //     }
        //     v1.clear();
        //     if(p2==n-1){
        //             p1++;
        //     }

        //     if(ans.size() == 2^n){
        //         break;
        //     }     
        }
        ans.push_back(nums);
    
        for(int i=0;i<ans.size();i++){
            for(int j=0;j<ans[i].size();j++){
                cout<<ans[i][j]<<" ";
            }
            cout<<"\n";
        }
}
int main(){

    vector<int> v = {1,2,3,4};
    cout<<"\n";
    subsets(v);
    return 0;
}