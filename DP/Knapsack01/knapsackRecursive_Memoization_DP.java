import java.util.*;

//time : O(n*capatiy) space : O(n*capacity);

class KnapSack{
	static int dp[][];

	KnapSack(int n,int cap){
		dp = new int[n+1][cap+1];

		for(int i=0;i<n;i++){
			for(int j=0;j<cap;j++){
				dp[i][j] = -1;
			}
		}
	}
	static int KnapSackProfit(int[] val,int wei[],int n,int capacity){

		if(capacity == 0  || n == 0 ) // if there were no items or bag capacity is 0
			return 0;

			// if we have sol of subproblem which we needed we directly return fwithout calculating it again
		
			// MEMOIZATION
		if(dp[n][capacity] != -1)
			return dp[n][capacity];

		if(capacity >= wei[n-1]){
			// by including the weight or by not includng the weight the max is returned 
			return dp[n][capacity] = (Math.max(
					val[n-1]+KnapSackProfit(val,wei,n-1,capacity-wei[n-1]),
					KnapSackProfit(val,wei,n-1,capacity)));


		}
		// or if the item weight is greater the capacity of kanpsack then we wil not include that item 
		else{ //capacity < wei[n-1]
			return dp[n][capacity] = KnapSackProfit(val,wei,n-1,capacity);
		}
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter total items count : ");
		int  n = sc.nextInt();

		int[] wei = new int[n];
		int[] val = new int[n];

		System.out.print("Enter items value : ");
		for(int i=0;i<n;i++){
			val[i] = sc.nextInt();
		}

		System.out.print("Enter items weight : ");
		for(int i=0;i<n;i++){
			wei[i] = sc.nextInt();
		}

		System.out.print("Enter KnapSack capacity : ");
		int cap = sc.nextInt();

		KnapSack ks = new KnapSack(n,cap);
		

		int maxProfit = KnapSackProfit(val,wei,n,cap);
		System.out.println("Maximum profit is  : " + maxProfit);
	}
}