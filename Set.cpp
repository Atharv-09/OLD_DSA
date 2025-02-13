#include<bits/stdc++.h>
using namespace std;

int main(){

    int n= 3;
    int m= 8;
    int arr1[n] = {1,1,2};
    int arr2[m] = {1,1,1,1,2,3,3,4};

    set<int> s1(arr1,arr1+n);
    set<int> s2(arr2,arr2+m);

    vector<int> v1,v2;

    copy(s1.begin(),s1.end(),back_inserter(v1));
    copy(s2.begin(),s2.end(),back_inserter(v2));

    vector<int> :: iterator i,i1;
    vector<int> v3;

    set_union(begin(v1),end(v1),begin(v2),end(v2),back_inserter(v3));

    for(i=v3.begin();i!=v3.end();i++){
        cout<<*i<<" ";
    }
    cout<<"\n";
    // for(int i=0;i<n;i++){
    //     s1.insert(arr1[i]);
    // }
    
    // for(int i=0;i<m;i++){
    //     s2.insert(arr2[i]);
    // }

    // for(auto i=v2.begin();i!=v2.end();i++){
    //     cout<<*i<<" ";
    // }
    return 0;
}