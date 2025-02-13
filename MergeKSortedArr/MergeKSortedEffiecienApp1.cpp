#include<bits/stdc++.h>
using namespace std;

void mergeArr(int arr[][n],int i,int j,int output[]){

    if(i == j ){
        for(int l=0;l<k;l++){
            output[i] = arr[i][l];
            return;
        }
    }

    if(j-i == 1){
        merge(arr[])
    }

}

int main(){

    cout<<"Enter size of k : ";
    cin>>k;

    int arr[k][k];

    for(int i=0;i<k;i++){
        for(int j=0;j<k;k++){
            cin>>arr[i][j];
        }
    }
    int output[k*k];

    mergeArr(arr,0,k-1,output); 
    return 0;
}