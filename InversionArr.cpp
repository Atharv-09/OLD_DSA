// { Driver Code Starts
// #include <bits/stdc++.h>
// using namespace std;


 // } Driver Code Ends


// Function to find inversion count in the array

// arr[]: Input Array
// N : Size of the Array arr[]

// long long int inversionCount(long long arr[], long long N)
// {
        
//         long long int count=0;
        
//         for(int i=N-1;i>=0;i--){
            
//             int curr = arr[i];
            
//             for(int j=0;j<i;j++){
                
//                 if(arr[j]>curr){
//                     count++;
//                 }
//             }
//         }    
        
    
//         return count;
    
// }

#include<bits/stdc++.h>
using namespace std;


int merge(int arr[],int l,int mid,int h){
    
    int count = 0;
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
            count=count+(mid-i);
            j++;
            k++;
        }

        k++;
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
   return count;

}

int mergeSort(int arr[],int low,int high){
int count=0;
    while(low<high){
        int mid;
        mid = (high-low)/2;
        count+=mergeSort(arr,low,mid-1);
        count+=mergeSort(arr,mid+1,high);
        count+=merge(arr,low,mid,high);
    }
    return count;
}
// O n^2 (worst);
// O nlogn (best,average);
// { Driver Code Starts.

int main() {
    
    long long T;
    cin >> T;
    
    while(T--){
        int N;
        cin >> N;
        
        int A[N];
        for(long long i = 0;i<N;i++){
            cin >> A[i];
        }
        int ans = mergeSort(A,0,N-1);
        cout<<ans<<"\n";
        // cout << inversionCount(A,0,N-1) << endl;
    }
    
    return 0;
}
  // } Driver Code Ends