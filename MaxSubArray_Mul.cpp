#include<bits/stdc++.h>
using namespace std;

long long maxProduct(int arr[],int n){

    long long maxSum = 0;
    int mul;
    for(int i=0;i<n;i++){
        
        mul = arr[i];
       
        // int mul = prev; // 0 
        for(int j=i+1;j<n;j++){

                // maxSum = max(abs(mul),abs(maxSum));
                if(abs(mul) > abs(maxSum)){
                    maxSum = mul;
                }

                mul = mul*arr[j]; // 0
                
                if(mul == 0){
                    break;
                }
        }
        if(abs(mul) > abs(maxSum)){
            maxSum = mul;
        }
    }

    return abs(maxSum);

}

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
        
        auto ans = maxProduct(arr, n);
        cout << ans << "\n";
    }
    return 0;
}  // } Driver Code Ends