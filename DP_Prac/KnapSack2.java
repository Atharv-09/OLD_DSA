import java.util.*;

class Knapsack{

	// TIME : O(m*n)

	static int knapSack(int[] wt,int[] val,int cap,int n,int[][] dp){

		if(cap==0 || n==0) return 0;

		// if weight of curr item is less then bag capacity 
		if(dp[n][cap]!=-1)
			return dp[n][cap];

		if(wt[n-1] > cap){
			return dp[n][cap] = knapSack(wt,val,cap,n-1,dp);
			
		}else{
			return dp[n][cap] = Math.max(val[n-1]+knapSack(wt,val,cap-wt[n-1],n-1,dp),knapSack(wt,val,cap,n-1,dp));
			
		}


	}
	public static void main(String[] args) {
		
		int[] wt = {1,3,4,6};
		int[] val = {20,30,10,50};
		int w = 10;
		int n = 4;
		// Knapsack k = new Knapsack(4,w);
		int[][] dp = new int[n+1][w+1];
		for(int i=0;i<n;i++){
			for(int j=0;j<w;j++){

				dp[i][j] = -1;
				
			}
		}
		System.out.println(knapSack(wt,val,w,4,dp));
	}
}