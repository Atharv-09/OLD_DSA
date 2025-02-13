import java.util.*;

class SubsetSum{

	static boolean[][] dp;
	SubsetSum(int n,int sum){
		dp = new boolean[n+1][sum+1];
		for(int i=0;i<n+1;i++){
			for(int j=0;j<sum+1;j++){
				dp[i][j]=false;
			}
		}
	}

	static boolean findSubsetSum(int[] arr,int n,int sumWe){

		if(n==0) return false;
		if(sumWe==0) return true;

		if(dp[n-1][sumWe]==true){ // if we have the ans of any subproblemn we want so we willl not calculate it 
			/// we direct return that abs;
			return dp[n-1][sumWe];
		}
		if(sumWe<arr[n-1]){ // if curr element is grater then required subset sum dont take that eleme
			return dp[n-1][sumWe] = findSubsetSum(arr,n-1,sumWe);
		}else{
			return dp[n-1][sumWe] = findSubsetSum(arr,n-1,sumWe) || findSubsetSum(arr,n-1,sumWe-arr[n-1]);
		}
	}

		public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter array size : ");
		int  n = sc.nextInt();

		int[] arr = new int[n];

		System.out.print("Enter array value : ");
		for(int i=0;i<n;i++){
			arr[i] = sc.nextInt();
		}

		System.out.print("Enter sum you want(target) : ");
		int sumWe = sc.nextInt();

		SubsetSum ss = new SubsetSum(n,sumWe);
		if(findSubsetSum(arr,n,sumWe))
			System.out.println("SubsetSum exists in array");
		else
			System.out.println("SubsetSum doesn't exist in array");
	}
}

/*hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/DP
$ java SubsetSum
Enter array size : 4
Enter array value : 3 4 8 6 
Enter sum you want(target) : 12
SubsetSum exists in array

hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/DP
$ java SubsetSum
Enter array size : 4
Enter array value : 3 4 8 6
Enter sum you want(target) : 20
SubsetSum doesn't exist in array*/