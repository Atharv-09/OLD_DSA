#include<bits/stdc++.h>
using namespace std;
int start(vector<int> v1,int target,int l,int h){
        int found=-1;
        
        while(l<=h){
            
            int m = l + (h-l)/2;
            
            if(v1[m] == target){
                found = m;
                h = m-1;
            }else if(v1[m]>target){
                h = m-1;
            }else{
                l = m+1;
            }
           
        }
        
        return found ;
 }

int end(vector<int> v1,int target,int l,int h){
        int found=-1;
        
        while(l<=h){
            
            int m = l + (h-l)/2;
            
            if(v1[m] == target){
                found = m;
                l = m+1;
            }else if(v1[m]>target){
                h = m-1;
            }else{
                l = m+1;
            }
           
        }
        
        return found ;
}
vector<int> searchRange(vector<int> nums,int target){

        vector<int> ans;
        // ans.push_back(-1);
        // ans.push_back(-1);
        
        int n = nums.size();
        
        if(n==0){
            return ans;
        }
        
        int startI=0,endI=0;
        // int key = 0;
        // ans.clear();
            
        int s = start(nums,target,0,n-1);
        int e = end(nums,target,0,n-1);
            
        ans.push_back(s);
        ans.push_back(e);
        
        return ans;




}

int main(){

    vector<int> nums = {5,7,7,8,8,10};
    vector<int> ans = searchRange(nums,8);

    for(int i=0;i<ans.size();i++){
        cout<<ans[i]<<" ";
    }

    return 0;
}