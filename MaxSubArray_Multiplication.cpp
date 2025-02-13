// // { Driver Code Starts
#include <bits/stdc++.h>

using namespace std;

class Solution{
public:

	// Function to find maximum product subarray
	void maxProduct(int *arr, int n) {
	        
	       //int j =0;
	       long long mul = 1;
	       long long ans=0;
	       
	       for(int i=0;i<n;i++){
	            
	            if(arr[i] == 0){
	               // j = 0;
	                mul=1;
	            }else{
	                mul*= arr[i];
                    // cout<<mul<<"\n";
	                ans = max(abs(mul),abs(ans));
                }
                //  cout<<ans<<"\n";
	       }
	       cout<<ans<<"\n";
	}
};

// { Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, i;
        cin >> n;
        int arr[n];
        for (i = 0; i < n; i++) {
            cin >> arr[i];
        }
        Solution ob;
        ob.maxProduct(arr, n);
        // cout << ans << "\n";
    }
    return 0;
}  // } Driver Code Ends



// int maxSubarrayProduct(int arr[], int n)
// {
//     // Initializing result
//     int result = arr[0];
 
//     for (int i = 0; i < n; i++) 
//     {
//         int mul = arr[i];
//         // traversing in current subarray
//         for (int j = i + 1; j < n; j++) 
//         {
//             // updating result every time
//             // to keep an eye over the maximum product
//             result = max(result, mul);
//             mul *= arr[j];
//         }
        
//         // updating the result for (n-1)th index.
//         result = max(result, mul);
        
//     }
//     return result;
// }
 
// // Driver code
// int main()
// {
//     int arr[] = { 0,3,-5 ,-2, 8, -7, -6, -2 ,-3, -9};
//     int n = sizeof(arr) / sizeof(arr[0]);
//     cout << "Maximum Sub array product is "
//          << maxSubarrayProduct(arr, n);
//     return 0;
// }