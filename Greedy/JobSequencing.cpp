// { Driver Code Starts
// Program to find the maximum profit job sequence from a given array 
// of jobs with deadlines and profits 
#include<bits/stdc++.h>
using namespace std; 

// A structure to represent a job 
struct Job 
{ 
    int id;	 // Job Id 
    int dead; // Deadline of job 
    int profit; // Profit if job is over before or on deadline 
}; 


 // } Driver Code Ends


// Prints minimum number of platforms reqquired 
bool comparison(Job a,Job b){
    return(a.profit>b.profit);
}
void JobScheduling(Job arr[], int n) 
{ 
    bool fill[n];
    sort(arr,arr+n,comparison);

    for(int i=0;i<n;i++){
        fill[i] = false;
    }
    int totalProfit = 0,count=0;
    for(int i=0;i<n;i++){
        cout<<fill[i]<<" ";
    }
    int i=0;
    while(i<n){


        if(fill[(arr[i].dead)-1] == 0){
            fill[(arr[i].dead)-1] == 1;
        }

        i++;
    }

    for(int i=0;i<n;i++){
        if(fill[i]){
            totalProfit = totalProfit + arr[i].d
        }
    }
        cout<<count<<" "<<totalProfit<<"\n";
            // cout<<ans.first<<" "<<ans.second<<endl;

} 



// { Driver Code Starts.
// Driver program to test methods 
int main() 
{ 
    int t;
    //testcases
    cin >> t;
    
    while(t--){
        int n;
        
        //size of array
        cin >> n;
        Job arr[n];
        
        //adding id, deadline, profit
        for(int i = 0;i<n;i++){
                int x, y, z;
                cin >> x >> y >> z;
                arr[i].id = x;
                arr[i].dead = y;
                arr[i].profit = z;
        }
        //function call
        // pair<int,int> ans = JobScheduling(arr, n);
        JobScheduling(arr, n);

    }
	return 0; 
}


  // } Driver Code Ends