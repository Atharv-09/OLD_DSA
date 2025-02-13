// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

struct Item{
    int value;
    int weight;
};


 // } Driver Code Ends


// function to return fractionalweights
double fractionalKnapsack(int W, Item arr[], int n)
{
    int perWeigh[n];
    
    for(int i=0;i<n;i++){
        perWeigh[i] = arr[i].value/arr[i].weight;
    }
    
    double totalProfit;
    
    int weightUpto = 0,lastWeight;
    int maxWei=0,maxI;
    
    while(weightUpto<=W){
            
            for(int i=0;i<n;i++){
                
                if(perWeigh[i]>maxWei){
                    maxWei = perWeigh[i];
                    maxI = i;
                }
            }
            lastWeight = weightUpto;
            weightUpto =weightUpto+ arr[maxI].weight;
            
            if(weightUpto>W){
                int remainingWei = W-lastWeight;
                
                totalProfit =totalProfit + (perWeigh[maxI]*remainingWei); 
            }else{
                totalProfit =totalProfit+ arr[maxI].value;
            }
            cout<<totalProfit<<"\n";
            perWeigh[maxI] = 0;
            maxWei = 0;
            // for(int i=0;i<n;i++){
            //     cout<<perWeigh[i]<<" ";
            // }
            // cout<<"\n";
    }
    
    return totalProfit;
    
}

// { Driver Code Starts.
int main()
{
	int t;
	//taking testcases
	cin>>t;
	cout<<setprecision(2)<<fixed;
	while(t--){
	    //size of array and weight
		int n, W;
		cin>>n>>W;
		
		Item arr[n];
		//value and weight of each item
		for(int i=0;i<n;i++){
			cin>>arr[i].value>>arr[i].weight;
		}
		
		//function call
		cout<<fractionalKnapsack(W, arr, n)<<endl;
	}
    return 0;
}  // } Driver Code Ends