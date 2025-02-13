class Main{

/*	static int findClosestNum(int[] arr,int tar,int l,int h,int closestNum,int diff){

		// if(tar<=arr[0]) return arr[0];
		// if(tar>=arr[h]) return arr[h];

		while(l<h){

			int mid = (l+h)/2;

			if(Math.abs(tar-arr[mid]) < diff){
				diff = Math.abs(tar-arr[mid]);
				closestNum = arr[mid];
			}

			if(tar > arr[mid]){
				//right
				return findClosestNum(arr,tar,mid+1,h,closestNum,diff);
			}else{
				// left
				return findClosestNum(arr,tar,l,mid,closestNum,diff);
			}

		}

		return closestNum; 

	}
	*/

	static int getClosest(int v1,int v2,int tar){

		if((tar-v1)>=(tar-v2)){
			return v2;
		}else{
			return v1;
		}
	}
	static int findClosestNum(int[] arr,int target){

		int n = arr.length;

		if(arr[0]>=target) return arr[0];
		if(arr[n-1]<=target) return arr[n-1];


		int l=0,h=n,mid=0;

		while(l<h){

			mid = (l+h)/2;

			if(target==arr[mid]) return arr[mid];

			if(target<arr[mid]){
				//left
				if(mid>0 && target>arr[mid-1])
					return getClosest(arr[mid],arr[mid-1],target);
				h = mid;
			}else{
				//right
				if(mid<n-1 && target<arr[mid+1])
					return getClosest(arr[mid],arr[mid+1],target);
				l = mid+1;
			}
		}
		return arr[mid];

	}
	public static void main(String[] args) {
		

		int arr[] = new int[]{1, 2, 4, 5, 6, 6, 8, 9};
		int tar = 7;

		// int ans = findClosestNum(arr,tar,0,arr.length-1,0,Integer.MAX_VALUE);
		int ans = findClosestNum(arr,tar);
		System.out.println(ans);
	}
}