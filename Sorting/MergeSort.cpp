#include<bits/stdc++.h>
using namespace std;

void merge(int arr[],int l,int mid,int h){
    
    int i = l;
    int j = mid+1;
    int k = l;
    int ans[h];
    while(i<=mid && j<=h){

        if(arr[i]<=arr[j]){
            ans[k] = arr[i];
            k++;
            i++;
        }else if(arr[i]>arr[j]){
            ans[k] = arr[j];
            j++;
            k++;
        }

        // k++;
    }
    
    //if we reached any one part end and other part is remainning 
    if(i>mid){
        while(j<=h){
            ans[k] = arr[j];
            k++;
            j++;
        }
        
    }else{
        while(i<=mid){
            ans[k] = arr[i];
            k++;
            i++;
        }
    }


    for(int i=l;i<h;i++){
        arr[i] = ans[i];
    }
    
    // for(int i=0;i<h;i++){
    //     cout<<ans[i]<<"\n";
    // }

}

void mergeSort(int arr[],int low,int high){

    while(low<high){
        int mid;
        mid = (high-low)/2;
        mergeSort(arr,low,mid-1);
        mergeSort(arr,mid+1,high);
        merge(arr,low,mid,high);
    }

    
}

int main(){

    int arr[] = {15,5,24,8,1,3,16,10,20};
    int n = sizeof(arr)/sizeof(arr[0]);

    
    mergeSort(arr,0,n-1);

    for(int i=0;i<n;i++){
        cout<<arr[i]<<" ";
    }

    return 0;
}