/*Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.

Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.

You may return any answer array that satisfies this condition.

 

Example 1:

Input: [4,2,5,7]
Output: [4,5,2,7]
Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.*/

#include<bits/stdc++.h>
using namespace std;
// using 2 pointer algo 
void sortByParity(int arr[],int n){
    
    int i = 0;
    int j = 1;

    for(;i<n&&j<n;){

        if(arr[i]%2==0)
            i+=2;
        else if(arr[j]%2==1)
            j+=2;
        else{
            swap(arr[i],arr[j]);
        }
    }
    for(int i=0;i<n;i++){
        cout<<arr[i]<<" ";
    }
    cout<<"\n";
}
/*
void sortByParity(int arr[],int n){

    int ans[n];
    int evenC=0;
    int oddC = 1;

    for(int i=0;i<n;i++){
        if(arr[i]%2==0){
            ans[evenC] = arr[i];
            evenC+=2;
        }else{
            ans[oddC] = arr[i];
            oddC+=2;
        }
    }

    for(int i=0;i<n;i++){
        cout<<ans[i]<<" ";
    }
    cout<<"\n";

}
*/
int main(){

    int arr[] = {4,2,5,7};
    int size = sizeof(arr)/sizeof(arr[0]);

    sortByParity(arr,size);
}