class EqlPartitionSum{

	// TIME : O(2^n)

	
	static boolean findSubsets(int[] arr,int n,int sum){

		if(sum==0) return true; // if sum is 0 that means array is emty 
		if(n==0 && sum!=0) return false; // is sum is not zero and array is empty it is not possible 


		if(arr[n-1]>sum){
			return findSubsets(arr,n-1,sum);
		}else{
			return findSubsets(arr,n-1,sum) || findSubsets(arr,n-1,sum-arr[n-1]);
		}

	}

	static boolean findPartition(int[] arr,int n){

		int sum = 0;
		for(int i=0;i<n;i++){
			sum += arr[i];
		}

		if(sum%2!=0) // sum is odd so we cannot divide it into 2 equal sum set
			return false;

		return findSubsets(arr,n,sum);

	}
	public static void main(String[] args) {
		
		int arr[] = {1,6,11,5};

		if(findPartition(arr,4)){
			System.out.println("We can divide array in 2 set whose sums are equal");
		}else{
			System.out.println("We cannot divide array in 2 set whose sums are equal");
		}


	}
}