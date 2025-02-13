import java.util.*;

//TIME : O(N*Cap);
//space : O(N*cap);


class KnapSack{

	static int max(int a,int b){
		return a>b ? a : b;
	}
	static int KnapSackProfit(int[] val,int[] wei,int n,int cap){
		 int i, j;
        int dp[][] = new int[n + 1][cap + 1];
 
        for (i = 0; i < n+1; i++){
            for (j = 0; j < cap+1; j++){
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (wei[i - 1] <= j){
                    dp[i][j]= max(val[i - 1]+ dp[i - 1][j - wei[i - 1]],dp[i - 1][j]);
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
 
        return dp[n][cap];

		

	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter total the items count : ");
		int  n = sc.nextInt();

		int[] wei = new int[n];
		int[] val = new int[n];

		System.out.print("Enter the items value : ");
		for(int i=0;i<n;i++){
			val[i] = sc.nextInt();
		}

		System.out.print("Enter the items weight : ");
		for(int i=0;i<n;i++){
			wei[i] = sc.nextInt();
		}

		System.out.print("Enter KnapSack capacity : ");
		int cap = sc.nextInt();


		int maxProfit = KnapSackProfit(val,wei,n,cap);
		System.out.println("Maximum profit is  : " + maxProfit);


	}
}

/*
hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/DP/Knapsack01
$ java KnapSack
Enter total items count : 4
Enter items value : 20 30 10 50
Enter items weight : 1 2 4 6
Enter KnapSack capacity : 10
Maximum profit is  : 100

hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/DP/Knapsack01
$ java KnapSack
Enter total items count : 2
Enter items value : 10 40
Enter items weight : 2 1
Enter KnapSack capacity : 2
Maximum profit is  : 40

*/