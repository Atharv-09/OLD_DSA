#include<bits/stdc++.h>


#define N 105
using namespace std;

// int *mergeKArrays(int arr[][N],int k);


void mergeKArrays(int arr[][N], int k)
{
    int ans[N*k];
    
    int c = 0;
    
    for(int i=0;i<k;i++){
        for(int j=0;j<k;j++){
    
            ans[c] = arr[i][j];
            c++;
        }
    }
    
    sort(ans,ans+k*k);
   
	for(int i=0;i<k*k;i++){
		cout<<ans[i]<<" ";
	}
	cout<<"\n";
}
int main()
{
	int t;
	cin>>t;
	while(t--){
	    int k;
	    cin>>k;
	    int arr[N][N];
	    for(int i=0; i<k; i++){
	        for(int j=0; j<k; j++)
	        {
	            cin>>arr[i][j];
	        }
	    }
	 mergeKArrays(arr, k);
	// printArray(output, k*k);
	// cout<<endl;
}
	return 0;
}// } Driver Code Ends


// your task is tocomplete this function
// function should return an pointer to output array int*
// of size k*k
