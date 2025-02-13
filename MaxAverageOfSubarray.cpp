#include<bits/stdc++.h>
using namespace std;

void findMaxAverage(vector<int>& nums, int k) {
            
             
            double ans=INT_MIN;
            double avgUpto ;
            int sum=0,strt=0;
            
            for(int i=0;i<nums.size();i++){
                    
                sum = sum + nums[i];
                
                if(i>=k-1){
                    
                    avgUpto  = (double)sum/k;
                    
                    if(avgUpto>ans){
                        ans = avgUpto;
                    }
                    sum = sum - nums[strt];
                    strt++;
                }
                
            }
        
            
//             for(int i=0;i<=nums.size()-k;i++){ // 0<2
                
//                 // int sum = nums[i];
                
//                 for(int j=i;j<k+i;j++){
//                     sum =sum+ nums[j];
//                 }
//                 avgUpto = (double)sum/k;
                
//                 if(avgUpto>ans){
//                     ans = avgUpto;
//                 }
                
//                 sum = 0;
//             }
            
            
        cout<< ans<<"\n";
    }   

int main(){

    vector<int> v1 = {1,12,-5,-6,50,3};

    findMaxAverage(v1,4);
}

