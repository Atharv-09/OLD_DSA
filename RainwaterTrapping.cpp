#include<bits/stdc++.h>
using namespace std;

// O(n^2)
// int trappingWater(int arr[],int n){

//     int ans=0;

//     for(int i=1;i<n-1;i++){

//         int left = arr[i];
//         for(int j=0;j<i;j++){
//             left = max(left,arr[j]);
//         }

//         int right = arr[i];
//         for(int j=i+1;j<n;j++){
//             right = max(right,arr[j]);
//         }

//         ans = ans + (min(left,right)-arr[i]);
//     }
//     return ans;
// }

// O(n) 
int trappingWater(int arr[],int n){

        int left[n];
        int right[n];
        int water=0;


        left[0] = arr[0];
        for(int i=1;i<n;i++){
            left[i]= max(arr[i],left[i-1]);
        }

        right[n-1] = arr[n-1];
        for(int i=n-2;i>=0;i--){
            right[i] = max(arr[i],right[i+1]);
        } 

        for(int i=0;i<n;i++){
            water += (min(left[i],right[i]) - arr[i]);
        }

    return water;
}
int main(){
    
    int t;
    cin >> t;
    
    while(t--){
        int n;
        
        //size of array
        cin >> n;
        
        int a[n];
        
        //adding elements to the array
        for(int i =0;i<n;i++){
            cin >> a[i];            
        }
        
        //calling trappingWater() function
        cout << trappingWater(a, n) << endl;
    }

    return 0;
}

/*$ ./a.exe
6
6
3 0 0 2 0 4
10 ans 
3
6 9 9
0 asns 
4
7 4 0 9
10 ans 
7 
8 8 2 4 5 5 1
4 ans 
11
1 1 5 2 7 6 1 4 2 3 7  
22 ans
3
1 4 2
0 ans
*/