#include<bits/stdc++.h>
using namespace std;


void calculateSpan(int price[],int n){
   
//    vector<int> ans;
//     ans.push_back(1);
//     // O(n^2)
//     for(int i=1;i<n;i++){
//        int count=1;
//        for(int j=i-1;j>=0;j--){
//             if(price[j]<=price[i]){
//                 count++;
//             }else{
//                 break;
//             }       
//        }
//         ans.push_back(count);
//    }

    // TIME : O(n) SPACE: O(n) 

    vector<int> ans;
    ans.push_back(1);

    stack<int> s; // we will push the index
    s.push(0);

    for(int i=1;i<n;i++){

        int curr = price[i];

        while(!s.empty() && curr>=price[s.top()]){
            s.pop();
        }

        if(s.empty())
            ans.push_back(i+1);
        else
            ans.push_back(i-s.top()); // because it has the back index which has greater value then curr

    }


    for(int i=0;i<n;i++){
        cout<<ans[i]<<" ";
    }


   
}

int main(){

    int n;
    cout<<"Enter days count : ";
    cin>>n;

    int price[n];
    for(int i=0;i<n;i++){
        cin>>price[i];
    }

    calculateSpan(price,n);
    return 0;
}
