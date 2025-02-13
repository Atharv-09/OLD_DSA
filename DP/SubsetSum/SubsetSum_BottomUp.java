import java.util.*;

class SubsetSum{

	static boolean[][] dp;
	SubsetSum(int n,int sum){
		dp = new boolean[n+1][sum+1];
		for(int i=0;i<n+1;i++){
			for(int j=0;j<sum+1;j++){
				if(i == 0)
					dp[i][j] = true;
				if(j == 0)
					dp[i][j] = false;
			}
		}
	}

	static boolean findSubsetSum(int[] arr,int n,int sumWe){

		for(int i=1;i<n+1;i++){
			for(int j=1;j<sumWe+1;j++){
					
				if(i>=arr[j-1]){
					dp[i][j] = dp[i-1][j] || dp[i][j-arr[i-1]];
				}else{
					dp[i][j] = dp[i-1][j];
				}
			}
		}

		return dp[n][sumWe];
	
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