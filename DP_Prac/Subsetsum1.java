class SubsetSum{

	static boolean subsetsum(int[] arr,int n,int sum){

		
		if(sum==0) return true;
		if(n==0) return false;

		
		if(arr[n-1] > sum){
			return subsetsum(arr,n-1,sum);
		}else{
			return subsetsum(arr,n-1,sum) || subsetsum(arr,n-1,sum-arr[n-1]) ;
		}


	}
	public static void main(String[] args) {
				
		int arr[] = {2,3,7,8,10};
		int n = 5;
		int target = 22;


		System.out.println(subsetsum(arr,n,target));

	}
}