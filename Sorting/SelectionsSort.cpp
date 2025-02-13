#include<bits/stdc++.h>
using namespace std;

void swap(int *p1,int *p2){

    int temp;

     temp = *p1;
     *p1 = *p2;
     *p2 = temp;
}   

void selectionSort(int arr[],int n){

        int min_index;

        for(int i=0;i<n-1;i++){

            min_index = i;
            for(int j=i+1;j<n;j++){

                if(arr[j]<arr[min_index]){

                        min_index = j;

                }
            }

            swap(&arr[min_index],&arr[i]);

        }

}
int main(){

    int arr[] = {64,25,12,22,11};
    int size = sizeof(arr)/sizeof(arr[0]);

    selectionSort(arr,size);
    

    for(int i=0;i<size;i++){
        cout<<arr[i]<<" ";
    }

        cout<<"\n";
    return 0;
}