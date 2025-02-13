class MinSubsetSumDiff{


	static int findMinDiff(int[] arr,int n,int sumCalculated,int totalSum){

		if(n==0) return Math.abs((totalSum-sumCalculated)-sumCalculated);

		// include element or not include elemen
		//if include then add into sucalculated 
		
		return Math.min(findMinDiff(arr,n-1,sumCalculated+arr[n-1],totalSum),findMinDiff(arr,n-1,sumCalculated,totalSum));
	}
	static int findMinSubSetDiff(int arr[] ,int n){

		int totalSum = 0;
		for(int i=0;i<n;i++){
			totalSum+=arr[i];
		}

		return findMinDiff(arr,n,0,totalSum);

	}

	public static void main(String[] args) {
		
		int arr[] = {1,10,11,5};

		int ans = findMinSubSetDiff(arr,4);

		System.out.println(ans);
	}
}