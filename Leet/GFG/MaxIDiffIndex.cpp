#include<bits/stdc++.h>
using namespace std;
int findMaxDiffIndex(int arr[],int n){

    int lMin[n];
    int rMax[n];

    lMin[0] = arr[0];
    for(int i=1;i<n;i++){
        lMin[i] = min(lMin[i-1],arr[i]);
    }

    rMax[n-1] = arr[n-1];
    for(int i=n-2;i>=0;i--){
        rMax[i] = max(rMax[i+1],arr[i]);
    }

    int i=0,j=0,maxDiff=-1;

    while(i<n && j<n){
        if(lMin[i]<=rMax[j]){
            maxDiff = max(maxDiff,j-i);
            j++;
        }else{
            i++;
        }
    }
    return maxDiff;
}
int main(){
    int size;

    cout<<"Enter size : ";
    cin>>size;
    int arr[size];
    cout<<"Enter array : ";
    for(int i=0;i<size;i++){
        cin>>arr[i];
    }

    cout<<findMaxDiffIndex(arr,size);

    return 0;
}