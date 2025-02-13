

class Main{


	static boolean binSearch(int arr[],int s,int e,int ele){

		if(s<=e){
			
			int mid = s+(e-s)/2;

			if(arr[mid]==ele) return true;

			if(ele > arr[mid])
				return binSearch(arr,mid+1,e,ele);
			else
				return binSearch(arr,s,mid-1,ele);
		}	
		return false;
	}

	public static void main(String[] args) {
		
		int[] arr = { 2, 3, 4, 10, 40};

		boolean ans= binSearch(arr,0,arr.length-1,2);

		System.out.println(ans);
	}
}