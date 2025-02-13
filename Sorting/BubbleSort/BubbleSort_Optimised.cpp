#include<bits/stdc++.h>
using namespace std;


void swap(int *p1,int *p2){

    int temp;
    temp = *p1;
    *p1 = *p2;
    *p2 = temp;

}


void bubbleSort(int arr[],int n){

    int count=0;
    for(int i=0;i<n-1;i++){
        bool swap1 = false;
        for(int j=0;j<n-i-1;j++){

            if(arr[j+1]<arr[j]){
                swap(&arr[j+1],&arr[j]);
                swap1 = true;
            }
        }

        if(swap1 == false){
            break;
        }
    }

    // cout<<count<<" ";
}

int main(){

    int arr[] = { 15, 11 , 4 ,2 ,8 };
    int size = sizeof(arr)/sizeof(arr[0]);

    bubbleSort(arr,size);

    for(int i=0;i<size;i++){
        cout<<arr[i]<<" ";
    }

    cout<<"\n";
    return 0;

}