#include<bits/stdc++.h>
using namespace std;
void findMaxWater(vector<int> height){
    
    int n = height.size(); // 9
    
    int l = height[0];// 0
    int h = height[n-1]; // 8
    
    // int k = n-1;
    int  minHei=0,ans=0,maxWater=0;

    for(int i=0;i<n;i++){
        
          if(l<h){
            minHei = min(height[l],height[h]);

            ans = (h-l)*minHei;
            maxWater = max(maxWater, ans);

            if(height[l]<height[h]){
                l++;
            }else{
                h--;
            }
        }
    }

    // int ans=0,maxWater=0,min;
    // for(int i=0;i<height.size()-1;i++){
    //     int low = height[i];
    //     int high = height[height.size()-1];

    //     if(low<high){
    //         min = low;
    //     }else{
    //         min = high;
    //     }
    //     // cout<<min<<" ";
    //     for(int j=i+1;j<height.size();j++){

    //             maxWater = maxWater+min;

    //     }
        
    //     ans = max(ans,maxWater);
    //     maxWater = 0;
    // }
    /* O(n^2) 
        int n = height.size();
        int ans=0,min1,maxWater=0;
        
        for(int i=0;i<n-1;i++){
            
            
            
            
            for(int j=i+1;j<n;j++){
                int low = height[i];
                int high = height[j];
                min1 = min(low,high);
                maxWater = (j-i)*min1;     
                ans = max(maxWater,ans);
            }
            
            
            maxWater = 0;
        }
        return ans;*/
    cout<<maxWater<<"\n";
}
int main(){

    vector<int> hei = {1,8,6,2,5,4,8,3,7};

    findMaxWater(hei);

    return 0;
}