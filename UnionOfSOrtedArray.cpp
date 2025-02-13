#include<bits/stdc++.h>
using namespace std;

int main(){

    int m,n;
    int arr1[n],arr2[m];
    
    cin>>n;
    for(int i=0;i<n;i++){
        cin>>arr1[i];
    }

    cin>>m;
    for(int i=0;i<m;i++){
        cin>>arr2[i];
    }
    set<int> s1(arr1,arr1+n);
    set<int> s2(arr2,arr2+m);

    vector<int> v1,v2;

    copy(s1.begin(),s1.end(),back_inserter(v1));
    copy(s2.begin(),s2.end(),back_inserter(v2));

    vector<int> :: iterator i,i1;
    vector<int> v3;

    set_union(begin(v1),end(v1),begin(v2),end(v2),inserter(v3, end(v3)));
    for_each(begin(v3), end(v3), [](int x) {  
    cout << x << " ";  
    });  
    cout<<"\n";


    // int i=0,j=0,k=0,temp[m],key=0;
    // while(i<n && j<m){

    //     if(m>n){
    //         for(int i=0;i<n;i++){
    //             for(int j=0;j<m;j++){
    //                 if(arr1[i] == arr2[j] && key!=1){
    //                     key=1;
    //                     temp[k] = arr1[i];
    //                     k++;
    //                 }else if(arr1[i]!=arr2[j]){

    //                 }else{
    //                     j++;
    //                 }
    //             }
    //         }
    //     }
        
    // }


    return 0;
}
/*    // int i=0;
    // int j=0;
    // vector<int> v1;
    
    // while(i<m || j<n){
    //     if(arr1[i] == arr2[j]){
    //         v1.insert(v1.begin(),arr1[i]);
    //         i++;
    //         j++;
    //     }else if(arr1[i]>arr2[j]){
    //         v1.insert(v1.begin(),arr1[i]);
    //         j++;
    //     }else{
    //         i++;
    //     }
    // }
    
    // return v1;
    
    //Your code here
    //return vector with correct order of elements
    // int temp[n];
    // int k=0;
    // for(int i=0;i<n;i++){
    //     if(arr1[i]!=arr1[i+1]){
    //         temp[i] = arr1[i];
    //     }
    // }
    // for(int i=0;i<n;i++){
    //     arr1[i] = temp[i];
    // }
    // //for removing duplicates 
    // int temp2[n];
    // int k1=0;
    // for(int i=0;i<m;i++){
    //     if(arr2[i]!=arr2[i+1]){
    //         temp2[i] = arr2[i];
    //     }
    // }
    // for(int i=0;i<m;i++){
    //     arr2[i] = temp2[i];
    // }
    
    // set<int> s1;
    // for(int i=0;i<n;i++){
    //     s1.insert(arr1[i]);
    // }
    
    // set<int> s2;
    // for(int i=0;i<m;i++){
    //     s2.insert(arr2[i]);
    // }
        
    // vector<int> o1;
    // vector<int> o2;
    // copy(s1.begin(),s1.end(),o1.begin());
    // copy(s2.begin(),s2.end(),o2.begin());
    
    // vector<int> v1(10);
    // vector<int> v2;
    
    
    // vector<int> :: iterator it,i;
    
    // it=set_union(o1.begin(),o1.end(),o2.begin(),o2.end(),v1.begin());
    
  //  cout<<it-v1.begin()<<"\n";

    
  //  sort(v1.begin(),v1.end());*/