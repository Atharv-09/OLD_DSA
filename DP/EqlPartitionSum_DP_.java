class EqlPartitionSum{

	// TIME : O(2^n)
	static boolean findSubsets(int[] arr,int n,int sum){

		boolean[][] dp = new boolean[n+1][sum+1];

		for(int i=0;i<n+1;i++){
			for(int j=0;j<sum+1;j++){

				if(i==0){
					dp[i][j] = true;
				}

				if(j==0)
					dp[i][j] = false;
			}
		}


		for(int i=1;i<n+1;i++){
			for(int j=1;j<sum+1;j++){

				if(arr[i-1]>j){
					dp[i][j] = dp[i-1][j];
				}else{
					dp[i][j] = dp[i-1][j] || dp[i-1][sum-arr[j]];
				}
			}
		}

		return dp[n][sum];

	}

	static boolean findPartition(int[] arr,int n){

		int sum = 0;
		for(int i=0;i<n;i++){
			sum += arr[i];
		}

		if(sum%2!=0) // sum is odd so we cannot divide it into 2 equal sum set
			return false;

		return findSubsets(arr,n,sum/2);

	}
	public static void main(String[] args) {
		
		int arr[] = {1,5,5};

		if(findPartition(arr,3)){
			System.out.println("We can divide array in 2 set whose sums are equal");
		}else{
			System.out.println("We cannot divide array in 2 set whose sums are equal");
		}


	}
}