#include<bits/stdc++.h>
using namespace std;
// time : n^2
void insertion(int arr[],int n){

    int key,index=0;
    for(int i=1;i<n;i++){

        int j=i-1;
        index = i;
        key = arr[i];
        // while(j>=0){
        while(j>=0 && arr[j]>key){

            arr[j+1] = arr[j];
            j--;
            // if(arr[j]>arr[i]){
                // int temp;
                // temp = arr[j];
                // arr[j] = arr[i];
                // arr[i] = temp;
            // }
            // j--;
            // i--;
        }
        arr[j+1] = key;
        // i = index;
        //  arr[i] = key;
    }



}

int main(){

    int arr[] = {12, 11, 13, 5, 6 };
    int size = sizeof(arr)/sizeof(arr[0]);

    insertion(arr,size);

    for(int i=0;i<size;i++){
        cout<<arr[i]<<" ";
    }
    cout<<"\n";
    return 0;
}