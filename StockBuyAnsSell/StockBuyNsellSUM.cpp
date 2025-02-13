#include<bits/stdc++.h>
using namespace std;

//User function template for C++

class Solution{
public:
    int stockBuySell(int arr[], int n){
            
                
            
         //   int arr[n];
            
          //  copy(A.begin(),A.end(),arr);

            
            // vector<vector<int>> vt1;
            // vector<int> v1;
        	int startIndex=0,endIndex=0,key=0,sum=0;

        	for(int i=0;i<n-1;i++){
        		
        			if((startIndex==0 && key==0) && arr[i+1]!=arr[i]){
        				startIndex = i; 
        				key++;
        			}
        			
        			if(arr[i+1]>=arr[i]){
        				endIndex = i+1;
        			}
        
        			if(arr[i+1]<arr[i] || i==n-2){
        				
        				if(endIndex>startIndex){
        					//	m1.insert(pair<int,int> (startIndex,endIndex));

                            sum+= arr[endIndex]-arr[startIndex];
        					// v1.push_back(startIndex);
        					// v1.push_back(endIndex);
        					// vt1.push_back(v1);
        					// v1.clear();
        				
        				}		
        			
        						startIndex =0 ;
        						endIndex = 0;
        						key=0;
        			}
        		
        	}
        
        return sum;	
        //return m1;
    }
};



int main()
{   
    int t;
    cin>>t;
    while(t--){
        int n;
        cin>>n;
        int A[n];
        for (int i=0; i<n; ++i){
            cin>>A[i];
        }
        Solution ob;
        int ans;
        ans = ob.stockBuySell(A, n);
        
        cout<<"Total profit : "<< ans<<" \n";
        
    }
    return 0;
}
