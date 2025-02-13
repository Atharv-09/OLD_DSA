#include<bits/stdc++.h>
using namespace std;
void merge(int arr[],int l,int m,int h){

    int i = l;
    int j = m+1;
    int k = l;

    int ans[h];

    while(i<=m && j<=h){
        if(arr[i]<=arr[j]){
            ans[k] = arr[i];
            i++;
            // k++;
        }else if(arr[i]>arr[j]){
            ans[k] = arr[j];
            j++;
            // k++;
        }
            k++;
    }

    // if one of the list remai 

    if(i>m){
        while(j<=h){
            ans[k] = arr[j];
            j++;
            k++;
        }
    }else{
        while(i<=m){
            ans[k] = arr[i];
            i++;
            k++;
        }
    }


    for(int i=l;i<h;i++){
        arr[i] = ans[i];
    }

}
void mergeSort(int arr[],int low,int high){

        while(low<high){

            int mid;
            mid = (high-low)/2;
            mergeSort(arr,low,mid-1);
            mergeSort(arr,mid+1,high);
            merge(arr,low,mid,high);
        }

        // for(int i=0;i<high;i++){
        //     cout<<arr[i]<<"\n";
        // }
        
        
}

int main(){

    int arr[] = {38,27,43,3,9,82,10};

    int size = sizeof(arr)/sizeof(arr[0]);

    mergeSort(arr,0,size-1);
    for(int i=0;i<size;i++){
            cout<<arr[i]<<" ";
    }
        
    return 0;

}