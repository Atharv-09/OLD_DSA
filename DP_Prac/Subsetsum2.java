import java.util.*;


class SubsetSum{

	static boolean subsetsum(int[] arr,int n,int sum,boolean[][] dp){

		
		if(sum==0) return true;
		if(n==0) return false;

		
		if(arr[n-1] > sum){
			return dp[n][sum] = subsetsum(arr,n-1,sum,dp);
		}else{ 	
			return dp[n][sum] = subsetsum(arr,n-1,sum,dp) || subsetsum(arr,n-1,sum-arr[n-1],dp) ;
		}


	}
	public static void main(String[] args) {
				
		int arr[] = {2,3,7,8,10};
		int n = 5;
		int target = 90;

		boolean[][] dp = new boolean[n+1][target+1];

		for(int i=0;i<n+1;i++){
			for(int j=0;j<target+1;j++){
				dp[i][j] = false;
			}
		}


		System.out.println(subsetsum(arr,n,target,dp));

	}
}