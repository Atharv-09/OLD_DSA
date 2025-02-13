import java.util.*;

class Knapsack{

	// TIME : O(m*n)

	static int knapSack(int[] wt,int[] val,int cap,int n){

		int dp[][] = new int[n+1][cap+1];

		for(int i=0;i<n+1;i++){
			for(int j=0;j<cap+1;j++){

				if(i==0 || j==0)
					dp[i][j] = 0;
				else if(wt[i-1] <= j)
					dp[i][j] = Math.max(val[i-1]+dp[i-1][j-wt[i-1]],dp[i-1][j]);
				else
					dp[i][j] = dp[i-1][j];			
			}
		}	

		return dp[n][cap];

	}
	public static void main(String[] args) {
		
		int[] wt = {1,3,4,6};
		int[] val = {20,30,10,50};
		int w = 10;
		int n = 4;
		// Knapsack k = new Knapsack(4,w);
		System.out.println(knapSack(wt,val,w,4));
	}
}