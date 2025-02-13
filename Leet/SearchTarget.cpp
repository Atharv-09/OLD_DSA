#include<bits/stdc++.h>
using namespace std;

 bool search(vector<int>& nums, int target) {

        int n = nums.size();
        int l = 0;
        int h = n-1;

        while(l<=h){

            int m = l+(h-l)/2;

            if(nums[m]==target){
                return true;
            }

            if(nums[m] == nums[h]){
                h--;
            }else{
                    if(target<=nums[h] && target>nums[m]){
                        l = m+1;
                    }else{
                        h = m-1;
                    }
            }

        }   

        return false;
 }
int main(){

    vector<int> nums = {2,5,6,0,0,1,2};
    int target = 11; // found 

    bool ans = search(nums,target);

    cout<<ans<<"\n";
    return 0;
}