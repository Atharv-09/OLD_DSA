#include<bits/stdc++.h>
using namespace std;

// Functio to find first smallest positive
// missing number in the array 
// int missingNumber(int arr[], int n) { 


        
    // sort(arr,arr+n);
     
    //     for(int i=0;i<n-1;){
    //         if(arr[i]>0){
    //             if(arr[i+1]==(arr[i]+1)){
    //                 i++;
    //             }else{
    //                 return arr[i]+1;
    //             }
    //         }else{
    //             i++;
    //         }
    //     }
        
    //     return n+1;
    
    
// } 

// { Driver Code Starts.

int missingNumber(int arr[],int n){

    sort(arr,arr+n);

    for(int i=1;i<n;i++){

        if(arr[i]>=0){

            if(arr[i+1]==(arr[i]+1)){
                i++;
            }else if(arr[i-1]<0){
                return arr[i]+1;
            }else{
                return 1;
            }
        }else{
            i++;
        }
    }

    return n+1;

}

int main() { 
    
    //taking testcases
    int t;
    cin>>t;
    while(t--){
        
        //input number n
        int n;
        cin>>n;
        int arr[n];
        
        //adding elements to the array
        for(int i=0; i<n; i++)cin>>arr[i];

             
        //calling missingNumber()
        cout<<missingNumber(arr, n)<<endl;
    }
    return 0; 

}