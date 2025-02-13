#include<bits/stdc++.h>
using namespace std;
void nextLargerElement(vector<long long> arr1, int n){
    // Your code here
    
    long long arr[n];
    
    copy(arr1.begin(),arr1.end(),arr);
    
    long long ans[n];
    stack<int> s;
    
    s.push(0);
    int ele;
    for(int i=1;i<n;i++){
            
        if(!s.empty()){
            
            
                int ele = s.top();
                s.pop(); // 1
                while(arr[i]>arr[ele]){
                    ans[ele] = arr[i];
                    if(s.empty()) break;
                    ele = s.top();
                    s.pop();
                }

                if(arr[i]<arr[ele]){
                    s.push(ele);
                }
        }
        s.push(i);
        
    }
    
    while(!s.empty()){
        int t = s.top();
        ans[t] = -1;        
        s.pop();
    }
    for(int i=0;i<n;i++){
        cout<<ans[i]<<" ";
    }
    // vector<long long> sol(n);
    
    // for(int i=0;i<n;i++){
    //     sol.push_back(ans[i]);
    // }

    // O(n^2)
    // for(int i=0;i<n-1;i++){
    //     long long curr = arr[i];
    //     bool found=false;
    //     for(int j=i+1;j<n;j++){
    //         if(arr[j]>curr){
    //             ans.push_back(arr[j]);
    //             found=true;
    //             break;
    //         }
    //     }
    //     if(found==false)
    //         ans.push_back(-1);
    
    // }
    // ans.push_back(-1);
    //return sol;
}
int main(){

    vector<long long> vec = {6,8,0,1,3};
    int n = 5;
    //vector<long long> ans = 
    nextLargerElement(vec,n);

    
    cout<<"\n";

    return 0;
}