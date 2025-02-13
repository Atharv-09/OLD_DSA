// { Driver Code Starts
//Initial template for C++

#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends


//User function template for C++

class Solution{
public: 
    vector<vector<int> > stockBuySell(vector<int> A, int n){
            
            
            int arr[n];
            
            copy(A.begin(),A.end(),arr);
  
            
            vector<vector<int>> vt1;
            vector<int> v1;
        	int startIndex=0,endIndex=0,key=0;
        	for(int i=0;i<n-1;i++){
        		
        			if((startIndex==0 && key==0) && arr[i+1]!=arr[i]){
        				startIndex = i; // 0
        				key++;
        				 // 1
        			}
        			
        			if(arr[i+1]>=arr[i]){
        			
        			        if(arr[i-1]>arr[i] && arr[i+1] == arr[i]){
        			            
        			        }else{
        			            endIndex = i+1;    
        			        }
        			        

        	
        			}
        
        			if(arr[i+1]<arr[i] || i==n-2){
        				
        				if(endIndex>startIndex){
        					//	m1.insert(pair<int,int> (startIndex,endIndex));
        					v1.push_back(startIndex);
        					v1.push_back(endIndex);
        					vt1.push_back(v1);
        					v1.clear();
        				
        				}	
        			
        						startIndex =0 ;
        						endIndex = 0;
        						key=0;
        					// startIndex=i;
        					// }
        				
        			}
        		
        	}
        	//Multimap into vector
        return vt1;	
        //return m1;
    }
};

// { Driver Code Starts.

int main()
{   
    int t;
    cin>>t;
    while(t--){
        int n;
        cin>>n;
        vector<int> A(n);
        for (int i=0; i<n; ++i){
            cin>>A[i];
        }
        Solution ob;
        vector<vector<int> > ans = ob.stockBuySell(A, n);
        if(ans.size()==0)
            cout<<"No Profit";
        else{
            for (int i=0; i<ans.size(); ++i){
                cout<<"("<<ans[i][0]<<" "<<ans[i][1]<<") ";
            }
        }cout<<endl;
    }
    return 0;
}

  // } Driver Code Ends