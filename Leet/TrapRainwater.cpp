#include<bits/stdc++.h>
using namespace std;

int trap(vector<int> hei){

    int n = hei.size();
    int total=0;

    int left[n];

    left[0] = hei[0];
    // int ans=left[0];
    for(int i=1;i<n;i++){
        left[i] = max(hei[i],left[i-1]);    
    }

    int right[n];
    right[n-1] = hei[n-1];
    for(int i=n-2;i>=0;i--){
        right[i] = max(hei[i],right[i+1]);
    }
    
    for(int i=0;i<n;i++){
        total+= (min(left[i],right[i]) - hei[i]);
    }
    return total;
}
int main(){

    vector<int> v1 = {4,2,0,3,2,5};
    int totalHeight = trap(v1);
    // trap(v1);
    cout<<totalHeight<<"\n";
    return 0;

}
/* int lmax=0,rmax=0, left=0, right=height.size()-1, water=0;
    while(left < right)
    {
        if(height[left]<= height[right])
        {
            lmax=max(lmax, height[left]);
            water+= lmax - height[left];
            left++;
        }
        else
        {
            rmax=max(rmax, height[right]);
            water+= rmax - height[right];
            right--;
        }
    }
    return water;*/