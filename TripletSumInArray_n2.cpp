#include<bits/stdc++.h>
using namespace std;

void tripletSumInArray_n2(int arr[],int n,int num){

    int i=0;
    int j=n/2;
    int k=n-1;

    bool found = false;

    while(i<j){

        if(arr[i]+arr[j]+arr[k] == num){
            cout<<"Found";
            found = true;
            break;
        }else if(arr[i]+arr[j]+arr[k] > num && j<=k){
            k--;
        }else if(arr[i]+arr[j]+arr[k] < num && i<k){
            i++;
        }else{
            k--;
        }

    } 

    if(found == false){
        cout<<"Not found";
    }
}

int main(){ 

    int n,num;

    cout<<"Enter array size :";
    cin >> n;

    int arr[n];
    cout<<"Enter array : ";
    for(int i=0;i<n;i++){
        cin>>arr[i];
    }
    cout<<"Enter number :";
    cin>>num;

    sort(arr,arr+n);

    tripletSumInArray_n2(arr,n,num);

}