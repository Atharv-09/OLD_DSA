#include<bits/stdc++.h>
using namespace std;
//Bubble Sort it will search for all elements 
// not stop when the half is already sorted 
// time complexiyt for best-n    worst-n^2
void swap(int *p1,int *p2){
    int temp;

    temp = *p1;
    *p1 = *p2;
    *p2 = temp;
}

void bubbleSort(int arr[],int n){

    for(int i=0;i<n-1;i++){
        // int key = arr[i]
        for(int j=0;j<n-1;j++){

            if(arr[j+1]<arr[j]){
                swap(&arr[j+1],&arr[j]);
            }
       }
    }

}

int main(){

    int arr[] = { 5, 1 , 4 ,2 ,8 };
    int size = sizeof(arr)/sizeof(arr[0]);

    bubbleSort(arr,size);

    for(int i=0;i<size;i++){
        cout<<arr[i]<<" ";
    }

    cout<<"\n";
    return 0;

}