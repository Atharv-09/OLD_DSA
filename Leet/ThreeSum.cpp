
#include<bits/stdc++.h>
using namespace std;

vector<vector<int>> threeSum(vector<int>& arr) {
        

//1092 ms 181.7 mb
            sort(arr.begin(),arr.end());

            set<vector<int>> ans;
             
            int n = arr.size();
            
            if(n <=2 ){ 
                return vector<vector<int>>();
            }
            
            
            for(int i = 0;i<n-2;i++){
                
                int s = i;
                int m = i+1;
                int e = n-1;
                
                while(m<e){
                    
                    int sum = arr[s]+arr[m]+arr[e];
                     if(sum > 0){
                        e--;
                    }else if(sum <0){
                        m++;
                    }else{
                          
                            ans.insert(vector<int>({arr[s],arr[m],arr[e]}));
                            m++;
                            e--;
                     }
                }
                
            }
            
       
           return vector<vector<int>>(ans.begin(),ans.end());
// //if size is less than 3 we can not find three unique elements
// 160 ms 33.6mb
//         if(nums.size()<3) return {};
//       vector<vector<int>>ans;
//         sort(nums.begin(),nums.end());
//         for(auto i=0;i<nums.size()-2;i++){
//             //to handle duplicates
//             if(i==0 || (i>0 && nums[i]!=nums[i-1])){
//                 int start=i+1;
//                 int end=nums.size()-1;
//                 while(start<end){
//                     vector<int>v;
//                       if(nums[i]+nums[start]+nums[end]==0){
//                           v.push_back(nums[i]);
//                           v.push_back(nums[start]);
//                           v.push_back(nums[end]);
//                           //to handle duplicates 
//                           while(start<end && nums[start]==nums[start+1]) start++;
//                           while(start<end && nums[end]==nums[end-1]) end--;
//                           ans.push_back(v);
//                           start++;
//                           end--;
//                       }
//                         else if( nums[i]+nums[start]+nums[end]>0){
//                             end--;
//                         }else if(nums[i]+nums[start]+nums[end]<0){
//                             start++;
//                         }
//                 }
//             }
//         }
//         return ans;

}
     
        


int main(){

    vector<int>  ar = {-1,0,1,2,-1,-4};

    vector<vector<int>> ans;

    ans = threeSum(ar);

    for(int i=0;i<ans.size();i++){
        for(int j=0;j<ans[i].size();j++){
            cout<<ans[i][j]<<" ";
        }
        cout<<"\n";
    }


}