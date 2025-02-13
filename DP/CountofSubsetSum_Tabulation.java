class CountOfSubsetSumWithGivenSum{

	static int count(int[] arr,int n,int target){

		int[][] dp = new int[n+1][target+1];
		for(int i=0;i<n+1;i++){
			for(int j=0;j<target+1;j++){
				if(i==0)
					dp[i][j] = 0; 
				
				if(j==0)
					dp[i][j] = 1;
			}
		}
		for(int i=1;i<n+1;i++){
			for(int j=1;j<target+1;j++){
				if(j>=arr[i-1]){
					dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i-1]];
				}else{ // arr[i-1]>j
					dp[i][j] = dp[i-1][j];
				}
			}
		}

		return dp[n][target];
	}
	public static void main(String[] args) {
		
		int arr[] = {2,3,5,6,8,10};
		int n = 6;

		System.out.println(count(arr,n,10));
	}
}