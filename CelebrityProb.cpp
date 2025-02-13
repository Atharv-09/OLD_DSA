#include<bits/stdc++.h>
using namespace std;

int findCelebrity(int a[n][n],int n){

    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            if(a[j] == 1 && j!=i){
                if(i==n-1){
                    return j;
                }
            }
        }
    }

    return -1;
}

int main(){

    int arr[][] = {{0,1,0},{0,0,0},{0,1,0}};

    int n = sizeof(arr)/sizeof(arr[0]);
    cout<<findCelebrity(arr,n)<<"\n";


    return 0;
}