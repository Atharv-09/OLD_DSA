#include<bits/stdc++.h>
using namespace std;

void swap(int *p1,int *p2){
    int temp = *p1;
    *p1 = *p2;
    *p2 = temp;
}

int partition(int arr[],int low,int high){

    int pivot;
    pivot = arr[low];

    int start = low;
    int end = high;

    while(start<end){
        while(arr[start]<=pivot){
            start++;
        }

        while(arr[end]>pivot){
            end--;
        }
        //                   
        if(start<end){ 
            swap(&arr[start],&arr[end]);
        }
    }
    //for swapping first/pivot with the end element we get 
    //swap with pivot coz end < start as the start crosses end
    swap(&arr[low],&arr[end]);  
    
    return end;
}

void quickSort(int arr[],int low,int high){
    if(low<high){
    
        int part = partition(arr,low,high);

        quickSort(arr,low,part-1);
        quickSort(arr,part+1,high);
    }
}

int main(){ 

    int arr[] = {7,6,10,5,9,2,1,15,7};
    int n = sizeof(arr)/sizeof(arr[0]);

    int low = 0;
    int high = n-1;
    
    quickSort(arr,low,high);

    for(int i=0;i<n;i++){
        cout<<arr[i]<<" ";
    }
    return 0;
}

// O n^2 (worst);
// O nlogn (best,average);